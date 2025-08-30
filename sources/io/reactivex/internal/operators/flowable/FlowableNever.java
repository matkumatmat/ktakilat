package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;

public final class FlowableNever extends Flowable<Object> {
    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(EmptySubscription.INSTANCE);
    }
}
