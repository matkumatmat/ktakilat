package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraInternal;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class CameraStateRegistry implements CameraCoordinator.ConcurrentCameraModeListener {
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_CONCURRENT_MODE = 2;
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_SINGLE_MODE = 1;
    private static final String TAG = "CameraStateRegistry";
    @GuardedBy("mLock")
    private int mAvailableCameras;
    @GuardedBy("mLock")
    private final CameraCoordinator mCameraCoordinator;
    @GuardedBy("mLock")
    private final Map<Camera, CameraRegistration> mCameraStates;
    private final StringBuilder mDebugString = new StringBuilder();
    private final Object mLock;
    private int mMaxAllowedOpenedCameras;

    public static class CameraRegistration {
        private final Executor mNotifyExecutor;
        private final OnConfigureAvailableListener mOnConfigureAvailableListener;
        private final OnOpenAvailableListener mOnOpenAvailableListener;
        private CameraInternal.State mState;

        public CameraRegistration(@Nullable CameraInternal.State state, @NonNull Executor executor, @NonNull OnConfigureAvailableListener onConfigureAvailableListener, @NonNull OnOpenAvailableListener onOpenAvailableListener) {
            this.mState = state;
            this.mNotifyExecutor = executor;
            this.mOnConfigureAvailableListener = onConfigureAvailableListener;
            this.mOnOpenAvailableListener = onOpenAvailableListener;
        }

        public CameraInternal.State getState() {
            return this.mState;
        }

        public void notifyOnConfigureAvailableListener() {
            try {
                Executor executor = this.mNotifyExecutor;
                OnConfigureAvailableListener onConfigureAvailableListener = this.mOnConfigureAvailableListener;
                Objects.requireNonNull(onConfigureAvailableListener);
                executor.execute(new x0(onConfigureAvailableListener, 8));
            } catch (RejectedExecutionException e) {
                Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to configure.", e);
            }
        }

        public void notifyOnOpenAvailableListener() {
            try {
                Executor executor = this.mNotifyExecutor;
                OnOpenAvailableListener onOpenAvailableListener = this.mOnOpenAvailableListener;
                Objects.requireNonNull(onOpenAvailableListener);
                executor.execute(new x0(onOpenAvailableListener, 7));
            } catch (RejectedExecutionException e) {
                Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to open.", e);
            }
        }

        public CameraInternal.State setState(@Nullable CameraInternal.State state) {
            CameraInternal.State state2 = this.mState;
            this.mState = state;
            return state2;
        }
    }

    public interface OnConfigureAvailableListener {
        void onConfigureAvailable();
    }

    public interface OnOpenAvailableListener {
        void onOpenAvailable();
    }

    public CameraStateRegistry(@NonNull CameraCoordinator cameraCoordinator, int i) {
        Object obj = new Object();
        this.mLock = obj;
        this.mCameraStates = new HashMap();
        this.mMaxAllowedOpenedCameras = i;
        synchronized (obj) {
            this.mCameraCoordinator = cameraCoordinator;
            this.mAvailableCameras = this.mMaxAllowedOpenedCameras;
        }
    }

    @GuardedBy("mLock")
    @Nullable
    private CameraRegistration getCameraRegistration(@NonNull String str) {
        for (Camera next : this.mCameraStates.keySet()) {
            if (str.equals(((CameraInfoInternal) next.getCameraInfo()).getCameraId())) {
                return this.mCameraStates.get(next);
            }
        }
        return null;
    }

    private static boolean isOpen(@Nullable CameraInternal.State state) {
        if (state == null || !state.holdsCameraSlot()) {
            return false;
        }
        return true;
    }

    @WorkerThread
    @GuardedBy("mLock")
    private void recalculateAvailableCameras() {
        String str;
        if (Logger.isDebugEnabled(TAG)) {
            this.mDebugString.setLength(0);
            this.mDebugString.append("Recalculating open cameras:\n");
            this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{"Camera", "State"}));
            this.mDebugString.append("-------------------------------------------------------------------\n");
        }
        int i = 0;
        for (Map.Entry next : this.mCameraStates.entrySet()) {
            if (Logger.isDebugEnabled(TAG)) {
                if (((CameraRegistration) next.getValue()).getState() != null) {
                    str = ((CameraRegistration) next.getValue()).getState().toString();
                } else {
                    str = "UNKNOWN";
                }
                this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{((Camera) next.getKey()).toString(), str}));
            }
            if (isOpen(((CameraRegistration) next.getValue()).getState())) {
                i++;
            }
        }
        if (Logger.isDebugEnabled(TAG)) {
            this.mDebugString.append("-------------------------------------------------------------------\n");
            StringBuilder sb = this.mDebugString;
            Locale locale = Locale.US;
            int i2 = this.mMaxAllowedOpenedCameras;
            sb.append("Open count: " + i + " (Max allowed: " + i2 + ")");
            Logger.d(TAG, this.mDebugString.toString());
        }
        this.mAvailableCameras = Math.max(this.mMaxAllowedOpenedCameras - i, 0);
    }

    private static void traceState(Camera camera, CameraInternal.State state) {
        if (Trace.isEnabled()) {
            Trace.setCounter("CX:State[" + camera + "]", state.ordinal());
        }
    }

    @GuardedBy("mLock")
    @Nullable
    private CameraInternal.State unregisterCamera(@NonNull Camera camera) {
        CameraRegistration remove = this.mCameraStates.remove(camera);
        if (remove == null) {
            return null;
        }
        recalculateAvailableCameras();
        return remove.getState();
    }

    @GuardedBy("mLock")
    @Nullable
    private CameraInternal.State updateAndVerifyState(@NonNull Camera camera, @NonNull CameraInternal.State state) {
        boolean z;
        CameraInternal.State state2 = ((CameraRegistration) Preconditions.checkNotNull(this.mCameraStates.get(camera), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).setState(state);
        CameraInternal.State state3 = CameraInternal.State.OPENING;
        if (state == state3) {
            if (isOpen(state) || state2 == state3) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (state2 != state) {
            traceState(camera, state);
            recalculateAvailableCameras();
        }
        return state2;
    }

    public boolean isCameraClosing() {
        synchronized (this.mLock) {
            try {
                for (Map.Entry<Camera, CameraRegistration> value : this.mCameraStates.entrySet()) {
                    if (((CameraRegistration) value.getValue()).getState() == CameraInternal.State.CLOSING) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void markCameraState(@NonNull Camera camera, @NonNull CameraInternal.State state) {
        markCameraState(camera, state, true);
    }

    public void onCameraOperatingModeUpdated(int i, int i2) {
        int i3;
        boolean z;
        synchronized (this.mLock) {
            boolean z2 = true;
            if (i2 == 2) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            this.mMaxAllowedOpenedCameras = i3;
            if (i == 2 || i2 != 2) {
                z = false;
            } else {
                z = true;
            }
            if (i != 2 || i2 == 2) {
                z2 = false;
            }
            if (z || z2) {
                recalculateAvailableCameras();
            }
        }
    }

    public void registerCamera(@NonNull Camera camera, @NonNull Executor executor, @NonNull OnConfigureAvailableListener onConfigureAvailableListener, @NonNull OnOpenAvailableListener onOpenAvailableListener) {
        synchronized (this.mLock) {
            Preconditions.checkState(!this.mCameraStates.containsKey(camera), "Camera is already registered: " + camera);
            this.mCameraStates.put(camera, new CameraRegistration((CameraInternal.State) null, executor, onConfigureAvailableListener, onOpenAvailableListener));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0078 A[Catch:{ all -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097 A[Catch:{ all -> 0x0055 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean tryOpenCamera(@androidx.annotation.NonNull androidx.camera.core.Camera r13) {
        /*
            r12 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = " --> "
            java.lang.Object r3 = r12.mLock
            monitor-enter(r3)
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r4 = r12.mCameraStates     // Catch:{ all -> 0x0055 }
            java.lang.Object r4 = r4.get(r13)     // Catch:{ all -> 0x0055 }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r4 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r4     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = "Camera must first be registered with registerCamera()"
            java.lang.Object r4 = androidx.core.util.Preconditions.checkNotNull(r4, r5)     // Catch:{ all -> 0x0055 }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r4 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r4     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = "CameraStateRegistry"
            boolean r5 = androidx.camera.core.Logger.isDebugEnabled(r5)     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0057
            java.lang.StringBuilder r5 = r12.mDebugString     // Catch:{ all -> 0x0055 }
            r5.setLength(r1)     // Catch:{ all -> 0x0055 }
            java.lang.StringBuilder r5 = r12.mDebugString     // Catch:{ all -> 0x0055 }
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ all -> 0x0055 }
            java.lang.String r7 = "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]"
            int r8 = r12.mAvailableCameras     // Catch:{ all -> 0x0055 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0055 }
            androidx.camera.core.impl.CameraInternal$State r9 = r4.getState()     // Catch:{ all -> 0x0055 }
            boolean r9 = isOpen(r9)     // Catch:{ all -> 0x0055 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0055 }
            androidx.camera.core.impl.CameraInternal$State r10 = r4.getState()     // Catch:{ all -> 0x0055 }
            r11 = 4
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x0055 }
            r11[r1] = r13     // Catch:{ all -> 0x0055 }
            r11[r0] = r8     // Catch:{ all -> 0x0055 }
            r8 = 2
            r11[r8] = r9     // Catch:{ all -> 0x0055 }
            r8 = 3
            r11[r8] = r10     // Catch:{ all -> 0x0055 }
            java.lang.String r6 = java.lang.String.format(r6, r7, r11)     // Catch:{ all -> 0x0055 }
            r5.append(r6)     // Catch:{ all -> 0x0055 }
            goto L_0x0057
        L_0x0055:
            r13 = move-exception
            goto L_0x009c
        L_0x0057:
            int r5 = r12.mAvailableCameras     // Catch:{ all -> 0x0055 }
            if (r5 > 0) goto L_0x0068
            androidx.camera.core.impl.CameraInternal$State r5 = r4.getState()     // Catch:{ all -> 0x0055 }
            boolean r5 = isOpen(r5)     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r0 = 0
            goto L_0x0070
        L_0x0068:
            androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.OPENING     // Catch:{ all -> 0x0055 }
            r4.setState(r1)     // Catch:{ all -> 0x0055 }
            traceState(r13, r1)     // Catch:{ all -> 0x0055 }
        L_0x0070:
            java.lang.String r13 = "CameraStateRegistry"
            boolean r13 = androidx.camera.core.Logger.isDebugEnabled(r13)     // Catch:{ all -> 0x0055 }
            if (r13 == 0) goto L_0x0095
            java.lang.StringBuilder r13 = r12.mDebugString     // Catch:{ all -> 0x0055 }
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0081
            java.lang.String r1 = "SUCCESS"
            goto L_0x0083
        L_0x0081:
            java.lang.String r1 = "FAIL"
        L_0x0083:
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x0055 }
            r13.append(r1)     // Catch:{ all -> 0x0055 }
            java.lang.String r13 = "CameraStateRegistry"
            java.lang.StringBuilder r1 = r12.mDebugString     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0055 }
            androidx.camera.core.Logger.d(r13, r1)     // Catch:{ all -> 0x0055 }
        L_0x0095:
            if (r0 == 0) goto L_0x009a
            r12.recalculateAvailableCameras()     // Catch:{ all -> 0x0055 }
        L_0x009a:
            monitor-exit(r3)     // Catch:{ all -> 0x0055 }
            return r0
        L_0x009c:
            monitor-exit(r3)     // Catch:{ all -> 0x0055 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.tryOpenCamera(androidx.camera.core.Camera):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
        return r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0047 A[Catch:{ all -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055 A[ADDED_TO_REGION, Catch:{ all -> 0x000f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean tryOpenCaptureSession(@androidx.annotation.NonNull java.lang.String r6, @androidx.annotation.Nullable java.lang.String r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            androidx.camera.core.concurrent.CameraCoordinator r1 = r5.mCameraCoordinator     // Catch:{ all -> 0x000f }
            int r1 = r1.getCameraOperatingMode()     // Catch:{ all -> 0x000f }
            r2 = 2
            r3 = 1
            if (r1 == r2) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r3
        L_0x000f:
            r6 = move-exception
            goto L_0x005b
        L_0x0011:
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r6 = r5.getCameraRegistration(r6)     // Catch:{ all -> 0x000f }
            r1 = 0
            if (r6 == 0) goto L_0x001d
            androidx.camera.core.impl.CameraInternal$State r6 = r6.getState()     // Catch:{ all -> 0x000f }
            goto L_0x001e
        L_0x001d:
            r6 = r1
        L_0x001e:
            if (r7 == 0) goto L_0x0025
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r7 = r5.getCameraRegistration(r7)     // Catch:{ all -> 0x000f }
            goto L_0x0026
        L_0x0025:
            r7 = r1
        L_0x0026:
            if (r7 == 0) goto L_0x002c
            androidx.camera.core.impl.CameraInternal$State r1 = r7.getState()     // Catch:{ all -> 0x000f }
        L_0x002c:
            androidx.camera.core.impl.CameraInternal$State r7 = androidx.camera.core.impl.CameraInternal.State.OPEN     // Catch:{ all -> 0x000f }
            boolean r2 = r7.equals(r6)     // Catch:{ all -> 0x000f }
            r4 = 0
            if (r2 != 0) goto L_0x0040
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch:{ all -> 0x000f }
            boolean r6 = r2.equals(r6)     // Catch:{ all -> 0x000f }
            if (r6 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r6 = 0
            goto L_0x0041
        L_0x0040:
            r6 = 1
        L_0x0041:
            boolean r7 = r7.equals(r1)     // Catch:{ all -> 0x000f }
            if (r7 != 0) goto L_0x0052
            androidx.camera.core.impl.CameraInternal$State r7 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch:{ all -> 0x000f }
            boolean r7 = r7.equals(r1)     // Catch:{ all -> 0x000f }
            if (r7 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r7 = 0
            goto L_0x0053
        L_0x0052:
            r7 = 1
        L_0x0053:
            if (r6 == 0) goto L_0x0058
            if (r7 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r3 = 0
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r3
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.tryOpenCaptureSession(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        r2 = r6.mCameraCoordinator.getPairedConcurrentCameraId(((androidx.camera.core.impl.CameraInfoInternal) r7.getCameraInfo()).getCameraId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009f, code lost:
        if (r4 == null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a1, code lost:
        r7 = r4.values().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ad, code lost:
        if (r7.hasNext() == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00af, code lost:
        ((androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r7.next()).notifyOnOpenAvailableListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b9, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bb, code lost:
        r2.notifyOnConfigureAvailableListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void markCameraState(@androidx.annotation.NonNull androidx.camera.core.Camera r7, @androidx.annotation.NonNull androidx.camera.core.impl.CameraInternal.State r8, boolean r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            int r1 = r6.mAvailableCameras     // Catch:{ all -> 0x000e }
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal.State.RELEASED     // Catch:{ all -> 0x000e }
            if (r8 != r2) goto L_0x0011
            androidx.camera.core.impl.CameraInternal$State r2 = r6.unregisterCamera(r7)     // Catch:{ all -> 0x000e }
            goto L_0x0015
        L_0x000e:
            r7 = move-exception
            goto L_0x00bf
        L_0x0011:
            androidx.camera.core.impl.CameraInternal$State r2 = r6.updateAndVerifyState(r7, r8)     // Catch:{ all -> 0x000e }
        L_0x0015:
            if (r2 != r8) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x0019:
            androidx.camera.core.concurrent.CameraCoordinator r2 = r6.mCameraCoordinator     // Catch:{ all -> 0x000e }
            int r2 = r2.getCameraOperatingMode()     // Catch:{ all -> 0x000e }
            r3 = 2
            r4 = 0
            if (r2 != r3) goto L_0x003e
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch:{ all -> 0x000e }
            if (r8 != r2) goto L_0x003e
            androidx.camera.core.CameraInfo r2 = r7.getCameraInfo()     // Catch:{ all -> 0x000e }
            androidx.camera.core.impl.CameraInfoInternal r2 = (androidx.camera.core.impl.CameraInfoInternal) r2     // Catch:{ all -> 0x000e }
            java.lang.String r2 = r2.getCameraId()     // Catch:{ all -> 0x000e }
            androidx.camera.core.concurrent.CameraCoordinator r3 = r6.mCameraCoordinator     // Catch:{ all -> 0x000e }
            java.lang.String r2 = r3.getPairedConcurrentCameraId(r2)     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x003e
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r2 = r6.getCameraRegistration(r2)     // Catch:{ all -> 0x000e }
            goto L_0x003f
        L_0x003e:
            r2 = r4
        L_0x003f:
            r3 = 1
            if (r1 >= r3) goto L_0x007f
            int r1 = r6.mAvailableCameras     // Catch:{ all -> 0x000e }
            if (r1 <= 0) goto L_0x007f
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x000e }
            r4.<init>()     // Catch:{ all -> 0x000e }
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r8 = r6.mCameraStates     // Catch:{ all -> 0x000e }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x000e }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x000e }
        L_0x0055:
            boolean r1 = r8.hasNext()     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x0097
            java.lang.Object r1 = r8.next()     // Catch:{ all -> 0x000e }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x000e }
            java.lang.Object r3 = r1.getValue()     // Catch:{ all -> 0x000e }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r3 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r3     // Catch:{ all -> 0x000e }
            androidx.camera.core.impl.CameraInternal$State r3 = r3.getState()     // Catch:{ all -> 0x000e }
            androidx.camera.core.impl.CameraInternal$State r5 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch:{ all -> 0x000e }
            if (r3 != r5) goto L_0x0055
            java.lang.Object r3 = r1.getKey()     // Catch:{ all -> 0x000e }
            androidx.camera.core.Camera r3 = (androidx.camera.core.Camera) r3     // Catch:{ all -> 0x000e }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x000e }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch:{ all -> 0x000e }
            r4.put(r3, r1)     // Catch:{ all -> 0x000e }
            goto L_0x0055
        L_0x007f:
            androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch:{ all -> 0x000e }
            if (r8 != r1) goto L_0x0097
            int r8 = r6.mAvailableCameras     // Catch:{ all -> 0x000e }
            if (r8 <= 0) goto L_0x0097
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x000e }
            r4.<init>()     // Catch:{ all -> 0x000e }
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r8 = r6.mCameraStates     // Catch:{ all -> 0x000e }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ all -> 0x000e }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r8 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r8     // Catch:{ all -> 0x000e }
            r4.put(r7, r8)     // Catch:{ all -> 0x000e }
        L_0x0097:
            if (r4 == 0) goto L_0x009e
            if (r9 != 0) goto L_0x009e
            r4.remove(r7)     // Catch:{ all -> 0x000e }
        L_0x009e:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            if (r4 == 0) goto L_0x00b9
            java.util.Collection r7 = r4.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x00a9:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00b9
            java.lang.Object r8 = r7.next()
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r8 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r8
            r8.notifyOnOpenAvailableListener()
            goto L_0x00a9
        L_0x00b9:
            if (r2 == 0) goto L_0x00be
            r2.notifyOnConfigureAvailableListener()
        L_0x00be:
            return
        L_0x00bf:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.markCameraState(androidx.camera.core.Camera, androidx.camera.core.impl.CameraInternal$State, boolean):void");
    }
}
