package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {241, 242, 242}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2 {
    public ChannelIterator c;
    public Object d;
    public int e;
    public int f;
    public /* synthetic */ Object g;

    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r9.f
            r2 = 0
            if (r1 == 0) goto L_0x008c
            r3 = 1
            r4 = 2
            if (r1 == r3) goto L_0x005f
            r5 = 3
            if (r1 == r4) goto L_0x0024
            if (r1 != r5) goto L_0x001c
            int r1 = r9.e
            kotlinx.coroutines.channels.ChannelIterator r5 = r9.c
            java.lang.Object r6 = r9.g
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.b(r10)
            goto L_0x004c
        L_0x001c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0024:
            int r1 = r9.e
            java.lang.Object r6 = r9.d
            kotlinx.coroutines.channels.ChannelIterator r7 = r9.c
            java.lang.Object r8 = r9.g
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x004e
            r9.g = r8
            r9.c = r7
            r9.d = r2
            r9.e = r1
            r9.f = r5
            java.lang.Object r10 = r8.A(r6, r9)
            if (r10 != r0) goto L_0x004a
            return r0
        L_0x004a:
            r5 = r7
            r6 = r8
        L_0x004c:
            r7 = r5
            r8 = r6
        L_0x004e:
            r9.g = r8
            r9.c = r7
            r9.d = r2
            r9.e = r1
            r9.f = r3
            java.lang.Object r10 = r7.a(r9)
            if (r10 != r0) goto L_0x006b
            return r0
        L_0x005f:
            int r1 = r9.e
            kotlinx.coroutines.channels.ChannelIterator r7 = r9.c
            java.lang.Object r0 = r9.g
            r8 = r0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r10)
        L_0x006b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x0076
            kotlin.Unit r10 = kotlin.Unit.f696a
            return r10
        L_0x0076:
            java.lang.Object r10 = r7.next()
            int r0 = r1 + 1
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r1)
            r9.g = r8
            r9.c = r7
            r9.d = r10
            r9.e = r0
            r9.f = r4
            throw r2
        L_0x008c:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.g
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
