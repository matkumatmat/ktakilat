package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {179}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
final class FlowKt__ReduceKt$firstOrNull$3<T> extends ContinuationImpl {
    public Ref.ObjectRef c;
    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 d;
    public /* synthetic */ Object e;
    public int f;

    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        AbortFlowException e2;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
        this.e = obj;
        int i = (this.f | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f = i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.b(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(objectRef2);
            try {
                this.c = objectRef2;
                this.d = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                this.f = 1;
                throw null;
            } catch (AbortFlowException e3) {
                AbortFlowException abortFlowException = e3;
                objectRef = objectRef2;
                e2 = abortFlowException;
                if (e2.owner != flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) {
                    throw e2;
                }
                return objectRef.element;
            }
        } else if (i == 1) {
            flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = this.d;
            objectRef = this.c;
            try {
                ResultKt.b(obj);
            } catch (AbortFlowException e4) {
                e2 = e4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return objectRef.element;
    }
}
