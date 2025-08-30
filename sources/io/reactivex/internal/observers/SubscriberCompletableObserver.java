package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscription;

public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {
    public Disposable c;

    public final void cancel() {
        this.c.dispose();
    }

    public final void onComplete() {
        throw null;
    }

    public final void onError(Throwable th) {
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.c, disposable)) {
            this.c = disposable;
            throw null;
        }
    }

    public final void request(long j) {
    }
}
