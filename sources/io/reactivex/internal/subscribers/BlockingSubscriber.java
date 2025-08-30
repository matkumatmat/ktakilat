package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    public final Queue c;

    public BlockingSubscriber(Queue<Object> queue) {
        this.c = queue;
    }

    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.c.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        if (get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    public void onComplete() {
        this.c.offer(NotificationLite.complete());
    }

    public void onError(Throwable th) {
        this.c.offer(NotificationLite.error(th));
    }

    public void onNext(T t) {
        this.c.offer(NotificationLite.next(t));
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            this.c.offer(NotificationLite.subscription(this));
        }
    }

    public void request(long j) {
        ((Subscription) get()).request(j);
    }
}
