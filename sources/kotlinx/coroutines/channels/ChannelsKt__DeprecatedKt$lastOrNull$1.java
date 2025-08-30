package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {153, 156}, m = "lastOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
final class ChannelsKt__DeprecatedKt$lastOrNull$1<E> extends ContinuationImpl {
    public ReceiveChannel c;
    public ChannelIterator d;
    public Object e;
    public /* synthetic */ Object f;
    public int g;

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068 A[Catch:{ all -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            r8.f = r9
            int r0 = r8.g
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r8.g = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            r2 = 0
            if (r0 == 0) goto L_0x007d
            r3 = 1
            r4 = 2
            if (r0 == r3) goto L_0x002f
            if (r0 != r4) goto L_0x0027
            java.lang.Object r0 = r8.e
            kotlinx.coroutines.channels.ChannelIterator r3 = r8.d
            kotlinx.coroutines.channels.ReceiveChannel r5 = r8.c
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x0023 }
            r6 = r5
            r5 = r3
            r3 = r0
            r0 = r8
            goto L_0x0060
        L_0x0023:
            r9 = move-exception
            r2 = r5
            goto L_0x0082
        L_0x0027:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x002f:
            kotlinx.coroutines.channels.ChannelIterator r0 = r8.d
            kotlinx.coroutines.channels.ReceiveChannel r3 = r8.c
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x007a }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x007a }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x007a }
            if (r9 != 0) goto L_0x0043
            r3.c(r2)
            r1 = r2
            goto L_0x0079
        L_0x0043:
            java.lang.Object r9 = r0.next()     // Catch:{ all -> 0x007a }
            r5 = r3
            r3 = r0
            r0 = r9
            r9 = r8
        L_0x004b:
            r9.c = r5     // Catch:{ all -> 0x0023 }
            r9.d = r3     // Catch:{ all -> 0x0023 }
            r9.e = r0     // Catch:{ all -> 0x0023 }
            r9.g = r4     // Catch:{ all -> 0x0023 }
            java.lang.Object r6 = r3.a(r9)     // Catch:{ all -> 0x0023 }
            if (r6 != r1) goto L_0x005a
            goto L_0x0079
        L_0x005a:
            r7 = r0
            r0 = r9
            r9 = r6
            r6 = r5
            r5 = r3
            r3 = r7
        L_0x0060:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0072 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0072 }
            if (r9 == 0) goto L_0x0075
            java.lang.Object r9 = r5.next()     // Catch:{ all -> 0x0072 }
            r3 = r5
            r5 = r6
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x004b
        L_0x0072:
            r9 = move-exception
            r2 = r6
            goto L_0x0082
        L_0x0075:
            r6.c(r2)
            r1 = r3
        L_0x0079:
            return r1
        L_0x007a:
            r9 = move-exception
            r2 = r3
            goto L_0x0082
        L_0x007d:
            kotlin.ResultKt.b(r9)
            throw r2     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r9 = move-exception
        L_0x0082:
            throw r9     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r2, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
