package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public Disposable d;
        public Object e;

        public TakeLastOneObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            this.e = null;
            this.d.dispose();
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            Object obj = this.e;
            Observer observer = this.c;
            if (obj != null) {
                this.e = null;
                observer.onNext(obj);
            }
            observer.onComplete();
        }

        public final void onError(Throwable th) {
            this.e = null;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.e = obj;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastOne(Observable observable) {
        super(observable);
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new TakeLastOneObserver(observer));
    }
}
