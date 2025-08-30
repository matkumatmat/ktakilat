package androidx.camera.view;

import android.view.PixelCopy;
import java.util.concurrent.Semaphore;

public final /* synthetic */ class k implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Semaphore f39a;

    public /* synthetic */ k(Semaphore semaphore) {
        this.f39a = semaphore;
    }

    public final void onPixelCopyFinished(int i) {
        SurfaceViewImplementation.lambda$getPreviewBitmap$1(this.f39a, i);
    }
}
