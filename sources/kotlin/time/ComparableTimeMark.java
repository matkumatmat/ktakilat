package kotlin.time;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/ComparableTimeMark;", "Lkotlin/time/TimeMark;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface ComparableTimeMark extends TimeMark, Comparable<ComparableTimeMark> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int a(ComparableTimeMark comparableTimeMark, ComparableTimeMark comparableTimeMark2) {
            Intrinsics.checkNotNullParameter(comparableTimeMark2, FacebookRequestErrorClassification.KEY_OTHER);
            long a2 = comparableTimeMark.a(comparableTimeMark2);
            Duration.d.getClass();
            return Duration.d(a2, 0);
        }
    }

    long a(ComparableTimeMark comparableTimeMark);
}
