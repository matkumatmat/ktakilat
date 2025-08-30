package defpackage;

import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.internal.CameraUseCaseAdapter;

/* renamed from: r2  reason: default package */
public final /* synthetic */ class r2 implements Preview.SurfaceProvider {
    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        CameraUseCaseAdapter.lambda$createExtraPreview$1(surfaceRequest);
    }
}
