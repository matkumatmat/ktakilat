package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.core.util.Consumer;

public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ CaptureNode d;

    public /* synthetic */ a(CaptureNode captureNode, int i) {
        this.c = i;
        this.d = captureNode;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                this.d.onRequestAvailable((ProcessingRequest) obj);
                return;
            case 1:
                this.d.lambda$transform$0((ProcessingRequest) obj);
                return;
            default:
                this.d.sendCaptureError((TakePictureManager.CaptureError) obj);
                return;
        }
    }
}
