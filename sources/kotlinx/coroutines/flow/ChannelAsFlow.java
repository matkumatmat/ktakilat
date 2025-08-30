package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002R\u000b\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/atomicfu/AtomicBoolean;", "consumed", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/ChannelAsFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
final class ChannelAsFlow<T> extends ChannelFlow<T> {
    private volatile /* synthetic */ int consumed$volatile;

    static {
        AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed$volatile");
    }

    public final String c() {
        throw null;
    }

    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        if (this.d != -3) {
            Object collect = super.collect(flowCollector, continuation);
            if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return collect;
            }
            return Unit.f696a;
        }
        throw null;
    }

    public final Object d(ProducerScope producerScope, Continuation continuation) {
        throw null;
    }

    public final ChannelFlow e(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        throw null;
    }

    public final ReceiveChannel f(CoroutineScope coroutineScope) {
        throw null;
    }
}
