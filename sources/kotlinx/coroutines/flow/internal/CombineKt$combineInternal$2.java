package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {51, 73, 76}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Channel c;
    public byte[] d;
    public int e;
    public int f;
    public int g;
    public /* synthetic */ Object i;
    public final /* synthetic */ Flow[] j;
    public final /* synthetic */ Function0 k;
    public final /* synthetic */ SuspendLambda l;
    public final /* synthetic */ FlowCollector m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(Continuation continuation, Function0 function0, Function3 function3, FlowCollector flowCollector, Flow[] flowArr) {
        super(2, continuation);
        this.j = flowArr;
        this.k = function0;
        this.l = (SuspendLambda) function3;
        this.m = flowCollector;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    public final Continuation create(Object obj, Continuation continuation) {
        ? r3 = this.l;
        Continuation continuation2 = continuation;
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(continuation2, this.k, r3, this.m, this.j);
        combineKt$combineInternal$2.i = obj;
        return combineKt$combineInternal$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineInternal$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: kotlinx.coroutines.channels.BufferedChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: kotlin.collections.IndexedValue} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: kotlinx.coroutines.channels.BufferedChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: kotlinx.coroutines.channels.BufferedChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: kotlinx.coroutines.channels.BufferedChannel} */
    /* JADX WARNING: type inference failed for: r13v6, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c0 A[LOOP:1: B:28:0x00c0->B:37:0x00e0, LOOP_START, PHI: r9 r13 
      PHI: (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:25:0x00bb, B:37:0x00e0] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v3 kotlin.collections.IndexedValue) = (r13v2 kotlin.collections.IndexedValue), (r13v10 kotlin.collections.IndexedValue) binds: [B:25:0x00bb, B:37:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.flow.internal.NullSurrogateKt.b
            r4 = 1
            r5 = 3
            r6 = 0
            r7 = 0
            r8 = 2
            if (r2 == 0) goto L_0x005e
            if (r2 == r4) goto L_0x0045
            if (r2 == r8) goto L_0x0032
            if (r2 != r5) goto L_0x002a
            int r2 = r0.f
            int r9 = r0.e
            byte[] r10 = r0.d
            kotlinx.coroutines.channels.Channel r11 = r0.c
            java.lang.Object r12 = r0.i
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            kotlin.ResultKt.b(r21)
            r6 = r2
            r2 = r10
            r10 = r12
            r4 = 0
            goto L_0x011d
        L_0x002a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0032:
            int r2 = r0.f
            int r9 = r0.e
            byte[] r10 = r0.d
            kotlinx.coroutines.channels.Channel r11 = r0.c
            java.lang.Object r12 = r0.i
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            kotlin.ResultKt.b(r21)
            r6 = r2
            r2 = r10
            r10 = r12
            goto L_0x009e
        L_0x0045:
            int r2 = r0.f
            int r9 = r0.e
            byte[] r10 = r0.d
            kotlinx.coroutines.channels.Channel r11 = r0.c
            java.lang.Object r12 = r0.i
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            kotlin.ResultKt.b(r21)
            r13 = r21
            kotlinx.coroutines.channels.ChannelResult r13 = (kotlinx.coroutines.channels.ChannelResult) r13
            java.lang.Object r13 = r13.f775a
            r6 = r2
            r2 = r10
            r10 = r12
            goto L_0x00b3
        L_0x005e:
            kotlin.ResultKt.b(r21)
            java.lang.Object r2 = r0.i
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlinx.coroutines.flow.Flow[] r9 = r0.j
            int r9 = r9.length
            if (r9 != 0) goto L_0x006d
            kotlin.Unit r1 = kotlin.Unit.f696a
            return r1
        L_0x006d:
            java.lang.Object[] r10 = new java.lang.Object[r9]
            kotlin.collections.ArraysKt.m(r10, r3, r6, r9)
            r11 = 6
            kotlinx.coroutines.channels.BufferedChannel r11 = kotlinx.coroutines.channels.ChannelKt.a(r9, r7, r11)
            java.util.concurrent.atomic.AtomicInteger r15 = new java.util.concurrent.atomic.AtomicInteger
            r15.<init>(r9)
            r14 = 0
        L_0x007d:
            if (r14 >= r9) goto L_0x009b
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 r13 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1
            kotlinx.coroutines.flow.Flow[] r12 = r0.j
            r17 = 0
            r16 = r12
            r12 = r13
            r6 = r13
            r13 = r16
            r18 = r14
            r19 = r15
            r16 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            kotlinx.coroutines.BuildersKt.b(r2, r7, r7, r6, r5)
            int r14 = r18 + 1
            r6 = 0
            goto L_0x007d
        L_0x009b:
            byte[] r2 = new byte[r9]
            r6 = 0
        L_0x009e:
            int r6 = r6 + r4
            byte r6 = (byte) r6
            r0.i = r10
            r0.c = r11
            r0.d = r2
            r0.e = r9
            r0.f = r6
            r0.g = r4
            java.lang.Object r13 = r11.t(r0)
            if (r13 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            boolean r12 = r13 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
            if (r12 != 0) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r13 = r7
        L_0x00b9:
            kotlin.collections.IndexedValue r13 = (kotlin.collections.IndexedValue) r13
            if (r13 != 0) goto L_0x00c0
            kotlin.Unit r1 = kotlin.Unit.f696a
            return r1
        L_0x00c0:
            int r12 = r13.f700a
            r14 = r10[r12]
            java.lang.Object r13 = r13.b
            r10[r12] = r13
            if (r14 != r3) goto L_0x00cc
            int r9 = r9 + -1
        L_0x00cc:
            byte r13 = r2[r12]
            if (r13 == r6) goto L_0x00e2
            byte r13 = (byte) r6
            r2[r12] = r13
            java.lang.Object r12 = r11.h()
            boolean r13 = r12 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
            if (r13 != 0) goto L_0x00dc
            goto L_0x00dd
        L_0x00dc:
            r12 = r7
        L_0x00dd:
            r13 = r12
            kotlin.collections.IndexedValue r13 = (kotlin.collections.IndexedValue) r13
            if (r13 != 0) goto L_0x00c0
        L_0x00e2:
            if (r9 != 0) goto L_0x009e
            kotlin.jvm.functions.Function0 r12 = r0.k
            java.lang.Object r12 = r12.invoke()
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            kotlin.coroutines.jvm.internal.SuspendLambda r13 = r0.l
            kotlinx.coroutines.flow.FlowCollector r14 = r0.m
            if (r12 != 0) goto L_0x0105
            r0.i = r10
            r0.c = r11
            r0.d = r2
            r0.e = r9
            r0.f = r6
            r0.g = r8
            java.lang.Object r12 = r13.invoke(r14, r10, r0)
            if (r12 != r1) goto L_0x009e
            return r1
        L_0x0105:
            int r15 = r10.length
            r4 = 0
            kotlin.collections.ArraysKt.j(r10, r4, r12, r4, r15)
            r0.i = r10
            r0.c = r11
            r0.d = r2
            r0.e = r9
            r0.f = r6
            r0.g = r5
            java.lang.Object r12 = r13.invoke(r14, r12, r0)
            if (r12 != r1) goto L_0x011d
            return r1
        L_0x011d:
            r4 = 1
            goto L_0x009e
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
