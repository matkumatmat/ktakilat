package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {209}, m = "toList", n = {"$this$toList_u24lambda_u242", "$this$consume$iv$iv"}, s = {"L$1", "L$2"})
final class ChannelsKt__Channels_commonKt$toList$1<E> extends ContinuationImpl {
    public List c;
    public List d;
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
            new ListBuilder(0, 1, (DefaultConstructorMarker) null);
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
            }
        } else if (i2 == 1) {
            ChannelIterator channelIterator = this.f;
            ReceiveChannel receiveChannel2 = this.e;
            List list = this.d;
            List list2 = this.c;
            try {
                ResultKt.b(obj);
                while (((Boolean) obj).booleanValue()) {
                    list.add(channelIterator.next());
                    this.c = list2;
                    this.d = list;
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
                Intrinsics.checkNotNullParameter(list2, "builder");
                return ((ListBuilder) list2).build();
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
