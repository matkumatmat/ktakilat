package kotlin.time;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.ComparableTimeMark;
import kotlin.time.Duration;
import kotlin.time.DurationUnitKt__DurationUnitKt;
import kotlin.time.TimeSource;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {

    /* renamed from: a  reason: collision with root package name */
    public final DurationUnit f756a;
    public final Lazy b = LazyKt.b(new c(this, 0));

    @SourceDebugExtension({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,202:1\n80#2:203\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n67#1:203\n*E\n"})
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "", "startedAt", "Lkotlin/time/AbstractLongTimeSource;", "timeSource", "Lkotlin/time/Duration;", "offset", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LongTimeMark implements ComparableTimeMark {
        public final long c;
        public final AbstractLongTimeSource d;
        public final long e;

        public LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            Intrinsics.checkNotNullParameter(abstractLongTimeSource, "timeSource");
            this.c = j;
            this.d = abstractLongTimeSource;
            this.e = j2;
        }

        public final long a(ComparableTimeMark comparableTimeMark) {
            Intrinsics.checkNotNullParameter(comparableTimeMark, FacebookRequestErrorClassification.KEY_OTHER);
            if (comparableTimeMark instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) comparableTimeMark;
                AbstractLongTimeSource abstractLongTimeSource = longTimeMark.d;
                AbstractLongTimeSource abstractLongTimeSource2 = this.d;
                if (Intrinsics.a(abstractLongTimeSource2, abstractLongTimeSource)) {
                    return Duration.f(LongSaturatedMathKt.b(this.c, longTimeMark.c, abstractLongTimeSource2.f756a), Duration.f(this.e, Duration.i(longTimeMark.e)));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + comparableTimeMark);
        }

        public final int compareTo(Object obj) {
            return ComparableTimeMark.DefaultImpls.a(this, (ComparableTimeMark) obj);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof LongTimeMark) {
                if (Intrinsics.a(this.d, ((LongTimeMark) obj).d)) {
                    long a2 = a((ComparableTimeMark) obj);
                    Duration.d.getClass();
                    if (a2 == 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            Duration.Companion companion = Duration.d;
            long j = this.e;
            long j2 = this.c;
            return (((int) (j ^ (j >>> 32))) * 37) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("LongTimeMark(");
            sb.append(this.c);
            AbstractLongTimeSource abstractLongTimeSource = this.d;
            DurationUnit durationUnit = abstractLongTimeSource.f756a;
            Intrinsics.checkNotNullParameter(durationUnit, "<this>");
            switch (DurationUnitKt__DurationUnitKt.WhenMappings.f758a[durationUnit.ordinal()]) {
                case 1:
                    str = "ns";
                    break;
                case 2:
                    str = "us";
                    break;
                case 3:
                    str = "ms";
                    break;
                case 4:
                    str = "s";
                    break;
                case 5:
                    str = "m";
                    break;
                case 6:
                    str = "h";
                    break;
                case 7:
                    str = "d";
                    break;
                default:
                    throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
            }
            sb.append(str);
            sb.append(" + ");
            sb.append(Duration.h(this.e));
            sb.append(", ");
            sb.append(abstractLongTimeSource);
            sb.append(')');
            return sb.toString();
        }
    }

    public AbstractLongTimeSource(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        this.f756a = durationUnit;
    }
}
