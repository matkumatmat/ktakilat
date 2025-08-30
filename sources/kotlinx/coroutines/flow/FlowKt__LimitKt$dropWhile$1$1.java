package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ FlowCollector d;
    public final /* synthetic */ SuspendLambda e;

    public FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, FlowCollector flowCollector, Function2 function2) {
        this.c = booleanRef;
        this.d = flowCollector;
        this.e = (SuspendLambda) function2;
    }

    /* JADX WARNING: type inference failed for: r8v10, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r5) goto L_0x003f
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.b(r8)
            goto L_0x0086
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.d
            java.lang.Object r2 = r0.c
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1) r2
            kotlin.ResultKt.b(r8)
            goto L_0x006a
        L_0x003f:
            kotlin.ResultKt.b(r8)
            goto L_0x0057
        L_0x0043:
            kotlin.ResultKt.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.c
            boolean r8 = r8.element
            if (r8 == 0) goto L_0x005a
            r0.g = r5
            kotlinx.coroutines.flow.FlowCollector r8 = r6.d
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L_0x0057
            return r1
        L_0x0057:
            kotlin.Unit r7 = kotlin.Unit.f696a
            return r7
        L_0x005a:
            r0.c = r6
            r0.d = r7
            r0.g = r4
            kotlin.coroutines.jvm.internal.SuspendLambda r8 = r6.e
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L_0x0069
            return r1
        L_0x0069:
            r2 = r6
        L_0x006a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0089
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.c
            r8.element = r5
            r8 = 0
            r0.c = r8
            r0.d = r8
            r0.g = r3
            kotlinx.coroutines.flow.FlowCollector r8 = r2.d
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L_0x0086
            return r1
        L_0x0086:
            kotlin.Unit r7 = kotlin.Unit.f696a
            return r7
        L_0x0089:
            kotlin.Unit r7 = kotlin.Unit.f696a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
