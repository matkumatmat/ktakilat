package defpackage;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;

/* renamed from: oa  reason: default package */
public final /* synthetic */ class oa implements ForwardingImageProxy.OnImageCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f207a;
    public final /* synthetic */ ImageProxy b;
    public final /* synthetic */ ImageProxy c;

    public /* synthetic */ oa(ImageProxy imageProxy, ImageProxy imageProxy2, int i) {
        this.f207a = i;
        this.b = imageProxy;
        this.c = imageProxy2;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        switch (this.f207a) {
            case 0:
                ImageProcessingUtil.lambda$convertYUVToRGB$0(this.b, this.c, imageProxy);
                return;
            default:
                ImageProcessingUtil.lambda$rotateYUV$1(this.b, this.c, imageProxy);
                return;
        }
    }
}
