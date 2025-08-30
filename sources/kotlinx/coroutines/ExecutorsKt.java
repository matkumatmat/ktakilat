package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0010\b\u0007\u0010\u0002\"\u00020\u00002\u00020\u0000B\u0002\b\u0001¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/ExperimentalCoroutinesApi;", "CloseableCoroutineDispatcher", "kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExecutorsKt {
    public static final Executor a(CoroutineDispatcher coroutineDispatcher) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcher;
        Executor t;
        if (coroutineDispatcher instanceof ExecutorCoroutineDispatcher) {
            executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) coroutineDispatcher;
        } else {
            executorCoroutineDispatcher = null;
        }
        if (executorCoroutineDispatcher == null || (t = executorCoroutineDispatcher.t()) == null) {
            return new DispatcherExecutor(coroutineDispatcher);
        }
        return t;
    }

    public static final CoroutineDispatcher b(Executor executor) {
        DispatcherExecutor dispatcherExecutor;
        if (executor instanceof DispatcherExecutor) {
            dispatcherExecutor = (DispatcherExecutor) executor;
        } else {
            dispatcherExecutor = null;
        }
        if (dispatcherExecutor != null) {
            return dispatcherExecutor.c;
        }
        return new ExecutorCoroutineDispatcherImpl(executor);
    }
}
