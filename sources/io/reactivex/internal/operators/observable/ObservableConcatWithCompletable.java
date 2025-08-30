package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    public final CompletableSource d;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;
        public final Observer c;
        public CompletableSource d;
        public boolean e;

        public ConcatWithObserver(Observer observer, CompletableSource completableSource) {
            this.c = observer;
            this.d = completableSource;
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
            CompletableSource completableSource = this.d;
            this.d = null;
            completableSource.b(this);
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
    }

    public ObservableConcatWithCompletable(Observable observable, CompletableSource completableSource) {
        super(observable);
        this.d = completableSource;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new ConcatWithObserver(observer, this.d));
    }
}
