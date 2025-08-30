package androidx.camera.view;

import androidx.arch.core.util.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f36a = i;
        this.b = obj;
    }

    public final Object apply(Object obj) {
        switch (this.f36a) {
            case 0:
                return ((CameraController) this.b).lambda$new$0((ProcessCameraProviderWrapper) obj);
            default:
                return ((PreviewStreamStateObserver) this.b).lambda$startPreviewStreamStateFlow$1((Void) obj);
        }
    }
}
