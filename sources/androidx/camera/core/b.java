package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

public final /* synthetic */ class b implements ImageReader.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidImageReaderProxy f23a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener c;

    public /* synthetic */ b(AndroidImageReaderProxy androidImageReaderProxy, Executor executor, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f23a = androidImageReaderProxy;
        this.b = executor;
        this.c = onImageAvailableListener;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.f23a.lambda$setOnImageAvailableListener$1(this.b, this.c, imageReader);
    }
}
