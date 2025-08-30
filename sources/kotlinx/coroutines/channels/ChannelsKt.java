package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class ChannelsKt {
    public static final void a(ReceiveChannel receiveChannel, Throwable th) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was consumed, consumer had failed");
            cancellationException.initCause(th);
        }
        receiveChannel.c(cancellationException);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlinx.coroutines.channels.ProducerScope, code=kotlinx.coroutines.channels.SendChannel, for r7v0, types: [kotlinx.coroutines.channels.ProducerScope] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a A[Catch:{ all -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(kotlinx.coroutines.channels.ReceiveChannel r6, kotlinx.coroutines.channels.SendChannel r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            kotlinx.coroutines.channels.ChannelIterator r6 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r7 = r0.d
            kotlinx.coroutines.channels.SendChannel r2 = r0.c
            kotlin.ResultKt.b(r8)     // Catch:{ all -> 0x0033 }
        L_0x002f:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L_0x004e
        L_0x0033:
            r6 = move-exception
            goto L_0x0089
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlinx.coroutines.channels.ChannelIterator r6 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r7 = r0.d
            kotlinx.coroutines.channels.SendChannel r2 = r0.c
            kotlin.ResultKt.b(r8)     // Catch:{ all -> 0x0033 }
            goto L_0x0062
        L_0x0047:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x0085 }
        L_0x004e:
            r0.c = r7     // Catch:{ all -> 0x0085 }
            r0.d = r6     // Catch:{ all -> 0x0085 }
            r0.e = r8     // Catch:{ all -> 0x0085 }
            r0.g = r4     // Catch:{ all -> 0x0085 }
            java.lang.Object r2 = r8.a(r0)     // Catch:{ all -> 0x0085 }
            if (r2 != r1) goto L_0x005d
            goto L_0x0084
        L_0x005d:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L_0x0062:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0033 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0033 }
            if (r8 == 0) goto L_0x007d
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0033 }
            r0.c = r2     // Catch:{ all -> 0x0033 }
            r0.d = r7     // Catch:{ all -> 0x0033 }
            r0.e = r6     // Catch:{ all -> 0x0033 }
            r0.g = r3     // Catch:{ all -> 0x0033 }
            java.lang.Object r8 = r2.A(r8, r0)     // Catch:{ all -> 0x0033 }
            if (r8 != r1) goto L_0x002f
            goto L_0x0084
        L_0x007d:
            kotlin.Unit r6 = kotlin.Unit.f696a     // Catch:{ all -> 0x0033 }
            r6 = 0
            r7.c(r6)
            r1 = r2
        L_0x0084:
            return r1
        L_0x0085:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0089:
            throw r6     // Catch:{ all -> 0x008a }
        L_0x008a:
            r8 = move-exception
            a(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.b(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ProducerScope, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final void c(SendChannel sendChannel, Object obj) {
        Object z = sendChannel.z(obj);
        if (!(z instanceof ChannelResult.Failed)) {
            Unit unit = (Unit) z;
            Unit unit2 = Unit.f696a;
            return;
        }
        Object obj2 = ((ChannelResult) BuildersKt.c(new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, obj, (Continuation) null))).f775a;
    }
}
