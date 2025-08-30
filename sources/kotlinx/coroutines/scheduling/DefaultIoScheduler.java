package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultIoScheduler;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {
    public static final DefaultIoScheduler c = new CoroutineDispatcher();
    public static final CoroutineDispatcher d;

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlinx.coroutines.scheduling.DefaultIoScheduler, kotlinx.coroutines.CoroutineDispatcher] */
    static {
        UnlimitedIoScheduler unlimitedIoScheduler = UnlimitedIoScheduler.c;
        int a2 = SystemPropsKt.a();
        if (64 >= a2) {
            a2 = 64;
        }
        d = CoroutineDispatcher.limitedParallelism$default(unlimitedIoScheduler, SystemPropsKt.d("kotlinx.coroutines.io.parallelism", a2, 0, 0, 12), (String) null, 2, (Object) null);
    }

    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        d.dispatch(coroutineContext, runnable);
    }

    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        d.dispatchYield(coroutineContext, runnable);
    }

    public final void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        return UnlimitedIoScheduler.c.limitedParallelism(i, str);
    }

    public final Executor t() {
        return this;
    }

    public final String toString() {
        return "Dispatchers.IO";
    }
}
