package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithSingle<T> extends AbstractObservableWithUpstream<T, T> {
    public final SingleSource d;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;
        public final Observer c;
        public SingleSource d;
        public boolean e;

        public ConcatWithObserver(Observer observer, SingleSource singleSource) {
            this.c = observer;
            this.d = singleSource;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            this.e = true;
            DisposableHelper.replace(this, (Disposable) null);
            SingleSource singleSource = this.d;
            this.d = null;
            singleSource.b(this);
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

    public ObservableConcatWithSingle(Observable observable, SingleSource singleSource) {
        super(observable);
        this.d = singleSource;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new ConcatWithObserver(observer, this.d));
    }
}
