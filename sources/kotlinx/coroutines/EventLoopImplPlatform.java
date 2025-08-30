package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.EventLoopImplBase;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class EventLoopImplPlatform extends EventLoop {
    public abstract Thread F();

    public void G(long j, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.k.L(j, delayedTask);
    }
}
