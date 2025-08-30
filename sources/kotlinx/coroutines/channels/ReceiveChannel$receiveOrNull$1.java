package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", i = {}, l = {380}, m = "receiveOrNull", n = {}, s = {})
final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {
    public /* synthetic */ Object c;
    public int d;

    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        int i = (this.d | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.d = i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.b(obj);
            this.d = 1;
            throw null;
        } else if (i == 1) {
            ResultKt.b(obj);
            Object obj2 = ((ChannelResult) obj).f775a;
            if (!(obj2 instanceof ChannelResult.Failed)) {
                return obj2;
            }
            return null;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
