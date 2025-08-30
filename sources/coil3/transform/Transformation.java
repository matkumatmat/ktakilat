package coil3.transform;

import android.graphics.Bitmap;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/transform/Transformation;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Transformation {
    public abstract Bitmap a(Bitmap bitmap, Size size);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Transformation) {
            ((Transformation) obj).getClass();
            if (Intrinsics.a((Object) null, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "Transformation(cacheKey=null)";
    }
}
