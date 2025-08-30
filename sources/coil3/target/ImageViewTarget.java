package coil3.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/target/ImageViewTarget;", "Lcoil3/target/GenericViewTarget;", "Landroid/widget/ImageView;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ImageViewTarget extends GenericViewTarget<ImageView> {
    public final ImageView d;

    public ImageViewTarget(ImageView imageView) {
        this.d = imageView;
    }

    public final ImageView a() {
        return this.d;
    }

    public final Drawable c() {
        return this.d.getDrawable();
    }

    public final void e(Drawable drawable) {
        this.d.setImageDrawable(drawable);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageViewTarget) && Intrinsics.a(this.d, ((ImageViewTarget) obj).d);
    }

    public final int hashCode() {
        return this.d.hashCode();
    }

    public final String toString() {
        return "ImageViewTarget(view=" + this.d + ')';
    }
}
