package io.reactivex.internal.subscribers;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 7917814472626990048L;
    public final Subscriber c;
    public Subscription d;
    public Object e;
    public long f;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.c = subscriber;
    }

    public final void a(Object obj) {
        long j = this.f;
        if (j != 0) {
            BackpressureHelper.e(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                b(obj);
                return;
            } else if ((j2 & LocationRequestCompat.PASSIVE_INTERVAL) != 0) {
                lazySet(-9223372036854775807L);
                Subscriber subscriber = this.c;
                subscriber.onNext(obj);
                subscriber.onComplete();
                return;
            } else {
                this.e = obj;
                if (!compareAndSet(0, Long.MIN_VALUE)) {
                    this.e = null;
                } else {
                    return;
                }
            }
        }
    }

    public void b(Object obj) {
    }

    public void cancel() {
        this.d.cancel();
    }

    public abstract /* synthetic */ void onComplete();

    public abstract /* synthetic */ void onError(Throwable th);

    public abstract /* synthetic */ void onNext(Object obj);

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.d, subscription)) {
            this.d = subscription;
            this.c.onSubscribe(this);
        }
    }

    public void onSuccess(Object obj) {
        a(obj);
    }

    public final void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        Object obj = this.e;
                        Subscriber subscriber = this.c;
                        subscriber.onNext(obj);
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j2, BackpressureHelper.c(j2, j)));
            this.d.request(j);
        }
    }
}
