package kotlinx.coroutines.tasks;

import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/tasks/DirectExecutor;", "Ljava/util/concurrent/Executor;", "kotlinx-coroutines-play-services"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DirectExecutor implements Executor {
    public static final DirectExecutor c = new Object();

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
