package androidx.camera.view;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ TextureViewImplementation c;
    public final /* synthetic */ Surface d;
    public final /* synthetic */ ListenableFuture e;
    public final /* synthetic */ SurfaceRequest f;

    public /* synthetic */ n(TextureViewImplementation textureViewImplementation, Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        this.c = textureViewImplementation;
        this.d = surface;
        this.e = listenableFuture;
        this.f = surfaceRequest;
    }

    public final void run() {
        this.c.lambda$tryToProvidePreviewSurface$2(this.d, this.e, this.f);
    }
}
