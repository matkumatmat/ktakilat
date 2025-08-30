package io.reactivex.subscribers;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    public final AtomicReference c = new AtomicReference();

    public final void dispose() {
        SubscriptionHelper.cancel(this.c);
    }

    public final boolean isDisposed() {
        if (this.c.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    public final void onSubscribe(Subscription subscription) {
        AtomicReference atomicReference = this.c;
        if (EndConsumerHelper.c(atomicReference, subscription, getClass())) {
            ((Subscription) atomicReference.get()).request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
