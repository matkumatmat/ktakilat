package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"kotlin/ranges/RangesKt__RangesKt", "kotlin/ranges/RangesKt___RangesKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class RangesKt extends RangesKt___RangesKt {
    public static long a(long j, long j2, long j3) {
        if (j2 > j3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (j < j2) {
            return j2;
        } else {
            if (j > j3) {
                return j3;
            }
            return j;
        }
    }

    public static IntProgression b(IntRange intRange, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Integer valueOf = Integer.valueOf(i);
        Intrinsics.checkNotNullParameter(valueOf, "step");
        if (z) {
            IntProgression.Companion companion = IntProgression.f;
            int i2 = intRange.c;
            if (intRange.e <= 0) {
                i = -i;
            }
            companion.getClass();
            return new IntProgression(i2, intRange.d, i);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + valueOf + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlin.ranges.IntProgression} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.ranges.IntRange} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.ranges.IntRange c(int r2, int r3) {
        /*
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 > r0) goto L_0x000c
            kotlin.ranges.IntRange$Companion r2 = kotlin.ranges.IntRange.g
            r2.getClass()
            kotlin.ranges.IntRange r2 = kotlin.ranges.IntRange.i
            goto L_0x0014
        L_0x000c:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            r1 = 1
            int r3 = r3 - r1
            r0.<init>(r2, r3, r1)
            r2 = r0
        L_0x0014:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.RangesKt.c(int, int):kotlin.ranges.IntRange");
    }
}
