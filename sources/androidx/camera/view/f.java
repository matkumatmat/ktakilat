package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

public final /* synthetic */ class f implements CallbackToFutureAdapter.Resolver, SurfaceRequest.TransformationInfoListener, PreviewViewImplementation.OnSurfaceNotInUseListener {
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ f(PreviewView.AnonymousClass1 r1, PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
        this.d = r1;
        this.c = previewStreamStateObserver;
        this.e = cameraInternal;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((PreviewStreamStateObserver) this.c).lambda$waitForCaptureResult$2((CameraInfo) this.d, (List) this.e, completer);
    }

    public void onSurfaceNotInUse() {
        ((PreviewView.AnonymousClass1) this.d).lambda$onSurfaceRequested$2((PreviewStreamStateObserver) this.c, (CameraInternal) this.e);
    }

    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        ((PreviewView.AnonymousClass1) this.c).lambda$onSurfaceRequested$1((CameraInternal) this.d, (SurfaceRequest) this.e, transformationInfo);
    }

    public /* synthetic */ f(Object obj, Object obj2, Object obj3) {
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }
}
