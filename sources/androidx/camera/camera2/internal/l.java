package androidx.camera.camera2.internal;

public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Camera2CameraImpl d;

    public /* synthetic */ l(Camera2CameraImpl camera2CameraImpl, int i) {
        this.c = i;
        this.d = camera2CameraImpl;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.openInternal();
                return;
            case 1:
                this.d.lambda$configAndCloseIfNeeded$0();
                return;
            default:
                this.d.closeInternal();
                return;
        }
    }
}
