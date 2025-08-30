package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class AsyncSubscription extends AtomicLong implements Subscription, Disposable {
    private static final long serialVersionUID = 7028635084060361255L;
    public final AtomicReference c;
    public final AtomicReference d;

    public AsyncSubscription() {
        this.d = new AtomicReference();
        this.c = new AtomicReference();
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.c);
        DisposableHelper.dispose(this.d);
    }

    public boolean isDisposed() {
        if (this.c.get() == SubscriptionHelper.CANCELLED) {
            return true;
        }
        return false;
    }

    public boolean replaceResource(Disposable disposable) {
        return DisposableHelper.replace(this.d, disposable);
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.c, this, j);
    }

    public boolean setResource(Disposable disposable) {
        return DisposableHelper.set(this.d, disposable);
    }

    public void setSubscription(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.c, this, subscription);
    }

    public AsyncSubscription(Disposable disposable) {
        this();
        this.d.lazySet(disposable);
    }
}
