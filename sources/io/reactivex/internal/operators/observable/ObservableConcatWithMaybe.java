package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    public final MaybeSource d;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;
        public final Observer c;
        public MaybeSource d;
        public boolean e;

        public ConcatWithObserver(Observer observer, MaybeSource maybeSource) {
            this.c = observer;
            this.d = maybeSource;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            if (this.e) {
                this.c.onComplete();
                return;
            }
            this.e = true;
            DisposableHelper.replace(this, (Disposable) null);
            MaybeSource maybeSource = this.d;
            this.d = null;
            maybeSource.b(this);
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.e) {
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            Observer observer = this.c;
            observer.onNext(obj);
            observer.onComplete();
        }
    }

    public ObservableConcatWithMaybe(Observable observable, MaybeSource maybeSource) {
        super(observable);
        this.d = maybeSource;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new ConcatWithObserver(observer, this.d));
    }
}
