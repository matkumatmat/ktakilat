package androidx.camera.camera2.internal;

public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FocusMeteringControl d;
    public final /* synthetic */ long e;

    public /* synthetic */ a0(int i, long j, FocusMeteringControl focusMeteringControl) {
        this.c = i;
        this.d = focusMeteringControl;
        this.e = j;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$executeMeteringAction$10(this.e);
                return;
            case 1:
                this.d.lambda$executeMeteringAction$8(this.e);
                return;
            case 2:
                this.d.lambda$executeMeteringAction$9(this.e);
                return;
            default:
                this.d.lambda$executeMeteringAction$11(this.e);
                return;
        }
    }
}
