package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class ObservableNever extends Observable<Object> {
    public static final ObservableNever c = new Object();

    public final void subscribeActual(Observer observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
