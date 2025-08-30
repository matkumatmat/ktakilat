package io.reactivex.subscribers;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    public Subscription c;

    public final void onSubscribe(Subscription subscription) {
        Subscription subscription2 = this.c;
        Class<?> cls = getClass();
        ObjectHelper.b(subscription, "next is null");
        if (subscription2 != null) {
            subscription.cancel();
            if (subscription2 != SubscriptionHelper.CANCELLED) {
                EndConsumerHelper.a(cls);
                return;
            }
            return;
        }
        this.c = subscription;
        subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
