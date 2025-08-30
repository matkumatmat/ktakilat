package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSerialized<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableSerialized(Observable observable) {
        super(observable);
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new SerializedObserver(observer));
    }
}
