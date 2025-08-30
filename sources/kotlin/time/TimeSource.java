package kotlin.time;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/time/TimeSource;", "", "WithComparableMarks", "Monotonic", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface TimeSource {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Monotonic implements WithComparableMarks {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Monotonic f760a = new Object();

        @JvmInline
        @SinceKotlin(version = "1.9")
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\b@\u0018\u00002\u00020\u0001\u0001\u0002\u0001\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @WasExperimental(markerClass = {ExperimentalTime.class})
        public static final class ValueTimeMark implements ComparableTimeMark {
            public final long a(ComparableTimeMark comparableTimeMark) {
                Intrinsics.checkNotNullParameter(comparableTimeMark, FacebookRequestErrorClassification.KEY_OTHER);
                Intrinsics.checkNotNullParameter(comparableTimeMark, FacebookRequestErrorClassification.KEY_OTHER);
                if (comparableTimeMark instanceof ValueTimeMark) {
                    ((ValueTimeMark) comparableTimeMark).getClass();
                    MonotonicTimeSource.f759a.getClass();
                    return LongSaturatedMathKt.b(0, 0, DurationUnit.NANOSECONDS);
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: ValueTimeMark(reading=0) and " + comparableTimeMark);
            }

            public final int compareTo(Object obj) {
                return ComparableTimeMark.DefaultImpls.a(this, (ComparableTimeMark) obj);
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof ValueTimeMark)) {
                    return false;
                }
                ((ValueTimeMark) obj).getClass();
                return true;
            }

            public final int hashCode() {
                return (int) 0;
            }

            public final String toString() {
                return "ValueTimeMark(reading=0)";
            }
        }

        public final String toString() {
            MonotonicTimeSource.f759a.getClass();
            return "TimeSource(System.nanoTime())";
        }
    }

    @SinceKotlin(version = "1.9")
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public interface WithComparableMarks extends TimeSource {
    }
}
