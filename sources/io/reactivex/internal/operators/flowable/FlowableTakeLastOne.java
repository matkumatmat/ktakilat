package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastOne<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5467847744262967226L;
        public Subscription e;

        public final void cancel() {
            super.cancel();
            this.e.cancel();
        }

        public final void onComplete() {
            Object obj = this.d;
            if (obj != null) {
                complete(obj);
            } else {
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            this.d = null;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.d = obj;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.FlowableSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription] */
    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new DeferredScalarSubscription(flowableSubscriber));
    }
}
