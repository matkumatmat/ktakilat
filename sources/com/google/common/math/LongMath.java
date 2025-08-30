package com.google.common.math;

import androidx.core.location.LocationRequestCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
import okhttp3.internal.connection.RealConnection;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class LongMath {
    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    @GwtIncompatible
    @VisibleForTesting
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.VT, Ascii.VT, Ascii.VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{LocationRequestCompat.PASSIVE_INTERVAL, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    @GwtIncompatible
    @VisibleForTesting
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.AnonymousClass1.<clinit>():void");
        }
    }

    public enum MillerRabinTester {
        SMALL {
            public long mulMod(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            public long squareMod(long j, long j2) {
                return (j * j) % j2;
            }
        },
        LARGE {
            private long plusMod(long j, long j2, long j3) {
                int i = (j > (j3 - j2) ? 1 : (j == (j3 - j2) ? 0 : -1));
                long j4 = j + j2;
                return i >= 0 ? j4 - j3 : j4;
            }

            private long times2ToThe32Mod(long j, long j2) {
                int i = 32;
                do {
                    int min = Math.min(i, Long.numberOfLeadingZeros(j));
                    j = UnsignedLongs.remainder(j << min, j2);
                    i -= min;
                } while (i > 0);
                return j;
            }

            public long mulMod(long j, long j2, long j3) {
                long j4 = j3;
                long j5 = j >>> 32;
                long j6 = j2 >>> 32;
                long j7 = j & 4294967295L;
                long j8 = j2 & 4294967295L;
                long times2ToThe32Mod = (j5 * j8) + times2ToThe32Mod(j5 * j6, j4);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j4);
                }
                Long.signum(j7);
                return plusMod(times2ToThe32Mod((j6 * j7) + times2ToThe32Mod, j4), UnsignedLongs.remainder(j7 * j8, j4), j3);
            }

            public long squareMod(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                long j5 = j3 * j4 * 2;
                if (j5 < 0) {
                    j5 = UnsignedLongs.remainder(j5, j2);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j5, j2), UnsignedLongs.remainder(j4 * j4, j2), j2);
            }
        };

        private long powMod(long j, long j2, long j3) {
            long j4 = 1;
            while (j2 != 0) {
                if ((j2 & 1) != 0) {
                    j4 = mulMod(j4, j, j3);
                }
                j = squareMod(j, j3);
                j2 >>= 1;
            }
            return j4;
        }

        public static boolean test(long j, long j2) {
            MillerRabinTester millerRabinTester;
            if (j2 <= LongMath.FLOOR_SQRT_MAX_LONG) {
                millerRabinTester = SMALL;
            } else {
                millerRabinTester = LARGE;
            }
            return millerRabinTester.testWitness(j, j2);
        }

        private boolean testWitness(long j, long j2) {
            long j3 = j2;
            long j4 = j3 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
            long j5 = j4 >> numberOfTrailingZeros;
            long j6 = j % j3;
            if (j6 == 0) {
                return true;
            }
            long powMod = powMod(j6, j5, j2);
            if (powMod == 1) {
                return true;
            }
            int i = 0;
            while (powMod != j4) {
                i++;
                if (i == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j3);
            }
            return true;
        }

        public abstract long mulMod(long j, long j2, long j3);

        public abstract long squareMod(long j, long j2);
    }

    private LongMath() {
    }

    public static long binomial(int i, int i2) {
        boolean z;
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", i2);
        if (i2 <= i) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        long j = 1;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return (long) i;
        }
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i] / (jArr[i2] * jArr[i - i2]);
        }
        int[] iArr = biggestBinomials;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i2 >= iArr2.length || i > iArr2[i2]) {
            long j2 = (long) i;
            int log2 = log2(j2, RoundingMode.CEILING);
            int i3 = i - 1;
            int i4 = log2;
            long j3 = j2;
            int i5 = 2;
            long j4 = 1;
            while (i5 <= i2) {
                i4 += log2;
                if (i4 < 63) {
                    j3 *= (long) i3;
                    j4 *= (long) i5;
                } else {
                    j = multiplyFraction(j, j3, j4);
                    j3 = (long) i3;
                    j4 = (long) i5;
                    i4 = log2;
                }
                i5++;
                i3--;
            }
            return multiplyFraction(j, j3, j4);
        }
        int i6 = i - 1;
        long j5 = (long) i;
        for (int i7 = 2; i7 <= i2; i7++) {
            j5 = (j5 * ((long) i6)) / ((long) i7);
            i6--;
        }
        return j5;
    }

    @Beta
    public static long ceilingPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        if (j <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        StringBuilder sb = new StringBuilder(70);
        sb.append("ceilingPowerOfTwo(");
        sb.append(j);
        sb.append(") is not representable as a long");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static long checkedAdd(long j, long j2) {
        boolean z;
        long j3 = j + j2;
        boolean z2 = false;
        if ((j ^ j2) < 0) {
            z = true;
        } else {
            z = false;
        }
        if ((j ^ j3) >= 0) {
            z2 = true;
        }
        MathPreconditions.checkNoOverflow(z | z2, "checkedAdd", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j3 = j;
        long j4 = j2;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j4) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j3) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j3 * j4;
        }
        if (numberOfLeadingZeros >= 64) {
            z = true;
        } else {
            z = false;
        }
        MathPreconditions.checkNoOverflow(z, "checkedMultiply", j, j2);
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (j4 != Long.MIN_VALUE) {
            z3 = true;
        } else {
            z3 = false;
        }
        MathPreconditions.checkNoOverflow(z2 | z3, "checkedMultiply", j, j2);
        long j5 = j3 * j4;
        if (i == 0 || j5 / j3 == j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        MathPreconditions.checkNoOverflow(z4, "checkedMultiply", j, j2);
        return j5;
    }

    @GwtIncompatible
    public static long checkedPow(long j, int i) {
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        boolean z4;
        boolean z5;
        MathPreconditions.checkNonNegative("exponent", i);
        if (j >= -2) {
            z = true;
        } else {
            z = false;
        }
        if (j <= 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j3 = 1;
        if (z && z2) {
            int i2 = (int) j;
            if (i2 == -2) {
                if (i < 64) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                MathPreconditions.checkNoOverflow(z4, "checkedPow", j, (long) i);
                if ((i & 1) == 0) {
                    return 1 << i;
                }
                return -1 << i;
            } else if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 == 2) {
                        if (i < 63) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        MathPreconditions.checkNoOverflow(z5, "checkedPow", j, (long) i);
                        return 1 << i;
                    }
                    throw new AssertionError();
                } else if (i == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            long j4 = j;
            int i3 = i;
            while (i3 != 0) {
                if (i3 == 1) {
                    return checkedMultiply(j3, j4);
                }
                if ((i3 & 1) != 0) {
                    j2 = checkedMultiply(j3, j4);
                } else {
                    j2 = j3;
                }
                int i4 = i3 >> 1;
                if (i4 > 0) {
                    if (-3037000499L > j4 || j4 > FLOOR_SQRT_MAX_LONG) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    MathPreconditions.checkNoOverflow(z3, "checkedPow", j4, (long) i4);
                    j4 *= j4;
                }
                j3 = j2;
                i3 = i4;
            }
            return j3;
        }
    }

    @GwtIncompatible
    public static long checkedSubtract(long j, long j2) {
        boolean z;
        long j3 = j - j2;
        boolean z2 = false;
        if ((j ^ j2) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if ((j ^ j3) >= 0) {
            z2 = true;
        }
        MathPreconditions.checkNoOverflow(z | z2, "checkedSubtract", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long divide(long j, long j2, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        int i = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i == 0) {
            return j3;
        }
        int i2 = (int) ((j ^ j2) >> 63);
        boolean z = true;
        int i3 = i2 | 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (i != 0) {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                return j3;
            case 2:
                return j3;
            case 3:
                if (i3 >= 0) {
                    return j3;
                }
                break;
            case 4:
                break;
            case 5:
                if (i3 <= 0) {
                    return j3;
                }
                break;
            case 6:
            case 7:
            case 8:
                long abs = Math.abs(j4);
                int i4 = ((abs - (Math.abs(j2) - abs)) > 0 ? 1 : ((abs - (Math.abs(j2) - abs)) == 0 ? 0 : -1));
                if (i4 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j3) == 0)) {
                        return j3;
                    }
                } else if (i4 <= 0) {
                    return j3;
                }
                break;
            default:
                throw new AssertionError();
        }
        return j3 + ((long) i3);
    }

    @GwtIncompatible
    public static long factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i];
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static boolean fitsInInt(long j) {
        return ((long) ((int) j)) == j;
    }

    @Beta
    public static long floorPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    public static long gcd(long j, long j2) {
        MathPreconditions.checkNonNegative("a", j);
        MathPreconditions.checkNonNegative("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j3 = j >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros2;
        while (j3 != j4) {
            long j5 = j3 - j4;
            long j6 = (j5 >> 63) & j5;
            long j7 = (j5 - j6) - j6;
            j4 += j6;
            j3 = j7 >> Long.numberOfTrailingZeros(j7);
        }
        return j3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j) {
        boolean z = false;
        boolean z2 = j > 0;
        if ((j & (j - 1)) == 0) {
            z = true;
        }
        return z2 & z;
    }

    @GwtIncompatible
    @Beta
    public static boolean isPrime(long j) {
        if (j < 2) {
            MathPreconditions.checkNonNegative("n", j);
            return false;
        } else if (j < 66) {
            if (((722865708377213483 >> (((int) j) - 2)) & 1) != 0) {
                return true;
            }
            return false;
        } else if (((1 << ((int) (j % 30))) & SIEVE_30) != 0 || j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
            return false;
        } else {
            if (j < 289) {
                return true;
            }
            for (long[] jArr : millerRabinBaseSets) {
                if (j <= jArr[0]) {
                    for (int i = 1; i < jArr.length; i++) {
                        if (!MillerRabinTester.test(jArr[i], j)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long j, long j2) {
        return (int) ((~(~(j - j2))) >>> 63);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r4 + r0;
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int log10(long r4, java.math.RoundingMode r6) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.checkPositive((java.lang.String) r0, (long) r4)
            int r0 = log10Floor(r4)
            long[] r1 = powersOf10
            r2 = r1[r0]
            int[] r1 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r6 = r6.ordinal()
            r6 = r1[r6]
            switch(r6) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0037;
                case 3: goto L_0x0037;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x001e;
                case 7: goto L_0x001e;
                case 8: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x001e:
            long[] r6 = halfPowersOf10
            r1 = r6[r0]
            int r4 = lessThanBranchFree(r1, r4)
        L_0x0026:
            int r4 = r4 + r0
            return r4
        L_0x0028:
            int r4 = lessThanBranchFree(r2, r4)
            goto L_0x0026
        L_0x002d:
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r4)
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.log10(long, java.math.RoundingMode):int");
    }

    @GwtIncompatible
    public static int log10Floor(long j) {
        byte b = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j)];
        return b - lessThanBranchFree(j, powersOf10[b]);
    }

    public static int log2(long j, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j) + (63 - numberOfLeadingZeros);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    @GwtIncompatible
    public static int mod(long j, int i) {
        return (int) mod(j, (long) i);
    }

    public static long multiplyFraction(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long gcd = gcd(j, j3);
        return (j2 / (j3 / gcd)) * (j / gcd);
    }

    @GwtIncompatible
    public static long pow(long j, int i) {
        long j2;
        MathPreconditions.checkNonNegative("exponent", i);
        if (-2 > j || j > 2) {
            long j3 = 1;
            while (i != 0) {
                if (i == 1) {
                    return j3 * j;
                }
                if ((i & 1) == 0) {
                    j2 = 1;
                } else {
                    j2 = j;
                }
                j3 *= j2;
                j *= j;
                i >>= 1;
            }
            return j3;
        }
        int i2 = (int) j;
        if (i2 != -2) {
            if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 != 2) {
                        throw new AssertionError();
                    } else if (i < 64) {
                        return 1 << i;
                    } else {
                        return 0;
                    }
                } else if (i == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i >= 64) {
            return 0;
        } else {
            if ((i & 1) == 0) {
                return 1 << i;
            }
            return -(1 << i);
        }
    }

    @GwtIncompatible
    public static double roundToDouble(long j, RoundingMode roundingMode) {
        int i;
        boolean z;
        double d;
        long j2;
        long j3 = j;
        double d2 = (double) j3;
        long j4 = (long) d2;
        if (j4 == LocationRequestCompat.PASSIVE_INTERVAL) {
            i = -1;
        } else {
            i = Longs.compare(j3, j4);
        }
        int[] iArr = AnonymousClass1.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                return d2;
            case 2:
                if (j3 >= 0) {
                    if (i >= 0) {
                        return d2;
                    }
                    return DoubleUtils.nextDown(d2);
                } else if (i <= 0) {
                    return d2;
                } else {
                    return Math.nextUp(d2);
                }
            case 3:
                if (i >= 0) {
                    return d2;
                }
                return DoubleUtils.nextDown(d2);
            case 4:
                if (j3 >= 0) {
                    if (i <= 0) {
                        return d2;
                    }
                    return Math.nextUp(d2);
                } else if (i >= 0) {
                    return d2;
                } else {
                    return DoubleUtils.nextDown(d2);
                }
            case 5:
                if (i <= 0) {
                    return d2;
                }
                return Math.nextUp(d2);
            case 6:
            case 7:
            case 8:
                if (i >= 0) {
                    d = Math.nextUp(d2);
                    j2 = (long) Math.ceil(d);
                } else {
                    double nextDown = DoubleUtils.nextDown(d2);
                    long j5 = j4;
                    j4 = (long) Math.floor(nextDown);
                    d = d2;
                    d2 = nextDown;
                    j2 = j5;
                }
                long j6 = j3 - j4;
                long j7 = j2 - j3;
                if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                    j7++;
                }
                int compare = Longs.compare(j6, j7);
                if (compare < 0) {
                    return d2;
                }
                if (compare > 0) {
                    return d;
                }
                int i2 = iArr[roundingMode.ordinal()];
                if (i2 != 6) {
                    if (i2 != 7) {
                        if (i2 != 8) {
                            throw new AssertionError("impossible");
                        } else if ((DoubleUtils.getSignificand(d2) & 1) == 0) {
                            return d2;
                        } else {
                            return d;
                        }
                    } else if (j3 >= 0) {
                        return d;
                    } else {
                        return d2;
                    }
                } else if (j3 >= 0) {
                    return d2;
                } else {
                    return d;
                }
            default:
                throw new AssertionError("impossible");
        }
    }

    @Beta
    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = false;
        boolean z2 = (j2 ^ j) < 0;
        if ((j ^ j3) >= 0) {
            z = true;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @Beta
    public static long saturatedMultiply(long j, long j2) {
        boolean z;
        boolean z2;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + LocationRequestCompat.PASSIVE_INTERVAL;
        boolean z3 = false;
        if (numberOfLeadingZeros < 64) {
            z = true;
        } else {
            z = false;
        }
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (j2 == Long.MIN_VALUE) {
            z3 = true;
        }
        if (z || (z3 & z2)) {
            return j3;
        }
        long j4 = j * j2;
        if (i == 0 || j4 / j == j2) {
            return j4;
        }
        return j3;
    }

    @Beta
    public static long saturatedPow(long j, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        MathPreconditions.checkNonNegative("exponent", i);
        if (j >= -2) {
            z = true;
        } else {
            z = false;
        }
        if (j <= 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j2 = 1;
        if (z && z2) {
            int i2 = (int) j;
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            return 1;
                        }
                        if (i2 != 2) {
                            throw new AssertionError();
                        } else if (i >= 63) {
                            return LocationRequestCompat.PASSIVE_INTERVAL;
                        } else {
                            return 1 << i;
                        }
                    } else if (i == 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else if ((i & 1) == 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (i >= 64) {
                return ((long) (i & 1)) + LocationRequestCompat.PASSIVE_INTERVAL;
            } else {
                if ((i & 1) == 0) {
                    return 1 << i;
                }
                return -1 << i;
            }
        } else {
            long j3 = ((j >>> 63) & ((long) (i & 1))) + LocationRequestCompat.PASSIVE_INTERVAL;
            while (i != 0) {
                if (i == 1) {
                    return saturatedMultiply(j2, j);
                }
                if ((i & 1) != 0) {
                    j2 = saturatedMultiply(j2, j);
                }
                i >>= 1;
                if (i > 0) {
                    if (-3037000499L > j) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (j > FLOOR_SQRT_MAX_LONG) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z3 || z4) {
                        return j3;
                    }
                    j *= j;
                }
            }
            return j2;
        }
    }

    @Beta
    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = false;
        boolean z2 = (j2 ^ j) >= 0;
        if ((j ^ j3) >= 0) {
            z = true;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @GwtIncompatible
    public static long sqrt(long j, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j);
        if (fitsInInt(j)) {
            return (long) IntMath.sqrt((int) j, roundingMode);
        }
        long sqrt = (long) Math.sqrt((double) j);
        long j2 = sqrt * sqrt;
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (j2 == j) {
                    z = true;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                return sqrt;
            case 2:
            case 3:
                if (j < j2) {
                    return sqrt - 1;
                }
                return sqrt;
            case 4:
            case 5:
                if (j > j2) {
                    return sqrt + 1;
                }
                return sqrt;
            case 6:
            case 7:
            case 8:
                if (j < j2) {
                    z = true;
                }
                long j3 = sqrt - (z ? 1 : 0);
                return j3 + ((long) lessThanBranchFree((j3 * j3) + j3, j));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long mod(long j, long j2) {
        if (j2 > 0) {
            long j3 = j % j2;
            return j3 >= 0 ? j3 : j3 + j2;
        }
        throw new ArithmeticException("Modulus must be positive");
    }
}
