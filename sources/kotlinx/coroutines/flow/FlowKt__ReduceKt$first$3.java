package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {179}, m = "first", n = {"predicate", "result", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
final class FlowKt__ReduceKt$first$3<T> extends ContinuationImpl {
    public Function2 c;
    public Ref.ObjectRef d;
    public FlowKt__ReduceKt$first$$inlined$collectWhile$2 e;
    public /* synthetic */ Object f;
    public int g;

    /* JADX WARNING: type inference failed for: r6v11, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            r5.f = r6
            int r6 = r5.g
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 | r0
            r5.g = r6
            r1 = r6 & r0
            if (r1 == 0) goto L_0x0012
            int r6 = r6 - r0
            r5.g = r6
            r6 = r5
            goto L_0x0017
        L_0x0012:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 r6 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3
            r6.<init>(r5)
        L_0x0017:
            java.lang.Object r0 = r6.f
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.g
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f791a
            r3 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r3) goto L_0x0030
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r1 = r6.e
            kotlin.jvm.internal.Ref$ObjectRef r3 = r6.d
            kotlin.jvm.functions.Function2 r6 = r6.c
            kotlin.ResultKt.b(r0)     // Catch:{ AbortFlowException -> 0x002e }
            goto L_0x0059
        L_0x002e:
            r0 = move-exception
            goto L_0x0055
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0038:
            kotlin.ResultKt.b(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r0.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r4 = 0
            r1.<init>(r4, r0)
            r6.c = r4     // Catch:{ AbortFlowException -> 0x0051 }
            r6.d = r0     // Catch:{ AbortFlowException -> 0x0051 }
            r6.e = r1     // Catch:{ AbortFlowException -> 0x0051 }
            r6.g = r3     // Catch:{ AbortFlowException -> 0x0051 }
            throw r4
        L_0x0051:
            r6 = move-exception
            r3 = r0
            r0 = r6
            r6 = r4
        L_0x0055:
            java.lang.Object r4 = r0.owner
            if (r4 != r1) goto L_0x0072
        L_0x0059:
            T r0 = r3.element
            if (r0 == r2) goto L_0x005e
            return r0
        L_0x005e:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected at least one element matching the predicate "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x0072:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
