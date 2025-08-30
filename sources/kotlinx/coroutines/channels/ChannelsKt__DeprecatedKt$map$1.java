package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,509:1\n160#2:510\n94#2,3:511\n161#2,2:514\n101#2:516\n97#2,3:517\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n*L\n362#1:510\n362#1:511,3\n362#1:514,2\n362#1:516\n362#1:517,3\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {514, 363, 363}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public Function2 c;
    public ReceiveChannel d;
    public ChannelIterator e;
    public ProducerScope f;
    public int g;
    public /* synthetic */ Object i;

    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$map$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095 A[Catch:{ all -> 0x001f }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.g
            r2 = 0
            if (r1 == 0) goto L_0x00a4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L_0x003d
            if (r1 == r4) goto L_0x002a
            if (r1 != r3) goto L_0x0022
            kotlinx.coroutines.channels.ChannelIterator r1 = r10.e
            kotlinx.coroutines.channels.ReceiveChannel r6 = r10.d
            kotlin.jvm.functions.Function2 r7 = r10.c
            java.lang.Object r8 = r10.i
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r11)     // Catch:{ all -> 0x001f }
            goto L_0x0085
        L_0x001f:
            r11 = move-exception
            goto L_0x009e
        L_0x0022:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002a:
            kotlinx.coroutines.channels.ProducerScope r1 = r10.f
            kotlinx.coroutines.channels.ChannelIterator r6 = r10.e
            kotlinx.coroutines.channels.ReceiveChannel r7 = r10.d
            kotlin.jvm.functions.Function2 r8 = r10.c
            java.lang.Object r9 = r10.i
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.b(r11)     // Catch:{ all -> 0x003a }
            goto L_0x006e
        L_0x003a:
            r11 = move-exception
            r6 = r7
            goto L_0x009e
        L_0x003d:
            kotlinx.coroutines.channels.ChannelIterator r1 = r10.e
            kotlinx.coroutines.channels.ReceiveChannel r6 = r10.d
            kotlin.jvm.functions.Function2 r7 = r10.c
            java.lang.Object r8 = r10.i
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r11)     // Catch:{ all -> 0x001f }
        L_0x004a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x001f }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x001f }
            if (r11 == 0) goto L_0x0096
            java.lang.Object r11 = r1.next()     // Catch:{ all -> 0x001f }
            r10.i = r8     // Catch:{ all -> 0x001f }
            r10.c = r7     // Catch:{ all -> 0x001f }
            r10.d = r6     // Catch:{ all -> 0x001f }
            r10.e = r1     // Catch:{ all -> 0x001f }
            r10.f = r8     // Catch:{ all -> 0x001f }
            r10.g = r4     // Catch:{ all -> 0x001f }
            java.lang.Object r11 = r7.invoke(r11, r10)     // Catch:{ all -> 0x001f }
            if (r11 != r0) goto L_0x0069
            return r0
        L_0x0069:
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x006e:
            r10.i = r9     // Catch:{ all -> 0x003a }
            r10.c = r8     // Catch:{ all -> 0x003a }
            r10.d = r7     // Catch:{ all -> 0x003a }
            r10.e = r6     // Catch:{ all -> 0x003a }
            r10.f = r2     // Catch:{ all -> 0x003a }
            r10.g = r3     // Catch:{ all -> 0x003a }
            java.lang.Object r11 = r1.A(r11, r10)     // Catch:{ all -> 0x003a }
            if (r11 != r0) goto L_0x0081
            return r0
        L_0x0081:
            r1 = r6
            r6 = r7
            r7 = r8
            r8 = r9
        L_0x0085:
            r10.i = r8     // Catch:{ all -> 0x001f }
            r10.c = r7     // Catch:{ all -> 0x001f }
            r10.d = r6     // Catch:{ all -> 0x001f }
            r10.e = r1     // Catch:{ all -> 0x001f }
            r10.g = r5     // Catch:{ all -> 0x001f }
            java.lang.Object r11 = r1.a(r10)     // Catch:{ all -> 0x001f }
            if (r11 != r0) goto L_0x004a
            return r0
        L_0x0096:
            kotlin.Unit r11 = kotlin.Unit.f696a     // Catch:{ all -> 0x001f }
            r6.c(r2)
            kotlin.Unit r11 = kotlin.Unit.f696a
            return r11
        L_0x009e:
            throw r11     // Catch:{ all -> 0x009f }
        L_0x009f:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r6, r11)
            throw r0
        L_0x00a4:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.i
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
