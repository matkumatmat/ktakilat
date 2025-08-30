package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;

public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5636543848937116287L;
        public boolean c;
        public Subscription d;
        public final FlowableSubscriber e;
        public long f = 0;

        public TakeSubscriber(FlowableSubscriber flowableSubscriber) {
            this.e = flowableSubscriber;
        }

        public final void cancel() {
            this.d.cancel();
        }

        public final void onComplete() {
            if (!this.c) {
                this.c = true;
                this.e.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (!this.c) {
                this.c = true;
                this.d.cancel();
                this.e.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            boolean z;
            if (!this.c) {
                long j = this.f;
                long j2 = j - 1;
                this.f = j2;
                if (j > 0) {
                    if (j2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.e.onNext(obj);
                    if (z) {
                        this.d.cancel();
                        onComplete();
                    }
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                subscription.cancel();
                this.c = true;
                EmptySubscription.complete(this.e);
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (get() || !compareAndSet(false, true) || j < 0) {
                    this.d.request(j);
                } else {
                    this.d.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new TakeSubscriber(flowableSubscriber));
    }
}
