package androidx.camera.core.imagecapture;

import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.imagecapture.CaptureNode;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((SafeCloseImageReaderProxy) this.d).safeClose();
                return;
            case 1:
                CaptureNode.lambda$releaseInputResources$4((SafeCloseImageReaderProxy) this.d);
                return;
            default:
                ((CaptureNode.AnonymousClass1) this.d).lambda$onCaptureStarted$0();
                return;
        }
    }
}
