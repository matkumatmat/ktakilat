package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {179, 182}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$singleOrNull$1<E> extends ContinuationImpl {
    public ReceiveChannel c;
    public Object d;
    public /* synthetic */ Object e;
    public int f;

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            r5.e = r6
            int r0 = r5.f
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r5.f = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            r2 = 0
            if (r0 == 0) goto L_0x0063
            r3 = 1
            r4 = 2
            if (r0 == r3) goto L_0x002a
            if (r0 != r4) goto L_0x0022
            java.lang.Object r0 = r5.d
            kotlinx.coroutines.channels.ReceiveChannel r1 = r5.c
            kotlin.ResultKt.b(r6)     // Catch:{ all -> 0x001f }
            r3 = r1
            r1 = r0
            goto L_0x0053
        L_0x001f:
            r6 = move-exception
            r2 = r1
            goto L_0x0068
        L_0x0022:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x002a:
            java.lang.Object r0 = r5.d
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            kotlinx.coroutines.channels.ReceiveChannel r3 = r5.c
            kotlin.ResultKt.b(r6)     // Catch:{ all -> 0x0060 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0060 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0060 }
            if (r6 != 0) goto L_0x0040
        L_0x003b:
            r3.c(r2)
            r1 = r2
            goto L_0x005f
        L_0x0040:
            java.lang.Object r6 = r0.next()     // Catch:{ all -> 0x0060 }
            r5.c = r3     // Catch:{ all -> 0x0060 }
            r5.d = r6     // Catch:{ all -> 0x0060 }
            r5.f = r4     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.a(r5)     // Catch:{ all -> 0x0060 }
            if (r0 != r1) goto L_0x0051
            goto L_0x005f
        L_0x0051:
            r1 = r6
            r6 = r0
        L_0x0053:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0060 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x005c
            goto L_0x003b
        L_0x005c:
            r3.c(r2)
        L_0x005f:
            return r1
        L_0x0060:
            r6 = move-exception
            r2 = r3
            goto L_0x0068
        L_0x0063:
            kotlin.ResultKt.b(r6)
            throw r2     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r6 = move-exception
        L_0x0068:
            throw r6     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
