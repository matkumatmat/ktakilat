package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "", "step", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "f", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public class UIntProgression implements Iterable<UInt>, KMappedMarker {
    @NotNull
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public final int c;
    public final int d;
    public final int e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public UIntProgression(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.c = i;
            if (i3 > 0) {
                if (Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) < 0) {
                    UInt.Companion companion = UInt.d;
                    i2 -= UProgressionUtilKt.a(i2, i, i3);
                }
            } else if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            } else if (Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) > 0) {
                UInt.Companion companion2 = UInt.d;
                i2 += UProgressionUtilKt.a(i, i2, -i3);
            }
            this.d = i2;
            this.e = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r3 = (kotlin.ranges.UIntProgression) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof kotlin.ranges.UIntProgression
            if (r0 == 0) goto L_0x0029
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0013
            r0 = r3
            kotlin.ranges.UIntProgression r0 = (kotlin.ranges.UIntProgression) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0027
        L_0x0013:
            kotlin.ranges.UIntProgression r3 = (kotlin.ranges.UIntProgression) r3
            int r0 = r3.c
            int r1 = r2.c
            if (r1 != r0) goto L_0x0029
            int r0 = r2.d
            int r1 = r3.d
            if (r0 != r1) goto L_0x0029
            int r0 = r2.e
            int r3 = r3.e
            if (r0 != r3) goto L_0x0029
        L_0x0027:
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.UIntProgression.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.c * 31) + this.d) * 31) + this.e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0015 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r6 = this;
            int r0 = r6.e
            r1 = 0
            r2 = 1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            int r4 = r6.d
            int r5 = r6.c
            if (r0 <= 0) goto L_0x0017
            r0 = r5 ^ r3
            r3 = r3 ^ r4
            int r0 = java.lang.Integer.compare(r0, r3)
            if (r0 <= 0) goto L_0x0021
        L_0x0015:
            r1 = 1
            goto L_0x0021
        L_0x0017:
            r0 = r5 ^ r3
            r3 = r3 ^ r4
            int r0 = java.lang.Integer.compare(r0, r3)
            if (r0 >= 0) goto L_0x0021
            goto L_0x0015
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.UIntProgression.isEmpty():boolean");
    }

    public final Iterator iterator() {
        return new UIntProgressionIterator(this.c, this.d, this.e, (DefaultConstructorMarker) null);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.d;
        int i2 = this.c;
        int i3 = this.e;
        if (i3 > 0) {
            sb.append(UInt.b(i2));
            sb.append("..");
            sb.append(UInt.b(i));
            sb.append(" step ");
            sb.append(i3);
        } else {
            sb = new StringBuilder();
            sb.append(UInt.b(i2));
            sb.append(" downTo ");
            sb.append(UInt.b(i));
            sb.append(" step ");
            sb.append(-i3);
        }
        return sb.toString();
    }
}
