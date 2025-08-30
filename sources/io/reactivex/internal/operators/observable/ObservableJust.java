package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {
    public final Object c;

    public ObservableJust(Object obj) {
        this.c = obj;
    }

    public final Object call() {
        return this.c;
    }

    public final void subscribeActual(Observer observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.c);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
