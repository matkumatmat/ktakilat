package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;

    public static final class SkipObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public long d;
        public Disposable e;

        public SkipObserver(Observer observer, long j) {
            this.c = observer;
            this.d = j;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            long j = this.d;
            if (j != 0) {
                this.d = j - 1;
            } else {
                this.c.onNext(obj);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSkip(Observable observable, long j) {
        super(observable);
        this.d = j;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new SkipObserver(observer, this.d));
    }
}
