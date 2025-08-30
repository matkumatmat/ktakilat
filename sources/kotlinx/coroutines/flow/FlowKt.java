package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class FlowKt {
    public static final StateFlow a(MutableStateFlow mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, (Job) null);
    }

    public static final Flow b(Function2 function2) {
        return new CallbackFlowBuilder(function2, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.Serializable c(kotlin.coroutines.jvm.internal.ContinuationImpl r4, kotlinx.coroutines.flow.Flow r5, kotlinx.coroutines.flow.FlowCollector r6) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r4
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r4)
        L_0x0018:
            java.lang.Object r4 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.jvm.internal.Ref$ObjectRef r5 = r0.c
            kotlin.ResultKt.b(r4)     // Catch:{ all -> 0x0029 }
            goto L_0x004c
        L_0x0029:
            r4 = move-exception
            r1 = r4
            goto L_0x0051
        L_0x002c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0034:
            kotlin.ResultKt.b(r4)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2     // Catch:{ all -> 0x004e }
            r2.<init>(r6, r4)     // Catch:{ all -> 0x004e }
            r0.c = r4     // Catch:{ all -> 0x004e }
            r0.e = r3     // Catch:{ all -> 0x004e }
            java.lang.Object r4 = r5.collect(r2, r0)     // Catch:{ all -> 0x004e }
            if (r4 != r1) goto L_0x004c
            goto L_0x0082
        L_0x004c:
            r1 = 0
            goto L_0x0082
        L_0x004e:
            r5 = move-exception
            r1 = r5
            r5 = r4
        L_0x0051:
            T r4 = r5.element
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L_0x005d
            boolean r5 = r4.equals(r1)
            if (r5 != 0) goto L_0x007f
        L_0x005d:
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            kotlinx.coroutines.Job$Key r6 = kotlinx.coroutines.Job.Key.c
            kotlin.coroutines.CoroutineContext$Element r5 = r5.get(r6)
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            if (r5 == 0) goto L_0x0080
            boolean r6 = r5.isCancelled()
            if (r6 != 0) goto L_0x0072
            goto L_0x0080
        L_0x0072:
            java.util.concurrent.CancellationException r5 = r5.g()
            if (r5 == 0) goto L_0x0080
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            throw r1
        L_0x0080:
            if (r4 != 0) goto L_0x0083
        L_0x0082:
            return r1
        L_0x0083:
            boolean r5 = r1 instanceof java.util.concurrent.CancellationException
            if (r5 == 0) goto L_0x008b
            kotlin.ExceptionsKt.a(r4, r1)
            throw r4
        L_0x008b:
            kotlin.ExceptionsKt.a(r1, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.c(kotlin.coroutines.jvm.internal.ContinuationImpl, kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.FlowCollector):java.io.Serializable");
    }

    public static final Flow d(Function2 function2) {
        return new ChannelFlowBuilder(function2, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    public static final Object e(ContinuationImpl continuationImpl, Flow flow, FlowCollector flowCollector) {
        if (!(flowCollector instanceof ThrowingCollector)) {
            Object collect = flow.collect(flowCollector, continuationImpl);
            if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return collect;
            }
            return Unit.f696a;
        }
        throw ((ThrowingCollector) flowCollector).c;
    }

    public static final Object f(FlowCollector flowCollector, ReceiveChannel receiveChannel, Continuation continuation) {
        Object a2 = FlowKt__ChannelsKt.a(flowCollector, receiveChannel, true, continuation);
        if (a2 == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return a2;
        }
        return Unit.f696a;
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(kotlinx.coroutines.flow.Flow r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.f
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f791a
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1 r5 = r0.d
            kotlin.jvm.internal.Ref$ObjectRef r0 = r0.c
            kotlin.ResultKt.b(r6)     // Catch:{ AbortFlowException -> 0x002d }
            goto L_0x005d
        L_0x002d:
            r6 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.b(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r6.element = r3
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
            r2.<init>(r6)
            r0.c = r6     // Catch:{ AbortFlowException -> 0x0055 }
            r0.d = r2     // Catch:{ AbortFlowException -> 0x0055 }
            r0.f = r4     // Catch:{ AbortFlowException -> 0x0055 }
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch:{ AbortFlowException -> 0x0055 }
            if (r5 != r1) goto L_0x0053
            goto L_0x0061
        L_0x0053:
            r0 = r6
            goto L_0x005d
        L_0x0055:
            r5 = move-exception
            r0 = r6
            r6 = r5
            r5 = r2
        L_0x0059:
            java.lang.Object r1 = r6.owner
            if (r1 != r5) goto L_0x006a
        L_0x005d:
            T r1 = r0.element
            if (r1 == r3) goto L_0x0062
        L_0x0061:
            return r1
        L_0x0062:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element"
            r5.<init>(r6)
            throw r5
        L_0x006a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.g(kotlinx.coroutines.flow.Flow, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final Flow h(Function2 function2) {
        return new SafeFlow(function2);
    }
}
