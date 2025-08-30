package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;

public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {
    public final Observable c;

    public static final class CountObserver implements Observer<Object>, Disposable {
        public final SingleObserver c;
        public Disposable d;
        public long e;

        public CountObserver(SingleObserver singleObserver) {
            this.c = singleObserver;
        }

        public final void dispose() {
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            this.c.onSuccess(Long.valueOf(this.e));
        }

        public final void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
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

    public ObservableCountSingle(Observable observable) {
        this.c = observable;
    }

    public final Observable a() {
        return new AbstractObservableWithUpstream(this.c);
    }

    public final void c(SingleObserver singleObserver) {
        this.c.subscribe(new CountObserver(singleObserver));
    }
}
