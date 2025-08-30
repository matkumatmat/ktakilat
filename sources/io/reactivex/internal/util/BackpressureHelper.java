package io.reactivex.internal.util;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

public final class BackpressureHelper {
    public static long a(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        } while (!atomicLong.compareAndSet(j2, c(j2, j)));
        return j2;
    }

    public static long b(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        } while (!atomicLong.compareAndSet(j2, c(j2, j)));
        return j2;
    }

    public static long c(long j, long j2) {
        long j3 = j + j2;
        return j3 < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j3;
    }

    public static long d(long j, long j2) {
        long j3 = j * j2;
        if (((j | j2) >>> 31) == 0 || j3 / j == j2) {
            return j3;
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static void e(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                j3 = j2 - j;
                if (j3 < 0) {
                    RxJavaPlugins.b(new IllegalStateException(e.j(j3, "More produced than requested: ")));
                    j3 = 0;
                }
            } else {
                return;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
    }

    public static long f(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                RxJavaPlugins.b(new IllegalStateException(e.j(j3, "More produced than requested: ")));
                j3 = 0;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }
}
