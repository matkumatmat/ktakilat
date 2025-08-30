package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {
    public final Function d;

    public static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public final Function d;
        public Disposable e;

        public OnErrorReturnObserver(Observer observer, Function function) {
            this.c = observer;
            this.d = function;
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
            Observer observer = this.c;
            try {
                Object apply = this.d.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    observer.onError(nullPointerException);
                    return;
                }
                observer.onNext(apply);
                observer.onComplete();
            } catch (Throwable th2) {
                Exceptions.a(th2);
                observer.onError(new CompositeException(th, th2));
            }
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableOnErrorReturn(Observable observable, Function function) {
        super(observable);
        this.d = function;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new OnErrorReturnObserver(observer, this.d));
    }
}
