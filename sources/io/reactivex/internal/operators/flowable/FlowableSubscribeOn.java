package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;

        public static final class Request implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public final void cancel() {
            SubscriptionHelper.cancel((AtomicReference<Subscription>) null);
            throw null;
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce((AtomicReference<Subscription>) null, subscription)) {
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                throw null;
            }
        }

        public final void run() {
            lazySet(Thread.currentThread());
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
