package org.apache.commons.lang3;

import androidx.core.location.LocationRequestCompat;
import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static byte[] nextBytes(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Validate.isTrue(z, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static double nextDouble(double d, double d2) {
        boolean z = true;
        Validate.isTrue(d2 >= d, "Start value must be smaller or equal to end value.", new Object[0]);
        if (d < 0.0d) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (d == d2) {
            return d;
        }
        return (RANDOM.nextDouble() * (d2 - d)) + d;
    }

    public static float nextFloat(float f, float f2) {
        boolean z = true;
        Validate.isTrue(f2 >= f, "Start value must be smaller or equal to end value.", new Object[0]);
        if (f < 0.0f) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (f == f2) {
            return f;
        }
        return (RANDOM.nextFloat() * (f2 - f)) + f;
    }

    public static int nextInt(int i, int i2) {
        boolean z = true;
        Validate.isTrue(i2 >= i, "Start value must be smaller or equal to end value.", new Object[0]);
        if (i < 0) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (i == i2) {
            return i;
        }
        return RANDOM.nextInt(i2 - i) + i;
    }

    public static long nextLong(long j, long j2) {
        boolean z = true;
        Validate.isTrue(j2 >= j, "Start value must be smaller or equal to end value.", new Object[0]);
        if (j < 0) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        if (j == j2) {
            return j;
        }
        return j + nextLong(j2 - j);
    }

    public static double nextDouble() {
        return nextDouble(0.0d, Double.MAX_VALUE);
    }

    public static float nextFloat() {
        return nextFloat(0.0f, Float.MAX_VALUE);
    }

    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE);
    }

    public static long nextLong() {
        return nextLong(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    private static long nextLong(long j) {
        long nextLong;
        long j2;
        do {
            nextLong = RANDOM.nextLong() >>> 1;
            j2 = nextLong % j;
        } while ((j - 1) + (nextLong - j2) < 0);
        return j2;
    }
}
