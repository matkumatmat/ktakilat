package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {228, 229, 229}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ChannelIterator c;
    public Object d;
    public int e;
    public /* synthetic */ Object f;

    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.e
            r2 = 0
            if (r1 == 0) goto L_0x0079
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L_0x0057
            r5 = 3
            if (r1 == r3) goto L_0x0022
            if (r1 != r5) goto L_0x001a
            kotlinx.coroutines.channels.ChannelIterator r1 = r8.c
            java.lang.Object r5 = r8.f
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r9)
            goto L_0x0046
        L_0x001a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0022:
            java.lang.Object r1 = r8.d
            kotlinx.coroutines.channels.ChannelIterator r6 = r8.c
            java.lang.Object r7 = r8.f
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0048
            r8.f = r7
            r8.c = r6
            r8.d = r2
            r8.e = r5
            java.lang.Object r9 = r7.A(r1, r8)
            if (r9 != r0) goto L_0x0044
            return r0
        L_0x0044:
            r1 = r6
            r5 = r7
        L_0x0046:
            r6 = r1
            r7 = r5
        L_0x0048:
            r8.f = r7
            r8.c = r6
            r8.d = r2
            r8.e = r4
            java.lang.Object r9 = r6.a(r8)
            if (r9 != r0) goto L_0x0061
            return r0
        L_0x0057:
            kotlinx.coroutines.channels.ChannelIterator r6 = r8.c
            java.lang.Object r0 = r8.f
            r7 = r0
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r9)
        L_0x0061:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x006c
            kotlin.Unit r9 = kotlin.Unit.f696a
            return r9
        L_0x006c:
            java.lang.Object r9 = r6.next()
            r8.f = r7
            r8.c = r6
            r8.d = r9
            r8.e = r3
            throw r2
        L_0x0079:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
