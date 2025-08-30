package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {
    public final String c() {
        throw null;
    }

    public final Object d(ProducerScope producerScope, Continuation continuation) {
        throw null;
    }

    public final ChannelFlow e(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        throw null;
    }

    public final ReceiveChannel f(CoroutineScope coroutineScope) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this, (Continuation) null);
        return ProduceKt.b(coroutineScope, this.c, this.d, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, (Function1) null, channelFlow$collectToFun$1);
    }
}
