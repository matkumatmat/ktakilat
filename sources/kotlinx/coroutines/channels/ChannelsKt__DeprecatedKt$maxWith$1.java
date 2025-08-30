package kotlinx.coroutines.channels;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {450, 452}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "max"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
final class ChannelsKt__DeprecatedKt$maxWith$1<E> extends ContinuationImpl {
    public Comparator c;
    public ReceiveChannel d;
    public ChannelIterator e;
    public Object f;
    public /* synthetic */ Object g;
    public int i;

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072 A[Catch:{ all -> 0x0089 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            r10.g = r11
            int r0 = r10.i
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r10.i = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            r2 = 0
            if (r0 == 0) goto L_0x0094
            r3 = 1
            r4 = 2
            if (r0 == r3) goto L_0x0032
            if (r0 != r4) goto L_0x002a
            java.lang.Object r0 = r10.f
            kotlinx.coroutines.channels.ChannelIterator r3 = r10.e
            kotlinx.coroutines.channels.ReceiveChannel r5 = r10.d
            java.util.Comparator r6 = r10.c
            kotlin.ResultKt.b(r11)     // Catch:{ all -> 0x0026 }
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = r0
            r0 = r10
            goto L_0x006a
        L_0x0026:
            r11 = move-exception
            r2 = r5
            goto L_0x0099
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0032:
            kotlinx.coroutines.channels.ChannelIterator r0 = r10.e
            kotlinx.coroutines.channels.ReceiveChannel r3 = r10.d
            java.util.Comparator r5 = r10.c
            kotlin.ResultKt.b(r11)     // Catch:{ all -> 0x0091 }
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0091 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0091 }
            if (r11 != 0) goto L_0x0049
            r3.c(r2)
            r1 = r2
            goto L_0x0090
        L_0x0049:
            java.lang.Object r11 = r0.next()     // Catch:{ all -> 0x0091 }
            r6 = r5
            r5 = r3
            r3 = r0
            r0 = r11
            r11 = r10
        L_0x0052:
            r11.c = r6     // Catch:{ all -> 0x0026 }
            r11.d = r5     // Catch:{ all -> 0x0026 }
            r11.e = r3     // Catch:{ all -> 0x0026 }
            r11.f = r0     // Catch:{ all -> 0x0026 }
            r11.i = r4     // Catch:{ all -> 0x0026 }
            java.lang.Object r7 = r3.a(r11)     // Catch:{ all -> 0x0026 }
            if (r7 != r1) goto L_0x0063
            goto L_0x0090
        L_0x0063:
            r9 = r0
            r0 = r11
            r11 = r7
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = r9
        L_0x006a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0089 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0089 }
            if (r11 == 0) goto L_0x008c
            java.lang.Object r11 = r5.next()     // Catch:{ all -> 0x0089 }
            int r8 = r7.compare(r3, r11)     // Catch:{ all -> 0x0089 }
            if (r8 >= 0) goto L_0x0083
            r3 = r5
            r5 = r6
            r6 = r7
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x0052
        L_0x0083:
            r11 = r0
            r0 = r3
            r3 = r5
            r5 = r6
            r6 = r7
            goto L_0x0052
        L_0x0089:
            r11 = move-exception
            r2 = r6
            goto L_0x0099
        L_0x008c:
            r6.c(r2)
            r1 = r3
        L_0x0090:
            return r1
        L_0x0091:
            r11 = move-exception
            r2 = r3
            goto L_0x0099
        L_0x0094:
            kotlin.ResultKt.b(r11)
            throw r2     // Catch:{ all -> 0x0098 }
        L_0x0098:
            r11 = move-exception
        L_0x0099:
            throw r11     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r2, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
