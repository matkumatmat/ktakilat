package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1059:1\n1012#1,6:1061\n1015#1,3:1067\n1012#1,6:1070\n1012#1,6:1076\n1015#1,3:1085\n1#2:1060\n1734#3,3:1082\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n936#1:1061,6\n970#1:1067,3\n973#1:1070,6\n976#1:1076,6\n1012#1:1085,3\n1001#1:1082,3\n*E\n"})
public final class DurationKt {
    public static final long a(long j) {
        long j2 = (j << 1) + 1;
        Duration.Companion companion = Duration.d;
        int i = DurationJvmKt.f757a;
        return j2;
    }

    public static final long b(long j) {
        long j2 = j << 1;
        Duration.Companion companion = Duration.d;
        int i = DurationJvmKt.f757a;
        return j2;
    }

    public static final long c(int i, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (durationUnit.compareTo(DurationUnit.SECONDS) <= 0) {
            return b(DurationUnitKt__DurationUnitJvmKt.b((long) i, durationUnit, DurationUnit.NANOSECONDS));
        }
        return d((long) i, durationUnit);
    }

    public static final long d(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long b = DurationUnitKt__DurationUnitJvmKt.b(4611686018426999999L, durationUnit2, durationUnit);
        if ((-b) > j || j > b) {
            return a(RangesKt.a(DurationUnitKt__DurationUnitJvmKt.a(j, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
        }
        return b(DurationUnitKt__DurationUnitJvmKt.b(j, durationUnit, durationUnit2));
    }
}
