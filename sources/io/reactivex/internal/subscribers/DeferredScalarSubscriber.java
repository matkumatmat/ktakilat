package io.reactivex.internal.subscribers;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    public Subscription e;

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    public void cancel() {
        super.cancel();
        this.e.cancel();
    }

    public void onComplete() {
        this.c.onComplete();
    }

    public void onError(Throwable th) {
        this.d = null;
        this.c.onError(th);
    }

    public abstract /* synthetic */ void onNext(Object obj);

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.e, subscription)) {
            this.e = subscription;
            this.c.onSubscribe(this);
            subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
