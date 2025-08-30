package defpackage;

import androidx.camera.core.processing.SurfaceEdge;

/* renamed from: of  reason: default package */
public final /* synthetic */ class of implements Runnable {
    public final /* synthetic */ SurfaceEdge c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public /* synthetic */ of(SurfaceEdge surfaceEdge, int i, int i2) {
        this.c = surfaceEdge;
        this.d = i;
        this.e = i2;
    }

    public final void run() {
        this.c.lambda$updateTransformation$3(this.d, this.e);
    }
}
