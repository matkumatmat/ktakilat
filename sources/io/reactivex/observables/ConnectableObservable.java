package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public abstract class ConnectableObservable<T> extends Observable<T> {
    public abstract void c(Consumer consumer);
}
