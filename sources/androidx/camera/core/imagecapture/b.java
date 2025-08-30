package androidx.camera.core.imagecapture;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class b implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f25a;
    public final /* synthetic */ CaptureNode b;

    public /* synthetic */ b(CaptureNode captureNode, int i) {
        this.f25a = i;
        this.b = captureNode;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        switch (this.f25a) {
            case 0:
                this.b.lambda$transform$1(imageReaderProxy);
                return;
            default:
                this.b.lambda$transform$2(imageReaderProxy);
                return;
        }
    }
}
