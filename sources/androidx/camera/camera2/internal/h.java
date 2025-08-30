package androidx.camera.camera2.internal;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ Camera2CameraImpl c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ h(Camera2CameraImpl camera2CameraImpl, boolean z) {
        this.c = camera2CameraImpl;
        this.d = z;
    }

    public final void run() {
        this.c.lambda$setActiveResumingMode$18(this.d);
    }
}
