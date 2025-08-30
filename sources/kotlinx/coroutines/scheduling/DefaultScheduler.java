package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.internal.NamedDispatcher;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {
    public static final DefaultScheduler d;

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher, kotlinx.coroutines.scheduling.DefaultScheduler, kotlinx.coroutines.CoroutineDispatcher] */
    static {
        int i = TasksKt.c;
        int i2 = TasksKt.d;
        long j = TasksKt.e;
        String str = TasksKt.f813a;
        ? coroutineDispatcher = new CoroutineDispatcher();
        coroutineDispatcher.c = new CoroutineScheduler(j, str, i, i2);
        d = coroutineDispatcher;
    }

    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        LimitedDispatcherKt.a(i);
        if (i < TasksKt.c) {
            return super.limitedParallelism(i, str);
        }
        if (str != null) {
            return new NamedDispatcher(this, str);
        }
        return this;
    }

    public final String toString() {
        return "Dispatchers.Default";
    }
}
