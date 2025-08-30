package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {351, 352, 352}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Function2 {
    public ChannelIterator c;
    public int d;
    public /* synthetic */ Object e;

    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.d;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    channelIterator = this.c;
                    ProducerScope producerScope2 = (ProducerScope) this.e;
                    ResultKt.b(obj);
                    this.e = producerScope2;
                    this.c = channelIterator;
                    this.d = 3;
                    if (ChannelsKt.b((ReceiveChannel) obj, producerScope2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    producerScope = producerScope2;
                } else if (i == 3) {
                    channelIterator = this.c;
                    producerScope = (ProducerScope) this.e;
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.e = producerScope;
                this.c = channelIterator;
                this.d = 1;
                obj = channelIterator.a(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                channelIterator = this.c;
                producerScope = (ProducerScope) this.e;
                ResultKt.b(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                return Unit.f696a;
            }
            channelIterator.next();
            this.e = producerScope;
            this.c = channelIterator;
            this.d = 2;
            throw null;
        }
        ResultKt.b(obj);
        ProducerScope producerScope3 = (ProducerScope) this.e;
        throw null;
    }
}
