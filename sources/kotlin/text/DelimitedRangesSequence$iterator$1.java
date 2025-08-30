package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    public int c = -1;
    public int d;
    public int e;
    public IntRange f;
    public int g;
    public final /* synthetic */ DelimitedRangesSequence i;

    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.i = delimitedRangesSequence;
        int i2 = delimitedRangesSequence.b;
        int length = delimitedRangesSequence.f745a.length();
        if (length >= 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > length) {
                i2 = length;
            }
            this.d = i2;
            this.e = i2;
            return;
        }
        throw new IllegalArgumentException(ba.l(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [kotlin.ranges.IntProgression, kotlin.ranges.IntRange] */
    /* JADX WARNING: type inference failed for: r0v8, types: [kotlin.ranges.IntProgression, kotlin.ranges.IntRange] */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r6 < r3) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r7 = this;
            int r0 = r7.e
            r1 = 0
            if (r0 >= 0) goto L_0x000c
            r7.c = r1
            r0 = 0
            r7.f = r0
            goto L_0x0080
        L_0x000c:
            kotlin.text.DelimitedRangesSequence r2 = r7.i
            int r3 = r2.c
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L_0x001b
            int r6 = r7.g
            int r6 = r6 + r5
            r7.g = r6
            if (r6 >= r3) goto L_0x0023
        L_0x001b:
            java.lang.CharSequence r3 = r2.f745a
            int r3 = r3.length()
            if (r0 <= r3) goto L_0x0035
        L_0x0023:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r7.d
            java.lang.CharSequence r2 = r2.f745a
            int r2 = kotlin.text.StringsKt__StringsKt.c(r2)
            r0.<init>(r1, r2, r5)
            r7.f = r0
            r7.e = r4
            goto L_0x007e
        L_0x0035:
            kotlin.jvm.functions.Function2 r0 = r2.d
            java.lang.CharSequence r3 = r2.f745a
            int r6 = r7.e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.invoke(r3, r6)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L_0x0059
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r7.d
            java.lang.CharSequence r2 = r2.f745a
            int r2 = kotlin.text.StringsKt__StringsKt.c(r2)
            r0.<init>(r1, r2, r5)
            r7.f = r0
            r7.e = r4
            goto L_0x007e
        L_0x0059:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.d
            kotlin.ranges.IntRange r3 = kotlin.ranges.RangesKt.c(r3, r2)
            r7.f = r3
            int r2 = r2 + r0
            r7.d = r2
            if (r0 != 0) goto L_0x007b
            r1 = 1
        L_0x007b:
            int r2 = r2 + r1
            r7.e = r2
        L_0x007e:
            r7.c = r5
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.a():void");
    }

    public final boolean hasNext() {
        if (this.c == -1) {
            a();
        }
        if (this.c == 1) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (this.c == -1) {
            a();
        }
        if (this.c != 0) {
            IntRange intRange = this.f;
            Intrinsics.d(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f = null;
            this.c = -1;
            return intRange;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
