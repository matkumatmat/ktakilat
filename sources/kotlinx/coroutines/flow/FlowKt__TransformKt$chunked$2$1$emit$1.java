package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$chunked$2$1", f = "Transform.kt", i = {0}, l = {159}, m = "emit", n = {"this"}, s = {"L$0"})
final class FlowKt__TransformKt$chunked$2$1$emit$1 extends ContinuationImpl {
    public /* synthetic */ Object c;
    public final /* synthetic */ FlowKt__TransformKt$chunked$2$1 d;
    public int e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__TransformKt$chunked$2$1$emit$1(FlowKt__TransformKt$chunked$2$1 flowKt__TransformKt$chunked$2$1, Continuation continuation) {
        super(continuation);
        this.d = flowKt__TransformKt$chunked$2$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        this.d.emit((Object) null, this);
        throw null;
    }
}
