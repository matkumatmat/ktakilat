package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {387, 394, 397}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class SharedFlowImpl$collect$1<T> extends ContinuationImpl {
    public SharedFlowImpl c;
    public FlowCollector d;
    public SharedFlowSlot e;
    public Job f;
    public /* synthetic */ Object g;
    public final /* synthetic */ SharedFlowImpl i;
    public int j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(SharedFlowImpl sharedFlowImpl, Continuation continuation) {
        super(continuation);
        this.i = sharedFlowImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.j |= Integer.MIN_VALUE;
        return SharedFlowImpl.i(this.i, (FlowCollector) null, this);
    }
}
