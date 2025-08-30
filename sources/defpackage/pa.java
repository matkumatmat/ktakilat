package defpackage;

import android.graphics.Bitmap;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.internal.utils.ImageUtil;

/* renamed from: pa  reason: default package */
public abstract /* synthetic */ class pa {
    public static Bitmap a(ImageProxy imageProxy) {
        return ImageUtil.createBitmapFromImageProxy(imageProxy);
    }
}
