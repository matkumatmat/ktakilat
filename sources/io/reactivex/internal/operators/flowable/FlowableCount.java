package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

public final class FlowableCount<T> extends AbstractFlowableWithUpstream<T, Long> {

    public static final class CountSubscriber extends DeferredScalarSubscription<Long> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        public Subscription e;
        public long f;

        public final void cancel() {
            super.cancel();
            this.e.cancel();
        }

        public final void onComplete() {
            complete(Long.valueOf(this.f));
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.f++;
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
