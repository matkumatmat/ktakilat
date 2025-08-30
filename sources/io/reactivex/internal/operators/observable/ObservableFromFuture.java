package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ObservableFromFuture<T> extends Observable<T> {
    public final Future c;
    public final long d;
    public final TimeUnit e;

    public ObservableFromFuture(Future future, long j, TimeUnit timeUnit) {
        this.c = future;
        this.d = j;
        this.e = timeUnit;
    }

    public final void subscribeActual(Observer observer) {
        Object obj;
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                TimeUnit timeUnit = this.e;
                Future future = this.c;
                if (timeUnit != null) {
                    obj = future.get(this.d, timeUnit);
                } else {
                    obj = future.get();
                }
                ObjectHelper.b(obj, "Future returned null");
                deferredScalarDisposable.complete(obj);
            } catch (Throwable th) {
                Exceptions.a(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                }
            }
        }
    }
}
