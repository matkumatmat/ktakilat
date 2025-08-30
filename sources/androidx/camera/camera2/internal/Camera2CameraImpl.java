package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.CamcorderProfile;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.ApiCompat;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.perf.util.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class Camera2CameraImpl implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera2CameraImpl";
    @NonNull
    final CameraAvailability mCameraAvailability;
    @NonNull
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    @NonNull
    private CameraConfig mCameraConfig;
    @NonNull
    final CameraConfigureAvailable mCameraConfigureAvailable;
    private final Camera2CameraControlImpl mCameraControlInternal;
    @NonNull
    final CameraCoordinator mCameraCoordinator;
    @Nullable
    CameraDevice mCameraDevice;
    int mCameraDeviceError;
    @NonNull
    final Camera2CameraInfoImpl mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    private final CameraStateMachine mCameraStateMachine;
    @NonNull
    final CameraStateRegistry mCameraStateRegistry;
    CaptureSessionInterface mCaptureSession;
    @NonNull
    private final SynchronizedCaptureSession.OpenerBuilder mCaptureSessionOpenerBuilder;
    @NonNull
    private final CaptureSessionRepository mCaptureSessionRepository;
    private final boolean mCloseCameraBeforeCreateNewSessionQuirk;
    private final boolean mConfigAndCloseQuirk;
    @NonNull
    private final DisplayInfoManager mDisplayInfoManager;
    @NonNull
    private final DynamicRangesCompat mDynamicRangesCompat;
    /* access modifiers changed from: private */
    public final ErrorTimeoutReopenScheduler mErrorTimeoutReopenScheduler;
    /* access modifiers changed from: private */
    public final Executor mExecutor;
    boolean mIsActiveResumingMode;
    private boolean mIsConfigAndCloseRequired;
    private boolean mIsConfiguringForClose;
    private boolean mIsPrimary;
    final Object mLock;
    private MeteringRepeatingSession mMeteringRepeatingSession;
    private final Set<String> mNotifyStateAttachedSet;
    private final LiveDataObservable<CameraInternal.State> mObservableState;
    final AtomicInteger mReleaseRequestCount;
    final Map<CaptureSessionInterface, ListenableFuture<Void>> mReleasedCaptureSessions;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService mScheduledExecutorService;
    @GuardedBy("mLock")
    @Nullable
    private SessionProcessor mSessionProcessor;
    volatile InternalState mState = InternalState.INITIALIZED;
    /* access modifiers changed from: private */
    public final StateCallback mStateCallback;
    @NonNull
    private final SupportedSurfaceCombination mSupportedSurfaceCombination;
    private int mTraceStateErrorCount;
    private final UseCaseAttachState mUseCaseAttachState;
    ListenableFuture<Void> mUserReleaseFuture;
    CallbackToFutureAdapter.Completer<Void> mUserReleaseNotifier;

    public final class CameraAvailability extends CameraManager.AvailabilityCallback implements CameraStateRegistry.OnOpenAvailableListener {
        private boolean mCameraAvailable = true;
        private final String mCameraId;

        public CameraAvailability(String str) {
            this.mCameraId = str;
        }

        public boolean isCameraAvailable() {
            return this.mCameraAvailable;
        }

        public void onCameraAvailable(@NonNull String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = true;
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.tryOpenCameraDevice(false);
                }
            }
        }

        public void onCameraUnavailable(@NonNull String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = false;
            }
        }

        public void onOpenAvailable() {
            if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.tryOpenCameraDevice(false);
            }
        }
    }

    public final class CameraConfigureAvailable implements CameraStateRegistry.OnConfigureAvailableListener {
        public CameraConfigureAvailable() {
        }

        public void onConfigureAvailable() {
            if (Camera2CameraImpl.this.mState == InternalState.OPENED) {
                Camera2CameraImpl.this.openCaptureSession();
            }
        }
    }

    public final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        public ControlUpdateListenerInternal() {
        }

        public void onCameraControlCaptureRequests(@NonNull List<CaptureConfig> list) {
            Camera2CameraImpl.this.submitCaptureRequests((List) Preconditions.checkNotNull(list));
        }

        public void onCameraControlUpdateSessionConfig() {
            Camera2CameraImpl.this.updateCaptureSessionConfig();
        }
    }

    public class ErrorTimeoutReopenScheduler {
        private static final long ERROR_TIMEOUT_MILLIS = 2000;
        @Nullable
        private ScheduleNode mScheduleNode;

        public class ScheduleNode {
            private final AtomicBoolean mIsDone = new AtomicBoolean(false);
            private final ScheduledFuture<?> mScheduledFuture;

            public ScheduleNode() {
                this.mScheduledFuture = Camera2CameraImpl.this.mScheduledExecutorService.schedule(new m(this, 0), ErrorTimeoutReopenScheduler.ERROR_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            }

            /* access modifiers changed from: private */
            public void execute() {
                if (!this.mIsDone.getAndSet(true)) {
                    Camera2CameraImpl.this.mExecutor.execute(new m(this, 1));
                }
            }

            /* access modifiers changed from: private */
            public void executeInternal() {
                if (Camera2CameraImpl.this.mState != InternalState.OPENING) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    camera2CameraImpl.debugLog("Camera skip reopen at state: " + Camera2CameraImpl.this.mState);
                    return;
                }
                Camera2CameraImpl.this.debugLog("Camera onError timeout, reopen it.");
                Camera2CameraImpl.this.setState(InternalState.REOPENING);
                Camera2CameraImpl.this.mStateCallback.scheduleCameraReopen();
            }

            public void cancel() {
                this.mIsDone.set(true);
                this.mScheduledFuture.cancel(true);
            }

            public boolean isDone() {
                return this.mIsDone.get();
            }
        }

        private ErrorTimeoutReopenScheduler() {
            this.mScheduleNode = null;
        }

        public void cancel() {
            ScheduleNode scheduleNode = this.mScheduleNode;
            if (scheduleNode != null) {
                scheduleNode.cancel();
            }
            this.mScheduleNode = null;
        }

        public void deviceOnError() {
            Camera2CameraImpl.this.debugLog("Camera receive onErrorCallback");
            cancel();
        }

        public boolean isErrorHandling() {
            ScheduleNode scheduleNode = this.mScheduleNode;
            if (scheduleNode == null || scheduleNode.isDone()) {
                return false;
            }
            return true;
        }

        public void start() {
            if (Camera2CameraImpl.this.mState != InternalState.OPENING) {
                Camera2CameraImpl.this.debugLog("Don't need the onError timeout handler.");
                return;
            }
            Camera2CameraImpl.this.debugLog("Camera waiting for onError.");
            cancel();
            this.mScheduleNode = new ScheduleNode();
        }
    }

    public enum InternalState {
        RELEASED,
        RELEASING,
        INITIALIZED,
        PENDING_OPEN,
        CLOSING,
        REOPENING_QUIRK,
        REOPENING,
        OPENING,
        OPENED,
        CONFIGURED
    }

    public final class StateCallback extends CameraDevice.StateCallback {
        @NonNull
        private final CameraReopenMonitor mCameraReopenMonitor;
        private final Executor mExecutor;
        ScheduledFuture<?> mScheduledReopenHandle;
        private ScheduledReopen mScheduledReopenRunnable;
        private final ScheduledExecutorService mScheduler;

        public class CameraReopenMonitor {
            static final int ACTIVE_REOPEN_DELAY_BASE_MS = 1000;
            static final int ACTIVE_REOPEN_LIMIT_MS = 1800000;
            static final int INVALID_TIME = -1;
            static final int REOPEN_DELAY_MS = 700;
            static final int REOPEN_LIMIT_MS = 10000;
            private final long mCameraOpenRetryMaxTimeoutInMs;
            private long mFirstReopenTime = -1;

            public CameraReopenMonitor(long j) {
                this.mCameraOpenRetryMaxTimeoutInMs = j;
            }

            public boolean canScheduleCameraReopen() {
                if (getElapsedTime() < ((long) getReopenLimitMs())) {
                    return true;
                }
                reset();
                return false;
            }

            public long getElapsedTime() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.mFirstReopenTime == -1) {
                    this.mFirstReopenTime = uptimeMillis;
                }
                return uptimeMillis - this.mFirstReopenTime;
            }

            public int getReopenDelayMs() {
                if (!StateCallback.this.shouldActiveResume()) {
                    return 700;
                }
                long elapsedTime = getElapsedTime();
                if (elapsedTime <= 120000) {
                    return 1000;
                }
                if (elapsedTime <= 300000) {
                    return Constants.MAX_URL_LENGTH;
                }
                return 4000;
            }

            public int getReopenLimitMs() {
                if (!StateCallback.this.shouldActiveResume()) {
                    long j = this.mCameraOpenRetryMaxTimeoutInMs;
                    if (j > 0) {
                        return Math.min((int) j, REOPEN_LIMIT_MS);
                    }
                    return REOPEN_LIMIT_MS;
                }
                long j2 = this.mCameraOpenRetryMaxTimeoutInMs;
                if (j2 > 0) {
                    return Math.min((int) j2, ACTIVE_REOPEN_LIMIT_MS);
                }
                return ACTIVE_REOPEN_LIMIT_MS;
            }

            public void reset() {
                this.mFirstReopenTime = -1;
            }
        }

        public class ScheduledReopen implements Runnable {
            private boolean mCancelled = false;
            private Executor mExecutor;

            public ScheduledReopen(@NonNull Executor executor) {
                this.mExecutor = executor;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0() {
                boolean z;
                if (!this.mCancelled) {
                    if (Camera2CameraImpl.this.mState == InternalState.REOPENING || Camera2CameraImpl.this.mState == InternalState.REOPENING_QUIRK) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkState(z);
                    if (StateCallback.this.shouldActiveResume()) {
                        Camera2CameraImpl.this.tryForceOpenCameraDevice(true);
                    } else {
                        Camera2CameraImpl.this.tryOpenCameraDevice(true);
                    }
                }
            }

            public void cancel() {
                this.mCancelled = true;
            }

            public void run() {
                this.mExecutor.execute(new n(this, 0));
            }
        }

        public StateCallback(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, long j) {
            this.mExecutor = executor;
            this.mScheduler = scheduledExecutorService;
            this.mCameraReopenMonitor = new CameraReopenMonitor(j);
        }

        private void handleErrorOnOpen(@NonNull CameraDevice cameraDevice, int i) {
            boolean z;
            int i2;
            if (Camera2CameraImpl.this.mState == InternalState.OPENING || Camera2CameraImpl.this.mState == InternalState.OPENED || Camera2CameraImpl.this.mState == InternalState.CONFIGURED || Camera2CameraImpl.this.mState == InternalState.REOPENING || Camera2CameraImpl.this.mState == InternalState.REOPENING_QUIRK) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.mState);
            if (i == 1 || i == 2 || i == 4) {
                Logger.d(Camera2CameraImpl.TAG, e.o("Attempt to reopen camera[", cameraDevice.getId(), "] after error[", Camera2CameraImpl.getErrorMessage(i), "]"));
                reopenCameraAfterError(i);
                return;
            }
            Logger.e(Camera2CameraImpl.TAG, "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.getErrorMessage(i) + " closing camera.");
            if (i == 3) {
                i2 = 5;
            } else {
                i2 = 6;
            }
            Camera2CameraImpl.this.setState(InternalState.CLOSING, CameraState.StateError.create(i2));
            Camera2CameraImpl.this.closeCamera(false);
        }

        private void reopenCameraAfterError(int i) {
            boolean z;
            int i2 = 1;
            if (Camera2CameraImpl.this.mCameraDeviceError != 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (i == 1) {
                i2 = 2;
            } else if (i != 2) {
                i2 = 3;
            }
            Camera2CameraImpl.this.setState(InternalState.REOPENING, CameraState.StateError.create(i2));
            Camera2CameraImpl.this.closeCamera(false);
        }

        public boolean cancelScheduledReopen() {
            if (this.mScheduledReopenHandle == null) {
                return false;
            }
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.debugLog("Cancelling scheduled re-open: " + this.mScheduledReopenRunnable);
            this.mScheduledReopenRunnable.cancel();
            this.mScheduledReopenRunnable = null;
            this.mScheduledReopenHandle.cancel(false);
            this.mScheduledReopenHandle = null;
            return true;
        }

        public void onClosed(@NonNull CameraDevice cameraDevice) {
            boolean z;
            Camera2CameraImpl.this.debugLog("CameraDevice.onClosed()");
            if (Camera2CameraImpl.this.mCameraDevice == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Unexpected onClose callback on camera device: " + cameraDevice);
            int ordinal = Camera2CameraImpl.this.mState.ordinal();
            if (ordinal == 1 || ordinal == 4) {
                Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
                Camera2CameraImpl.this.configAndCloseIfNeeded();
            } else if (ordinal == 5 || ordinal == 6) {
                Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                if (camera2CameraImpl.mCameraDeviceError != 0) {
                    camera2CameraImpl.debugLog("Camera closed due to error: " + Camera2CameraImpl.getErrorMessage(Camera2CameraImpl.this.mCameraDeviceError));
                    scheduleCameraReopen();
                    return;
                }
                camera2CameraImpl.tryOpenCameraDevice(false);
            } else {
                throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.mState);
            }
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = i;
            camera2CameraImpl.mErrorTimeoutReopenScheduler.deviceOnError();
            int ordinal = Camera2CameraImpl.this.mState.ordinal();
            if (ordinal != 1) {
                switch (ordinal) {
                    case 4:
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        String id = cameraDevice.getId();
                        String errorMessage = Camera2CameraImpl.getErrorMessage(i);
                        String name = Camera2CameraImpl.this.mState.name();
                        StringBuilder u = e.u("CameraDevice.onError(): ", id, " failed with ", errorMessage, " while in ");
                        u.append(name);
                        u.append(" state. Will attempt recovering from error.");
                        Logger.d(Camera2CameraImpl.TAG, u.toString());
                        handleErrorOnOpen(cameraDevice, i);
                        return;
                    default:
                        throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.mState);
                }
            }
            String id2 = cameraDevice.getId();
            String errorMessage2 = Camera2CameraImpl.getErrorMessage(i);
            String name2 = Camera2CameraImpl.this.mState.name();
            StringBuilder u2 = e.u("CameraDevice.onError(): ", id2, " failed with ", errorMessage2, " while in ");
            u2.append(name2);
            u2.append(" state. Will finish closing camera.");
            Logger.e(Camera2CameraImpl.TAG, u2.toString());
            Camera2CameraImpl.this.closeCamera(false);
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onOpened()");
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = 0;
            resetReopenMonitor();
            int ordinal = Camera2CameraImpl.this.mState.ordinal();
            if (ordinal == 1 || ordinal == 4) {
                Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
                Camera2CameraImpl.this.mCameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            } else if (ordinal == 5 || ordinal == 6 || ordinal == 7) {
                Camera2CameraImpl.this.setState(InternalState.OPENED);
                CameraStateRegistry cameraStateRegistry = Camera2CameraImpl.this.mCameraStateRegistry;
                String id = cameraDevice.getId();
                Camera2CameraImpl camera2CameraImpl2 = Camera2CameraImpl.this;
                if (cameraStateRegistry.tryOpenCaptureSession(id, camera2CameraImpl2.mCameraCoordinator.getPairedConcurrentCameraId(camera2CameraImpl2.mCameraDevice.getId()))) {
                    Camera2CameraImpl.this.openCaptureSession();
                }
            } else {
                throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.mState);
            }
        }

        public void resetReopenMonitor() {
            this.mCameraReopenMonitor.reset();
        }

        public void scheduleCameraReopen() {
            boolean z;
            boolean z2 = true;
            if (this.mScheduledReopenRunnable == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            if (this.mScheduledReopenHandle != null) {
                z2 = false;
            }
            Preconditions.checkState(z2);
            if (this.mCameraReopenMonitor.canScheduleCameraReopen()) {
                this.mScheduledReopenRunnable = new ScheduledReopen(this.mExecutor);
                Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                camera2CameraImpl.debugLog("Attempting camera re-open in " + this.mCameraReopenMonitor.getReopenDelayMs() + "ms: " + this.mScheduledReopenRunnable + " activeResuming = " + Camera2CameraImpl.this.mIsActiveResumingMode);
                this.mScheduledReopenHandle = this.mScheduler.schedule(this.mScheduledReopenRunnable, (long) this.mCameraReopenMonitor.getReopenDelayMs(), TimeUnit.MILLISECONDS);
                return;
            }
            Logger.e(Camera2CameraImpl.TAG, "Camera reopening attempted for " + this.mCameraReopenMonitor.getReopenLimitMs() + "ms without success.");
            Camera2CameraImpl.this.setState(InternalState.PENDING_OPEN, (CameraState.StateError) null, false);
        }

        public boolean shouldActiveResume() {
            int i;
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            if (!camera2CameraImpl.mIsActiveResumingMode || ((i = camera2CameraImpl.mCameraDeviceError) != 1 && i != 2)) {
                return false;
            }
            return true;
        }
    }

    @AutoValue
    public static abstract class UseCaseInfo {
        @NonNull
        public static UseCaseInfo create(@NonNull String str, @NonNull Class<?> cls, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig, @Nullable Size size, @Nullable StreamSpec streamSpec, @Nullable List<UseCaseConfigFactory.CaptureType> list) {
            return new AutoValue_Camera2CameraImpl_UseCaseInfo(str, cls, sessionConfig, useCaseConfig, size, streamSpec, list);
        }

        @NonNull
        public static UseCaseInfo from(@NonNull UseCase useCase, boolean z) {
            SessionConfig secondarySessionConfig;
            String useCaseId = Camera2CameraImpl.getUseCaseId(useCase);
            Class<?> cls = useCase.getClass();
            if (z) {
                secondarySessionConfig = useCase.getSessionConfig();
            } else {
                secondarySessionConfig = useCase.getSecondarySessionConfig();
            }
            return create(useCaseId, cls, secondarySessionConfig, useCase.getCurrentConfig(), useCase.getAttachedSurfaceResolution(), useCase.getAttachedStreamSpec(), Camera2CameraImpl.getCaptureTypes(useCase));
        }

        @Nullable
        public abstract List<UseCaseConfigFactory.CaptureType> getCaptureTypes();

        @NonNull
        public abstract SessionConfig getSessionConfig();

        @Nullable
        public abstract StreamSpec getStreamSpec();

        @Nullable
        public abstract Size getSurfaceResolution();

        @NonNull
        public abstract UseCaseConfig<?> getUseCaseConfig();

        @NonNull
        public abstract String getUseCaseId();

        @NonNull
        public abstract Class<?> getUseCaseType();
    }

    public Camera2CameraImpl(@NonNull Context context, @NonNull CameraManagerCompat cameraManagerCompat, @NonNull String str, @NonNull Camera2CameraInfoImpl camera2CameraInfoImpl, @NonNull CameraCoordinator cameraCoordinator, @NonNull CameraStateRegistry cameraStateRegistry, @NonNull Executor executor, @NonNull Handler handler, @NonNull DisplayInfoManager displayInfoManager, long j) throws CameraUnavailableException {
        CameraManagerCompat cameraManagerCompat2 = cameraManagerCompat;
        String str2 = str;
        Camera2CameraInfoImpl camera2CameraInfoImpl2 = camera2CameraInfoImpl;
        CameraStateRegistry cameraStateRegistry2 = cameraStateRegistry;
        LiveDataObservable<CameraInternal.State> liveDataObservable = new LiveDataObservable<>();
        this.mObservableState = liveDataObservable;
        this.mCameraDeviceError = 0;
        this.mReleaseRequestCount = new AtomicInteger(0);
        this.mReleasedCaptureSessions = new LinkedHashMap();
        this.mTraceStateErrorCount = 0;
        this.mIsConfigAndCloseRequired = false;
        this.mIsConfiguringForClose = false;
        this.mIsPrimary = true;
        this.mNotifyStateAttachedSet = new HashSet();
        this.mCameraConfig = CameraConfigs.defaultConfig();
        this.mLock = new Object();
        this.mIsActiveResumingMode = false;
        this.mErrorTimeoutReopenScheduler = new ErrorTimeoutReopenScheduler();
        this.mCameraManager = cameraManagerCompat2;
        this.mCameraCoordinator = cameraCoordinator;
        this.mCameraStateRegistry = cameraStateRegistry2;
        ScheduledExecutorService newHandlerExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mScheduledExecutorService = newHandlerExecutor;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = newSequentialExecutor;
        this.mStateCallback = new StateCallback(newSequentialExecutor, newHandlerExecutor, j);
        this.mUseCaseAttachState = new UseCaseAttachState(str2);
        liveDataObservable.postValue(CameraInternal.State.CLOSED);
        CameraStateMachine cameraStateMachine = new CameraStateMachine(cameraStateRegistry2);
        this.mCameraStateMachine = cameraStateMachine;
        CaptureSessionRepository captureSessionRepository = new CaptureSessionRepository(newSequentialExecutor);
        this.mCaptureSessionRepository = captureSessionRepository;
        this.mDisplayInfoManager = displayInfoManager;
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str);
            this.mCameraCharacteristicsCompat = cameraCharacteristicsCompat;
            CaptureSessionRepository captureSessionRepository2 = captureSessionRepository;
            Camera2CameraControlImpl camera2CameraControlImpl = r1;
            Camera2CameraControlImpl camera2CameraControlImpl2 = new Camera2CameraControlImpl(cameraCharacteristicsCompat, newHandlerExecutor, newSequentialExecutor, new ControlUpdateListenerInternal(), camera2CameraInfoImpl.getCameraQuirks());
            this.mCameraControlInternal = camera2CameraControlImpl;
            this.mCameraInfoInternal = camera2CameraInfoImpl2;
            camera2CameraInfoImpl2.linkWithCameraControl(camera2CameraControlImpl);
            camera2CameraInfoImpl2.setCameraStateSource(cameraStateMachine.getStateLiveData());
            this.mDynamicRangesCompat = DynamicRangesCompat.fromCameraCharacteristics(cameraCharacteristicsCompat);
            this.mCaptureSession = newCaptureSession();
            Executor executor2 = newSequentialExecutor;
            this.mCaptureSessionOpenerBuilder = new SynchronizedCaptureSession.OpenerBuilder(newSequentialExecutor, newHandlerExecutor, handler, captureSessionRepository2, camera2CameraInfoImpl.getCameraQuirks(), DeviceQuirks.getAll());
            this.mCloseCameraBeforeCreateNewSessionQuirk = camera2CameraInfoImpl.getCameraQuirks().contains(LegacyCameraOutputConfigNullPointerQuirk.class);
            this.mConfigAndCloseQuirk = camera2CameraInfoImpl.getCameraQuirks().contains(LegacyCameraSurfaceCleanupQuirk.class);
            CameraAvailability cameraAvailability = new CameraAvailability(str2);
            this.mCameraAvailability = cameraAvailability;
            CameraConfigureAvailable cameraConfigureAvailable = new CameraConfigureAvailable();
            this.mCameraConfigureAvailable = cameraConfigureAvailable;
            cameraStateRegistry2.registerCamera(this, executor2, cameraConfigureAvailable, cameraAvailability);
            cameraManagerCompat2.registerAvailabilityCallback(executor2, cameraAvailability);
            this.mSupportedSurfaceCombination = new SupportedSurfaceCombination(context, str2, cameraManagerCompat2, new CamcorderProfileHelper() {
                public CamcorderProfile get(int i, int i2) {
                    return CamcorderProfile.get(i, i2);
                }

                public boolean hasProfile(int i, int i2) {
                    return CamcorderProfile.hasProfile(i, i2);
                }
            });
        } catch (CameraAccessExceptionCompat e) {
            throw CameraUnavailableExceptionHelper.createFrom(e);
        }
    }

    private void addMeteringRepeating() {
        MeteringRepeatingSession meteringRepeatingSession = this.mMeteringRepeatingSession;
        if (meteringRepeatingSession != null) {
            String meteringRepeatingId = getMeteringRepeatingId(meteringRepeatingSession);
            UseCaseAttachState useCaseAttachState = this.mUseCaseAttachState;
            SessionConfig sessionConfig = this.mMeteringRepeatingSession.getSessionConfig();
            UseCaseConfig<?> useCaseConfig = this.mMeteringRepeatingSession.getUseCaseConfig();
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
            useCaseAttachState.setUseCaseAttached(meteringRepeatingId, sessionConfig, useCaseConfig, (StreamSpec) null, Collections.singletonList(captureType));
            this.mUseCaseAttachState.setUseCaseActive(meteringRepeatingId, this.mMeteringRepeatingSession.getSessionConfig(), this.mMeteringRepeatingSession.getUseCaseConfig(), (StreamSpec) null, Collections.singletonList(captureType));
        }
    }

    private void addOrRemoveMeteringRepeatingUseCase() {
        SessionConfig build = this.mUseCaseAttachState.getAttachedBuilder().build();
        CaptureConfig repeatingCaptureConfig = build.getRepeatingCaptureConfig();
        int size = repeatingCaptureConfig.getSurfaces().size();
        int size2 = build.getSurfaces().size();
        if (build.getSurfaces().isEmpty()) {
            return;
        }
        if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
            if (this.mMeteringRepeatingSession == null) {
                this.mMeteringRepeatingSession = new MeteringRepeatingSession(this.mCameraInfoInternal.getCameraCharacteristicsCompat(), this.mDisplayInfoManager, new e(this, 1));
            }
            if (isSurfaceCombinationWithMeteringRepeatingSupported()) {
                addMeteringRepeating();
            } else {
                Logger.e(TAG, "Failed to add a repeating surface, CameraControl and ImageCapture may encounter issues due to the absence of repeating surface. Please add a UseCase (Preview or ImageAnalysis) that can provide a repeating surface for CameraControl and ImageCapture to function properly.");
            }
        } else if (size2 == 1 && size == 1) {
            removeMeteringRepeating();
        } else if (size >= 2) {
            removeMeteringRepeating();
        } else if (this.mMeteringRepeatingSession == null || isSurfaceCombinationWithMeteringRepeatingSupported()) {
            Logger.d(TAG, "No need to remove a previous mMeteringRepeating, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
        } else {
            removeMeteringRepeating();
        }
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig.Builder builder) {
        if (!builder.getSurfaces().isEmpty()) {
            Logger.w(TAG, "The capture config builder already has surface inside.");
            return false;
        }
        for (SessionConfig repeatingCaptureConfig : this.mUseCaseAttachState.getActiveAndAttachedSessionConfigs()) {
            CaptureConfig repeatingCaptureConfig2 = repeatingCaptureConfig.getRepeatingCaptureConfig();
            List<DeferrableSurface> surfaces = repeatingCaptureConfig2.getSurfaces();
            if (!surfaces.isEmpty()) {
                if (repeatingCaptureConfig2.getPreviewStabilizationMode() != 0) {
                    builder.setPreviewStabilization(repeatingCaptureConfig2.getPreviewStabilizationMode());
                }
                if (repeatingCaptureConfig2.getVideoStabilizationMode() != 0) {
                    builder.setVideoStabilization(repeatingCaptureConfig2.getVideoStabilizationMode());
                }
                for (DeferrableSurface addSurface : surfaces) {
                    builder.addSurface(addSurface);
                }
            }
        }
        if (!builder.getSurfaces().isEmpty()) {
            return true;
        }
        Logger.w(TAG, "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    /* access modifiers changed from: private */
    public void closeInternal() {
        debugLog("Closing camera.");
        boolean z = true;
        switch (this.mState.ordinal()) {
            case 3:
                if (this.mCameraDevice != null) {
                    z = false;
                }
                Preconditions.checkState(z);
                setState(InternalState.INITIALIZED);
                return;
            case 5:
            case 6:
            case 7:
                if (!this.mStateCallback.cancelScheduledReopen() && !this.mErrorTimeoutReopenScheduler.isErrorHandling()) {
                    z = false;
                }
                this.mErrorTimeoutReopenScheduler.cancel();
                setState(InternalState.CLOSING);
                if (z) {
                    Preconditions.checkState(isSessionCloseComplete());
                    configAndCloseIfNeeded();
                    return;
                }
                return;
            case 8:
            case 9:
                setState(InternalState.CLOSING);
                closeCamera(false);
                return;
            default:
                debugLog("close() ignored due to being in state: " + this.mState);
                return;
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public ListenableFuture<Void> configAndClose(@NonNull CameraDevice cameraDevice) {
        CaptureSession captureSession = new CaptureSession(this.mDynamicRangesCompat);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(FaceEnvironment.VALUE_CROP_HEIGHT, FaceEnvironment.VALUE_CROP_WIDTH);
        Surface surface = new Surface(surfaceTexture);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        immediateSurface.getTerminationFuture().addListener(new c(2, surface, surfaceTexture), CameraXExecutors.directExecutor());
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.addNonRepeatingSurface(immediateSurface);
        builder.setTemplateType(1);
        debugLog("Start configAndClose.");
        return FutureChain.from(Futures.transformAsyncOnCompletion(captureSession.open(builder.build(), cameraDevice, this.mCaptureSessionOpenerBuilder.build()))).transformAsync(new k(0, captureSession, immediateSurface), this.mExecutor);
    }

    /* access modifiers changed from: private */
    public void configAndCloseIfNeeded() {
        boolean z;
        if (this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        if (!this.mIsConfigAndCloseRequired) {
            finishClose();
        } else if (this.mIsConfiguringForClose) {
            debugLog("Ignored since configAndClose is processing");
        } else if (!this.mCameraAvailability.isCameraAvailable()) {
            this.mIsConfigAndCloseRequired = false;
            finishClose();
            debugLog("Ignore configAndClose and finish the close flow directly since camera is unavailable.");
        } else {
            debugLog("Open camera to configAndClose");
            ListenableFuture<Void> openCameraConfigAndClose = openCameraConfigAndClose();
            this.mIsConfiguringForClose = true;
            openCameraConfigAndClose.addListener(new l(this, 1), this.mExecutor);
        }
    }

    private CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());
        arrayList.add(this.mCaptureSessionRepository.getCameraStateCallback());
        arrayList.add(this.mStateCallback);
        return CameraDeviceStateCallbacks.createComboCallback((List<CameraDevice.StateCallback>) arrayList);
    }

    private int getCameraMode() {
        synchronized (this.mLock) {
            try {
                if (this.mCameraCoordinator.getCameraOperatingMode() == 2) {
                    return 1;
                }
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(@NonNull UseCase useCase) {
        if (useCase.getCamera() == null) {
            return null;
        }
        return StreamSharing.getCaptureTypes(useCase);
    }

    public static String getErrorMessage(int i) {
        if (i == 0) {
            return "ERROR_NONE";
        }
        if (i == 1) {
            return "ERROR_CAMERA_IN_USE";
        }
        if (i == 2) {
            return "ERROR_MAX_CAMERAS_IN_USE";
        }
        if (i == 3) {
            return "ERROR_CAMERA_DISABLED";
        }
        if (i == 4) {
            return "ERROR_CAMERA_DEVICE";
        }
        if (i != 5) {
            return "UNKNOWN ERROR";
        }
        return "ERROR_CAMERA_SERVICE";
    }

    @NonNull
    public static String getMeteringRepeatingId(@NonNull MeteringRepeatingSession meteringRepeatingSession) {
        return meteringRepeatingSession.getName() + meteringRepeatingSession.hashCode();
    }

    private ListenableFuture<Void> getOrCreateUserReleaseFuture() {
        if (this.mUserReleaseFuture == null) {
            if (this.mState != InternalState.RELEASED) {
                this.mUserReleaseFuture = CallbackToFutureAdapter.getFuture(new e(this, 2));
            } else {
                this.mUserReleaseFuture = Futures.immediateFuture(null);
            }
        }
        return this.mUserReleaseFuture;
    }

    @NonNull
    public static String getUseCaseId(@NonNull UseCase useCase) {
        return useCase.getName() + useCase.hashCode();
    }

    private boolean isSurfaceCombinationWithMeteringRepeatingSupported() {
        ArrayList arrayList = new ArrayList();
        int cameraMode = getCameraMode();
        for (UseCaseAttachState.UseCaseAttachInfo next : this.mUseCaseAttachState.getAttachedUseCaseInfo()) {
            if (next.getCaptureTypes() == null || next.getCaptureTypes().get(0) != UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                if (next.getStreamSpec() == null || next.getCaptureTypes() == null) {
                    Logger.w(TAG, "Invalid stream spec or capture types in " + next);
                    return false;
                }
                SessionConfig sessionConfig = next.getSessionConfig();
                UseCaseConfig<?> useCaseConfig = next.getUseCaseConfig();
                for (DeferrableSurface next2 : sessionConfig.getSurfaces()) {
                    arrayList.add(AttachedSurfaceInfo.create(this.mSupportedSurfaceCombination.transformSurfaceConfig(cameraMode, useCaseConfig.getInputFormat(), next2.getPrescribedSize()), useCaseConfig.getInputFormat(), next2.getPrescribedSize(), next.getStreamSpec().getDynamicRange(), next.getCaptureTypes(), next.getStreamSpec().getImplementationOptions(), useCaseConfig.getTargetFrameRate((Range<Integer>) null)));
                }
            }
        }
        Preconditions.checkNotNull(this.mMeteringRepeatingSession);
        HashMap hashMap = new HashMap();
        hashMap.put(this.mMeteringRepeatingSession.getUseCaseConfig(), Collections.singletonList(this.mMeteringRepeatingSession.getMeteringRepeatingSize()));
        try {
            this.mSupportedSurfaceCombination.getSuggestedStreamSpecifications(cameraMode, arrayList, hashMap, false, false);
            debugLog("Surface combination with metering repeating supported!");
            return true;
        } catch (IllegalArgumentException e) {
            debugLog("Surface combination with metering repeating  not supported!", e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addOrRemoveMeteringRepeatingUseCase$17() {
        if (isMeteringRepeatingAttached()) {
            resetUseCase(getMeteringRepeatingId(this.mMeteringRepeatingSession), this.mMeteringRepeatingSession.getSessionConfig(), this.mMeteringRepeatingSession.getUseCaseConfig(), (StreamSpec) null, Collections.singletonList(UseCaseConfigFactory.CaptureType.METERING_REPEATING));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$attachUseCases$15(List list) {
        try {
            tryAttachUseCases(list);
        } finally {
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$configAndClose$2(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ListenableFuture lambda$configAndClose$3(CaptureSession captureSession, DeferrableSurface deferrableSurface, Void voidR) throws Exception {
        captureSession.close();
        deferrableSurface.close();
        return captureSession.release(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$configAndCloseIfNeeded$0() {
        this.mIsConfiguringForClose = false;
        this.mIsConfigAndCloseRequired = false;
        debugLog("OpenCameraConfigAndClose is done, state: " + this.mState);
        int ordinal = this.mState.ordinal();
        if (ordinal == 1 || ordinal == 4) {
            Preconditions.checkState(isSessionCloseComplete());
            finishClose();
        } else if (ordinal != 6) {
            debugLog("OpenCameraConfigAndClose finished while in state: " + this.mState);
        } else if (this.mCameraDeviceError != 0) {
            debugLog("OpenCameraConfigAndClose in error: " + getErrorMessage(this.mCameraDeviceError));
            this.mStateCallback.scheduleCameraReopen();
        } else {
            tryOpenCameraDevice(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$getOrCreateUserReleaseFuture$6(CallbackToFutureAdapter.Completer completer) throws Exception {
        boolean z;
        if (this.mUserReleaseNotifier == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Camera can only be released once, so release completer should be null on creation.");
        this.mUserReleaseNotifier = completer;
        return "Release[camera=" + this + "]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$isMeteringRepeatingAttached$13(CallbackToFutureAdapter.Completer completer) {
        MeteringRepeatingSession meteringRepeatingSession = this.mMeteringRepeatingSession;
        if (meteringRepeatingSession == null) {
            completer.set(Boolean.FALSE);
            return;
        }
        completer.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseAttached(getMeteringRepeatingId(meteringRepeatingSession))));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$isMeteringRepeatingAttached$14(CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            this.mExecutor.execute(new i(this, completer, 1));
            return "isMeteringRepeatingAttached";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
            return "isMeteringRepeatingAttached";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$isUseCaseAttached$11(CallbackToFutureAdapter.Completer completer, String str) {
        completer.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseAttached(str)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$isUseCaseAttached$12(String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            this.mExecutor.execute(new j(this, completer, str));
            return "isUseCaseAttached";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if use case is attached. Camera executor shut down."));
            return "isUseCaseAttached";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onUseCaseActive$7(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, StreamSpec streamSpec, List list) {
        debugLog(ba.o("Use case ", str, " ACTIVE"));
        this.mUseCaseAttachState.setUseCaseActive(str, sessionConfig, useCaseConfig, streamSpec, list);
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig, useCaseConfig, streamSpec, list);
        updateCaptureSessionConfig();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onUseCaseInactive$8(String str) {
        debugLog(ba.o("Use case ", str, " INACTIVE"));
        this.mUseCaseAttachState.setUseCaseInactive(str);
        updateCaptureSessionConfig();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onUseCaseUpdated$9(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, StreamSpec streamSpec, List list) {
        debugLog(ba.o("Use case ", str, " UPDATED"));
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig, useCaseConfig, streamSpec, list);
        updateCaptureSessionConfig();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$openCameraConfigAndClose$1(final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());
            arrayList.add(this.mCaptureSessionRepository.getCameraStateCallback());
            arrayList.add(new CameraDevice.StateCallback() {
                public void onClosed(@NonNull CameraDevice cameraDevice) {
                    Camera2CameraImpl.this.debugLog("openCameraConfigAndClose camera closed");
                    completer.set(null);
                }

                public void onDisconnected(@NonNull CameraDevice cameraDevice) {
                    Camera2CameraImpl.this.debugLog("openCameraConfigAndClose camera disconnected");
                    completer.set(null);
                }

                public void onError(@NonNull CameraDevice cameraDevice, int i) {
                    Camera2CameraImpl.this.debugLog(ba.k(i, "openCameraConfigAndClose camera error "));
                    completer.set(null);
                }

                public void onOpened(@NonNull CameraDevice cameraDevice) {
                    Camera2CameraImpl.this.debugLog("openCameraConfigAndClose camera opened");
                    ListenableFuture access$600 = Camera2CameraImpl.this.configAndClose(cameraDevice);
                    Objects.requireNonNull(cameraDevice);
                    access$600.addListener(new x0(cameraDevice, 5), Camera2CameraImpl.this.mExecutor);
                }
            });
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, CameraDeviceStateCallbacks.createComboCallback((List<CameraDevice.StateCallback>) arrayList));
            return "configAndCloseTask";
        } catch (CameraAccessExceptionCompat | SecurityException e) {
            debugLog("Unable to open camera for configAndClose: " + e.getMessage(), e);
            completer.setException(e);
            return "configAndCloseTask";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4(CallbackToFutureAdapter.Completer completer) {
        Futures.propagate(releaseInternal(), completer);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$release$5(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new i(this, completer, 0));
        return "Release[request=" + this.mReleaseRequestCount.getAndIncrement() + "]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$resetUseCase$10(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, StreamSpec streamSpec, List list) {
        debugLog(ba.o("Use case ", str, " RESET"));
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig, useCaseConfig, streamSpec, list);
        addOrRemoveMeteringRepeatingUseCase();
        resetCaptureSession(false);
        updateCaptureSessionConfig();
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setActiveResumingMode$18(boolean z) {
        this.mIsActiveResumingMode = z;
        if (z && this.mState == InternalState.PENDING_OPEN) {
            tryForceOpenCameraDevice(false);
        }
    }

    @NonNull
    private CaptureSessionInterface newCaptureSession() {
        synchronized (this.mLock) {
            try {
                if (this.mSessionProcessor == null) {
                    CaptureSession captureSession = new CaptureSession(this.mDynamicRangesCompat, this.mCameraInfoInternal.getCameraQuirks());
                    return captureSession;
                }
                ProcessingCaptureSession processingCaptureSession = new ProcessingCaptureSession(this.mSessionProcessor, this.mCameraInfoInternal, this.mDynamicRangesCompat, this.mExecutor, this.mScheduledExecutorService);
                return processingCaptureSession;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void notifyStateAttachedAndCameraControlReady(List<UseCase> list) {
        for (UseCase next : list) {
            String useCaseId = getUseCaseId(next);
            if (!this.mNotifyStateAttachedSet.contains(useCaseId)) {
                this.mNotifyStateAttachedSet.add(useCaseId);
                next.onStateAttached();
                next.onCameraControlReady();
            }
        }
    }

    private void notifyStateDetachedToUseCases(List<UseCase> list) {
        for (UseCase next : list) {
            String useCaseId = getUseCaseId(next);
            if (this.mNotifyStateAttachedSet.contains(useCaseId)) {
                next.onStateDetached();
                this.mNotifyStateAttachedSet.remove(useCaseId);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    @NonNull
    private ListenableFuture<Void> openCameraConfigAndClose() {
        return CallbackToFutureAdapter.getFuture(new e(this, 3));
    }

    @SuppressLint({"MissingPermission"})
    private void openCameraDevice(boolean z) {
        if (!z) {
            this.mStateCallback.resetReopenMonitor();
        }
        this.mStateCallback.cancelScheduledReopen();
        this.mErrorTimeoutReopenScheduler.cancel();
        debugLog("Opening camera.");
        setState(InternalState.OPENING);
        try {
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, createDeviceStateCallback());
        } catch (CameraAccessExceptionCompat e) {
            debugLog("Unable to open camera due to " + e.getMessage());
            if (e.getReason() != 10001) {
                this.mErrorTimeoutReopenScheduler.start();
            } else {
                setState(InternalState.INITIALIZED, CameraState.StateError.create(7, e));
            }
        } catch (SecurityException e2) {
            debugLog("Unable to open camera due to " + e2.getMessage());
            setState(InternalState.REOPENING);
            this.mStateCallback.scheduleCameraReopen();
        }
    }

    /* access modifiers changed from: private */
    public void openInternal() {
        int ordinal = this.mState.ordinal();
        boolean z = false;
        if (ordinal == 2 || ordinal == 3) {
            tryForceOpenCameraDevice(false);
        } else if (ordinal != 4) {
            debugLog("open() ignored due to being in state: " + this.mState);
        } else {
            setState(InternalState.REOPENING);
            if (!isSessionCloseComplete() && !this.mIsConfiguringForClose && this.mCameraDeviceError == 0) {
                if (this.mCameraDevice != null) {
                    z = true;
                }
                Preconditions.checkState(z, "Camera Device should be open if session close is not complete");
                setState(InternalState.OPENED);
                openCaptureSession();
            }
        }
    }

    private ListenableFuture<Void> releaseInternal() {
        ListenableFuture<Void> orCreateUserReleaseFuture = getOrCreateUserReleaseFuture();
        boolean z = true;
        switch (this.mState.ordinal()) {
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
                if (!this.mStateCallback.cancelScheduledReopen() && !this.mErrorTimeoutReopenScheduler.isErrorHandling()) {
                    z = false;
                }
                this.mErrorTimeoutReopenScheduler.cancel();
                setState(InternalState.RELEASING);
                if (z) {
                    Preconditions.checkState(isSessionCloseComplete());
                    configAndCloseIfNeeded();
                    break;
                }
                break;
            case 2:
            case 3:
                if (this.mCameraDevice != null) {
                    z = false;
                }
                Preconditions.checkState(z);
                setState(InternalState.RELEASING);
                Preconditions.checkState(isSessionCloseComplete());
                configAndCloseIfNeeded();
                break;
            case 8:
            case 9:
                setState(InternalState.RELEASING);
                closeCamera(false);
                break;
            default:
                debugLog("release() ignored due to being in state: " + this.mState);
                break;
        }
        return orCreateUserReleaseFuture;
    }

    private void removeMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            UseCaseAttachState useCaseAttachState = this.mUseCaseAttachState;
            useCaseAttachState.setUseCaseDetached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            UseCaseAttachState useCaseAttachState2 = this.mUseCaseAttachState;
            useCaseAttachState2.setUseCaseInactive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            this.mMeteringRepeatingSession.clear();
            this.mMeteringRepeatingSession = null;
        }
    }

    private void resetUseCase(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig, @Nullable StreamSpec streamSpec, @Nullable List<UseCaseConfigFactory.CaptureType> list) {
        this.mExecutor.execute(new d(this, str, sessionConfig, useCaseConfig, streamSpec, list, 1));
    }

    @NonNull
    private Collection<UseCaseInfo> toUseCaseInfos(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase from : collection) {
            arrayList.add(UseCaseInfo.from(from, this.mIsPrimary));
        }
        return arrayList;
    }

    private void tryAttachUseCases(@NonNull Collection<UseCaseInfo> collection) {
        Size surfaceResolution;
        boolean isEmpty = this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty();
        ArrayList arrayList = new ArrayList();
        Rational rational = null;
        for (UseCaseInfo next : collection) {
            if (!this.mUseCaseAttachState.isUseCaseAttached(next.getUseCaseId())) {
                this.mUseCaseAttachState.setUseCaseAttached(next.getUseCaseId(), next.getSessionConfig(), next.getUseCaseConfig(), next.getStreamSpec(), next.getCaptureTypes());
                arrayList.add(next.getUseCaseId());
                if (next.getUseCaseType() == Preview.class && (surfaceResolution = next.getSurfaceResolution()) != null) {
                    rational = new Rational(surfaceResolution.getWidth(), surfaceResolution.getHeight());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            debugLog("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
            if (isEmpty) {
                this.mCameraControlInternal.setActive(true);
                this.mCameraControlInternal.incrementUseCount();
            }
            addOrRemoveMeteringRepeatingUseCase();
            updateZslDisabledByUseCaseConfigStatus();
            updateCaptureSessionConfig();
            resetCaptureSession(false);
            if (this.mState == InternalState.OPENED) {
                openCaptureSession();
            } else {
                openInternal();
            }
            if (rational != null) {
                this.mCameraControlInternal.setPreviewAspectRatio(rational);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tryDetachUseCases */
    public void lambda$detachUseCases$16(@NonNull Collection<UseCaseInfo> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (UseCaseInfo next : collection) {
            if (this.mUseCaseAttachState.isUseCaseAttached(next.getUseCaseId())) {
                this.mUseCaseAttachState.removeUseCase(next.getUseCaseId());
                arrayList.add(next.getUseCaseId());
                if (next.getUseCaseType() == Preview.class) {
                    z = true;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            debugLog("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
            if (z) {
                this.mCameraControlInternal.setPreviewAspectRatio((Rational) null);
            }
            addOrRemoveMeteringRepeatingUseCase();
            if (this.mUseCaseAttachState.getAttachedUseCaseConfigs().isEmpty()) {
                this.mCameraControlInternal.setZslDisabledByUserCaseConfig(false);
            } else {
                updateZslDisabledByUseCaseConfigStatus();
            }
            if (this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty()) {
                this.mCameraControlInternal.decrementUseCount();
                resetCaptureSession(false);
                this.mCameraControlInternal.setActive(false);
                this.mCaptureSession = newCaptureSession();
                closeInternal();
                return;
            }
            updateCaptureSessionConfig();
            resetCaptureSession(false);
            if (this.mState == InternalState.OPENED) {
                openCaptureSession();
            }
        }
    }

    private void updateZslDisabledByUseCaseConfigStatus() {
        boolean z = false;
        for (UseCaseConfig<?> isZslDisabled : this.mUseCaseAttachState.getAttachedUseCaseConfigs()) {
            z |= isZslDisabled.isZslDisabled(false);
        }
        this.mCameraControlInternal.setZslDisabledByUserCaseConfig(z);
    }

    public void attachUseCases(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (!arrayList.isEmpty()) {
            this.mCameraControlInternal.incrementUseCount();
            notifyStateAttachedAndCameraControlReady(new ArrayList(arrayList));
            try {
                this.mExecutor.execute(new g(this, new ArrayList(toUseCaseInfos(arrayList)), 1));
            } catch (RejectedExecutionException e) {
                debugLog("Unable to attach use cases.", e);
                this.mCameraControlInternal.decrementUseCount();
            }
        }
    }

    public void close() {
        this.mExecutor.execute(new l(this, 2));
    }

    public void closeCamera(boolean z) {
        boolean z2;
        if (this.mState == InternalState.CLOSING || this.mState == InternalState.RELEASING || (this.mState == InternalState.REOPENING && this.mCameraDeviceError != 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.mState + " (error: " + getErrorMessage(this.mCameraDeviceError) + ")");
        resetCaptureSession(z);
        this.mCaptureSession.cancelIssuedCaptureRequests();
    }

    public void debugLog(@NonNull String str) {
        debugLog(str, (Throwable) null);
    }

    public void detachUseCases(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(toUseCaseInfos(arrayList));
            notifyStateDetachedToUseCases(new ArrayList(arrayList));
            this.mExecutor.execute(new g(this, arrayList2, 0));
        }
    }

    @Nullable
    public SessionConfig findSessionConfigForSurface(@NonNull DeferrableSurface deferrableSurface) {
        for (SessionConfig next : this.mUseCaseAttachState.getAttachedSessionConfigs()) {
            if (next.getSurfaces().contains(deferrableSurface)) {
                return next;
            }
        }
        return null;
    }

    public void finishClose() {
        boolean z;
        if (this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState == InternalState.CLOSING) {
            setState(InternalState.INITIALIZED);
            return;
        }
        this.mCameraManager.unregisterAvailabilityCallback(this.mCameraAvailability);
        setState(InternalState.RELEASED);
        CallbackToFutureAdapter.Completer<Void> completer = this.mUserReleaseNotifier;
        if (completer != null) {
            completer.set(null);
            this.mUserReleaseNotifier = null;
        }
    }

    @VisibleForTesting
    @NonNull
    public CameraAvailability getCameraAvailability() {
        return this.mCameraAvailability;
    }

    public final /* synthetic */ CameraControl getCameraControl() {
        return o2.a(this);
    }

    @NonNull
    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    public final /* synthetic */ CameraInfo getCameraInfo() {
        return o2.b(this);
    }

    @NonNull
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    @NonNull
    public Observable<CameraInternal.State> getCameraState() {
        return this.mObservableState;
    }

    @NonNull
    public CameraConfig getExtendedConfig() {
        return this.mCameraConfig;
    }

    public final /* synthetic */ boolean getHasTransform() {
        return o2.d(this);
    }

    public final /* synthetic */ boolean isFrontFacing() {
        return o2.e(this);
    }

    @VisibleForTesting
    public boolean isMeteringRepeatingAttached() {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new e(this, 4)).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e);
        }
    }

    public boolean isSessionCloseComplete() {
        return this.mReleasedCaptureSessions.isEmpty();
    }

    @VisibleForTesting
    public boolean isUseCaseAttached(@NonNull UseCase useCase) {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new f(0, this, getUseCaseId(useCase))).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unable to check if use case is attached.", e);
        }
    }

    public final /* synthetic */ boolean isUseCasesCombinationSupported(boolean z, UseCase... useCaseArr) {
        return r1.a(this, z, useCaseArr);
    }

    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr) {
        return r1.c(this, useCaseArr);
    }

    public void onUseCaseActive(@NonNull UseCase useCase) {
        SessionConfig secondarySessionConfig;
        Preconditions.checkNotNull(useCase);
        String useCaseId = getUseCaseId(useCase);
        if (this.mIsPrimary) {
            secondarySessionConfig = useCase.getSessionConfig();
        } else {
            secondarySessionConfig = useCase.getSecondarySessionConfig();
        }
        SessionConfig sessionConfig = secondarySessionConfig;
        this.mExecutor.execute(new d(this, useCaseId, sessionConfig, useCase.getCurrentConfig(), useCase.getAttachedStreamSpec(), getCaptureTypes(useCase), 0));
    }

    public void onUseCaseInactive(@NonNull UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new c(3, this, getUseCaseId(useCase)));
    }

    public void onUseCaseReset(@NonNull UseCase useCase) {
        SessionConfig secondarySessionConfig;
        Preconditions.checkNotNull(useCase);
        if (this.mIsPrimary) {
            secondarySessionConfig = useCase.getSessionConfig();
        } else {
            secondarySessionConfig = useCase.getSecondarySessionConfig();
        }
        SessionConfig sessionConfig = secondarySessionConfig;
        resetUseCase(getUseCaseId(useCase), sessionConfig, useCase.getCurrentConfig(), useCase.getAttachedStreamSpec(), getCaptureTypes(useCase));
    }

    public void onUseCaseUpdated(@NonNull UseCase useCase) {
        SessionConfig secondarySessionConfig;
        Preconditions.checkNotNull(useCase);
        String useCaseId = getUseCaseId(useCase);
        if (this.mIsPrimary) {
            secondarySessionConfig = useCase.getSessionConfig();
        } else {
            secondarySessionConfig = useCase.getSecondarySessionConfig();
        }
        SessionConfig sessionConfig = secondarySessionConfig;
        this.mExecutor.execute(new d(this, useCaseId, sessionConfig, useCase.getCurrentConfig(), useCase.getAttachedStreamSpec(), getCaptureTypes(useCase), 2));
    }

    public void open() {
        this.mExecutor.execute(new l(this, 0));
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public void openCaptureSession() {
        boolean z;
        if (this.mState == InternalState.OPENED) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        SessionConfig.ValidatingBuilder attachedBuilder = this.mUseCaseAttachState.getAttachedBuilder();
        if (!attachedBuilder.isValid()) {
            debugLog("Unable to create capture session due to conflicting configurations");
        } else if (!this.mCameraStateRegistry.tryOpenCaptureSession(this.mCameraDevice.getId(), this.mCameraCoordinator.getPairedConcurrentCameraId(this.mCameraDevice.getId()))) {
            debugLog("Unable to create capture session in camera operating mode = " + this.mCameraCoordinator.getCameraOperatingMode());
        } else {
            HashMap hashMap = new HashMap();
            StreamUseCaseUtil.populateSurfaceToStreamUseCaseMapping(this.mUseCaseAttachState.getAttachedSessionConfigs(), this.mUseCaseAttachState.getAttachedUseCaseConfigs(), hashMap);
            this.mCaptureSession.setStreamUseCaseMap(hashMap);
            final CaptureSessionInterface captureSessionInterface = this.mCaptureSession;
            Futures.addCallback(captureSessionInterface.open(attachedBuilder.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()), new FutureCallback<Void>() {
                public void onFailure(@NonNull Throwable th) {
                    if (th instanceof DeferrableSurface.SurfaceClosedException) {
                        SessionConfig findSessionConfigForSurface = Camera2CameraImpl.this.findSessionConfigForSurface(((DeferrableSurface.SurfaceClosedException) th).getDeferrableSurface());
                        if (findSessionConfigForSurface != null) {
                            Camera2CameraImpl.this.postSurfaceClosedError(findSessionConfigForSurface);
                        }
                    } else if (th instanceof CancellationException) {
                        Camera2CameraImpl.this.debugLog("Unable to configure camera cancelled");
                    } else {
                        InternalState internalState = Camera2CameraImpl.this.mState;
                        InternalState internalState2 = InternalState.OPENED;
                        if (internalState == internalState2) {
                            Camera2CameraImpl.this.setState(internalState2, CameraState.StateError.create(4, th));
                        }
                        Logger.e(Camera2CameraImpl.TAG, "Unable to configure camera " + Camera2CameraImpl.this, th);
                        Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                        if (camera2CameraImpl.mCaptureSession == captureSessionInterface) {
                            camera2CameraImpl.resetCaptureSession(false);
                        }
                    }
                }

                public void onSuccess(@Nullable Void voidR) {
                    if (Camera2CameraImpl.this.mCameraCoordinator.getCameraOperatingMode() == 2 && Camera2CameraImpl.this.mState == InternalState.OPENED) {
                        Camera2CameraImpl.this.setState(InternalState.CONFIGURED);
                    }
                }
            }, this.mExecutor);
        }
    }

    public void postSurfaceClosedError(@NonNull SessionConfig sessionConfig) {
        ScheduledExecutorService mainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        SessionConfig.ErrorListener errorListener = sessionConfig.getErrorListener();
        if (errorListener != null) {
            debugLog("Posting surface closed", new Throwable());
            mainThreadExecutor.execute(new c(1, errorListener, sessionConfig));
        }
    }

    @NonNull
    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new e(this, 0));
    }

    public ListenableFuture<Void> releaseSession(@NonNull final CaptureSessionInterface captureSessionInterface, boolean z) {
        captureSessionInterface.close();
        ListenableFuture<Void> release = captureSessionInterface.release(z);
        debugLog("Releasing session in state " + this.mState.name());
        this.mReleasedCaptureSessions.put(captureSessionInterface, release);
        Futures.addCallback(release, new FutureCallback<Void>() {
            public void onFailure(@NonNull Throwable th) {
            }

            public void onSuccess(@Nullable Void voidR) {
                Camera2CameraImpl.this.mReleasedCaptureSessions.remove(captureSessionInterface);
                int ordinal = Camera2CameraImpl.this.mState.ordinal();
                if (!(ordinal == 1 || ordinal == 4)) {
                    if (ordinal == 5 || (ordinal == 6 && Camera2CameraImpl.this.mCameraDeviceError != 0)) {
                        Camera2CameraImpl.this.debugLog("Camera reopen required. Checking if the current camera can be closed safely.");
                    } else {
                        return;
                    }
                }
                if (Camera2CameraImpl.this.isSessionCloseComplete()) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.mCameraDevice != null) {
                        camera2CameraImpl.debugLog("closing camera");
                        ApiCompat.Api21Impl.close(Camera2CameraImpl.this.mCameraDevice);
                        Camera2CameraImpl.this.mCameraDevice = null;
                    }
                }
            }
        }, CameraXExecutors.directExecutor());
        return release;
    }

    public void resetCaptureSession(boolean z) {
        boolean z2;
        if (this.mCaptureSession != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        debugLog("Resetting Capture Session");
        CaptureSessionInterface captureSessionInterface = this.mCaptureSession;
        SessionConfig sessionConfig = captureSessionInterface.getSessionConfig();
        List<CaptureConfig> captureConfigs = captureSessionInterface.getCaptureConfigs();
        CaptureSessionInterface newCaptureSession = newCaptureSession();
        this.mCaptureSession = newCaptureSession;
        newCaptureSession.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(captureConfigs);
        if (this.mState.ordinal() != 8) {
            debugLog("Skipping Capture Session state check due to current camera state: " + this.mState + " and previous session status: " + captureSessionInterface.isInOpenState());
        } else if (this.mCloseCameraBeforeCreateNewSessionQuirk && captureSessionInterface.isInOpenState()) {
            debugLog("Close camera before creating new session");
            setState(InternalState.REOPENING_QUIRK);
        }
        if (this.mConfigAndCloseQuirk && captureSessionInterface.isInOpenState()) {
            debugLog("ConfigAndClose is required when close the camera.");
            this.mIsConfigAndCloseRequired = true;
        }
        releaseSession(captureSessionInterface, z);
    }

    public void setActiveResumingMode(boolean z) {
        this.mExecutor.execute(new h(this, z));
    }

    public void setExtendedConfig(@Nullable CameraConfig cameraConfig) {
        if (cameraConfig == null) {
            cameraConfig = CameraConfigs.defaultConfig();
        }
        SessionProcessor sessionProcessor = cameraConfig.getSessionProcessor((SessionProcessor) null);
        this.mCameraConfig = cameraConfig;
        synchronized (this.mLock) {
            this.mSessionProcessor = sessionProcessor;
        }
    }

    public void setPrimary(boolean z) {
        this.mIsPrimary = z;
    }

    public void setState(@NonNull InternalState internalState) {
        setState(internalState, (CameraState.StateError) null);
    }

    public void submitCaptureRequests(@NonNull List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig next : list) {
            CaptureConfig.Builder from = CaptureConfig.Builder.from(next);
            if (next.getTemplateType() == 5 && next.getCameraCaptureResult() != null) {
                from.setCameraCaptureResult(next.getCameraCaptureResult());
            }
            if (!next.getSurfaces().isEmpty() || !next.isUseRepeatingSurface() || checkAndAttachRepeatingSurface(from)) {
                arrayList.add(from.build());
            }
        }
        debugLog("Issue capture request");
        this.mCaptureSession.issueCaptureRequests(arrayList);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", new Object[]{Integer.valueOf(hashCode()), this.mCameraInfoInternal.getCameraId()});
    }

    public void traceInternalState(@NonNull InternalState internalState, @Nullable CameraState.StateError stateError) {
        int i;
        if (Trace.isEnabled()) {
            Trace.setCounter("CX:C2State[" + this + "]", internalState.ordinal());
            if (stateError != null) {
                this.mTraceStateErrorCount++;
            }
            if (this.mTraceStateErrorCount > 0) {
                String str = "CX:C2StateErrorCode[" + this + "]";
                if (stateError != null) {
                    i = stateError.getCode();
                } else {
                    i = 0;
                }
                Trace.setCounter(str, i);
            }
        }
    }

    public void tryForceOpenCameraDevice(boolean z) {
        debugLog("Attempting to force open the camera.");
        if (!this.mCameraStateRegistry.tryOpenCamera(this)) {
            debugLog("No cameras available. Waiting for available camera before opening camera.");
            setState(InternalState.PENDING_OPEN);
            return;
        }
        openCameraDevice(z);
    }

    public void tryOpenCameraDevice(boolean z) {
        debugLog("Attempting to open the camera.");
        if (!this.mCameraAvailability.isCameraAvailable() || !this.mCameraStateRegistry.tryOpenCamera(this)) {
            debugLog("No cameras available. Waiting for available camera before opening camera.");
            setState(InternalState.PENDING_OPEN);
            return;
        }
        openCameraDevice(z);
    }

    public void updateCaptureSessionConfig() {
        SessionConfig.ValidatingBuilder activeAndAttachedBuilder = this.mUseCaseAttachState.getActiveAndAttachedBuilder();
        if (activeAndAttachedBuilder.isValid()) {
            this.mCameraControlInternal.setTemplate(activeAndAttachedBuilder.build().getTemplateType());
            activeAndAttachedBuilder.add(this.mCameraControlInternal.getSessionConfig());
            this.mCaptureSession.setSessionConfig(activeAndAttachedBuilder.build());
            return;
        }
        this.mCameraControlInternal.resetTemplate();
        this.mCaptureSession.setSessionConfig(this.mCameraControlInternal.getSessionConfig());
    }

    private void debugLog(@NonNull String str, @Nullable Throwable th) {
        Logger.d(TAG, e.n("{", toString(), "} ", str), th);
    }

    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return r1.b(this, useCaseArr);
    }

    public void setState(@NonNull InternalState internalState, @Nullable CameraState.StateError stateError) {
        setState(internalState, stateError, true);
    }

    public void setState(@NonNull InternalState internalState, @Nullable CameraState.StateError stateError, boolean z) {
        CameraInternal.State state;
        debugLog("Transitioning camera internal state: " + this.mState + " --> " + internalState);
        traceInternalState(internalState, stateError);
        this.mState = internalState;
        switch (internalState.ordinal()) {
            case 0:
                state = CameraInternal.State.RELEASED;
                break;
            case 1:
                state = CameraInternal.State.RELEASING;
                break;
            case 2:
                state = CameraInternal.State.CLOSED;
                break;
            case 3:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case 4:
            case 5:
                state = CameraInternal.State.CLOSING;
                break;
            case 6:
            case 7:
                state = CameraInternal.State.OPENING;
                break;
            case 8:
                state = CameraInternal.State.OPEN;
                break;
            case 9:
                state = CameraInternal.State.CONFIGURED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + internalState);
        }
        this.mCameraStateRegistry.markCameraState(this, state, z);
        this.mObservableState.postValue(state);
        this.mCameraStateMachine.updateState(state, stateError);
    }
}
