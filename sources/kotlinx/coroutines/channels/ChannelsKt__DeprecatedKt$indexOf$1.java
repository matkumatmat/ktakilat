package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {514}, m = "indexOf", n = {"element", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2"})
final class ChannelsKt__DeprecatedKt$indexOf$1<E> extends ContinuationImpl {
    public Object c;
    public Ref.IntRef d;
    public ReceiveChannel e;
    public ChannelIterator f;
    public /* synthetic */ Object g;
    public int i;

    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        int i2 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ReceiveChannel receiveChannel = null;
        if (i2 == 0) {
            ResultKt.b(obj);
            new Ref.IntRef();
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else if (i2 == 1) {
            ChannelIterator channelIterator = this.f;
            ReceiveChannel receiveChannel2 = this.e;
            Ref.IntRef intRef = this.d;
            Object obj2 = this.c;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    if (Intrinsics.a(obj2, channelIterator.next())) {
                        Integer num = new Integer(intRef.element);
                        receiveChannel2.c((CancellationException) null);
                        return num;
                    }
                    intRef.element++;
                    this.c = obj2;
                    this.d = intRef;
                    this.e = receiveChannel2;
                    this.f = channelIterator;
                    this.i = 1;
                    obj = channelIterator.a(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f696a;
                receiveChannel2.c((CancellationException) null);
                return new Integer(-1);
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
