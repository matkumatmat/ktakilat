package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {514, 272}, m = "filterNotNullTo", n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends SendChannel<? super E>> extends ContinuationImpl {
    public SendChannel c;
    public ReceiveChannel d;
    public ChannelIterator e;
    public /* synthetic */ Object f;
    public int g;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d A[Catch:{ all -> 0x0020 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A[Catch:{ all -> 0x0020 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061 A[Catch:{ all -> 0x0020 }] */
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
            if (r0 == 0) goto L_0x0068
            r3 = 2
            r4 = 1
            if (r0 == r4) goto L_0x002b
            if (r0 != r3) goto L_0x0023
            kotlinx.coroutines.channels.ChannelIterator r0 = r8.e
            kotlinx.coroutines.channels.ReceiveChannel r5 = r8.d
            kotlinx.coroutines.channels.SendChannel r6 = r8.c
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x0020 }
            r7 = r8
            goto L_0x0052
        L_0x0020:
            r9 = move-exception
            r2 = r5
            goto L_0x006d
        L_0x0023:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x002b:
            kotlinx.coroutines.channels.ChannelIterator r0 = r8.e
            kotlinx.coroutines.channels.ReceiveChannel r5 = r8.d
            kotlinx.coroutines.channels.SendChannel r6 = r8.c
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x0020 }
            r7 = r8
        L_0x0035:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0020 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0020 }
            if (r9 == 0) goto L_0x0061
            java.lang.Object r9 = r0.next()     // Catch:{ all -> 0x0020 }
            if (r9 == 0) goto L_0x0052
            r7.c = r6     // Catch:{ all -> 0x0020 }
            r7.d = r5     // Catch:{ all -> 0x0020 }
            r7.e = r0     // Catch:{ all -> 0x0020 }
            r7.g = r3     // Catch:{ all -> 0x0020 }
            java.lang.Object r9 = r6.A(r9, r7)     // Catch:{ all -> 0x0020 }
            if (r9 != r1) goto L_0x0052
            goto L_0x0067
        L_0x0052:
            r7.c = r6     // Catch:{ all -> 0x0020 }
            r7.d = r5     // Catch:{ all -> 0x0020 }
            r7.e = r0     // Catch:{ all -> 0x0020 }
            r7.g = r4     // Catch:{ all -> 0x0020 }
            java.lang.Object r9 = r0.a(r7)     // Catch:{ all -> 0x0020 }
            if (r9 != r1) goto L_0x0035
            goto L_0x0067
        L_0x0061:
            kotlin.Unit r9 = kotlin.Unit.f696a     // Catch:{ all -> 0x0020 }
            r5.c(r2)
            r1 = r6
        L_0x0067:
            return r1
        L_0x0068:
            kotlin.ResultKt.b(r9)
            throw r2     // Catch:{ all -> 0x006c }
        L_0x006c:
            r9 = move-exception
        L_0x006d:
            throw r9     // Catch:{ all -> 0x006e }
        L_0x006e:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r2, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
