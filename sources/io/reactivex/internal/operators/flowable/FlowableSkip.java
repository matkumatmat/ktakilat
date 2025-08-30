package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public final FlowableSubscriber c;
        public long d = 0;
        public Subscription e;

        public SkipSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.e.cancel();
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            long j = this.d;
            if (j != 0) {
                this.d = j - 1;
            } else {
                this.c.onNext(obj);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                long j = this.d;
                this.e = subscription;
                this.c.onSubscribe(this);
                subscription.request(j);
            }
        }

        public final void request(long j) {
            this.e.request(j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SkipSubscriber(flowableSubscriber));
    }
}
