package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class DistinctFlowImpl$collect$2<T> implements FlowCollector {
    public final /* synthetic */ DistinctFlowImpl c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ FlowCollector e;

    public DistinctFlowImpl$collect$2(DistinctFlowImpl distinctFlowImpl, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        this.c = distinctFlowImpl;
        this.d = objectRef;
        this.e = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.b(r7)
            goto L_0x0056
        L_0x0027:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002f:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl r7 = r5.c
            r7.getClass()
            kotlin.jvm.internal.Ref$ObjectRef r7 = r5.d
            T r2 = r7.element
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f791a
            if (r2 == r4) goto L_0x0049
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r6)
            if (r2 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            kotlin.Unit r6 = kotlin.Unit.f696a
            return r6
        L_0x0049:
            r7.element = r6
            r0.e = r3
            kotlinx.coroutines.flow.FlowCollector r7 = r5.e
            java.lang.Object r6 = r7.emit(r6, r0)
            if (r6 != r1) goto L_0x0056
            return r1
        L_0x0056:
            kotlin.Unit r6 = kotlin.Unit.f696a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
