package androidx.camera.core.processing;

import androidx.camera.core.processing.SurfaceEdge;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SurfaceEdge.SettableSurface d;

    public /* synthetic */ c(SurfaceEdge.SettableSurface settableSurface, int i) {
        this.c = i;
        this.d = settableSurface;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.close();
                return;
            case 1:
                this.d.decrementUseCount();
                return;
            default:
                this.d.lambda$close$1();
                return;
        }
    }
}
