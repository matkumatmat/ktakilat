package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final FlowableSubscriber c;
        public final SubscriptionArbiter d;
        public final Publisher e;
        public long f;

        public RepeatSubscriber(FlowableSubscriber flowableSubscriber, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
            this.c = flowableSubscriber;
            this.d = subscriptionArbiter;
            this.e = publisher;
        }

        public final void onComplete() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.c.onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.f++;
            this.c.onNext(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            this.d.setSubscription(subscription);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        flowableSubscriber.onSubscribe(subscriptionArbiter);
        RepeatSubscriber repeatSubscriber = new RepeatSubscriber(flowableSubscriber, subscriptionArbiter, this.d);
        if (repeatSubscriber.getAndIncrement() == 0) {
            int i = 1;
            do {
                SubscriptionArbiter subscriptionArbiter2 = repeatSubscriber.d;
                if (!subscriptionArbiter2.isCancelled()) {
                    long j = repeatSubscriber.f;
                    if (j != 0) {
                        repeatSubscriber.f = 0;
                        subscriptionArbiter2.produced(j);
                    }
                    repeatSubscriber.e.d(repeatSubscriber);
                    i = repeatSubscriber.addAndGet(-i);
                } else {
                    return;
                }
            } while (i != 0);
        }
    }
}
