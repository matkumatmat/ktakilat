package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 1, 1, 2, 2}, l = {102, 104, 105}, m = "fixedDelayTicker", n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {
    public long c;
    public SendChannel d;
    public /* synthetic */ Object e;
    public int f;

    /* JADX WARNING: type inference failed for: r9v5, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r2.A(r0, r9) == r1) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        if (kotlinx.coroutines.DelayKt.b(r5, r9) == r1) goto L_0x0070;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            r8.e = r9
            int r9 = r8.f
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r9 | r0
            r8.f = r9
            r1 = r9 & r0
            if (r1 == 0) goto L_0x0012
            int r9 = r9 - r0
            r8.f = r9
            r9 = r8
            goto L_0x0017
        L_0x0012:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r9 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r9.<init>(r8)
        L_0x0017:
            java.lang.Object r0 = r9.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r9.f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x0039
            if (r2 == r4) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            goto L_0x0039
        L_0x0029:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0031:
            long r5 = r9.c
            kotlinx.coroutines.channels.SendChannel r2 = r9.d
            kotlin.ResultKt.b(r0)
            goto L_0x0064
        L_0x0039:
            long r5 = r9.c
            kotlinx.coroutines.channels.SendChannel r2 = r9.d
            kotlin.ResultKt.b(r0)
            goto L_0x0055
        L_0x0041:
            kotlin.ResultKt.b(r0)
            r2 = 0
            r9.d = r2
            r6 = 0
            r9.c = r6
            r9.f = r5
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.b(r6, r9)
            if (r0 != r1) goto L_0x0054
            goto L_0x0070
        L_0x0054:
            r5 = r6
        L_0x0055:
            kotlin.Unit r0 = kotlin.Unit.f696a
            r9.d = r2
            r9.c = r5
            r9.f = r4
            java.lang.Object r0 = r2.A(r0, r9)
            if (r0 != r1) goto L_0x0064
            goto L_0x0070
        L_0x0064:
            r9.d = r2
            r9.c = r5
            r9.f = r3
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.b(r5, r9)
            if (r0 != r1) goto L_0x0055
        L_0x0070:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
