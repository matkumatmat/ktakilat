package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AndroidImageReaderProxy c;
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener d;

    public /* synthetic */ a(AndroidImageReaderProxy androidImageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.c = androidImageReaderProxy;
        this.d = onImageAvailableListener;
    }

    public final void run() {
        this.c.lambda$setOnImageAvailableListener$0(this.d);
    }
}
