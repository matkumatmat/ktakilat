package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public Subscription c;

        public final class OnComplete implements Runnable {
            public final void run() {
                try {
                    throw null;
                } catch (Throwable unused) {
                    throw null;
                }
            }
        }

        public final class OnError implements Runnable {
            public final void run() {
                try {
                    throw null;
                } catch (Throwable unused) {
                    throw null;
                }
            }
        }

        public final class OnNext implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public final void cancel() {
            this.c.cancel();
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
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                throw null;
            }
        }

        public final void request(long j) {
            this.c.request(j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
