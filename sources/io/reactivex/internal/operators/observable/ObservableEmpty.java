package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {
    public static final ObservableEmpty c = new Object();

    public final Object call() {
        return null;
    }

    public final void subscribeActual(Observer observer) {
        EmptyDisposable.complete((Observer<?>) observer);
    }
}
