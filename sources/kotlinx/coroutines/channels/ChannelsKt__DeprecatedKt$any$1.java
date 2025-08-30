package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {434}, m = "any", n = {"$this$consume$iv"}, s = {"L$0"})
final class ChannelsKt__DeprecatedKt$any$1<E> extends ContinuationImpl {
    public /* synthetic */ Object c;
    public int d;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        kotlinx.coroutines.channels.ChannelsKt.a((kotlinx.coroutines.channels.ReceiveChannel) null, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            r3.c = r4
            int r0 = r3.d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r3.d = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            r1 = 0
            if (r0 == 0) goto L_0x0020
            r2 = 1
            if (r0 != r2) goto L_0x0018
            kotlin.ResultKt.b(r4)     // Catch:{ all -> 0x0016 }
            throw r1
        L_0x0016:
            r4 = move-exception
            goto L_0x0024
        L_0x0018:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x0020:
            kotlin.ResultKt.b(r4)
            throw r1     // Catch:{ all -> 0x0016 }
        L_0x0024:
            throw r4     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
