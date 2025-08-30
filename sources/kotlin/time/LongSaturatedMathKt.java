package kotlin.time;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
public final class LongSaturatedMathKt {
    public static final long a(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        Duration.d.getClass();
        if (i < 0) {
            return Duration.f;
        }
        return Duration.e;
    }

    public static final long b(long j, long j2, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (((j2 - 1) | 1) == LocationRequestCompat.PASSIVE_INTERVAL) {
            if (j != j2) {
                return Duration.i(a(j2));
            }
            Duration.d.getClass();
            return 0;
        } else if (((j - 1) | 1) == LocationRequestCompat.PASSIVE_INTERVAL) {
            return a(j);
        } else {
            long j3 = j - j2;
            if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
                return DurationKt.d(j3, durationUnit);
            }
            DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
            if (durationUnit.compareTo(durationUnit2) >= 0) {
                return Duration.i(a(j3));
            }
            long a2 = DurationUnitKt__DurationUnitJvmKt.a(1, durationUnit2, durationUnit);
            long j4 = (j % a2) - (j2 % a2);
            Duration.Companion companion = Duration.d;
            return Duration.f(DurationKt.d((j / a2) - (j2 / a2), durationUnit2), DurationKt.d(j4, durationUnit));
        }
    }
}
