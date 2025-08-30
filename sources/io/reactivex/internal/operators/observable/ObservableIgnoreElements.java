package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        public final Observer c;
        public Disposable d;

        public IgnoreObservable(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            this.d.dispose();
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
        }

        public final void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.c.onSubscribe(this);
        }
    }

    public ObservableIgnoreElements(Observable observable) {
        super(observable);
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new IgnoreObservable(observer));
    }
}
