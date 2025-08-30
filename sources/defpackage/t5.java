package defpackage;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode;
import java.util.Map;

/* renamed from: t5  reason: default package */
public final /* synthetic */ class t5 implements Runnable {
    public final /* synthetic */ DualSurfaceProcessorNode c;
    public final /* synthetic */ CameraInternal d;
    public final /* synthetic */ CameraInternal e;
    public final /* synthetic */ SurfaceEdge f;
    public final /* synthetic */ SurfaceEdge g;
    public final /* synthetic */ Map.Entry i;

    public /* synthetic */ t5(DualSurfaceProcessorNode dualSurfaceProcessorNode, CameraInternal cameraInternal, CameraInternal cameraInternal2, SurfaceEdge surfaceEdge, SurfaceEdge surfaceEdge2, Map.Entry entry) {
        this.c = dualSurfaceProcessorNode;
        this.d = cameraInternal;
        this.e = cameraInternal2;
        this.f = surfaceEdge;
        this.g = surfaceEdge2;
        this.i = entry;
    }

    public final void run() {
        Map.Entry entry = this.i;
        this.c.lambda$sendSurfaceOutputs$0(this.d, this.e, this.f, this.g, entry);
    }
}
