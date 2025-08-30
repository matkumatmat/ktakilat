package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

public final class FlowableFromFuture<T> extends Flowable<T> {
    public final void b(FlowableSubscriber flowableSubscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(flowableSubscriber);
        flowableSubscriber.onSubscribe(deferredScalarSubscription);
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            if (!deferredScalarSubscription.isCancelled()) {
                flowableSubscriber.onError(th);
            }
        }
    }
}
