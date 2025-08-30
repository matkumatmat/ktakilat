package io.reactivex.internal.subscribers;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {
    public Object c;
    public Subscription d;

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.d, subscription)) {
            this.d = subscription;
            subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
