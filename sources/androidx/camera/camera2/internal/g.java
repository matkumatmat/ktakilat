package androidx.camera.camera2.internal;

import java.util.ArrayList;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Camera2CameraImpl d;
    public final /* synthetic */ ArrayList e;

    public /* synthetic */ g(Camera2CameraImpl camera2CameraImpl, ArrayList arrayList, int i) {
        this.c = i;
        this.d = camera2CameraImpl;
        this.e = arrayList;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$detachUseCases$16(this.e);
                return;
            default:
                this.d.lambda$attachUseCases$15(this.e);
                return;
        }
    }
}
