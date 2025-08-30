package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,425:1\n326#2:426\n*S KotlinDebug\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n*L\n416#1:426\n*E\n"})
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r5 = this;
            r0 = 0
            boolean r1 = r6 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r1 == 0) goto L_0x0014
            r1 = r6
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r1 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0014
            int r2 = r2 - r3
            r1.e = r2
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r1 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r1.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r1.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r1.e
            if (r1 == 0) goto L_0x003a
            r2 = 1
            if (r1 == r2) goto L_0x0035
            r0 = 2
            if (r1 != r0) goto L_0x002d
            kotlin.ResultKt.b(r6)
            kotlin.Unit r6 = kotlin.Unit.f696a
            return r6
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.b(r6)     // Catch:{ all -> 0x0039 }
            throw r0
        L_0x0039:
            throw r0
        L_0x003a:
            kotlin.ResultKt.b(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final Object emit(Object obj, Continuation continuation) {
        throw null;
    }
}
