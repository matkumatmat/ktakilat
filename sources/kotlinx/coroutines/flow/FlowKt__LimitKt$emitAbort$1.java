package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {70}, m = "emitAbort$FlowKt__LimitKt", n = {"ownershipMarker"}, s = {"L$0"})
final class FlowKt__LimitKt$emitAbort$1<T> extends ContinuationImpl {
    public /* synthetic */ Object c;
    public int d;

    /* JADX WARNING: type inference failed for: r5v6, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            r4.c = r5
            int r5 = r4.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 | r0
            r4.d = r5
            r1 = r5 & r0
            if (r1 == 0) goto L_0x0012
            int r5 = r5 - r0
            r4.d = r5
            r5 = r4
            goto L_0x0017
        L_0x0012:
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r5 = new kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            r5.<init>(r4)
        L_0x0017:
            java.lang.Object r0 = r5.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r5.d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 == r3) goto L_0x002b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x002b:
            kotlin.ResultKt.b(r0)
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r2)
            throw r5
        L_0x0034:
            kotlin.ResultKt.b(r0)
            r5.d = r3
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
