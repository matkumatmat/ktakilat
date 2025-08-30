package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewViewImplementation;

public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ SurfaceViewImplementation c;
    public final /* synthetic */ SurfaceRequest d;
    public final /* synthetic */ PreviewViewImplementation.OnSurfaceNotInUseListener e;

    public /* synthetic */ j(SurfaceViewImplementation surfaceViewImplementation, SurfaceRequest surfaceRequest, PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.c = surfaceViewImplementation;
        this.d = surfaceRequest;
        this.e = onSurfaceNotInUseListener;
    }

    public final void run() {
        this.c.lambda$onSurfaceRequested$0(this.d, this.e);
    }
}
