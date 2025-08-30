package coil3;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\n\u0010\u0001\"\u00020\u00002\u00020\u0000*\n\u0010\u0003\"\u00020\u00022\u00020\u0002¨\u0006\u0004"}, d2 = {"Landroid/graphics/Bitmap;", "Bitmap", "Landroid/graphics/Canvas;", "Canvas", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImage.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Image.android.kt\ncoil3/Image_androidKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,163:1\n95#2:164\n43#2,3:165\n*S KotlinDebug\n*F\n+ 1 Image.android.kt\ncoil3/Image_androidKt\n*L\n53#1:164\n53#1:165,3\n*E\n"})
public final class Image_androidKt {
    public static final Drawable a(Image image, Resources resources) {
        if (image instanceof DrawableImage) {
            return ((DrawableImage) image).f50a;
        }
        if (image instanceof BitmapImage) {
            return new BitmapDrawable(resources, ((BitmapImage) image).f47a);
        }
        return new ImageDrawable(image);
    }

    public static final Image b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return new BitmapImage(((BitmapDrawable) drawable).getBitmap(), true);
        }
        return new DrawableImage(drawable);
    }
}
