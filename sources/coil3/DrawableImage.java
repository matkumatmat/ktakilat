package coil3;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/DrawableImage;", "Lcoil3/Image;", "SizeProvider", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawableImage implements Image {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f50a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcoil3/DrawableImage$SizeProvider;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface SizeProvider {
        long getSize();
    }

    public DrawableImage(Drawable drawable) {
        this.f50a = drawable;
    }

    public final boolean a() {
        return false;
    }

    public final void draw(Canvas canvas) {
        this.f50a.draw(canvas);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableImage)) {
            return false;
        }
        return Intrinsics.a(this.f50a, ((DrawableImage) obj).f50a);
    }

    public final int getHeight() {
        return Utils_androidKt.a(this.f50a);
    }

    public final long getSize() {
        long j;
        Drawable drawable = this.f50a;
        if (drawable instanceof SizeProvider) {
            j = ((SizeProvider) drawable).getSize();
        } else {
            j = ((long) Utils_androidKt.b(drawable)) * 4 * ((long) Utils_androidKt.a(drawable));
        }
        if (j < 0) {
            return 0;
        }
        return j;
    }

    public final int getWidth() {
        return Utils_androidKt.b(this.f50a);
    }

    public final int hashCode() {
        return (this.f50a.hashCode() * 31) + 1237;
    }

    public final String toString() {
        return "DrawableImage(drawable=" + this.f50a + ", shareable=false)";
    }
}
