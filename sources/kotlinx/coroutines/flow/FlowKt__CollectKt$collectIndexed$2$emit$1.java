package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class FlowKt__CollectKt$collectIndexed$2$emit$1 extends ContinuationImpl {
    public /* synthetic */ Object c;
    public final /* synthetic */ FlowKt__CollectKt$collectIndexed$2 d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__CollectKt$collectIndexed$2$emit$1(FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2, Continuation<? super FlowKt__CollectKt$collectIndexed$2$emit$1> continuation) {
        super(continuation);
        this.d = flowKt__CollectKt$collectIndexed$2;
    }

    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.d.emit((Object) null, this);
        throw null;
    }
}
