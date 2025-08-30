package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final FlowableSubscriber c;
        public final SubscriptionArbiter d;
        public final Publisher e;
        public long f = -1;
        public long g;

        public RepeatSubscriber(FlowableSubscriber flowableSubscriber, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
            this.c = flowableSubscriber;
            this.d = subscriptionArbiter;
            this.e = publisher;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    SubscriptionArbiter subscriptionArbiter = this.d;
                    if (!subscriptionArbiter.isCancelled()) {
                        long j = this.g;
                        if (j != 0) {
                            this.g = 0;
                            subscriptionArbiter.produced(j);
                        }
                        this.e.d(this);
                        i = addAndGet(-i);
                    } else {
                        return;
                    }
                } while (i != 0);
            }
        }

        public final void onComplete() {
            long j = this.f;
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f = j - 1;
            }
            if (j != 0) {
                a();
            } else {
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.g++;
            this.c.onNext(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            this.d.setSubscription(subscription);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        flowableSubscriber.onSubscribe(subscriptionArbiter);
        new RepeatSubscriber(flowableSubscriber, subscriptionArbiter, this.d).a();
    }
}
