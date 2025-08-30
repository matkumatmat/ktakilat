package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;

abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {
    public final Flowable d;

    public AbstractFlowableWithUpstream(Flowable flowable) {
        this.d = flowable;
    }
}
