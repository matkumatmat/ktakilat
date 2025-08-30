package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {514}, m = "count", n = {"count", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$count$1<E> extends ContinuationImpl {
    public Ref.IntRef c;
    public ReceiveChannel d;
    public ChannelIterator e;
    public /* synthetic */ Object f;
    public int g;

    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        int i = (this.g | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.g = i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ReceiveChannel receiveChannel = null;
        if (i == 0) {
            ResultKt.b(obj);
            new Ref.IntRef();
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else if (i == 1) {
            ChannelIterator channelIterator = this.e;
            ReceiveChannel receiveChannel2 = this.d;
            Ref.IntRef intRef = this.c;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    channelIterator.next();
                    intRef.element++;
                    this.c = intRef;
                    this.d = receiveChannel2;
                    this.e = channelIterator;
                    this.g = 1;
                    obj = channelIterator.a(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f696a;
                receiveChannel2.c((CancellationException) null);
                return new Integer(intRef.element);
            } catch (Throwable th2) {
                th = th2;
                receiveChannel = receiveChannel2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    ChannelsKt.a(receiveChannel, th);
                    throw th3;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
