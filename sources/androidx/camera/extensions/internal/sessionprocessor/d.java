package androidx.camera.extensions.internal.sessionprocessor;

import android.media.ImageReader;

public final /* synthetic */ class d implements ImageReader.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageProcessor f32a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ d(ImageProcessor imageProcessor, int i, String str) {
        this.f32a = imageProcessor;
        this.b = i;
        this.c = str;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        SessionProcessorBase.lambda$setImageProcessor$1(this.f32a, this.b, this.c, imageReader);
    }
}
