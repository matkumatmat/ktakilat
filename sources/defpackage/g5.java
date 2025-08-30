package defpackage;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.core.util.Consumer;

/* renamed from: g5  reason: default package */
public final /* synthetic */ class g5 implements Consumer {
    public final /* synthetic */ DefaultSurfaceProcessor c;
    public final /* synthetic */ SurfaceRequest d;
    public final /* synthetic */ SurfaceTexture e;
    public final /* synthetic */ Surface f;

    public /* synthetic */ g5(DefaultSurfaceProcessor defaultSurfaceProcessor, SurfaceRequest surfaceRequest, SurfaceTexture surfaceTexture, Surface surface) {
        this.c = defaultSurfaceProcessor;
        this.d = surfaceRequest;
        this.e = surfaceTexture;
        this.f = surface;
    }

    public final void accept(Object obj) {
        SurfaceTexture surfaceTexture = this.e;
        this.c.lambda$onInputSurface$1(this.d, surfaceTexture, this.f, (SurfaceRequest.Result) obj);
    }
}
