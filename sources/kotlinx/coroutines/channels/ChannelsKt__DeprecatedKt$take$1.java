package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$take$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,509:1\n1#2:510\n*E\n"})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {284, 285}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2 {
    public ChannelIterator c;
    public int d;
    public int e;
    public /* synthetic */ Object f;

    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$take$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.e
            if (r1 == 0) goto L_0x005f
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            int r1 = r6.d
            kotlinx.coroutines.channels.ChannelIterator r4 = r6.c
            java.lang.Object r5 = r6.f
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r7)
            goto L_0x0046
        L_0x0018:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0020:
            int r1 = r6.d
            kotlinx.coroutines.channels.ChannelIterator r4 = r6.c
            java.lang.Object r5 = r6.f
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r7)
        L_0x002b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x005c
            java.lang.Object r7 = r4.next()
            r6.f = r5
            r6.c = r4
            r6.d = r1
            r6.e = r2
            java.lang.Object r7 = r5.A(r7, r6)
            if (r7 != r0) goto L_0x0046
            return r0
        L_0x0046:
            int r1 = r1 + -1
            if (r1 != 0) goto L_0x004d
            kotlin.Unit r7 = kotlin.Unit.f696a
            return r7
        L_0x004d:
            r6.f = r5
            r6.c = r4
            r6.d = r1
            r6.e = r3
            java.lang.Object r7 = r4.a(r6)
            if (r7 != r0) goto L_0x002b
            return r0
        L_0x005c:
            kotlin.Unit r7 = kotlin.Unit.f696a
            return r7
        L_0x005f:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
