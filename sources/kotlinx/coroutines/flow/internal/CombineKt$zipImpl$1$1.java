package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0, 0}, l = {123}, m = "invokeSuspend", n = {"second", "collectJob"}, s = {"L$0", "L$1"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public JobImpl c;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ FlowCollector f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$1$1(FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f = flowCollector;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.f, continuation);
        combineKt$zipImpl$1$1.e = obj;
        return combineKt$zipImpl$1$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$zipImpl$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: type inference failed for: r11v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r1.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0025
            if (r2 != r4) goto L_0x001d
            kotlinx.coroutines.JobImpl r2 = r1.c
            java.lang.Object r0 = r1.e
            r4 = r0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.b(r20)     // Catch:{ AbortFlowException -> 0x001a }
            goto L_0x0082
        L_0x0017:
            r0 = move-exception
            goto L_0x0098
        L_0x001a:
            r0 = move-exception
            goto L_0x008f
        L_0x001d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0025:
            kotlin.ResultKt.b(r20)
            java.lang.Object r2 = r1.e
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 r11 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1
            r5 = 2
            r11.<init>(r5, r3)
            kotlin.coroutines.EmptyCoroutineContext r6 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.channels.BufferOverflow r8 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlinx.coroutines.CoroutineStart r9 = kotlinx.coroutines.CoroutineStart.DEFAULT
            r10 = 0
            r7 = 0
            r5 = r2
            kotlinx.coroutines.channels.ReceiveChannel r5 = kotlinx.coroutines.channels.ProduceKt.b(r5, r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.JobImpl r6 = new kotlinx.coroutines.JobImpl
            r6.<init>(r3)
            r7 = r5
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1 r8 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1
            r8.<init>()
            r7.w(r8)
            kotlin.coroutines.CoroutineContext r13 = r2.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.b(r13)     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            kotlin.coroutines.CoroutineContext r2 = r2.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            kotlin.coroutines.CoroutineContext r2 = r2.plus(r6)     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            kotlin.Unit r7 = kotlin.Unit.f696a     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 r8 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            kotlinx.coroutines.flow.FlowCollector r9 = r1.f     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            r18 = 0
            r12 = r8
            r15 = r5
            r16 = r9
            r17 = r6
            r12.<init>(r14, r15, r16, r17, r18)     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            r1.e = r5     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            r1.c = r6     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            r1.d = r4     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.b(r2)     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            java.lang.Object r2 = kotlinx.coroutines.flow.internal.ChannelFlowKt.a(r2, r7, r4, r8, r1)     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008b }
            if (r2 != r0) goto L_0x0081
            return r0
        L_0x0081:
            r4 = r5
        L_0x0082:
            r4.c(r3)
            goto L_0x0094
        L_0x0086:
            r4 = r5
            goto L_0x0098
        L_0x0088:
            r4 = r5
            r2 = r6
            goto L_0x008f
        L_0x008b:
            r0 = move-exception
            goto L_0x0086
        L_0x008d:
            r0 = move-exception
            goto L_0x0088
        L_0x008f:
            java.lang.Object r5 = r0.owner     // Catch:{ all -> 0x0017 }
            if (r5 != r2) goto L_0x0097
            goto L_0x0082
        L_0x0094:
            kotlin.Unit r0 = kotlin.Unit.f696a
            return r0
        L_0x0097:
            throw r0     // Catch:{ all -> 0x0017 }
        L_0x0098:
            r4.c(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
