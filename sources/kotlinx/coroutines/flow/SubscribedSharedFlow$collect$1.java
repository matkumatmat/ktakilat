package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", i = {}, l = {408}, m = "collect", n = {}, s = {})
final class SubscribedSharedFlow$collect$1 extends ContinuationImpl {
    public /* synthetic */ Object c;
    public final /* synthetic */ SubscribedSharedFlow d;
    public int e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscribedSharedFlow$collect$1(SubscribedSharedFlow subscribedSharedFlow, Continuation continuation) {
        super(continuation);
        this.d = subscribedSharedFlow;
    }

    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        this.d.collect((FlowCollector) null, this);
        throw null;
    }
}
