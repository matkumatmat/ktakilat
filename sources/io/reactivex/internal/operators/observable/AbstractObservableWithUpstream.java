package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;

abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {
    public final ObservableSource c;

    public AbstractObservableWithUpstream(ObservableSource observableSource) {
        this.c = observableSource;
    }
}
