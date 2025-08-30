package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {179}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
final class FlowKt__ReduceKt$singleOrNull$1<T> extends ContinuationImpl {
    public Ref.ObjectRef c;
    public FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 d;
    public /* synthetic */ Object e;
    public int f;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            r6.e = r7
            int r0 = r6.f
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r6.f = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f791a
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0026
            if (r0 != r3) goto L_0x001e
            kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 r0 = r6.d
            kotlin.jvm.internal.Ref$ObjectRef r3 = r6.c
            kotlin.ResultKt.b(r7)     // Catch:{ AbortFlowException -> 0x001c }
            goto L_0x0044
        L_0x001c:
            r7 = move-exception
            goto L_0x0040
        L_0x001e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0026:
            kotlin.ResultKt.b(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
            r0.<init>(r7)
            r6.c = r7     // Catch:{ AbortFlowException -> 0x003c }
            r6.d = r0     // Catch:{ AbortFlowException -> 0x003c }
            r6.f = r3     // Catch:{ AbortFlowException -> 0x003c }
            throw r2
        L_0x003c:
            r3 = move-exception
            r5 = r3
            r3 = r7
            r7 = r5
        L_0x0040:
            java.lang.Object r4 = r7.owner
            if (r4 != r0) goto L_0x004b
        L_0x0044:
            T r7 = r3.element
            if (r7 != r1) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r2 = r7
        L_0x004a:
            return r2
        L_0x004b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
