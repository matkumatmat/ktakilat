package defpackage;

import androidx.camera.core.SurfaceRequest;

/* renamed from: sf  reason: default package */
public final /* synthetic */ class sf implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SurfaceRequest.TransformationInfoListener d;
    public final /* synthetic */ SurfaceRequest.TransformationInfo e;

    public /* synthetic */ sf(SurfaceRequest.TransformationInfoListener transformationInfoListener, SurfaceRequest.TransformationInfo transformationInfo, int i) {
        this.c = i;
        this.d = transformationInfoListener;
        this.e = transformationInfo;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.onTransformationInfoUpdate(this.e);
                return;
            default:
                this.d.onTransformationInfoUpdate(this.e);
                return;
        }
    }
}
