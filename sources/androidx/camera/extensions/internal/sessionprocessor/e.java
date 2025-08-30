package androidx.camera.extensions.internal.sessionprocessor;

import android.media.ImageReader;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ ImageReader c;

    public /* synthetic */ e(ImageReader imageReader) {
        this.c = imageReader;
    }

    public final void run() {
        this.c.close();
    }
}
