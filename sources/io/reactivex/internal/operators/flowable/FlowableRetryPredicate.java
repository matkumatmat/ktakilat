package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final FlowableSubscriber c;
        public final SubscriptionArbiter d;
        public final Publisher e;
        public long f = 0;
        public long g;

        public RetrySubscriber(FlowableSubscriber flowableSubscriber, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
            this.c = flowableSubscriber;
            this.d = subscriptionArbiter;
            this.e = publisher;
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            long j = this.f;
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f = j - 1;
            }
            FlowableSubscriber flowableSubscriber = this.c;
            if (j == 0) {
                flowableSubscriber.onError(th);
                return;
            }
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                flowableSubscriber.onError(new CompositeException(th, th2));
            }
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
        RetrySubscriber retrySubscriber = new RetrySubscriber(flowableSubscriber, subscriptionArbiter, this.d);
        if (retrySubscriber.getAndIncrement() == 0) {
            int i = 1;
            do {
                SubscriptionArbiter subscriptionArbiter2 = retrySubscriber.d;
                if (!subscriptionArbiter2.isCancelled()) {
                    long j = retrySubscriber.g;
                    if (j != 0) {
                        retrySubscriber.g = 0;
                        subscriptionArbiter2.produced(j);
                    }
                    retrySubscriber.e.d(retrySubscriber);
                    i = retrySubscriber.addAndGet(-i);
                } else {
                    return;
                }
            } while (i != 0);
        }
    }
}
