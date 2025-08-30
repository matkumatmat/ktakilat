package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class CameraRepository {
    private static final String TAG = "CameraRepository";
    @GuardedBy("mCamerasLock")
    private final Map<String, CameraInternal> mCameras = new LinkedHashMap();
    private final Object mCamerasLock = new Object();
    @GuardedBy("mCamerasLock")
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;
    @GuardedBy("mCamerasLock")
    private ListenableFuture<Void> mDeinitFuture;
    @GuardedBy("mCamerasLock")
    private final Set<CameraInternal> mReleasingCameras = new HashSet();

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$deinit$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mCamerasLock) {
            this.mDeinitCompleter = completer;
        }
        return "CameraRepository-deinit";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$deinit$1(CameraInternal cameraInternal) {
        synchronized (this.mCamerasLock) {
            try {
                this.mReleasingCameras.remove(cameraInternal);
                if (this.mReleasingCameras.isEmpty()) {
                    Preconditions.checkNotNull(this.mDeinitCompleter);
                    this.mDeinitCompleter.set(null);
                    this.mDeinitCompleter = null;
                    this.mDeinitFuture = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r1;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> deinit() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mCamerasLock
            monitor-enter(r0)
            java.util.Map<java.lang.String, androidx.camera.core.impl.CameraInternal> r1 = r7.mCameras     // Catch:{ all -> 0x0015 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0015 }
            if (r1 == 0) goto L_0x0019
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r1 = r7.mDeinitFuture     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0017
            r1 = 0
            com.google.common.util.concurrent.ListenableFuture r1 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r1)     // Catch:{ all -> 0x0015 }
            goto L_0x0017
        L_0x0015:
            r1 = move-exception
            goto L_0x0065
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return r1
        L_0x0019:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r1 = r7.mDeinitFuture     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x002a
            k0 r1 = new k0     // Catch:{ all -> 0x0015 }
            r2 = 8
            r1.<init>(r7, r2)     // Catch:{ all -> 0x0015 }
            com.google.common.util.concurrent.ListenableFuture r1 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r1)     // Catch:{ all -> 0x0015 }
            r7.mDeinitFuture = r1     // Catch:{ all -> 0x0015 }
        L_0x002a:
            java.util.Set<androidx.camera.core.impl.CameraInternal> r2 = r7.mReleasingCameras     // Catch:{ all -> 0x0015 }
            java.util.Map<java.lang.String, androidx.camera.core.impl.CameraInternal> r3 = r7.mCameras     // Catch:{ all -> 0x0015 }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x0015 }
            r2.addAll(r3)     // Catch:{ all -> 0x0015 }
            java.util.Map<java.lang.String, androidx.camera.core.impl.CameraInternal> r2 = r7.mCameras     // Catch:{ all -> 0x0015 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0015 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0015 }
        L_0x003f:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0015 }
            if (r3 == 0) goto L_0x005e
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0015 }
            androidx.camera.core.impl.CameraInternal r3 = (androidx.camera.core.impl.CameraInternal) r3     // Catch:{ all -> 0x0015 }
            com.google.common.util.concurrent.ListenableFuture r4 = r3.release()     // Catch:{ all -> 0x0015 }
            e0 r5 = new e0     // Catch:{ all -> 0x0015 }
            r6 = 9
            r5.<init>(r6, r7, r3)     // Catch:{ all -> 0x0015 }
            java.util.concurrent.Executor r3 = androidx.camera.core.impl.utils.executor.CameraXExecutors.directExecutor()     // Catch:{ all -> 0x0015 }
            r4.addListener(r5, r3)     // Catch:{ all -> 0x0015 }
            goto L_0x003f
        L_0x005e:
            java.util.Map<java.lang.String, androidx.camera.core.impl.CameraInternal> r2 = r7.mCameras     // Catch:{ all -> 0x0015 }
            r2.clear()     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return r1
        L_0x0065:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraRepository.deinit():com.google.common.util.concurrent.ListenableFuture");
    }

    @NonNull
    public CameraInternal getCamera(@NonNull String str) {
        CameraInternal cameraInternal;
        synchronized (this.mCamerasLock) {
            try {
                cameraInternal = this.mCameras.get(str);
                if (cameraInternal == null) {
                    throw new IllegalArgumentException("Invalid camera: " + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cameraInternal;
    }

    @NonNull
    public Set<String> getCameraIds() {
        LinkedHashSet linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet(this.mCameras.keySet());
        }
        return linkedHashSet;
    }

    @NonNull
    public LinkedHashSet<CameraInternal> getCameras() {
        LinkedHashSet<CameraInternal> linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet<>(this.mCameras.values());
        }
        return linkedHashSet;
    }

    public void init(@NonNull CameraFactory cameraFactory) throws InitializationException {
        synchronized (this.mCamerasLock) {
            try {
                for (String next : cameraFactory.getAvailableCameraIds()) {
                    Logger.d(TAG, "Added camera: " + next);
                    this.mCameras.put(next, cameraFactory.getCamera(next));
                }
            } catch (CameraUnavailableException e) {
                throw new InitializationException((Throwable) e);
            }
        }
    }
}
