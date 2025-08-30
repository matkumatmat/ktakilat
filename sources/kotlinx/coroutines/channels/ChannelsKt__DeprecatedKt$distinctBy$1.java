package kotlinx.coroutines.channels;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {417, 418, 420}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public HashSet c;
    public ChannelIterator d;
    public Object e;
    public int f;
    public /* synthetic */ Object g;

    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.f
            r2 = 0
            if (r1 == 0) goto L_0x008b
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L_0x0065
            r5 = 3
            if (r1 == r3) goto L_0x0027
            if (r1 != r5) goto L_0x001f
            java.lang.Object r1 = r10.e
            kotlinx.coroutines.channels.ChannelIterator r5 = r10.d
            java.util.HashSet r6 = r10.c
            java.lang.Object r7 = r10.g
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r11)
            r11 = r1
            goto L_0x004e
        L_0x001f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0027:
            java.lang.Object r1 = r10.e
            kotlinx.coroutines.channels.ChannelIterator r6 = r10.d
            java.util.HashSet r7 = r10.c
            java.lang.Object r8 = r10.g
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r11)
            boolean r9 = r7.contains(r11)
            if (r9 != 0) goto L_0x0054
            r10.g = r8
            r10.c = r7
            r10.d = r6
            r10.e = r11
            r10.f = r5
            java.lang.Object r1 = r8.A(r1, r10)
            if (r1 != r0) goto L_0x004b
            return r0
        L_0x004b:
            r5 = r6
            r6 = r7
            r7 = r8
        L_0x004e:
            r6.add(r11)
            r8 = r7
            r7 = r6
            r6 = r5
        L_0x0054:
            r10.g = r8
            r10.c = r7
            r10.d = r6
            r10.e = r2
            r10.f = r4
            java.lang.Object r11 = r6.a(r10)
            if (r11 != r0) goto L_0x0071
            return r0
        L_0x0065:
            kotlinx.coroutines.channels.ChannelIterator r6 = r10.d
            java.util.HashSet r7 = r10.c
            java.lang.Object r0 = r10.g
            r8 = r0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r11)
        L_0x0071:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x007c
            kotlin.Unit r11 = kotlin.Unit.f696a
            return r11
        L_0x007c:
            java.lang.Object r11 = r6.next()
            r10.g = r8
            r10.c = r7
            r10.d = r6
            r10.e = r11
            r10.f = r3
            throw r2
        L_0x008b:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.g
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
