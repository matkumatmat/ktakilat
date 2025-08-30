package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {29, 29}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
    public int c;
    public /* synthetic */ FlowCollector d;
    public /* synthetic */ Object[] e;

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1, kotlin.coroutines.jvm.internal.SuspendLambda] */
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ? suspendLambda = new SuspendLambda(3, (Continuation) obj3);
        suspendLambda.d = (FlowCollector) obj;
        suspendLambda.e = (Object[]) obj2;
        return suspendLambda.invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i != 0) {
            if (i == 1) {
                FlowCollector flowCollector = this.d;
                ResultKt.b(obj);
                this.d = null;
                this.c = 2;
                if (flowCollector.emit(obj, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else if (i == 2) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f696a;
        }
        ResultKt.b(obj);
        FlowCollector flowCollector2 = this.d;
        Object[] objArr = this.e;
        Object obj2 = objArr[0];
        Object obj3 = objArr[1];
        this.d = flowCollector2;
        this.c = 1;
        throw null;
    }
}
