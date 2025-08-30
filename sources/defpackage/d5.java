package defpackage;

import androidx.camera.core.SurfaceRequest;

/* renamed from: d5  reason: default package */
public final /* synthetic */ class d5 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SurfaceRequest d;

    public /* synthetic */ d5(SurfaceRequest surfaceRequest, int i) {
        this.c = i;
        this.d = surfaceRequest;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.willNotProvideSurface();
                return;
            default:
                this.d.lambda$new$3();
                return;
        }
    }
}
