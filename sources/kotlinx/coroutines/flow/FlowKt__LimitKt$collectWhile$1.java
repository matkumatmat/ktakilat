package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {133}, m = "collectWhile", n = {"collector"}, s = {"L$0"})
final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {
    public FlowKt__LimitKt$collectWhile$collector$1 c;
    public /* synthetic */ Object d;
    public int e;

    /* JADX WARNING: type inference failed for: r0v3, types: [kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1, java.lang.Object] */
    public final Object invokeSuspend(Object obj) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1;
        this.d = obj;
        int i = (this.e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.e = i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.b(obj);
            ? obj2 = new Object();
            flowKt__LimitKt$collectWhile$collector$1 = obj2;
            this.c = obj2;
            this.e = 1;
            flowKt__LimitKt$collectWhile$collector$1 = obj2;
            throw null;
        } else if (i == 1) {
            FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$12 = this.c;
            try {
                flowKt__LimitKt$collectWhile$collector$1 = flowKt__LimitKt$collectWhile$collector$12;
                ResultKt.b(obj);
                flowKt__LimitKt$collectWhile$collector$1 = flowKt__LimitKt$collectWhile$collector$12;
            } catch (AbortFlowException e2) {
                if (e2.owner != flowKt__LimitKt$collectWhile$collector$1) {
                    throw e2;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f696a;
    }
}
