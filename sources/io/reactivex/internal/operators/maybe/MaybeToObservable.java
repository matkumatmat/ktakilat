package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {

    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;
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

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.MaybeObserver, io.reactivex.internal.observers.DeferredScalarDisposable] */
    public static MaybeObserver c(Observer observer) {
        return new DeferredScalarDisposable(observer);
    }

    public final void subscribeActual(Observer observer) {
        new DeferredScalarDisposable(observer);
        throw null;
    }
}
