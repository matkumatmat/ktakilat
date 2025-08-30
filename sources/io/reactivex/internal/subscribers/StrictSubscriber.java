package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    public final Subscriber c;
    public final AtomicThrowable d = new AtomicThrowable();
    public final AtomicLong e = new AtomicLong();
    public final AtomicReference f = new AtomicReference();
    public final AtomicBoolean g = new AtomicBoolean();
    public volatile boolean i;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.c = subscriber;
    }

    public void cancel() {
        if (!this.i) {
            SubscriptionHelper.cancel(this.f);
        }
    }

    public void onComplete() {
        this.i = true;
        HalfSerializer.b(this.c, this, this.d);
    }

    public void onError(Throwable th) {
        this.i = true;
        HalfSerializer.d(this.c, th, this, this.d);
    }

    public void onNext(T t) {
        HalfSerializer.f(this.c, t, this, this.d);
    }

    public void onSubscribe(Subscription subscription) {
        if (this.g.compareAndSet(false, true)) {
            this.c.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.f, this.e, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void request(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException(e.j(j, "§3.9 violated: positive request amount required but it was ")));
            return;
        }
        SubscriptionHelper.deferredRequest(this.f, this.e, j);
    }
}
