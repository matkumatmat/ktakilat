package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ChannelsKt {
    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0092, code lost:
        if (r8 != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        kotlinx.coroutines.channels.ChannelsKt.a(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0097, code lost:
        throw r9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[Catch:{ all -> 0x0091 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(kotlinx.coroutines.flow.FlowCollector r6, kotlinx.coroutines.channels.ReceiveChannel r7, boolean r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.i = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.g
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            boolean r8 = r0.f
            kotlinx.coroutines.channels.ChannelIterator r6 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r7 = r0.d
            kotlinx.coroutines.flow.FlowCollector r2 = r0.c
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x0034 }
        L_0x0031:
            r9 = r6
            r6 = r2
            goto L_0x0055
        L_0x0034:
            r6 = move-exception
            goto L_0x0090
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            boolean r8 = r0.f
            kotlinx.coroutines.channels.ChannelIterator r6 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r7 = r0.d
            kotlinx.coroutines.flow.FlowCollector r2 = r0.c
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x0034 }
            goto L_0x006a
        L_0x004a:
            kotlin.ResultKt.b(r9)
            boolean r9 = r6 instanceof kotlinx.coroutines.flow.ThrowingCollector
            if (r9 != 0) goto L_0x0098
            kotlinx.coroutines.channels.ChannelIterator r9 = r7.iterator()     // Catch:{ all -> 0x0034 }
        L_0x0055:
            r0.c = r6     // Catch:{ all -> 0x0034 }
            r0.d = r7     // Catch:{ all -> 0x0034 }
            r0.e = r9     // Catch:{ all -> 0x0034 }
            r0.f = r8     // Catch:{ all -> 0x0034 }
            r0.i = r4     // Catch:{ all -> 0x0034 }
            java.lang.Object r2 = r9.a(r0)     // Catch:{ all -> 0x0034 }
            if (r2 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L_0x006a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0034 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0034 }
            if (r9 == 0) goto L_0x0087
            java.lang.Object r9 = r6.next()     // Catch:{ all -> 0x0034 }
            r0.c = r2     // Catch:{ all -> 0x0034 }
            r0.d = r7     // Catch:{ all -> 0x0034 }
            r0.e = r6     // Catch:{ all -> 0x0034 }
            r0.f = r8     // Catch:{ all -> 0x0034 }
            r0.i = r3     // Catch:{ all -> 0x0034 }
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch:{ all -> 0x0034 }
            if (r9 != r1) goto L_0x0031
            return r1
        L_0x0087:
            if (r8 == 0) goto L_0x008d
            r6 = 0
            r7.c(r6)
        L_0x008d:
            kotlin.Unit r6 = kotlin.Unit.f696a
            return r6
        L_0x0090:
            throw r6     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r9 = move-exception
            if (r8 == 0) goto L_0x0097
            kotlinx.coroutines.channels.ChannelsKt.a(r7, r6)
        L_0x0097:
            throw r9
        L_0x0098:
            kotlinx.coroutines.flow.ThrowingCollector r6 = (kotlinx.coroutines.flow.ThrowingCollector) r6
            java.lang.Throwable r6 = r6.c
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.a(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
