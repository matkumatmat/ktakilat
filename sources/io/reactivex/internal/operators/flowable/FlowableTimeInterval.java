package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import org.reactivestreams.Subscription;

public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {

    public static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public final FlowableSubscriber c;

        public TimeIntervalSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            throw null;
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate((Subscription) null, subscription)) {
                throw null;
            }
        }

        public final void request(long j) {
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new TimeIntervalSubscriber(flowableSubscriber));
    }
}
