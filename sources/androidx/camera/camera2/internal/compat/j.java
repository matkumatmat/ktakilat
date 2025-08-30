package androidx.camera.camera2.internal.compat;

import androidx.camera.camera2.internal.compat.CameraManagerCompat;

public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ CameraManagerCompat.AvailabilityCallbackExecutorWrapper c;

    public /* synthetic */ j(CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper) {
        this.c = availabilityCallbackExecutorWrapper;
    }

    public final void run() {
        this.c.lambda$onCameraAccessPrioritiesChanged$0();
    }
}
