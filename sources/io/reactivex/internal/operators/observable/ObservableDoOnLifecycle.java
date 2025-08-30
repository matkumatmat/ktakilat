package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.DisposableLambdaObserver;

public final class ObservableDoOnLifecycle<T> extends AbstractObservableWithUpstream<T, T> {
    public final Consumer d;
    public final Action e;

    public ObservableDoOnLifecycle(Observable observable, Consumer consumer, Action action) {
        super(observable);
        this.d = consumer;
        this.e = action;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DisposableLambdaObserver(observer, this.d, this.e));
    }
}
