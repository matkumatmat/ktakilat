package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    public final Flow f;

    public ChannelFlowOperator(Flow flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f = flow;
    }

    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        CoroutineContext coroutineContext;
        if (this.d == -3) {
            CoroutineContext context = continuation.getContext();
            Boolean bool = Boolean.FALSE;
            e3 e3Var = new e3(3);
            CoroutineContext coroutineContext2 = this.c;
            if (!((Boolean) coroutineContext2.fold(bool, e3Var)).booleanValue()) {
                coroutineContext = context.plus(coroutineContext2);
            } else {
                coroutineContext = CoroutineContextKt.a(context, coroutineContext2, false);
            }
            if (Intrinsics.a(coroutineContext, context)) {
                Object g = g(flowCollector, continuation);
                if (g == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return g;
                }
                return Unit.f696a;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.b;
            if (Intrinsics.a(coroutineContext.get(key), context.get(key))) {
                CoroutineContext context2 = continuation.getContext();
                if (!(flowCollector instanceof SendingCollector) && !(flowCollector instanceof NopCollector)) {
                    flowCollector = new UndispatchedContextCollector(flowCollector, context2);
                }
                Object a2 = ChannelFlowKt.a(coroutineContext, flowCollector, ThreadContextKt.b(coroutineContext), new ChannelFlowOperator$collectWithContextUndispatched$2(this, (Continuation) null), continuation);
                if (a2 == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return a2;
                }
                return Unit.f696a;
            }
        }
        Object collect = super.collect(flowCollector, continuation);
        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return collect;
        }
        return Unit.f696a;
    }

    public final Object d(ProducerScope producerScope, Continuation continuation) {
        Object g = g(new SendingCollector(producerScope), continuation);
        if (g == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return g;
        }
        return Unit.f696a;
    }

    public abstract Object g(FlowCollector flowCollector, Continuation continuation);

    public final String toString() {
        return this.f + " -> " + super.toString();
    }
}
