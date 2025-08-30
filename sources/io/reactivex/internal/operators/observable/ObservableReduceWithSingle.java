package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;

public final class ObservableReduceWithSingle<T, R> extends Single<R> {
    public final Observable c;
    public final Callable d;
    public final BiFunction e;

    public ObservableReduceWithSingle(Observable observable, Callable callable, BiFunction biFunction) {
        this.c = observable;
        this.d = callable;
        this.e = biFunction;
    }

    public final void c(SingleObserver singleObserver) {
        try {
            Object call = this.d.call();
            ObjectHelper.b(call, "The seedSupplier returned a null value");
            this.c.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.e, call));
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
