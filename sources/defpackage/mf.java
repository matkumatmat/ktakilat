package defpackage;

import androidx.camera.core.processing.SurfaceEdge;

/* renamed from: mf  reason: default package */
public final /* synthetic */ class mf implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SurfaceEdge d;

    public /* synthetic */ mf(SurfaceEdge surfaceEdge, int i) {
        this.c = i;
        this.d = surfaceEdge;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$createSurfaceRequest$1();
                return;
            default:
                this.d.lambda$createSurfaceRequest$0();
                return;
        }
    }
}
