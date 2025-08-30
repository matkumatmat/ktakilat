package coil3.size;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/size/RealSizeResolver;", "Lcoil3/size/SizeResolver;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealSizeResolver implements SizeResolver {
    public final Object a(Continuation continuation) {
        return Size.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealSizeResolver)) {
            return false;
        }
        Size size = Size.c;
        ((RealSizeResolver) obj).getClass();
        if (!size.equals(size)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Size.c.hashCode();
    }

    public final String toString() {
        return "RealSizeResolver(size=" + Size.c + ')';
    }
}
