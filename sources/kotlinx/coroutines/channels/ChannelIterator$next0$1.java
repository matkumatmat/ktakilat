package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {602}, m = "next", n = {"$this"}, s = {"L$0"})
final class ChannelIterator$next0$1<E> extends ContinuationImpl {
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
            if (((Boolean) obj).booleanValue()) {
                throw null;
            }
            throw new ClosedReceiveChannelException("Channel was closed");
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
