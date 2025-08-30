package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,509:1\n160#2:510\n94#2,3:511\n161#2,2:514\n101#2:516\n97#2,3:517\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n*L\n498#1:510\n498#1:511,3\n498#1:514,2\n498#1:516\n498#1:517,3\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "V", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {514, 499, 501}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ChannelIterator c;
    public Function2 d;
    public ReceiveChannel e;
    public ChannelIterator f;
    public Object g;
    public int i;
    public /* synthetic */ Object j;

    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[Catch:{ all -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084 A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b9 A[Catch:{ all -> 0x0021 }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r12.i
            r2 = 0
            if (r1 == 0) goto L_0x00c8
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L_0x0045
            if (r1 == r4) goto L_0x002c
            if (r1 != r3) goto L_0x0024
            kotlinx.coroutines.channels.ChannelIterator r1 = r12.f
            kotlinx.coroutines.channels.ReceiveChannel r6 = r12.e
            kotlin.jvm.functions.Function2 r7 = r12.d
            kotlinx.coroutines.channels.ChannelIterator r8 = r12.c
            java.lang.Object r9 = r12.j
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.b(r13)     // Catch:{ all -> 0x0021 }
            goto L_0x00a5
        L_0x0021:
            r13 = move-exception
            goto L_0x00c2
        L_0x0024:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002c:
            java.lang.Object r1 = r12.g
            kotlinx.coroutines.channels.ChannelIterator r6 = r12.f
            kotlinx.coroutines.channels.ReceiveChannel r7 = r12.e
            kotlin.jvm.functions.Function2 r8 = r12.d
            kotlinx.coroutines.channels.ChannelIterator r9 = r12.c
            java.lang.Object r10 = r12.j
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            kotlin.ResultKt.b(r13)     // Catch:{ all -> 0x0041 }
            r11 = r6
            r6 = r1
            r1 = r11
            goto L_0x007c
        L_0x0041:
            r13 = move-exception
            r6 = r7
            goto L_0x00c2
        L_0x0045:
            kotlinx.coroutines.channels.ChannelIterator r1 = r12.f
            kotlinx.coroutines.channels.ReceiveChannel r6 = r12.e
            kotlin.jvm.functions.Function2 r7 = r12.d
            kotlinx.coroutines.channels.ChannelIterator r8 = r12.c
            java.lang.Object r9 = r12.j
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.b(r13)     // Catch:{ all -> 0x0021 }
        L_0x0054:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x0021 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0021 }
            if (r13 == 0) goto L_0x00ba
            java.lang.Object r13 = r1.next()     // Catch:{ all -> 0x0021 }
            r12.j = r9     // Catch:{ all -> 0x0021 }
            r12.c = r8     // Catch:{ all -> 0x0021 }
            r12.d = r7     // Catch:{ all -> 0x0021 }
            r12.e = r6     // Catch:{ all -> 0x0021 }
            r12.f = r1     // Catch:{ all -> 0x0021 }
            r12.g = r13     // Catch:{ all -> 0x0021 }
            r12.i = r4     // Catch:{ all -> 0x0021 }
            java.lang.Object r10 = r8.a(r12)     // Catch:{ all -> 0x0021 }
            if (r10 != r0) goto L_0x0075
            return r0
        L_0x0075:
            r11 = r6
            r6 = r13
            r13 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r11
        L_0x007c:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x0041 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0041 }
            if (r13 == 0) goto L_0x00a1
            java.lang.Object r13 = r9.next()     // Catch:{ all -> 0x0041 }
            java.lang.Object r13 = r8.invoke(r6, r13)     // Catch:{ all -> 0x0041 }
            r12.j = r10     // Catch:{ all -> 0x0041 }
            r12.c = r9     // Catch:{ all -> 0x0041 }
            r12.d = r8     // Catch:{ all -> 0x0041 }
            r12.e = r7     // Catch:{ all -> 0x0041 }
            r12.f = r1     // Catch:{ all -> 0x0041 }
            r12.g = r2     // Catch:{ all -> 0x0041 }
            r12.i = r3     // Catch:{ all -> 0x0041 }
            java.lang.Object r13 = r10.A(r13, r12)     // Catch:{ all -> 0x0041 }
            if (r13 != r0) goto L_0x00a1
            return r0
        L_0x00a1:
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
        L_0x00a5:
            r12.j = r9     // Catch:{ all -> 0x0021 }
            r12.c = r8     // Catch:{ all -> 0x0021 }
            r12.d = r7     // Catch:{ all -> 0x0021 }
            r12.e = r6     // Catch:{ all -> 0x0021 }
            r12.f = r1     // Catch:{ all -> 0x0021 }
            r12.g = r2     // Catch:{ all -> 0x0021 }
            r12.i = r5     // Catch:{ all -> 0x0021 }
            java.lang.Object r13 = r1.a(r12)     // Catch:{ all -> 0x0021 }
            if (r13 != r0) goto L_0x0054
            return r0
        L_0x00ba:
            kotlin.Unit r13 = kotlin.Unit.f696a     // Catch:{ all -> 0x0021 }
            r6.c(r2)
            kotlin.Unit r13 = kotlin.Unit.f696a
            return r13
        L_0x00c2:
            throw r13     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r6, r13)
            throw r0
        L_0x00c8:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = r12.j
            kotlinx.coroutines.channels.ProducerScope r13 = (kotlinx.coroutines.channels.ProducerScope) r13
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
