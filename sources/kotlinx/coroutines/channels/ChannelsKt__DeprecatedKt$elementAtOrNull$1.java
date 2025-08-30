package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {83}, m = "elementAtOrNull", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
final class ChannelsKt__DeprecatedKt$elementAtOrNull$1<E> extends ContinuationImpl {
    public int c;
    public int d;
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
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else if (i2 == 1) {
            int i3 = this.d;
            int i4 = this.c;
            ChannelIterator channelIterator = this.f;
            ReceiveChannel receiveChannel2 = this.e;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    int i5 = i3 + 1;
                    if (i4 == i3) {
                        receiveChannel2.c((CancellationException) null);
                        return next;
                    }
                    this.e = receiveChannel2;
                    this.f = channelIterator;
                    this.c = i4;
                    this.d = i5;
                    this.i = 1;
                    obj = channelIterator.a(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    i3 = i5;
                }
                receiveChannel2.c((CancellationException) null);
                return null;
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
