package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
    public final ObservableSource d;

    public static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        public final Observer c;
        public final ObservableSource d;
        public final SequentialDisposable e = new SequentialDisposable();
        public boolean f = true;

        public SwitchIfEmptyObserver(Observer observer, ObservableSource observableSource) {
            this.c = observer;
            this.d = observableSource;
        }

        public final void onComplete() {
            if (this.f) {
                this.f = false;
                this.d.subscribe(this);
                return;
            }
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (this.f) {
                this.f = false;
            }
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            this.e.update(disposable);
        }
    }

    public ObservableSwitchIfEmpty(Observable observable, ObservableSource observableSource) {
        super(observable);
        this.d = observableSource;
    }

    public final void subscribeActual(Observer observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.d);
        observer.onSubscribe(switchIfEmptyObserver.e);
        this.c.subscribe(switchIfEmptyObserver);
    }
}
