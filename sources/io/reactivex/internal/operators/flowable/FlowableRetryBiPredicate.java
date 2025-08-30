package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableRetryBiPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final FlowableSubscriber c;
        public final SubscriptionArbiter d;
        public final Publisher e;
        public int f;
        public long g;

        public RetryBiSubscriber(FlowableSubscriber flowableSubscriber, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
            this.c = flowableSubscriber;
            this.d = subscriptionArbiter;
            this.e = publisher;
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            try {
                this.f++;
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                this.c.onError(new CompositeException(th, th2));
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
        RetryBiSubscriber retryBiSubscriber = new RetryBiSubscriber(flowableSubscriber, subscriptionArbiter, this.d);
        if (retryBiSubscriber.getAndIncrement() == 0) {
            int i = 1;
            do {
                SubscriptionArbiter subscriptionArbiter2 = retryBiSubscriber.d;
                if (!subscriptionArbiter2.isCancelled()) {
                    long j = retryBiSubscriber.g;
                    if (j != 0) {
                        retryBiSubscriber.g = 0;
                        subscriptionArbiter2.produced(j);
                    }
                    retryBiSubscriber.e.d(retryBiSubscriber);
                    i = retryBiSubscriber.addAndGet(-i);
                } else {
                    return;
                }
            } while (i != 0);
        }
    }
}
