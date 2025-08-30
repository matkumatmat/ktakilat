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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {514}, m = "lastIndexOf", n = {"element", "lastIndex", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class ChannelsKt__DeprecatedKt$lastIndexOf$1<E> extends ContinuationImpl {
    public Object c;
    public Ref.IntRef d;
    public Ref.IntRef e;
    public ReceiveChannel f;
    public ChannelIterator g;
    public /* synthetic */ Object i;
    public int j;

    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        int i2 = (this.j | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.j = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ReceiveChannel receiveChannel = null;
        if (i2 == 0) {
            ResultKt.b(obj);
            new Ref.IntRef().element = -1;
            new Ref.IntRef();
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else if (i2 == 1) {
            ChannelIterator channelIterator = this.g;
            ReceiveChannel receiveChannel2 = this.f;
            Ref.IntRef intRef = this.e;
            Ref.IntRef intRef2 = this.d;
            Object obj2 = this.c;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    if (Intrinsics.a(obj2, channelIterator.next())) {
                        intRef2.element = intRef.element;
                    }
                    intRef.element++;
                    this.c = obj2;
                    this.d = intRef2;
                    this.e = intRef;
                    this.f = receiveChannel2;
                    this.g = channelIterator;
                    this.j = 1;
                    obj = channelIterator.a(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                Unit unit = Unit.f696a;
                receiveChannel2.c((CancellationException) null);
                return new Integer(intRef2.element);
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
