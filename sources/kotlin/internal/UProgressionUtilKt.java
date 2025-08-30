package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UProgressionUtilKt {
    public static final int a(int i, int i2, int i3) {
        long j = ((long) i3) & 4294967295L;
        int i4 = (int) ((((long) i) & 4294967295L) % j);
        int i5 = (int) ((((long) i2) & 4294967295L) % j);
        int compare = Integer.compare(i4 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i5);
        int i6 = i4 - i5;
        UInt.Companion companion = UInt.d;
        if (compare >= 0) {
            return i6;
        }
        return i6 + i3;
    }

    public static final long b(long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        long j7 = 0;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i < 0) {
            if ((j ^ Long.MIN_VALUE) < (j3 ^ Long.MIN_VALUE)) {
                j4 = j;
            } else {
                j4 = j - j3;
            }
        } else if (j >= 0) {
            j4 = j % j3;
        } else {
            long j8 = j - ((((j >>> 1) / j3) << 1) * j3);
            if ((j8 ^ Long.MIN_VALUE) >= (j3 ^ Long.MIN_VALUE)) {
                j6 = j3;
            } else {
                j6 = 0;
            }
            j4 = j8 - j6;
        }
        if (i < 0) {
            if ((j2 ^ Long.MIN_VALUE) < (j3 ^ Long.MIN_VALUE)) {
                j5 = j2;
            } else {
                j5 = j2 - j3;
            }
        } else if (j2 >= 0) {
            j5 = j2 % j3;
        } else {
            long j9 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
            if ((j9 ^ Long.MIN_VALUE) >= (j3 ^ Long.MIN_VALUE)) {
                j7 = j3;
            }
            j5 = j9 - j7;
        }
        int compare = Long.compare(j4 ^ Long.MIN_VALUE, j5 ^ Long.MIN_VALUE);
        long j10 = j4 - j5;
        ULong.Companion companion = ULong.d;
        if (compare >= 0) {
            return j10;
        }
        return j10 + j3;
    }
}
