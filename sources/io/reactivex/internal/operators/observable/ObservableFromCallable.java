package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {
    public final Callable c;

    public ObservableFromCallable(Callable callable) {
        this.c = callable;
    }

    public final Object call() {
        Object call = this.c.call();
        ObjectHelper.b(call, "The callable returned a null value");
        return call;
    }

    public final void subscribeActual(Observer observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                Object call = this.c.call();
                ObjectHelper.b(call, "Callable returned null");
                deferredScalarDisposable.complete(call);
            } catch (Throwable th) {
                Exceptions.a(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                } else {
                    RxJavaPlugins.b(th);
                }
            }
        }
    }
}
