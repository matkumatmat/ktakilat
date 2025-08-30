package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;
    public final Subscriber c;
    public final AtomicReference d = new AtomicReference();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.c = subscriber;
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.d);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        if (this.d.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.c.onComplete();
    }

    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.c.onError(th);
    }

    public void onNext(T t) {
        this.c.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.d, subscription)) {
            this.c.onSubscribe(this);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            ((Subscription) this.d.get()).request(j);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
