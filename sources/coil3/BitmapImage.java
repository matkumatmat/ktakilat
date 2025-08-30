package coil3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/BitmapImage;", "Lcoil3/Image;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitmapImage implements Image {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f47a;
    public final boolean b;

    public BitmapImage(Bitmap bitmap, boolean z) {
        this.f47a = bitmap;
        this.b = z;
    }

    public final boolean a() {
        return this.b;
    }

    public final void draw(Canvas canvas) {
        canvas.drawBitmap(this.f47a, 0.0f, 0.0f, (Paint) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapImage)) {
            return false;
        }
        BitmapImage bitmapImage = (BitmapImage) obj;
        return Intrinsics.a(this.f47a, bitmapImage.f47a) && this.b == bitmapImage.b;
    }

    public final int getHeight() {
        return this.f47a.getHeight();
    }

    public final long getSize() {
        int i;
        int i2;
        Bitmap bitmap = this.f47a;
        if (!bitmap.isRecycled()) {
            try {
                i = bitmap.getAllocationByteCount();
            } catch (Exception unused) {
                int height = bitmap.getHeight() * bitmap.getWidth();
                Bitmap.Config config = bitmap.getConfig();
                if (config == Bitmap.Config.ALPHA_8) {
                    i2 = 1;
                } else if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
                    i2 = 2;
                } else if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.RGBA_F16) {
                    i2 = 4;
                } else {
                    i2 = 8;
                }
                i = i2 * height;
            }
            return (long) i;
        }
        throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap + " [" + bitmap.getWidth() + " x " + bitmap.getHeight() + "] + " + bitmap.getConfig()).toString());
    }

    public final int getWidth() {
        return this.f47a.getWidth();
    }

    public final int hashCode() {
        int i;
        int hashCode = this.f47a.hashCode() * 31;
        if (this.b) {
            i = 1231;
        } else {
            i = 1237;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "BitmapImage(bitmap=" + this.f47a + ", shareable=" + this.b + ')';
    }
}
