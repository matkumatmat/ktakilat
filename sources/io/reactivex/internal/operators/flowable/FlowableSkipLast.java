package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3807491841935125653L;
        public final FlowableSubscriber c;
        public Subscription d;

        public SkipLastSubscriber(FlowableSubscriber flowableSubscriber) {
            super(0);
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.d.cancel();
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (size() == 0) {
                this.c.onNext(poll());
            } else {
                this.d.request(1);
            }
            offer(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.c.onSubscribe(this);
            }
        }

        public final void request(long j) {
            this.d.request(j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SkipLastSubscriber(flowableSubscriber));
    }
}
