package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;

public final class FlowableSerialized<T> extends AbstractFlowableWithUpstream<T, T> {
    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SerializedSubscriber(flowableSubscriber));
    }
}
