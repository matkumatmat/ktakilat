package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableThrottleFirstTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;
        public Subscription c;
        public volatile boolean d;
        public boolean e;

        public final void cancel() {
            this.c.cancel();
            throw null;
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
            } else {
                this.e = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            if (!this.e && !this.d) {
                this.d = true;
                if (get() != 0) {
                    throw null;
                }
                this.e = true;
                cancel();
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this, j);
            }
        }

        public final void run() {
            this.d = false;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
