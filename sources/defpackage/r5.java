package defpackage;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.core.util.Consumer;

/* renamed from: r5  reason: default package */
public final /* synthetic */ class r5 implements Consumer {
    public final /* synthetic */ DualSurfaceProcessor c;
    public final /* synthetic */ SurfaceTexture d;
    public final /* synthetic */ Surface e;

    public /* synthetic */ r5(DualSurfaceProcessor dualSurfaceProcessor, SurfaceTexture surfaceTexture, Surface surface) {
        this.c = dualSurfaceProcessor;
        this.d = surfaceTexture;
        this.e = surface;
    }

    public final void accept(Object obj) {
        SurfaceTexture surfaceTexture = this.d;
        this.c.lambda$onInputSurface$0(surfaceTexture, this.e, (SurfaceRequest.Result) obj);
    }
}
