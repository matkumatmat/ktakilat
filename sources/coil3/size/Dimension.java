package coil3.size;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0001\u0002\u0004\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcoil3/size/Dimension;", "", "Pixels", "Undefined", "Lcoil3/size/Dimension$Pixels;", "Lcoil3/size/Dimension$Undefined;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Dimension {

    @JvmInline
    @SourceDebugExtension({"SMAP\nDimension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dimension.kt\ncoil3/size/Dimension$Pixels\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b@\u0018\u00002\u00020\u0001\u0001\u0002\u0001\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/size/Dimension$Pixels;", "Lcoil3/size/Dimension;", "px", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Pixels implements Dimension {

        /* renamed from: a  reason: collision with root package name */
        public final int f148a;

        public /* synthetic */ Pixels(int i) {
            this.f148a = i;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Pixels) && this.f148a == ((Pixels) obj).f148a) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.f148a;
        }

        public final String toString() {
            return "Pixels(px=" + this.f148a + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/size/Dimension$Undefined;", "Lcoil3/size/Dimension;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Undefined implements Dimension {

        /* renamed from: a  reason: collision with root package name */
        public static final Undefined f149a = new Object();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof Undefined);
        }

        public final int hashCode() {
            return -2093724603;
        }

        public final String toString() {
            return "Undefined";
        }
    }
}
