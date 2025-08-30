package coil3.size;

import coil3.size.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/size/Size;", "", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Size {
    public static final Size c;

    /* renamed from: a  reason: collision with root package name */
    public final Dimension f150a;
    public final Dimension b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/size/Size$Companion;", "", "Lcoil3/size/Size;", "ORIGINAL", "Lcoil3/size/Size;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    static {
        Dimension.Undefined undefined = Dimension.Undefined.f149a;
        c = new Size(undefined, undefined);
    }

    public Size(Dimension dimension, Dimension dimension2) {
        this.f150a = dimension;
        this.b = dimension2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return Intrinsics.a(this.f150a, size.f150a) && Intrinsics.a(this.b, size.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f150a.hashCode() * 31);
    }

    public final String toString() {
        return "Size(width=" + this.f150a + ", height=" + this.b + ')';
    }
}
