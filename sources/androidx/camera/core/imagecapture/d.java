package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.CaptureNode;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ CaptureNode.AnonymousClass1 c;
    public final /* synthetic */ int d;

    public /* synthetic */ d(CaptureNode.AnonymousClass1 r1, int i) {
        this.c = r1;
        this.d = i;
    }

    public final void run() {
        this.c.lambda$onCaptureProcessProgressed$1(this.d);
    }
}
