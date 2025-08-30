package io.reactivex.observables;

import io.reactivex.Observable;

public abstract class GroupedObservable<K, T> extends Observable<T> {
    public final Object c;

    public GroupedObservable(Object obj) {
        this.c = obj;
    }
}
