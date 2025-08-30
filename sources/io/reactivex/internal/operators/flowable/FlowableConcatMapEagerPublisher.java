package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;

public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {
    public final void b(FlowableSubscriber flowableSubscriber) {
        new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(flowableSubscriber);
        throw null;
    }
}
