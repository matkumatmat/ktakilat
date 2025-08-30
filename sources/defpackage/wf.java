package defpackage;

import androidx.camera.core.imagecapture.TakePictureManager;

/* renamed from: wf  reason: default package */
public final /* synthetic */ class wf implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ TakePictureManager d;

    public /* synthetic */ wf(TakePictureManager takePictureManager, int i) {
        this.c = i;
        this.d = takePictureManager;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$trackCurrentRequests$0();
                return;
            default:
                this.d.issueNextRequest();
                return;
        }
    }
}
