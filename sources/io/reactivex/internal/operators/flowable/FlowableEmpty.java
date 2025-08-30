package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;

public final class FlowableEmpty extends Flowable<Object> implements ScalarCallable<Object> {
    public final void b(FlowableSubscriber flowableSubscriber) {
        EmptySubscription.complete(flowableSubscriber);
    }

    public final Object call() {
        return null;
    }
}
