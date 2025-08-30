package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {299, 300, 301}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements Function2 {
    public ChannelIterator c;
    public Object d;
    public int e;
    public /* synthetic */ Object f;

    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.e;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    Object obj2 = this.d;
                    ChannelIterator channelIterator2 = this.c;
                    ProducerScope producerScope2 = (ProducerScope) this.f;
                    ResultKt.b(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        return Unit.f696a;
                    }
                    this.f = producerScope2;
                    this.c = channelIterator2;
                    this.d = null;
                    this.e = 3;
                    if (producerScope2.A(obj2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    channelIterator = channelIterator2;
                    producerScope = producerScope2;
                } else if (i == 3) {
                    channelIterator = this.c;
                    producerScope = (ProducerScope) this.f;
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.f = producerScope;
                this.c = channelIterator;
                this.e = 1;
                obj = channelIterator.a(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                channelIterator = this.c;
                producerScope = (ProducerScope) this.f;
                ResultKt.b(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                return Unit.f696a;
            }
            Object next = channelIterator.next();
            this.f = producerScope;
            this.c = channelIterator;
            this.d = next;
            this.e = 2;
            throw null;
        }
        ResultKt.b(obj);
        ProducerScope producerScope3 = (ProducerScope) this.f;
        throw null;
    }
}
