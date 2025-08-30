package kotlinx.coroutines.scheduling;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002*\f\b\u0000\u0010\u0001\"\u00020\u00002\u00020\u0000¨\u0006\u0002"}, d2 = {"", "TaskContext", "kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TasksKt {

    /* renamed from: a  reason: collision with root package name */
    public static final String f813a;
    public static final long b = SystemPropsKt.b(100000, 1, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.resolution.ns");
    public static final int c;
    public static final int d = SystemPropsKt.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
    public static final long e = TimeUnit.SECONDS.toNanos(SystemPropsKt.b(60, 1, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.keep.alive.sec"));
    public static final NanoTimeSource f = NanoTimeSource.f812a;

    static {
        String c2 = SystemPropsKt.c("kotlinx.coroutines.scheduler.default.name");
        if (c2 == null) {
            c2 = "DefaultDispatcher";
        }
        f813a = c2;
        int a2 = SystemPropsKt.a();
        if (a2 < 2) {
            a2 = 2;
        }
        c = SystemPropsKt.d("kotlinx.coroutines.scheduler.core.pool.size", a2, 1, 0, 8);
    }
}
