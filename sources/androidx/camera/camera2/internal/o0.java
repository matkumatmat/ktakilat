package androidx.camera.camera2.internal;

public final /* synthetic */ class o0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl d;
    public final /* synthetic */ SynchronizedCaptureSession e;

    public /* synthetic */ o0(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl, SynchronizedCaptureSession synchronizedCaptureSession, int i) {
        this.c = i;
        this.d = synchronizedCaptureSessionBaseImpl;
        this.e = synchronizedCaptureSession;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onSessionFinished$4(this.e);
                return;
            default:
                this.d.lambda$onClosed$3(this.e);
                return;
        }
    }
}
