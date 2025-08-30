package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        public Subscription e;
        public boolean f;

        public final void cancel() {
            super.cancel();
            this.e.cancel();
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                Object obj = this.d;
                this.d = null;
                if (obj == null) {
                    obj = null;
                }
                if (obj == null) {
                    this.c.onComplete();
                } else {
                    complete(obj);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                if (this.d != null) {
                    this.f = true;
                    this.e.cancel();
                    this.c.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.d = obj;
            }
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
