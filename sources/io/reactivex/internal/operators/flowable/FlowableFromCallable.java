package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Callable;

public final class FlowableFromCallable<T> extends Flowable<T> implements Callable<T> {
    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new DeferredScalarSubscription(flowableSubscriber));
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            flowableSubscriber.onError(th);
        }
    }

    public final Object call() {
        throw null;
    }
}
