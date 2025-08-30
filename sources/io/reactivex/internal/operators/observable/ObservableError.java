package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableError<T> extends Observable<T> {
    public final Callable c;

    public ObservableError(Callable callable) {
        this.c = callable;
    }

    public final void subscribeActual(Observer observer) {
        try {
            Object call = this.c.call();
            ObjectHelper.b(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = (Throwable) call;
        } catch (Throwable th) {
            th = th;
            Exceptions.a(th);
        }
        EmptyDisposable.error(th, (Observer<?>) observer);
    }
}
