package defpackage;

import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.imagecapture.NoMetadataImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

/* renamed from: zc  reason: default package */
public final /* synthetic */ class zc implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f219a;
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener b;
    public final /* synthetic */ ImageReaderProxy c;

    public /* synthetic */ zc(ImageReaderProxy imageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, int i) {
        this.f219a = i;
        this.c = imageReaderProxy;
        this.b = onImageAvailableListener;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        switch (this.f219a) {
            case 0:
                ((NoMetadataImageReader) this.c).lambda$setOnImageAvailableListener$0(this.b, imageReaderProxy);
                return;
            default:
                ((SafeCloseImageReaderProxy) this.c).lambda$setOnImageAvailableListener$1(this.b, imageReaderProxy);
                return;
        }
    }
}
