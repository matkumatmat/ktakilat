package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {80, 84, 90, 92}, m = "fixedPeriodTicker", n = {"channel", "delayMillis", "deadline", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs"}, s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {
    public long c;
    public long d;
    public SendChannel e;
    public /* synthetic */ Object f;
    public int g;

    /* JADX WARNING: type inference failed for: r1v5, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d5, code lost:
        if (kotlinx.coroutines.DelayKt.b(r16 / 1000000, r1) != r3) goto L_0x0043;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r0.f = r1
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 | r2
            r0.g = r1
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0016
            int r1 = r1 - r2
            r0.g = r1
            r1 = r0
            goto L_0x001b
        L_0x0016:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r1 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r2 = r1.f
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r1.g
            r5 = 0
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            if (r4 == 0) goto L_0x005d
            if (r4 == r10) goto L_0x0053
            if (r4 == r9) goto L_0x0049
            if (r4 == r8) goto L_0x003a
            if (r4 != r7) goto L_0x0032
            goto L_0x003a
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            long r10 = r1.d
            long r12 = r1.c
            kotlinx.coroutines.channels.SendChannel r4 = r1.e
            kotlin.ResultKt.b(r2)
        L_0x0043:
            r20 = r10
            r10 = r12
            r12 = r20
            goto L_0x007f
        L_0x0049:
            long r10 = r1.d
            long r12 = r1.c
            kotlinx.coroutines.channels.SendChannel r4 = r1.e
            kotlin.ResultKt.b(r2)
            goto L_0x0096
        L_0x0053:
            long r10 = r1.d
            long r12 = r1.c
            kotlinx.coroutines.channels.SendChannel r4 = r1.e
            kotlin.ResultKt.b(r2)
            goto L_0x007b
        L_0x005d:
            kotlin.ResultKt.b(r2)
            long r11 = java.lang.System.nanoTime()
            long r13 = kotlinx.coroutines.EventLoop_commonKt.a(r5)
            long r11 = r11 + r13
            r4 = 0
            r1.e = r4
            r1.c = r5
            r1.d = r11
            r1.g = r10
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r5, r1)
            if (r2 != r3) goto L_0x0079
            goto L_0x00d7
        L_0x0079:
            r10 = r11
            r12 = r5
        L_0x007b:
            long r12 = kotlinx.coroutines.EventLoop_commonKt.a(r12)
        L_0x007f:
            long r10 = r10 + r12
            kotlin.Unit r2 = kotlin.Unit.f696a
            r1.e = r4
            r1.c = r10
            r1.d = r12
            r1.g = r9
            java.lang.Object r2 = r4.A(r2, r1)
            if (r2 != r3) goto L_0x0091
            goto L_0x00d7
        L_0x0091:
            r20 = r10
            r10 = r12
            r12 = r20
        L_0x0096:
            long r14 = java.lang.System.nanoTime()
            long r16 = r12 - r14
            int r2 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x00a2
            r16 = r5
        L_0x00a2:
            r18 = 1000000(0xf4240, double:4.940656E-318)
            int r2 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00c7
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x00c7
            long r12 = r14 - r12
            long r12 = r12 % r10
            long r12 = r10 - r12
            long r14 = r14 + r12
            long r12 = r12 / r18
            r1.e = r4
            r1.c = r14
            r1.d = r10
            r1.g = r8
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r12, r1)
            if (r2 != r3) goto L_0x00c4
            goto L_0x00d7
        L_0x00c4:
            r12 = r10
            r10 = r14
            goto L_0x007f
        L_0x00c7:
            long r14 = r16 / r18
            r1.e = r4
            r1.c = r12
            r1.d = r10
            r1.g = r7
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r14, r1)
            if (r2 != r3) goto L_0x0043
        L_0x00d7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
