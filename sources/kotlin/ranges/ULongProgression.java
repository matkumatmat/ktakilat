package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0017\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "", "step", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "f", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
    @NotNull
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public final long c;
    public final long d;
    public final long e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j3 != Long.MIN_VALUE) {
            this.c = j;
            if (i > 0) {
                if (Long.compare(j ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) < 0) {
                    ULong.Companion companion = ULong.d;
                    j2 -= UProgressionUtilKt.b(j2, j, j3);
                }
            } else if (i >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            } else if (Long.compare(j ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j2) > 0) {
                ULong.Companion companion2 = ULong.d;
                j2 += UProgressionUtilKt.b(j, j2, -j3);
            }
            this.d = j2;
            this.e = j3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) obj).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) obj;
                if (!(this.c == uLongProgression.c && this.d == uLongProgression.d && this.e == uLongProgression.e)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.c;
        ULong.Companion companion = ULong.d;
        long j2 = this.d;
        long j3 = this.e;
        return ((int) (j3 ^ (j3 >>> 32))) + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001a A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r13 = this;
            long r0 = r13.e
            r2 = 0
            r4 = 0
            r5 = 1
            r6 = -9223372036854775808
            long r8 = r13.d
            long r10 = r13.c
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 <= 0) goto L_0x001c
            long r0 = r10 ^ r6
            long r2 = r8 ^ r6
            int r0 = java.lang.Long.compare(r0, r2)
            if (r0 <= 0) goto L_0x0027
        L_0x001a:
            r4 = 1
            goto L_0x0027
        L_0x001c:
            long r0 = r10 ^ r6
            long r2 = r8 ^ r6
            int r0 = java.lang.Long.compare(r0, r2)
            if (r0 >= 0) goto L_0x0027
            goto L_0x001a
        L_0x0027:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.ULongProgression.isEmpty():boolean");
    }

    public final Iterator iterator() {
        return new ULongProgressionIterator(this.c, this.d, this.e, (DefaultConstructorMarker) null);
    }

    public String toString() {
        StringBuilder sb;
        long j = this.d;
        long j2 = this.c;
        long j3 = this.e;
        if (j3 > 0) {
            sb.append(ULong.b(j2));
            sb.append("..");
            sb.append(ULong.b(j));
            sb.append(" step ");
            sb.append(j3);
        } else {
            sb = new StringBuilder();
            sb.append(ULong.b(j2));
            sb.append(" downTo ");
            sb.append(ULong.b(j));
            sb.append(" step ");
            sb.append(-j3);
        }
        return sb.toString();
    }
}
