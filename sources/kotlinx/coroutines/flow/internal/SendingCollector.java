package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/flow/internal/SendingCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalCoroutinesApi
public final class SendingCollector<T> implements FlowCollector<T> {
    public final ProducerScope c;

    public SendingCollector(ProducerScope producerScope) {
        this.c = producerScope;
    }

    public final Object emit(Object obj, Continuation continuation) {
        Object A = this.c.A(obj, continuation);
        if (A == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return A;
        }
        return Unit.f696a;
    }
}
