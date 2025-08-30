package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;

public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1015244841293359600L;
        public final FlowableSubscriber c;
        public Subscription d;

        public final class Cancellation implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public UnsubscribeSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public final void onComplete() {
            if (!get()) {
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.b(th);
            } else {
                this.c.onError(th);
            }
        }

        public final void onNext(Object obj) {
            if (!get()) {
                this.c.onNext(obj);
            }
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
        this.d.a(new UnsubscribeSubscriber(flowableSubscriber));
    }
}
