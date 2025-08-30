package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class FlowKt__CountKt$count$4<T> implements FlowCollector {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.lang.Object r4, kotlin.coroutines.Continuation r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1
            if (r4 == 0) goto L_0x0013
            r4 = r5
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1 r4 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1) r4
            int r0 = r4.f
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r4.f = r0
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1 r4 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1
            r4.<init>(r3, r5)
        L_0x0018:
            java.lang.Object r5 = r4.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r4.f
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0042
            if (r0 != r2) goto L_0x003a
            java.lang.Object r4 = r4.c
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4 r4 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$4) r4
            kotlin.ResultKt.b(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0036
            kotlin.Unit r4 = kotlin.Unit.f696a
            return r4
        L_0x0036:
            r4.getClass()
            throw r1
        L_0x003a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0042:
            kotlin.ResultKt.b(r5)
            r4.c = r3
            r4.f = r2
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt$count$4.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
