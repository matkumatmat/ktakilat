package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;

public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {
    public final Observable c;

    public static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        public final CompletableObserver c;
        public Disposable d;

        public IgnoreObservable(CompletableObserver completableObserver) {
            this.c = completableObserver;
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

    public ObservableIgnoreElementsCompletable(Observable observable) {
        this.c = observable;
    }

    public final Observable a() {
        return new AbstractObservableWithUpstream(this.c);
    }

    public final void c(CompletableObserver completableObserver) {
        this.c.subscribe(new IgnoreObservable(completableObserver));
    }
}
