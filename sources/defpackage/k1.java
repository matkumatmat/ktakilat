package defpackage;

import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.video.internal.audio.BufferedAudioStream;
import androidx.camera.view.CameraController;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* renamed from: k1  reason: default package */
public final /* synthetic */ class k1 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ k1(Object obj, int i, int i2) {
        this.c = i2;
        this.e = obj;
        this.d = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((BufferedAudioStream) this.e).lambda$updateCollectionBufferSizeAsync$4(this.d);
                return;
            case 1:
                ((CameraController) this.e).lambda$setEnabledUseCases$2(this.d);
                return;
            case 2:
                ((ResourcesCompat.FontCallback) this.e).lambda$callbackFailAsync$1(this.d);
                return;
            case 3:
                ((SideSheetBehavior) this.e).lambda$setState$0(this.d);
                return;
            default:
                ((TakePictureRequest) this.e).lambda$onCaptureProcessProgressed$3(this.d);
                return;
        }
    }
}
