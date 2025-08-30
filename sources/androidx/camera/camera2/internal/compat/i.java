package androidx.camera.camera2.internal.compat;

import androidx.camera.camera2.internal.compat.CameraManagerCompat;

public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CameraManagerCompat.AvailabilityCallbackExecutorWrapper d;
    public final /* synthetic */ String e;

    public /* synthetic */ i(CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper, String str, int i) {
        this.c = i;
        this.d = availabilityCallbackExecutorWrapper;
        this.e = str;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onCameraAvailable$1(this.e);
                return;
            default:
                this.d.lambda$onCameraUnavailable$2(this.e);
                return;
        }
    }
}
