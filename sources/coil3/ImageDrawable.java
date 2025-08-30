package coil3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/ImageDrawable;", "Landroid/graphics/drawable/Drawable;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Image f56a;

    public ImageDrawable(Image image) {
        this.f56a = image;
    }

    public final void draw(Canvas canvas) {
        this.f56a.draw(canvas);
    }

    public final int getOpacity() {
        return 0;
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
