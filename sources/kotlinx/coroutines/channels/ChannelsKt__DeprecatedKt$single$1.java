package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {166, 169}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$single$1<E> extends ContinuationImpl {
    public ReceiveChannel c;
    public Object d;
    public /* synthetic */ Object e;
    public int f;

    public final Object invokeSuspend(Object obj) {
        ReceiveChannel receiveChannel;
        this.e = obj;
        int i = (this.f | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f = i;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        ReceiveChannel receiveChannel2 = null;
        if (i != 0) {
            if (i == 1) {
                ChannelIterator channelIterator = (ChannelIterator) this.d;
                receiveChannel = this.c;
                try {
                    ResultKt.b(obj);
                    if (((Boolean) obj).booleanValue()) {
                        Object next = channelIterator.next();
                        this.c = receiveChannel;
                        this.d = next;
                        this.f = 2;
                        Object a2 = channelIterator.a(this);
                        if (a2 == obj2) {
                            return obj2;
                        }
                        obj2 = next;
                        obj = a2;
                    } else {
                        throw new NoSuchElementException("ReceiveChannel is empty.");
                    }
                } catch (Throwable th) {
                    th = th;
                    receiveChannel2 = receiveChannel;
                    throw th;
                }
            } else if (i == 2) {
                Object obj3 = this.d;
                ReceiveChannel receiveChannel3 = this.c;
                try {
                    ResultKt.b(obj);
                    receiveChannel = receiveChannel3;
                    obj2 = obj3;
                } catch (Throwable th2) {
                    th = th2;
                    receiveChannel2 = receiveChannel3;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        ChannelsKt.a(receiveChannel2, th);
                        throw th3;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (!((Boolean) obj).booleanValue()) {
                receiveChannel.c((CancellationException) null);
                return obj2;
            }
            throw new IllegalArgumentException("ReceiveChannel has more than one element.");
        }
        ResultKt.b(obj);
        try {
            throw null;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
