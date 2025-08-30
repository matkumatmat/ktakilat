package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {
    public final FlowableSubscriber c;
    public Subscription d;
    public QueueSubscription e;
    public boolean f;
    public int g;

    public BasicFuseableSubscriber(FlowableSubscriber flowableSubscriber) {
        this.c = flowableSubscriber;
    }

    public final void a(Throwable th) {
        Exceptions.a(th);
        this.d.cancel();
        onError(th);
    }

    public final void cancel() {
        this.d.cancel();
    }

    public void clear() {
        this.e.clear();
    }

    public final boolean isEmpty() {
        return this.e.isEmpty();
    }

    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f) {
            this.f = true;
            this.c.onComplete();
        }
    }

    public void onError(Throwable th) {
        if (this.f) {
            RxJavaPlugins.b(th);
            return;
        }
        this.f = true;
        this.c.onError(th);
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.d, subscription)) {
            this.d = subscription;
            if (subscription instanceof QueueSubscription) {
                this.e = (QueueSubscription) subscription;
            }
            this.c.onSubscribe(this);
        }
    }

    public final void request(long j) {
        this.d.request(j);
    }

    public int requestFusion(int i) {
        QueueSubscription queueSubscription = this.e;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i);
        if (requestFusion == 0) {
            return requestFusion;
        }
        this.g = requestFusion;
        return requestFusion;
    }
}
