package kotlin.time;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;

@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "DoubleTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@ExperimentalTime
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DoubleTimeMark implements ComparableTimeMark {
        public final long a(ComparableTimeMark comparableTimeMark) {
            Intrinsics.checkNotNullParameter(comparableTimeMark, FacebookRequestErrorClassification.KEY_OTHER);
            if (comparableTimeMark instanceof DoubleTimeMark) {
                ((DoubleTimeMark) comparableTimeMark).getClass();
                if (Intrinsics.a((Object) null, (Object) null)) {
                    if (Duration.e(0)) {
                        Duration.d.getClass();
                        return 0;
                    }
                    Duration.f(0, Duration.i(0));
                    throw null;
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + comparableTimeMark);
        }

        public final int compareTo(Object obj) {
            return ComparableTimeMark.DefaultImpls.a(this, (ComparableTimeMark) obj);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof DoubleTimeMark) {
                ((DoubleTimeMark) obj).getClass();
                if (Intrinsics.a((Object) null, (Object) null)) {
                    a((ComparableTimeMark) obj);
                    Duration.d.getClass();
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }
}
