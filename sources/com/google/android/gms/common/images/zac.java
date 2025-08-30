package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class zac implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    @Nullable
    private final Bitmap zac;
    private final CountDownLatch zad;

    public zac(ImageManager imageManager, @Nullable Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = bitmap;
        this.zad = countDownLatch;
    }

    public final void run() {
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.zaa.zai.remove(this.zab);
        if (imageReceiver != null) {
            ArrayList zaa2 = imageReceiver.zac;
            int size = zaa2.size();
            for (int i = 0; i < size; i++) {
                zag zag = (zag) zaa2.get(i);
                Bitmap bitmap = this.zac;
                if (bitmap != null) {
                    zag.zac(this.zaa.zad, bitmap, false);
                } else {
                    ImageManager imageManager = this.zaa;
                    imageManager.zaj.put(this.zab, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager2 = this.zaa;
                    zag.zab(imageManager2.zad, imageManager2.zag, false);
                }
                if (!(zag instanceof zaf)) {
                    this.zaa.zah.remove(zag);
                }
            }
        }
        this.zad.countDown();
        synchronized (ImageManager.zaa) {
            ImageManager.zab.remove(this.zab);
        }
    }
}
