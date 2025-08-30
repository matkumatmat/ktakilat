package androidx.camera.core.processing;

import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.processing.SurfaceEdge;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class b implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f27a;
    public final /* synthetic */ SurfaceEdge.SettableSurface b;
    public final /* synthetic */ int c;
    public final /* synthetic */ SurfaceOutput.CameraInputInfo d;
    public final /* synthetic */ SurfaceOutput.CameraInputInfo e;

    public /* synthetic */ b(SurfaceEdge surfaceEdge, SurfaceEdge.SettableSurface settableSurface, int i, SurfaceOutput.CameraInputInfo cameraInputInfo, SurfaceOutput.CameraInputInfo cameraInputInfo2) {
        this.f27a = surfaceEdge;
        this.b = settableSurface;
        this.c = i;
        this.d = cameraInputInfo;
        this.e = cameraInputInfo2;
    }

    public final ListenableFuture apply(Object obj) {
        int i = this.c;
        SurfaceOutput.CameraInputInfo cameraInputInfo = this.d;
        return this.f27a.lambda$createSurfaceOutputFuture$2(this.b, i, cameraInputInfo, this.e, (Surface) obj);
    }
}
