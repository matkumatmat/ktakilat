package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {41}, m = "consumeEach", n = {"action", "channel$iv"}, s = {"L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$consumeEach$1<E> extends ContinuationImpl {
    public Function1 c;
    public ReceiveChannel d;
    public ChannelIterator e;
    public /* synthetic */ Object f;
    public int g;

    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        int i = (this.g | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.g = i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.b(obj);
            throw null;
        } else if (i == 1) {
            ChannelIterator channelIterator = this.e;
            ReceiveChannel receiveChannel = this.d;
            Function1 function1 = this.c;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    function1.invoke(channelIterator.next());
                    this.c = function1;
                    this.d = receiveChannel;
                    this.e = channelIterator;
                    this.g = 1;
                    obj = channelIterator.a(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f696a;
                receiveChannel.c((CancellationException) null);
                return Unit.f696a;
            } catch (Throwable th) {
                receiveChannel.c((CancellationException) null);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
