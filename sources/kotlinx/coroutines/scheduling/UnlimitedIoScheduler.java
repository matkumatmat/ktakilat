package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.internal.NamedDispatcher;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/scheduling/UnlimitedIoScheduler;", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class UnlimitedIoScheduler extends CoroutineDispatcher {
    public static final UnlimitedIoScheduler c = new CoroutineDispatcher();

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.d.c.d(runnable, true, false);
    }

    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.d.c.d(runnable, true, true);
    }

    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        LimitedDispatcherKt.a(i);
        if (i < TasksKt.d) {
            return super.limitedParallelism(i, str);
        }
        if (str != null) {
            return new NamedDispatcher(this, str);
        }
        return this;
    }

    public final String toString() {
        return "Dispatchers.IO";
    }
}
