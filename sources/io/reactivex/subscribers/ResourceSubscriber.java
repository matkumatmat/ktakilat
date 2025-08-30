package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    public final void dispose() {
        if (SubscriptionHelper.cancel((AtomicReference<Subscription>) null)) {
            throw null;
        }
    }

    public final boolean isDisposed() {
        throw null;
    }

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.c((AtomicReference) null, subscription, getClass())) {
            throw null;
        }
    }
}
