package io.reactivex.internal.subscribers;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    public final InnerQueuedSubscriberSupport c;
    public final int d;
    public final int e;
    public volatile SimpleQueue f;
    public volatile boolean g;
    public long i;
    public int j;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i2) {
        this.c = innerQueuedSubscriberSupport;
        this.d = i2;
        this.e = i2 - (i2 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.g;
    }

    public void onComplete() {
        this.c.a(this);
    }

    public void onError(Throwable th) {
        this.c.e(this, th);
    }

    public void onNext(T t) {
        int i2 = this.j;
        InnerQueuedSubscriberSupport innerQueuedSubscriberSupport = this.c;
        if (i2 == 0) {
            innerQueuedSubscriberSupport.d(this, t);
        } else {
            innerQueuedSubscriberSupport.b();
        }
    }

    public void onSubscribe(Subscription subscription) {
        SimpleQueue simpleQueue;
        if (SubscriptionHelper.setOnce(this, subscription)) {
            boolean z = subscription instanceof QueueSubscription;
            long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (z) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.j = requestFusion;
                    this.f = queueSubscription;
                    this.g = true;
                    this.c.a(this);
                    return;
                } else if (requestFusion == 2) {
                    this.j = requestFusion;
                    this.f = queueSubscription;
                    int i2 = this.d;
                    if (i2 >= 0) {
                        j2 = (long) i2;
                    }
                    subscription.request(j2);
                    return;
                }
            }
            int i3 = this.d;
            if (i3 < 0) {
                simpleQueue = new SpscLinkedArrayQueue(-i3);
            } else {
                simpleQueue = new SpscArrayQueue(i3);
            }
            this.f = simpleQueue;
            int i4 = this.d;
            if (i4 >= 0) {
                j2 = (long) i4;
            }
            subscription.request(j2);
        }
    }

    public SimpleQueue<T> queue() {
        return this.f;
    }

    public void request(long j2) {
        if (this.j != 1) {
            long j3 = this.i + j2;
            if (j3 >= ((long) this.e)) {
                this.i = 0;
                ((Subscription) get()).request(j3);
                return;
            }
            this.i = j3;
        }
    }

    public void requestOne() {
        if (this.j != 1) {
            long j2 = this.i + 1;
            if (j2 == ((long) this.e)) {
                this.i = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.i = j2;
        }
    }

    public void setDone() {
        this.g = true;
    }
}
