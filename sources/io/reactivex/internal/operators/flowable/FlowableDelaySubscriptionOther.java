package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {

    public final class DelaySubscriber implements FlowableSubscriber<U> {
        public boolean c;

        public final class DelaySubscription implements Subscription {
            public final void cancel() {
                throw null;
            }

            public final void request(long j) {
            }
        }

        public final class OnCompleteSubscriber implements FlowableSubscriber<T> {
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
                throw null;
            }
        }

        public final void onComplete() {
            if (!this.c) {
                this.c = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.b(th);
            } else {
                this.c = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            onComplete();
        }

        public final void onSubscribe(Subscription subscription) {
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new SubscriptionArbiter());
        throw null;
    }
}
