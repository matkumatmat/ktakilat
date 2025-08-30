package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/ranges/ComparableRange;", "", "T", "Lkotlin/ranges/ClosedRange;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (kotlin.ranges.ClosedRange.DefaultImpls.a(r0) == false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof kotlin.ranges.ComparableRange
            if (r0 == 0) goto L_0x002d
            boolean r0 = kotlin.ranges.ClosedRange.DefaultImpls.a(r2)
            if (r0 == 0) goto L_0x0016
            r0 = r3
            kotlin.ranges.ComparableRange r0 = (kotlin.ranges.ComparableRange) r0
            r0.getClass()
            boolean r0 = kotlin.ranges.ClosedRange.DefaultImpls.a(r0)
            if (r0 != 0) goto L_0x002b
        L_0x0016:
            kotlin.ranges.ComparableRange r3 = (kotlin.ranges.ComparableRange) r3
            r3.getClass()
            r0 = 0
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r0, r0)
            if (r1 == 0) goto L_0x002d
            r3.getClass()
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r0, r0)
            if (r3 == 0) goto L_0x002d
        L_0x002b:
            r3 = 1
            goto L_0x002e
        L_0x002d:
            r3 = 0
        L_0x002e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.ComparableRange.equals(java.lang.Object):boolean");
    }

    public final Comparable getEndInclusive() {
        return null;
    }

    public final Comparable getStart() {
        return null;
    }

    public final int hashCode() {
        if (ClosedRange.DefaultImpls.a(this)) {
            return -1;
        }
        throw null;
    }

    public final String toString() {
        return "null..null";
    }
}
