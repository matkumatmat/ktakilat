package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ ProcessingRequest d;
    public final /* synthetic */ Object e;

    public /* synthetic */ g(ProcessingRequest processingRequest, Object obj, int i) {
        this.c = i;
        this.d = processingRequest;
        this.e = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.onProcessFailure((ImageCaptureException) this.e);
                return;
            case 1:
                this.d.onFinalResult((ImageProxy) this.e);
                return;
            case 2:
                this.d.onFinalResult((ImageCapture.OutputFileResults) this.e);
                return;
            default:
                this.d.onPostviewBitmapAvailable((Bitmap) this.e);
                return;
        }
    }
}
