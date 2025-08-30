package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {

    public static final class CountObserver implements Observer<Object>, Disposable {
        public final Observer c;
        public Disposable d;
        public long e;

        public CountObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            this.d.dispose();
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            Long valueOf = Long.valueOf(this.e);
            Observer observer = this.c;
            observer.onNext(valueOf);
            observer.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.e++;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new CountObserver(observer));
    }
}
