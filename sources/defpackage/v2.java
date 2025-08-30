package defpackage;

import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.extensions.internal.compat.workaround.CaptureOutputSurfaceForCaptureProcessor;

/* renamed from: v2  reason: default package */
public final /* synthetic */ class v2 implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f214a;
    public final /* synthetic */ Object b;

    public /* synthetic */ v2(Object obj, int i) {
        this.f214a = i;
        this.b = obj;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        switch (this.f214a) {
            case 0:
                ((CaptureOutputSurfaceForCaptureProcessor) this.b).lambda$new$0(imageReaderProxy);
                return;
            default:
                ((MetadataImageReader) this.b).lambda$new$0(imageReaderProxy);
                return;
        }
    }
}
