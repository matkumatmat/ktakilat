package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ ChannelFlowTransformLatest e;
    public final /* synthetic */ FlowCollector f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.e = channelFlowTransformLatest;
        this.f = flowCollector;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.e, this.f, continuation);
        channelFlowTransformLatest$flowCollect$3.d = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            ResultKt.b(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.d;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final ChannelFlowTransformLatest channelFlowTransformLatest = this.e;
            Flow flow = channelFlowTransformLatest.f;
            final FlowCollector flowCollector = this.f;
            AnonymousClass1 r5 = new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(final java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r9
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                        int r1 = r0.i
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.i = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                        r0.<init>(r7, r9)
                    L_0x0018:
                        java.lang.Object r9 = r0.f
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.i
                        r3 = 1
                        if (r2 == 0) goto L_0x0035
                        if (r2 != r3) goto L_0x002d
                        java.lang.Object r8 = r0.d
                        java.lang.Object r0 = r0.c
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r0
                        kotlin.ResultKt.b(r9)
                        goto L_0x0058
                    L_0x002d:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L_0x0035:
                        kotlin.ResultKt.b(r9)
                        kotlin.jvm.internal.Ref$ObjectRef r9 = kotlin.jvm.internal.Ref.ObjectRef.this
                        T r9 = r9.element
                        kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
                        if (r9 == 0) goto L_0x0057
                        kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                        r2.<init>()
                        r9.c(r2)
                        r0.c = r7
                        r0.d = r8
                        r0.e = r9
                        r0.i = r3
                        java.lang.Object r9 = r9.e(r0)
                        if (r9 != r1) goto L_0x0057
                        return r1
                    L_0x0057:
                        r0 = r7
                    L_0x0058:
                        kotlin.jvm.internal.Ref$ObjectRef r9 = kotlin.jvm.internal.Ref.ObjectRef.this
                        kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r2 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                        kotlinx.coroutines.flow.FlowCollector r4 = r6
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest r5 = r3
                        r6 = 0
                        r2.<init>(r4, r8, r6)
                        kotlinx.coroutines.CoroutineScope r8 = r8
                        kotlinx.coroutines.Job r8 = kotlinx.coroutines.BuildersKt.b(r8, r6, r1, r2, r3)
                        r9.element = r8
                        kotlin.Unit r8 = kotlin.Unit.f696a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.c = 1;
            if (flow.collect(r5, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f696a;
    }
}
