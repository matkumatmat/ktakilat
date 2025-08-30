package defpackage;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SafeCloseImageReaderProxy;

/* renamed from: ge  reason: default package */
public final /* synthetic */ class ge implements ForwardingImageProxy.OnImageCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeCloseImageReaderProxy f195a;

    public /* synthetic */ ge(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.f195a = safeCloseImageReaderProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.f195a.lambda$new$0(imageProxy);
    }
}
