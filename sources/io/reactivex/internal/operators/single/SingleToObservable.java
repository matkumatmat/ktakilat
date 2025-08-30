package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class SingleToObservable<T> extends Observable<T> {
    public final SingleSource c;

    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        public Disposable e;

        public final void dispose() {
            super.dispose();
            this.e.dispose();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public SingleToObservable(SingleSource singleSource) {
        this.c = singleSource;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.SingleObserver, io.reactivex.internal.observers.DeferredScalarDisposable] */
    public static SingleObserver c(Observer observer) {
        return new DeferredScalarDisposable(observer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.SingleObserver, io.reactivex.internal.observers.DeferredScalarDisposable] */
    public final void subscribeActual(Observer observer) {
        this.c.b(new DeferredScalarDisposable(observer));
    }
}
