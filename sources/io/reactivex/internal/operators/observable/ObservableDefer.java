package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableDefer<T> extends Observable<T> {
    public final Callable c;

    public ObservableDefer(Callable callable) {
        this.c = callable;
    }

    public final void subscribeActual(Observer observer) {
        try {
            Object call = this.c.call();
            ObjectHelper.b(call, "null ObservableSource supplied");
            ((ObservableSource) call).subscribe(observer);
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
