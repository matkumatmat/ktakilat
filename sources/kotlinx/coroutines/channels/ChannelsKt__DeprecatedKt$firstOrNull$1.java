package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {105}, m = "firstOrNull", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$firstOrNull$1<E> extends ContinuationImpl {
    public /* synthetic */ Object c;
    public int d;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        kotlinx.coroutines.channels.ChannelsKt.a((kotlinx.coroutines.channels.ReceiveChannel) null, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            r3.c = r4
            int r1 = r3.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 | r2
            int r1 = r1 - r2
            r3.d = r1
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L_0x0029
            r2 = 1
            if (r1 != r2) goto L_0x0021
            kotlin.ResultKt.b(r4)     // Catch:{ all -> 0x001f }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x001f }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x001f }
            if (r4 != 0) goto L_0x001e
            throw r0
        L_0x001e:
            throw r0     // Catch:{ all -> 0x001f }
        L_0x001f:
            r4 = move-exception
            goto L_0x002d
        L_0x0021:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x0029:
            kotlin.ResultKt.b(r4)
            throw r0     // Catch:{ all -> 0x001f }
        L_0x002d:
            throw r4     // Catch:{ all -> 0x002e }
        L_0x002e:
            r1 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
