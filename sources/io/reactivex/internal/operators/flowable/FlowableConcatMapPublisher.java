package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import org.reactivestreams.Publisher;

public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {
    public final void b(FlowableSubscriber flowableSubscriber) {
        if (!FlowableScalarXMap.a((Publisher) null, flowableSubscriber)) {
            int[] iArr = FlowableConcatMap.AnonymousClass1.f667a;
            throw null;
        }
    }
}
