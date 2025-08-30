package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableThrottleLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        public Subscription c;
        public volatile boolean d;
        public Throwable e;
        public volatile boolean f;

        public final void a() {
            if (getAndIncrement() == 0) {
                if (this.f) {
                    throw null;
                } else if (!this.d || this.e == null) {
                    throw null;
                } else {
                    throw null;
                }
            }
        }

        public final void cancel() {
            this.f = true;
            this.c.cancel();
            throw null;
        }

        public final void onComplete() {
            this.d = true;
            a();
        }

        public final void onError(Throwable th) {
            this.e = th;
            this.d = true;
            a();
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
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a((AtomicLong) null, j);
                throw null;
            }
        }

        public final void run() {
            a();
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
