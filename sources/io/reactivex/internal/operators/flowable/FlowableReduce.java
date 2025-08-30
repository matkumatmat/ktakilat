package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        public Subscription e;

        public final void cancel() {
            super.cancel();
            this.e.cancel();
            this.e = SubscriptionHelper.CANCELLED;
        }

        public final void onComplete() {
            Subscription subscription = this.e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.e = subscriptionHelper;
                Object obj = this.d;
                if (obj != null) {
                    complete(obj);
                } else {
                    this.c.onComplete();
                }
            }
        }

        public final void onError(Throwable th) {
            Subscription subscription = this.e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = subscriptionHelper;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (this.e != SubscriptionHelper.CANCELLED) {
                if (this.d == null) {
                    this.d = obj;
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.e.cancel();
                    onError(th);
                }
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
