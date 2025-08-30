package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\b'\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\rJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0015J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010 J\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\"¨\u0006$"}, d2 = {"Lkotlin/random/Random;", "", "<init>", "()V", "", "until", "nextInt", "(I)I", "from", "(II)I", "", "nextLong", "()J", "(J)J", "(JJ)J", "", "nextBoolean", "()Z", "", "nextDouble", "()D", "(D)D", "(DD)D", "", "nextFloat", "()F", "", "array", "fromIndex", "toIndex", "nextBytes", "([BII)[B", "([B)[B", "size", "(I)[B", "Default", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Random {
    @NotNull
    public static final Default Default = new Default((DefaultConstructorMarker) null);
    public static final Random c = PlatformImplementationsKt.f705a.b();

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0010H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "defaultRandom", "writeReplace", "", "nextBits", "", "bitCount", "nextInt", "until", "from", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "nextBytes", "", "array", "size", "fromIndex", "toIndex", "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Default extends Random implements Serializable {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Serialized implements Serializable {
            @NotNull
            public static final Serialized c = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.c;
        }

        public int nextBits(int i) {
            return Random.c.nextBits(i);
        }

        public boolean nextBoolean() {
            return Random.c.nextBoolean();
        }

        @NotNull
        public byte[] nextBytes(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            return Random.c.nextBytes(bArr);
        }

        public double nextDouble() {
            return Random.c.nextDouble();
        }

        public float nextFloat() {
            return Random.c.nextFloat();
        }

        public int nextInt() {
            return Random.c.nextInt();
        }

        public long nextLong() {
            return Random.c.nextLong();
        }

        private Default() {
        }

        @NotNull
        public byte[] nextBytes(int i) {
            return Random.c.nextBytes(i);
        }

        public double nextDouble(double d) {
            return Random.c.nextDouble(d);
        }

        public int nextInt(int i) {
            return Random.c.nextInt(i);
        }

        public long nextLong(long j) {
            return Random.c.nextLong(j);
        }

        @NotNull
        public byte[] nextBytes(@NotNull byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            return Random.c.nextBytes(bArr, i, i2);
        }

        public double nextDouble(double d, double d2) {
            return Random.c.nextDouble(d, d2);
        }

        public int nextInt(int i, int i2) {
            return Random.c.nextInt(i, i2);
        }

        public long nextLong(long j, long j2) {
            return Random.c.nextLong(j, j2);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return random.nextBytes(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i);

    public boolean nextBoolean() {
        if (nextBits(1) != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        if (i < 0 || i > bArr.length || i2 < 0 || i2 > bArr.length) {
            StringBuilder r = e.r(i, "fromIndex (", i2, ") or toIndex (", ") are out of range: 0..");
            r.append(bArr.length);
            r.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            throw new IllegalArgumentException(r.toString().toString());
        } else if (i <= i2) {
            int i3 = (i2 - i) / 4;
            for (int i4 = 0; i4 < i3; i4++) {
                int nextInt = nextInt();
                bArr[i] = (byte) nextInt;
                bArr[i + 1] = (byte) (nextInt >>> 8);
                bArr[i + 2] = (byte) (nextInt >>> 16);
                bArr[i + 3] = (byte) (nextInt >>> 24);
                i += 4;
            }
            int i5 = i2 - i;
            int nextBits = nextBits(i5 * 8);
            for (int i6 = 0; i6 < i5; i6++) {
                bArr[i + i6] = (byte) (nextBits >>> (i6 * 8));
            }
            return bArr;
        } else {
            throw new IllegalArgumentException(("fromIndex (" + i + ") must be not greater than toIndex (" + i2 + ").").toString());
        }
    }

    public double nextDouble() {
        return ((double) ((((long) nextBits(26)) << 27) + ((long) nextBits(27)))) / 9.007199254740992E15d;
    }

    public float nextFloat() {
        return ((float) nextBits(24)) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double d) {
        return nextDouble(0.0d, d);
    }

    public int nextInt(int i) {
        return nextInt(0, i);
    }

    public long nextLong(long j) {
        return nextLong(0, j);
    }

    public double nextDouble(double d, double d2) {
        double d3;
        if (d2 > d) {
            double d4 = d2 - d;
            if (!Double.isInfinite(d4) || Double.isInfinite(d) || Double.isNaN(d) || Double.isInfinite(d2) || Double.isNaN(d2)) {
                d3 = d + (nextDouble() * d4);
            } else {
                double d5 = (double) 2;
                double nextDouble = ((d2 / d5) - (d / d5)) * nextDouble();
                d3 = d + nextDouble + nextDouble;
            }
            return d3 >= d2 ? Math.nextAfter(d2, Double.NEGATIVE_INFINITY) : d3;
        }
        throw new IllegalArgumentException(RandomKt.a(Double.valueOf(d), Double.valueOf(d2)).toString());
    }

    public int nextInt(int i, int i2) {
        int i3;
        int nextInt;
        int i4;
        if (i2 > i) {
            int i5 = i2 - i;
            if (i5 > 0 || i5 == Integer.MIN_VALUE) {
                if (((-i5) & i5) == i5) {
                    i3 = nextBits(31 - Integer.numberOfLeadingZeros(i5));
                } else {
                    do {
                        nextInt = nextInt() >>> 1;
                        i4 = nextInt % i5;
                    } while ((i5 - 1) + (nextInt - i4) < 0);
                    i3 = i4;
                }
                return i + i3;
            }
            while (true) {
                int nextInt2 = nextInt();
                if (i <= nextInt2 && nextInt2 < i2) {
                    return nextInt2;
                }
            }
        } else {
            throw new IllegalArgumentException(RandomKt.a(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public long nextLong(long j, long j2) {
        long j3;
        long nextLong;
        long j4;
        int nextInt;
        if (j2 > j) {
            long j5 = j2 - j;
            if (j5 > 0) {
                if (((-j5) & j5) == j5) {
                    int i = (int) j5;
                    int i2 = (int) (j5 >>> 32);
                    if (i != 0) {
                        nextInt = nextBits(31 - Integer.numberOfLeadingZeros(i));
                    } else if (i2 == 1) {
                        nextInt = nextInt();
                    } else {
                        j3 = (((long) nextBits(31 - Integer.numberOfLeadingZeros(i2))) << 32) + (((long) nextInt()) & 4294967295L);
                    }
                    j3 = ((long) nextInt) & 4294967295L;
                } else {
                    do {
                        nextLong = nextLong() >>> 1;
                        j4 = nextLong % j5;
                    } while ((j5 - 1) + (nextLong - j4) < 0);
                    j3 = j4;
                }
                return j + j3;
            }
            while (true) {
                long nextLong2 = nextLong();
                if (j <= nextLong2 && nextLong2 < j2) {
                    return nextLong2;
                }
            }
        } else {
            throw new IllegalArgumentException(RandomKt.a(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        return nextBytes(bArr, 0, bArr.length);
    }

    @NotNull
    public byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }
}
