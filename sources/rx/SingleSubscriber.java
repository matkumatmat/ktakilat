package rx;

import rx.internal.util.SubscriptionList;

public abstract class SingleSubscriber<T> implements Subscription {
    private final SubscriptionList cs = new SubscriptionList();

    public final void add(Subscription subscription) {
        this.cs.add(subscription);
    }

    public final boolean isUnsubscribed() {
        return this.cs.isUnsubscribed();
    }

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void unsubscribe() {
        this.cs.unsubscribe();
    }
}
