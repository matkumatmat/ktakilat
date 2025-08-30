package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import org.reactivestreams.Publisher;

public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {
    public final void b(FlowableSubscriber flowableSubscriber) {
        if (!FlowableScalarXMap.a((Publisher) null, flowableSubscriber)) {
            new FlowableFlatMap.MergeSubscriber(flowableSubscriber);
            throw null;
        }
    }
}
