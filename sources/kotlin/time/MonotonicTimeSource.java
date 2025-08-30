package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.3")
public final class MonotonicTimeSource implements TimeSource.WithComparableMarks {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final MonotonicTimeSource f759a = new Object();

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.time.MonotonicTimeSource, java.lang.Object] */
    static {
        System.nanoTime();
    }

    public final String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
