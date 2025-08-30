package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.camera2.internal.compat.workaround.RequestMonitor;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.camera2.internal.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.internal.compat.workaround.TorchStateReset;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

final class CaptureSession implements CaptureSessionInterface {
    private static final String TAG = "CaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;
    @GuardedBy("mSessionLock")
    private final List<CaptureConfig> mCaptureConfigs;
    @GuardedBy("mSessionLock")
    private final StateCallback mCaptureSessionStateCallback;
    @GuardedBy("mSessionLock")
    List<DeferrableSurface> mConfiguredDeferrableSurfaces;
    @GuardedBy("mSessionLock")
    private final Map<DeferrableSurface, Surface> mConfiguredSurfaceMap;
    private final DynamicRangesCompat mDynamicRangesCompat;
    @GuardedBy("mSessionLock")
    CallbackToFutureAdapter.Completer<Void> mReleaseCompleter;
    @GuardedBy("mSessionLock")
    ListenableFuture<Void> mReleaseFuture;
    private final RequestMonitor mRequestMonitor;
    @GuardedBy("mSessionLock")
    @Nullable
    SessionConfig mSessionConfig;
    final Object mSessionLock;
    @GuardedBy("mSessionLock")
    @Nullable
    SynchronizedCaptureSession.Opener mSessionOpener;
    @GuardedBy("mSessionLock")
    State mState;
    private final StillCaptureFlow mStillCaptureFlow;
    @GuardedBy("mSessionLock")
    @NonNull
    private Map<DeferrableSurface, Long> mStreamUseCaseMap;
    @GuardedBy("mSessionLock")
    @Nullable
    SynchronizedCaptureSession mSynchronizedCaptureSession;
    private final TemplateParamsOverride mTemplateParamsOverride;
    /* access modifiers changed from: private */
    public final TorchStateReset mTorchStateReset;

    public enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    public final class StateCallback extends SynchronizedCaptureSession.StateCallback {
        public StateCallback() {
        }

        public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                try {
                    switch (CaptureSession.this.mState.ordinal()) {
                        case 0:
                        case 1:
                        case 2:
                        case 4:
                            throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.mState);
                        case 3:
                        case 5:
                        case 6:
                            CaptureSession.this.finishClose();
                            break;
                        case 7:
                            Logger.d(CaptureSession.TAG, "ConfigureFailed callback after change to RELEASED state");
                            break;
                    }
                    Logger.e(CaptureSession.TAG, "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.mState);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                try {
                    switch (CaptureSession.this.mState.ordinal()) {
                        case 0:
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                            throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.mState);
                        case 3:
                            CaptureSession captureSession = CaptureSession.this;
                            captureSession.mState = State.OPENED;
                            captureSession.mSynchronizedCaptureSession = synchronizedCaptureSession;
                            Logger.d(CaptureSession.TAG, "Attempting to send capture request onConfigured");
                            CaptureSession captureSession2 = CaptureSession.this;
                            captureSession2.issueRepeatingCaptureRequests(captureSession2.mSessionConfig);
                            CaptureSession.this.issuePendingCaptureRequest();
                            break;
                        case 5:
                            CaptureSession.this.mSynchronizedCaptureSession = synchronizedCaptureSession;
                            break;
                        case 6:
                            synchronizedCaptureSession.close();
                            break;
                    }
                    Logger.d(CaptureSession.TAG, "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.mState);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                try {
                    if (CaptureSession.this.mState.ordinal() != 0) {
                        Logger.d(CaptureSession.TAG, "CameraCaptureSession.onReady() " + CaptureSession.this.mState);
                    } else {
                        throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.mState);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onSessionFinished(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                try {
                    if (CaptureSession.this.mState != State.UNINITIALIZED) {
                        Logger.d(CaptureSession.TAG, "onSessionFinished()");
                        CaptureSession.this.finishClose();
                    } else {
                        throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.mState);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public CaptureSession(@NonNull DynamicRangesCompat dynamicRangesCompat) {
        this(dynamicRangesCompat, new Quirks(Collections.emptyList()));
    }

    @GuardedBy("mSessionLock")
    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        for (CameraCaptureCallback captureCallback : list) {
            arrayList.add(CaptureCallbackConverter.toCaptureCallback(captureCallback));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return Camera2CaptureCallbacks.createComboCallback((List<CameraCaptureSession.CaptureCallback>) arrayList);
    }

    @NonNull
    private OutputConfigurationCompat getOutputConfigurationCompat(@NonNull SessionConfig.OutputConfig outputConfig, @NonNull Map<DeferrableSurface, Surface> map, @Nullable String str) {
        long j;
        DynamicRangeProfiles dynamicRangeProfiles;
        Surface surface = map.get(outputConfig.getSurface());
        Preconditions.checkNotNull(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        OutputConfigurationCompat outputConfigurationCompat = new OutputConfigurationCompat(outputConfig.getSurfaceGroupId(), surface);
        if (str != null) {
            outputConfigurationCompat.setPhysicalCameraId(str);
        } else {
            outputConfigurationCompat.setPhysicalCameraId(outputConfig.getPhysicalCameraId());
        }
        if (outputConfig.getMirrorMode() == 0) {
            outputConfigurationCompat.setMirrorMode(1);
        } else if (outputConfig.getMirrorMode() == 1) {
            outputConfigurationCompat.setMirrorMode(2);
        }
        if (!outputConfig.getSharedSurfaces().isEmpty()) {
            outputConfigurationCompat.enableSurfaceSharing();
            for (DeferrableSurface deferrableSurface : outputConfig.getSharedSurfaces()) {
                Surface surface2 = map.get(deferrableSurface);
                Preconditions.checkNotNull(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                outputConfigurationCompat.addSurface(surface2);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && (dynamicRangeProfiles = this.mDynamicRangesCompat.toDynamicRangeProfiles()) != null) {
            DynamicRange dynamicRange = outputConfig.getDynamicRange();
            Long dynamicRangeToFirstSupportedProfile = DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(dynamicRange, dynamicRangeProfiles);
            if (dynamicRangeToFirstSupportedProfile == null) {
                Logger.e(TAG, "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + dynamicRange);
            } else {
                j = dynamicRangeToFirstSupportedProfile.longValue();
                outputConfigurationCompat.setDynamicRangeProfile(j);
                return outputConfigurationCompat;
            }
        }
        j = 1;
        outputConfigurationCompat.setDynamicRangeProfile(j);
        return outputConfigurationCompat;
    }

    @NonNull
    private List<OutputConfigurationCompat> getUniqueOutputConfigurations(@NonNull List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (OutputConfigurationCompat next : list) {
            if (!arrayList.contains(next.getSurface())) {
                arrayList.add(next.getSurface());
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$issueBurstCaptureRequest$3(CameraCaptureSession cameraCaptureSession, int i, boolean z) {
        synchronized (this.mSessionLock) {
            try {
                if (this.mState == State.OPENED) {
                    issueRepeatingCaptureRequests(this.mSessionConfig);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$issuePendingCaptureRequest$2() {
        synchronized (this.mSessionLock) {
            if (!this.mCaptureConfigs.isEmpty()) {
                try {
                    issueBurstCaptureRequest(this.mCaptureConfigs);
                } finally {
                    this.mCaptureConfigs.clear();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$release$1(CallbackToFutureAdapter.Completer completer) throws Exception {
        boolean z;
        String str;
        synchronized (this.mSessionLock) {
            if (this.mReleaseCompleter == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Release completer expected to be null");
            this.mReleaseCompleter = completer;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    /* access modifiers changed from: private */
    @NonNull
    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    /* renamed from: openCaptureSession */
    public ListenableFuture<Void> lambda$open$0(@NonNull List<Surface> list, @NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice) {
        synchronized (this.mSessionLock) {
            try {
                int ordinal = this.mState.ordinal();
                if (!(ordinal == 0 || ordinal == 1)) {
                    if (ordinal == 2) {
                        this.mConfiguredSurfaceMap.clear();
                        for (int i = 0; i < list.size(); i++) {
                            this.mConfiguredSurfaceMap.put(this.mConfiguredDeferrableSurfaces.get(i), list.get(i));
                        }
                        this.mState = State.OPENING;
                        Logger.d(TAG, "Opening capture session.");
                        SynchronizedCaptureSession.StateCallback createComboCallback = SynchronizedCaptureSessionStateCallbacks.createComboCallback(this.mCaptureSessionStateCallback, new SynchronizedCaptureSessionStateCallbacks.Adapter(sessionConfig.getSessionStateCallbacks()));
                        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(sessionConfig.getImplementationOptions());
                        CaptureConfig.Builder from = CaptureConfig.Builder.from(sessionConfig.getRepeatingCaptureConfig());
                        ArrayList arrayList = new ArrayList();
                        String physicalCameraId = camera2ImplConfig.getPhysicalCameraId((String) null);
                        for (SessionConfig.OutputConfig next : sessionConfig.getOutputConfigs()) {
                            OutputConfigurationCompat outputConfigurationCompat = getOutputConfigurationCompat(next, this.mConfiguredSurfaceMap, physicalCameraId);
                            if (this.mStreamUseCaseMap.containsKey(next.getSurface())) {
                                outputConfigurationCompat.setStreamUseCase(this.mStreamUseCaseMap.get(next.getSurface()).longValue());
                            }
                            arrayList.add(outputConfigurationCompat);
                        }
                        SessionConfigurationCompat createSessionConfigurationCompat = this.mSessionOpener.createSessionConfigurationCompat(sessionConfig.getSessionType(), getUniqueOutputConfigurations(arrayList), createComboCallback);
                        if (sessionConfig.getTemplateType() == 5 && sessionConfig.getInputConfiguration() != null) {
                            createSessionConfigurationCompat.setInputConfiguration(InputConfigurationCompat.wrap(sessionConfig.getInputConfiguration()));
                        }
                        CaptureRequest buildWithoutTarget = Camera2CaptureRequestBuilder.buildWithoutTarget(from.build(), cameraDevice, this.mTemplateParamsOverride);
                        if (buildWithoutTarget != null) {
                            createSessionConfigurationCompat.setSessionParameters(buildWithoutTarget);
                        }
                        ListenableFuture<Void> openCaptureSession = this.mSessionOpener.openCaptureSession(cameraDevice, createSessionConfigurationCompat, this.mConfiguredDeferrableSurfaces);
                        return openCaptureSession;
                    } else if (ordinal != 4) {
                        ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new CancellationException("openCaptureSession() not execute in state: " + this.mState));
                        return immediateFailedFuture;
                    }
                }
                ListenableFuture<Void> immediateFailedFuture2 = Futures.immediateFailedFuture(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.mState));
                return immediateFailedFuture2;
            } catch (CameraAccessException e) {
                return Futures.immediateFailedFuture(e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void abortCaptures() {
        synchronized (this.mSessionLock) {
            if (this.mState != State.OPENED) {
                Logger.e(TAG, "Unable to abort captures. Incorrect state:" + this.mState);
                return;
            }
            try {
                this.mSynchronizedCaptureSession.abortCaptures();
            } catch (CameraAccessException e) {
                Logger.e(TAG, "Unable to abort captures.", e);
            }
        }
    }

    public void cancelIssuedCaptureRequests() {
        ArrayList<CaptureConfig> arrayList;
        synchronized (this.mSessionLock) {
            try {
                if (!this.mCaptureConfigs.isEmpty()) {
                    arrayList = new ArrayList<>(this.mCaptureConfigs);
                    this.mCaptureConfigs.clear();
                } else {
                    arrayList = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (arrayList != null) {
            for (CaptureConfig captureConfig : arrayList) {
                for (CameraCaptureCallback onCaptureCancelled : captureConfig.getCameraCaptureCallbacks()) {
                    onCaptureCancelled.onCaptureCancelled(captureConfig.getId());
                }
            }
        }
    }

    public void close() {
        synchronized (this.mSessionLock) {
            try {
                int ordinal = this.mState.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal == 2) {
                            SynchronizedCaptureSession.Opener opener = this.mSessionOpener;
                            Preconditions.checkNotNull(opener, "The Opener shouldn't null in state:" + this.mState);
                            this.mSessionOpener.stop();
                        } else if (ordinal == 3 || ordinal == 4) {
                            SynchronizedCaptureSession.Opener opener2 = this.mSessionOpener;
                            Preconditions.checkNotNull(opener2, "The Opener shouldn't null in state:" + this.mState);
                            this.mSessionOpener.stop();
                            this.mState = State.CLOSED;
                            this.mRequestMonitor.stop();
                            this.mSessionConfig = null;
                        }
                    }
                    this.mState = State.RELEASED;
                } else {
                    throw new IllegalStateException("close() should not be possible in state: " + this.mState);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("mSessionLock")
    public void finishClose() {
        State state = this.mState;
        State state2 = State.RELEASED;
        if (state == state2) {
            Logger.d(TAG, "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.mState = state2;
        this.mSynchronizedCaptureSession = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.mReleaseCompleter;
        if (completer != null) {
            completer.set(null);
            this.mReleaseCompleter = null;
        }
    }

    @NonNull
    public List<CaptureConfig> getCaptureConfigs() {
        List<CaptureConfig> unmodifiableList;
        synchronized (this.mSessionLock) {
            unmodifiableList = Collections.unmodifiableList(this.mCaptureConfigs);
        }
        return unmodifiableList;
    }

    @Nullable
    public SessionConfig getSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.mSessionLock) {
            sessionConfig = this.mSessionConfig;
        }
        return sessionConfig;
    }

    public State getState() {
        State state;
        synchronized (this.mSessionLock) {
            state = this.mState;
        }
        return state;
    }

    public boolean isInOpenState() {
        boolean z;
        synchronized (this.mSessionLock) {
            try {
                State state = this.mState;
                if (state != State.OPENED) {
                    if (state != State.OPENING) {
                        z = false;
                    }
                }
                z = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r6.getTemplateType() != 2) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r7 = androidx.camera.core.impl.CaptureConfig.Builder.from(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        if (r6.getTemplateType() != 5) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a1, code lost:
        if (r6.getCameraCaptureResult() == null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
        r7.setCameraCaptureResult(r6.getCameraCaptureResult());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        r8 = r11.mSessionConfig;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ac, code lost:
        if (r8 == null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        r7.addImplementationOptions(r8.getRepeatingCaptureConfig().getImplementationOptions());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b9, code lost:
        r7.addImplementationOptions(r6.getImplementationOptions());
        r7 = androidx.camera.camera2.internal.Camera2CaptureRequestBuilder.build(r7.build(), r11.mSynchronizedCaptureSession.getDevice(), r11.mConfiguredSurfaceMap, false, r11.mTemplateParamsOverride);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d2, code lost:
        if (r7 != null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d4, code lost:
        androidx.camera.core.Logger.d(TAG, "Skipping issuing request without surface.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dc, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r8 = new java.util.ArrayList();
        r6 = r6.getCameraCaptureCallbacks().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ee, code lost:
        if (r6.hasNext() == false) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f0, code lost:
        androidx.camera.camera2.internal.CaptureCallbackConverter.toCaptureCallback(r6.next(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fa, code lost:
        r1.addCamera2Callbacks(r7, r8);
        r2.add(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int issueBurstCaptureRequest(java.util.List<androidx.camera.core.impl.CaptureConfig> r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.mSessionLock
            monitor-enter(r0)
            androidx.camera.camera2.internal.CaptureSession$State r1 = r11.mState     // Catch:{ all -> 0x0013 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = androidx.camera.camera2.internal.CaptureSession.State.OPENED     // Catch:{ all -> 0x0013 }
            r3 = -1
            if (r1 == r2) goto L_0x0016
            java.lang.String r12 = "CaptureSession"
            java.lang.String r1 = "Skipping issueBurstCaptureRequest due to session closed"
            androidx.camera.core.Logger.d(r12, r1)     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x0013:
            r12 = move-exception
            goto L_0x016b
        L_0x0016:
            boolean r1 = r12.isEmpty()     // Catch:{ all -> 0x0013 }
            if (r1 == 0) goto L_0x001e
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x001e:
            androidx.camera.camera2.internal.CameraBurstCaptureCallback r1 = new androidx.camera.camera2.internal.CameraBurstCaptureCallback     // Catch:{ CameraAccessException -> 0x0054 }
            r1.<init>()     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ CameraAccessException -> 0x0054 }
            r2.<init>()     // Catch:{ CameraAccessException -> 0x0054 }
            java.lang.String r4 = "CaptureSession"
            java.lang.String r5 = "Issuing capture request."
            androidx.camera.core.Logger.d(r4, r5)     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ CameraAccessException -> 0x0054 }
            r4 = 0
            r5 = 0
        L_0x0035:
            boolean r6 = r12.hasNext()     // Catch:{ CameraAccessException -> 0x0054 }
            r7 = 1
            if (r6 == 0) goto L_0x0102
            java.lang.Object r6 = r12.next()     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.core.impl.CaptureConfig r6 = (androidx.camera.core.impl.CaptureConfig) r6     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.List r8 = r6.getSurfaces()     // Catch:{ CameraAccessException -> 0x0054 }
            boolean r8 = r8.isEmpty()     // Catch:{ CameraAccessException -> 0x0054 }
            if (r8 == 0) goto L_0x0057
            java.lang.String r6 = "CaptureSession"
            java.lang.String r7 = "Skipping issuing empty capture request."
            androidx.camera.core.Logger.d(r6, r7)     // Catch:{ CameraAccessException -> 0x0054 }
            goto L_0x0035
        L_0x0054:
            r12 = move-exception
            goto L_0x014c
        L_0x0057:
            java.util.List r8 = r6.getSurfaces()     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ CameraAccessException -> 0x0054 }
        L_0x005f:
            boolean r9 = r8.hasNext()     // Catch:{ CameraAccessException -> 0x0054 }
            if (r9 == 0) goto L_0x008a
            java.lang.Object r9 = r8.next()     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.core.impl.DeferrableSurface r9 = (androidx.camera.core.impl.DeferrableSurface) r9     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r10 = r11.mConfiguredSurfaceMap     // Catch:{ CameraAccessException -> 0x0054 }
            boolean r10 = r10.containsKey(r9)     // Catch:{ CameraAccessException -> 0x0054 }
            if (r10 != 0) goto L_0x005f
            java.lang.String r6 = "CaptureSession"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x0054 }
            r7.<init>()     // Catch:{ CameraAccessException -> 0x0054 }
            java.lang.String r8 = "Skipping capture request with invalid surface: "
            r7.append(r8)     // Catch:{ CameraAccessException -> 0x0054 }
            r7.append(r9)     // Catch:{ CameraAccessException -> 0x0054 }
            java.lang.String r7 = r7.toString()     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.core.Logger.d(r6, r7)     // Catch:{ CameraAccessException -> 0x0054 }
            goto L_0x0035
        L_0x008a:
            int r8 = r6.getTemplateType()     // Catch:{ CameraAccessException -> 0x0054 }
            r9 = 2
            if (r8 != r9) goto L_0x0092
            r5 = 1
        L_0x0092:
            androidx.camera.core.impl.CaptureConfig$Builder r7 = androidx.camera.core.impl.CaptureConfig.Builder.from(r6)     // Catch:{ CameraAccessException -> 0x0054 }
            int r8 = r6.getTemplateType()     // Catch:{ CameraAccessException -> 0x0054 }
            r9 = 5
            if (r8 != r9) goto L_0x00aa
            androidx.camera.core.impl.CameraCaptureResult r8 = r6.getCameraCaptureResult()     // Catch:{ CameraAccessException -> 0x0054 }
            if (r8 == 0) goto L_0x00aa
            androidx.camera.core.impl.CameraCaptureResult r8 = r6.getCameraCaptureResult()     // Catch:{ CameraAccessException -> 0x0054 }
            r7.setCameraCaptureResult(r8)     // Catch:{ CameraAccessException -> 0x0054 }
        L_0x00aa:
            androidx.camera.core.impl.SessionConfig r8 = r11.mSessionConfig     // Catch:{ CameraAccessException -> 0x0054 }
            if (r8 == 0) goto L_0x00b9
            androidx.camera.core.impl.CaptureConfig r8 = r8.getRepeatingCaptureConfig()     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.core.impl.Config r8 = r8.getImplementationOptions()     // Catch:{ CameraAccessException -> 0x0054 }
            r7.addImplementationOptions(r8)     // Catch:{ CameraAccessException -> 0x0054 }
        L_0x00b9:
            androidx.camera.core.impl.Config r8 = r6.getImplementationOptions()     // Catch:{ CameraAccessException -> 0x0054 }
            r7.addImplementationOptions(r8)     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.core.impl.CaptureConfig r7 = r7.build()     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.camera2.internal.SynchronizedCaptureSession r8 = r11.mSynchronizedCaptureSession     // Catch:{ CameraAccessException -> 0x0054 }
            android.hardware.camera2.CameraDevice r8 = r8.getDevice()     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r9 = r11.mConfiguredSurfaceMap     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.camera2.internal.compat.workaround.TemplateParamsOverride r10 = r11.mTemplateParamsOverride     // Catch:{ CameraAccessException -> 0x0054 }
            android.hardware.camera2.CaptureRequest r7 = androidx.camera.camera2.internal.Camera2CaptureRequestBuilder.build(r7, r8, r9, r4, r10)     // Catch:{ CameraAccessException -> 0x0054 }
            if (r7 != 0) goto L_0x00dd
            java.lang.String r12 = "CaptureSession"
            java.lang.String r1 = "Skipping issuing request without surface."
            androidx.camera.core.Logger.d(r12, r1)     // Catch:{ CameraAccessException -> 0x0054 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x00dd:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ CameraAccessException -> 0x0054 }
            r8.<init>()     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.List r6 = r6.getCameraCaptureCallbacks()     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ CameraAccessException -> 0x0054 }
        L_0x00ea:
            boolean r9 = r6.hasNext()     // Catch:{ CameraAccessException -> 0x0054 }
            if (r9 == 0) goto L_0x00fa
            java.lang.Object r9 = r6.next()     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.core.impl.CameraCaptureCallback r9 = (androidx.camera.core.impl.CameraCaptureCallback) r9     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.camera2.internal.CaptureCallbackConverter.toCaptureCallback(r9, r8)     // Catch:{ CameraAccessException -> 0x0054 }
            goto L_0x00ea
        L_0x00fa:
            r1.addCamera2Callbacks(r7, r8)     // Catch:{ CameraAccessException -> 0x0054 }
            r2.add(r7)     // Catch:{ CameraAccessException -> 0x0054 }
            goto L_0x0035
        L_0x0102:
            boolean r12 = r2.isEmpty()     // Catch:{ CameraAccessException -> 0x0054 }
            if (r12 != 0) goto L_0x0144
            androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow r12 = r11.mStillCaptureFlow     // Catch:{ CameraAccessException -> 0x0054 }
            boolean r12 = r12.shouldStopRepeatingBeforeCapture(r2, r5)     // Catch:{ CameraAccessException -> 0x0054 }
            if (r12 == 0) goto L_0x011d
            androidx.camera.camera2.internal.SynchronizedCaptureSession r12 = r11.mSynchronizedCaptureSession     // Catch:{ CameraAccessException -> 0x0054 }
            r12.stopRepeating()     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.camera2.internal.y r12 = new androidx.camera.camera2.internal.y     // Catch:{ CameraAccessException -> 0x0054 }
            r12.<init>(r11)     // Catch:{ CameraAccessException -> 0x0054 }
            r1.setCaptureSequenceCallback(r12)     // Catch:{ CameraAccessException -> 0x0054 }
        L_0x011d:
            androidx.camera.camera2.internal.compat.workaround.TorchStateReset r12 = r11.mTorchStateReset     // Catch:{ CameraAccessException -> 0x0054 }
            boolean r12 = r12.isTorchResetRequired(r2, r5)     // Catch:{ CameraAccessException -> 0x0054 }
            if (r12 == 0) goto L_0x013c
            int r12 = r2.size()     // Catch:{ CameraAccessException -> 0x0054 }
            int r12 = r12 - r7
            java.lang.Object r12 = r2.get(r12)     // Catch:{ CameraAccessException -> 0x0054 }
            android.hardware.camera2.CaptureRequest r12 = (android.hardware.camera2.CaptureRequest) r12     // Catch:{ CameraAccessException -> 0x0054 }
            androidx.camera.camera2.internal.CaptureSession$2 r4 = new androidx.camera.camera2.internal.CaptureSession$2     // Catch:{ CameraAccessException -> 0x0054 }
            r4.<init>()     // Catch:{ CameraAccessException -> 0x0054 }
            java.util.List r4 = java.util.Collections.singletonList(r4)     // Catch:{ CameraAccessException -> 0x0054 }
            r1.addCamera2Callbacks(r12, r4)     // Catch:{ CameraAccessException -> 0x0054 }
        L_0x013c:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r12 = r11.mSynchronizedCaptureSession     // Catch:{ CameraAccessException -> 0x0054 }
            int r12 = r12.captureBurstRequests(r2, r1)     // Catch:{ CameraAccessException -> 0x0054 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return r12
        L_0x0144:
            java.lang.String r12 = "CaptureSession"
            java.lang.String r1 = "Skipping issuing burst request due to no valid request elements"
            androidx.camera.core.Logger.d(r12, r1)     // Catch:{ CameraAccessException -> 0x0054 }
            goto L_0x0169
        L_0x014c:
            java.lang.String r1 = "CaptureSession"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0013 }
            r2.<init>()     // Catch:{ all -> 0x0013 }
            java.lang.String r4 = "Unable to access camera: "
            r2.append(r4)     // Catch:{ all -> 0x0013 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x0013 }
            r2.append(r12)     // Catch:{ all -> 0x0013 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x0013 }
            androidx.camera.core.Logger.e(r1, r12)     // Catch:{ all -> 0x0013 }
            java.lang.Thread.dumpStack()     // Catch:{ all -> 0x0013 }
        L_0x0169:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x016b:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.issueBurstCaptureRequest(java.util.List):int");
    }

    public void issueCaptureRequests(@NonNull List<CaptureConfig> list) {
        synchronized (this.mSessionLock) {
            try {
                switch (this.mState.ordinal()) {
                    case 0:
                        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.mState);
                    case 1:
                    case 2:
                    case 3:
                        this.mCaptureConfigs.addAll(list);
                        break;
                    case 4:
                        this.mCaptureConfigs.addAll(list);
                        issuePendingCaptureRequest();
                        break;
                    case 5:
                    case 6:
                    case 7:
                        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("mSessionLock")
    public void issuePendingCaptureRequest() {
        this.mRequestMonitor.getRequestsProcessedFuture().addListener(new n(this, 2), CameraXExecutors.directExecutor());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        androidx.camera.core.Logger.e(TAG, "Unable to access camera: " + r8.getMessage());
        java.lang.Thread.dumpStack();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b2, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000e, B:19:0x003a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int issueRepeatingCaptureRequests(@androidx.annotation.Nullable androidx.camera.core.impl.SessionConfig r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Unable to access camera: "
            java.lang.String r1 = "Unable to access camera: "
            java.lang.Object r2 = r7.mSessionLock
            monitor-enter(r2)
            r3 = -1
            if (r8 != 0) goto L_0x0016
            java.lang.String r8 = "CaptureSession"
            java.lang.String r0 = "Skipping issueRepeatingCaptureRequests for no configuration case."
            androidx.camera.core.Logger.d(r8, r0)     // Catch:{ all -> 0x0013 }
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x0013:
            r8 = move-exception
            goto L_0x00b1
        L_0x0016:
            androidx.camera.camera2.internal.CaptureSession$State r4 = r7.mState     // Catch:{ all -> 0x0013 }
            androidx.camera.camera2.internal.CaptureSession$State r5 = androidx.camera.camera2.internal.CaptureSession.State.OPENED     // Catch:{ all -> 0x0013 }
            if (r4 == r5) goto L_0x0025
            java.lang.String r8 = "CaptureSession"
            java.lang.String r0 = "Skipping issueRepeatingCaptureRequests due to session closed"
            androidx.camera.core.Logger.d(r8, r0)     // Catch:{ all -> 0x0013 }
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x0025:
            androidx.camera.core.impl.CaptureConfig r8 = r8.getRepeatingCaptureConfig()     // Catch:{ all -> 0x0013 }
            java.util.List r4 = r8.getSurfaces()     // Catch:{ all -> 0x0013 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0013 }
            if (r4 == 0) goto L_0x005b
            java.lang.String r8 = "CaptureSession"
            java.lang.String r0 = "Skipping issueRepeatingCaptureRequests for no surface."
            androidx.camera.core.Logger.d(r8, r0)     // Catch:{ all -> 0x0013 }
            androidx.camera.camera2.internal.SynchronizedCaptureSession r8 = r7.mSynchronizedCaptureSession     // Catch:{ CameraAccessException -> 0x0040 }
            r8.stopRepeating()     // Catch:{ CameraAccessException -> 0x0040 }
            goto L_0x0059
        L_0x0040:
            r8 = move-exception
            java.lang.String r0 = "CaptureSession"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0013 }
            r4.<init>(r1)     // Catch:{ all -> 0x0013 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0013 }
            r4.append(r8)     // Catch:{ all -> 0x0013 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x0013 }
            androidx.camera.core.Logger.e(r0, r8)     // Catch:{ all -> 0x0013 }
            java.lang.Thread.dumpStack()     // Catch:{ all -> 0x0013 }
        L_0x0059:
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x005b:
            java.lang.String r1 = "CaptureSession"
            java.lang.String r4 = "Issuing request for session."
            androidx.camera.core.Logger.d(r1, r4)     // Catch:{ CameraAccessException -> 0x007c }
            androidx.camera.camera2.internal.SynchronizedCaptureSession r1 = r7.mSynchronizedCaptureSession     // Catch:{ CameraAccessException -> 0x007c }
            android.hardware.camera2.CameraDevice r1 = r1.getDevice()     // Catch:{ CameraAccessException -> 0x007c }
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r4 = r7.mConfiguredSurfaceMap     // Catch:{ CameraAccessException -> 0x007c }
            androidx.camera.camera2.internal.compat.workaround.TemplateParamsOverride r5 = r7.mTemplateParamsOverride     // Catch:{ CameraAccessException -> 0x007c }
            r6 = 1
            android.hardware.camera2.CaptureRequest r1 = androidx.camera.camera2.internal.Camera2CaptureRequestBuilder.build(r8, r1, r4, r6, r5)     // Catch:{ CameraAccessException -> 0x007c }
            if (r1 != 0) goto L_0x007e
            java.lang.String r8 = "CaptureSession"
            java.lang.String r1 = "Skipping issuing empty request for session."
            androidx.camera.core.Logger.d(r8, r1)     // Catch:{ CameraAccessException -> 0x007c }
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x007c:
            r8 = move-exception
            goto L_0x0097
        L_0x007e:
            androidx.camera.camera2.internal.compat.workaround.RequestMonitor r4 = r7.mRequestMonitor     // Catch:{ CameraAccessException -> 0x007c }
            java.util.List r8 = r8.getCameraCaptureCallbacks()     // Catch:{ CameraAccessException -> 0x007c }
            r5 = 0
            android.hardware.camera2.CameraCaptureSession$CaptureCallback[] r5 = new android.hardware.camera2.CameraCaptureSession.CaptureCallback[r5]     // Catch:{ CameraAccessException -> 0x007c }
            android.hardware.camera2.CameraCaptureSession$CaptureCallback r8 = r7.createCamera2CaptureCallback(r8, r5)     // Catch:{ CameraAccessException -> 0x007c }
            android.hardware.camera2.CameraCaptureSession$CaptureCallback r8 = r4.createMonitorListener(r8)     // Catch:{ CameraAccessException -> 0x007c }
            androidx.camera.camera2.internal.SynchronizedCaptureSession r4 = r7.mSynchronizedCaptureSession     // Catch:{ CameraAccessException -> 0x007c }
            int r8 = r4.setSingleRepeatingRequest(r1, r8)     // Catch:{ CameraAccessException -> 0x007c }
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            return r8
        L_0x0097:
            java.lang.String r1 = "CaptureSession"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0013 }
            r4.<init>(r0)     // Catch:{ all -> 0x0013 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0013 }
            r4.append(r8)     // Catch:{ all -> 0x0013 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x0013 }
            androidx.camera.core.Logger.e(r1, r8)     // Catch:{ all -> 0x0013 }
            java.lang.Thread.dumpStack()     // Catch:{ all -> 0x0013 }
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            return r3
        L_0x00b1:
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.issueRepeatingCaptureRequests(androidx.camera.core.impl.SessionConfig):int");
    }

    @NonNull
    public ListenableFuture<Void> open(@NonNull SessionConfig sessionConfig, @NonNull CameraDevice cameraDevice, @NonNull SynchronizedCaptureSession.Opener opener) {
        synchronized (this.mSessionLock) {
            try {
                if (this.mState.ordinal() != 1) {
                    Logger.e(TAG, "Open not allowed in state: " + this.mState);
                    ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.mState));
                    return immediateFailedFuture;
                }
                this.mState = State.GET_SURFACE;
                ArrayList arrayList = new ArrayList(sessionConfig.getSurfaces());
                this.mConfiguredDeferrableSurfaces = arrayList;
                this.mSessionOpener = opener;
                FutureChain<T> transformAsync = FutureChain.from(opener.startWithDeferrableSurface(arrayList, 5000)).transformAsync(new z(this, sessionConfig, cameraDevice), this.mSessionOpener.getExecutor());
                Futures.addCallback(transformAsync, new FutureCallback<Void>() {
                    public void onFailure(@NonNull Throwable th) {
                        synchronized (CaptureSession.this.mSessionLock) {
                            try {
                                CaptureSession.this.mSessionOpener.stop();
                                int ordinal = CaptureSession.this.mState.ordinal();
                                if (ordinal == 3 || ordinal == 5 || ordinal == 6) {
                                    if (!(th instanceof CancellationException)) {
                                        Logger.w(CaptureSession.TAG, "Opening session with fail " + CaptureSession.this.mState, th);
                                        CaptureSession.this.finishClose();
                                    }
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }

                    public void onSuccess(@Nullable Void voidR) {
                    }
                }, this.mSessionOpener.getExecutor());
                ListenableFuture<Void> nonCancellationPropagating = Futures.nonCancellationPropagating(transformAsync);
                return nonCancellationPropagating;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r5.mState = androidx.camera.camera2.internal.CaptureSession.State.RELEASING;
        r5.mRequestMonitor.stop();
        r6 = r5.mSessionOpener;
        androidx.core.util.Preconditions.checkNotNull(r6, "The Opener shouldn't null in state:" + r5.mState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r5.mSessionOpener.stop() == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        finishClose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r5.mReleaseFuture != null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r5.mReleaseFuture = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(new androidx.camera.camera2.internal.y(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        r6 = r5.mReleaseFuture;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0067, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r5.mState = androidx.camera.camera2.internal.CaptureSession.State.RELEASED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        return androidx.camera.core.impl.utils.futures.Futures.immediateFuture(null);
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> release(boolean r6) {
        /*
            r5 = this;
            java.lang.String r0 = "release() should not be possible in state: "
            java.lang.String r1 = "The Opener shouldn't null in state:"
            java.lang.String r2 = "The Opener shouldn't null in state:"
            java.lang.Object r3 = r5.mSessionLock
            monitor-enter(r3)
            androidx.camera.camera2.internal.CaptureSession$State r4 = r5.mState     // Catch:{ all -> 0x001d }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x001d }
            switch(r4) {
                case 0: goto L_0x008b;
                case 1: goto L_0x0080;
                case 2: goto L_0x0068;
                case 3: goto L_0x002d;
                case 4: goto L_0x0013;
                case 5: goto L_0x0013;
                case 6: goto L_0x0055;
                default: goto L_0x0012;
            }     // Catch:{ all -> 0x001d }
        L_0x0012:
            goto L_0x0084
        L_0x0013:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r0 = r5.mSynchronizedCaptureSession     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x002d
            if (r6 == 0) goto L_0x0028
            r0.abortCaptures()     // Catch:{ CameraAccessException -> 0x0020 }
            goto L_0x0028
        L_0x001d:
            r6 = move-exception
            goto L_0x009f
        L_0x0020:
            r6 = move-exception
            java.lang.String r0 = "CaptureSession"
            java.lang.String r1 = "Unable to abort captures."
            androidx.camera.core.Logger.e(r0, r1, r6)     // Catch:{ all -> 0x001d }
        L_0x0028:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r6 = r5.mSynchronizedCaptureSession     // Catch:{ all -> 0x001d }
            r6.close()     // Catch:{ all -> 0x001d }
        L_0x002d:
            androidx.camera.camera2.internal.CaptureSession$State r6 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ all -> 0x001d }
            r5.mState = r6     // Catch:{ all -> 0x001d }
            androidx.camera.camera2.internal.compat.workaround.RequestMonitor r6 = r5.mRequestMonitor     // Catch:{ all -> 0x001d }
            r6.stop()     // Catch:{ all -> 0x001d }
            androidx.camera.camera2.internal.SynchronizedCaptureSession$Opener r6 = r5.mSessionOpener     // Catch:{ all -> 0x001d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x001d }
            r0.<init>(r2)     // Catch:{ all -> 0x001d }
            androidx.camera.camera2.internal.CaptureSession$State r1 = r5.mState     // Catch:{ all -> 0x001d }
            r0.append(r1)     // Catch:{ all -> 0x001d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x001d }
            androidx.core.util.Preconditions.checkNotNull(r6, r0)     // Catch:{ all -> 0x001d }
            androidx.camera.camera2.internal.SynchronizedCaptureSession$Opener r6 = r5.mSessionOpener     // Catch:{ all -> 0x001d }
            boolean r6 = r6.stop()     // Catch:{ all -> 0x001d }
            if (r6 == 0) goto L_0x0055
            r5.finishClose()     // Catch:{ all -> 0x001d }
            goto L_0x0084
        L_0x0055:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r6 = r5.mReleaseFuture     // Catch:{ all -> 0x001d }
            if (r6 != 0) goto L_0x0064
            androidx.camera.camera2.internal.y r6 = new androidx.camera.camera2.internal.y     // Catch:{ all -> 0x001d }
            r6.<init>(r5)     // Catch:{ all -> 0x001d }
            com.google.common.util.concurrent.ListenableFuture r6 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r6)     // Catch:{ all -> 0x001d }
            r5.mReleaseFuture = r6     // Catch:{ all -> 0x001d }
        L_0x0064:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r6 = r5.mReleaseFuture     // Catch:{ all -> 0x001d }
            monitor-exit(r3)     // Catch:{ all -> 0x001d }
            return r6
        L_0x0068:
            androidx.camera.camera2.internal.SynchronizedCaptureSession$Opener r6 = r5.mSessionOpener     // Catch:{ all -> 0x001d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x001d }
            r0.<init>(r1)     // Catch:{ all -> 0x001d }
            androidx.camera.camera2.internal.CaptureSession$State r1 = r5.mState     // Catch:{ all -> 0x001d }
            r0.append(r1)     // Catch:{ all -> 0x001d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x001d }
            androidx.core.util.Preconditions.checkNotNull(r6, r0)     // Catch:{ all -> 0x001d }
            androidx.camera.camera2.internal.SynchronizedCaptureSession$Opener r6 = r5.mSessionOpener     // Catch:{ all -> 0x001d }
            r6.stop()     // Catch:{ all -> 0x001d }
        L_0x0080:
            androidx.camera.camera2.internal.CaptureSession$State r6 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ all -> 0x001d }
            r5.mState = r6     // Catch:{ all -> 0x001d }
        L_0x0084:
            monitor-exit(r3)     // Catch:{ all -> 0x001d }
            r6 = 0
            com.google.common.util.concurrent.ListenableFuture r6 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r6)
            return r6
        L_0x008b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x001d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001d }
            r1.<init>(r0)     // Catch:{ all -> 0x001d }
            androidx.camera.camera2.internal.CaptureSession$State r0 = r5.mState     // Catch:{ all -> 0x001d }
            r1.append(r0)     // Catch:{ all -> 0x001d }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x001d }
            r6.<init>(r0)     // Catch:{ all -> 0x001d }
            throw r6     // Catch:{ all -> 0x001d }
        L_0x009f:
            monitor-exit(r3)     // Catch:{ all -> 0x001d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.release(boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSessionConfig(@androidx.annotation.Nullable androidx.camera.core.impl.SessionConfig r4) {
        /*
            r3 = this;
            java.lang.String r0 = "setSessionConfig() should not be possible in state: "
            java.lang.Object r1 = r3.mSessionLock
            monitor-enter(r1)
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x0017 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0017 }
            switch(r2) {
                case 0: goto L_0x0049;
                case 1: goto L_0x0045;
                case 2: goto L_0x0045;
                case 3: goto L_0x0045;
                case 4: goto L_0x0019;
                case 5: goto L_0x000f;
                case 6: goto L_0x000f;
                case 7: goto L_0x000f;
                default: goto L_0x000e;
            }     // Catch:{ all -> 0x0017 }
        L_0x000e:
            goto L_0x0047
        L_0x000f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0017 }
            java.lang.String r0 = "Session configuration cannot be set on a closed/released session."
            r4.<init>(r0)     // Catch:{ all -> 0x0017 }
            throw r4     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r4 = move-exception
            goto L_0x005d
        L_0x0019:
            r3.mSessionConfig = r4     // Catch:{ all -> 0x0017 }
            if (r4 != 0) goto L_0x001f
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            return
        L_0x001f:
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r0 = r3.mConfiguredSurfaceMap     // Catch:{ all -> 0x0017 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x0017 }
            java.util.List r4 = r4.getSurfaces()     // Catch:{ all -> 0x0017 }
            boolean r4 = r0.containsAll(r4)     // Catch:{ all -> 0x0017 }
            if (r4 != 0) goto L_0x0038
            java.lang.String r4 = "CaptureSession"
            java.lang.String r0 = "Does not have the proper configured lists"
            androidx.camera.core.Logger.e(r4, r0)     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            return
        L_0x0038:
            java.lang.String r4 = "CaptureSession"
            java.lang.String r0 = "Attempting to submit CaptureRequest after setting"
            androidx.camera.core.Logger.d(r4, r0)     // Catch:{ all -> 0x0017 }
            androidx.camera.core.impl.SessionConfig r4 = r3.mSessionConfig     // Catch:{ all -> 0x0017 }
            r3.issueRepeatingCaptureRequests(r4)     // Catch:{ all -> 0x0017 }
            goto L_0x0047
        L_0x0045:
            r3.mSessionConfig = r4     // Catch:{ all -> 0x0017 }
        L_0x0047:
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            return
        L_0x0049:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0017 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0017 }
            r2.<init>(r0)     // Catch:{ all -> 0x0017 }
            androidx.camera.camera2.internal.CaptureSession$State r0 = r3.mState     // Catch:{ all -> 0x0017 }
            r2.append(r0)     // Catch:{ all -> 0x0017 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0017 }
            r4.<init>(r0)     // Catch:{ all -> 0x0017 }
            throw r4     // Catch:{ all -> 0x0017 }
        L_0x005d:
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.setSessionConfig(androidx.camera.core.impl.SessionConfig):void");
    }

    public void setStreamUseCaseMap(@NonNull Map<DeferrableSurface, Long> map) {
        synchronized (this.mSessionLock) {
            this.mStreamUseCaseMap = map;
        }
    }

    public void stopRepeating() {
        synchronized (this.mSessionLock) {
            if (this.mState != State.OPENED) {
                Logger.e(TAG, "Unable to stop repeating. Incorrect state:" + this.mState);
                return;
            }
            try {
                this.mSynchronizedCaptureSession.stopRepeating();
            } catch (CameraAccessException e) {
                Logger.e(TAG, "Unable to stop repeating.", e);
            }
        }
    }

    public CaptureSession(@NonNull DynamicRangesCompat dynamicRangesCompat, @NonNull Quirks quirks) {
        this.mSessionLock = new Object();
        this.mCaptureConfigs = new ArrayList();
        this.mConfiguredSurfaceMap = new HashMap();
        this.mConfiguredDeferrableSurfaces = Collections.emptyList();
        this.mState = State.UNINITIALIZED;
        this.mStreamUseCaseMap = new HashMap();
        this.mStillCaptureFlow = new StillCaptureFlow();
        this.mTorchStateReset = new TorchStateReset();
        this.mState = State.INITIALIZED;
        this.mDynamicRangesCompat = dynamicRangesCompat;
        this.mCaptureSessionStateCallback = new StateCallback();
        this.mRequestMonitor = new RequestMonitor(quirks.contains(CaptureNoResponseQuirk.class));
        this.mTemplateParamsOverride = new TemplateParamsOverride(quirks);
    }
}
