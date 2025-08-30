package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        public final void onComplete() {
            long j = this.k;
            if (j != 0) {
                this.k = 0;
                produced(j);
            }
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }
    }

    public static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;

        public final void cancel() {
            SubscriptionHelper.cancel((AtomicReference<Subscription>) null);
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce((AtomicReference<Subscription>) null, (AtomicLong) null, subscription);
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest((AtomicReference<Subscription>) null, (AtomicLong) null, j);
        }
    }

    public static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        public long k;

        public final void cancel() {
            super.cancel();
            throw null;
        }

        public final void onNext(Object obj) {
            this.k++;
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        new UnicastProcessor((Runnable) null, 8).e();
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptySubscription.error(th, flowableSubscriber);
        }
    }
}
