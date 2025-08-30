package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final class ObservableFromUnsafeSource<T> extends Observable<T> {
    public final ObservableSource c;

    public ObservableFromUnsafeSource(ObservableSource observableSource) {
        this.c = observableSource;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(observer);
    }
}
