package io.reactivex.internal.subscribers;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    public Object c;

    public final void cancel() {
    }

    public final Object get() {
        if (getCount() != 0) {
            await();
        }
        throw null;
    }

    public final boolean isCancelled() {
        throw null;
    }

    public final boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    public final void onComplete() {
        if (this.c == null) {
            new NoSuchElementException("The source is empty");
            throw null;
        }
        throw null;
    }

    public final void onError(Throwable th) {
        throw null;
    }

    public final void onNext(Object obj) {
        if (this.c == null) {
            this.c = obj;
            return;
        }
        throw null;
    }

    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference<Subscription>) null, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public final void request(long j) {
    }

    public final boolean cancel(boolean z) {
        throw null;
    }

    public final Object get(long j, TimeUnit timeUnit) {
        if (getCount() == 0 || await(j, timeUnit)) {
            throw null;
        }
        throw new TimeoutException();
    }
}
