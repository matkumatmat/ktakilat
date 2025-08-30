package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {
    public final boolean cancel(boolean z) {
        throw null;
    }

    public final void dispose() {
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

    public final boolean isDisposed() {
        return isDone();
    }

    public final boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    public final void onError(Throwable th) {
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference<Disposable>) null, disposable);
    }

    public final void onSuccess(Object obj) {
        throw null;
    }

    public final Object get(long j, TimeUnit timeUnit) {
        if (getCount() == 0 || await(j, timeUnit)) {
            throw null;
        }
        throw new TimeoutException();
    }
}
