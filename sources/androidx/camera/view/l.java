package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.util.Consumer;

public final /* synthetic */ class l implements Consumer {
    public final /* synthetic */ PreviewViewImplementation.OnSurfaceNotInUseListener c;

    public /* synthetic */ l(PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.c = onSurfaceNotInUseListener;
    }

    public final void accept(Object obj) {
        SurfaceViewImplementation.SurfaceRequestCallback.lambda$tryToComplete$0(this.c, (SurfaceRequest.Result) obj);
    }
}
