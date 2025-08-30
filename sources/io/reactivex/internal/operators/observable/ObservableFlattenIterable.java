package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final Function d;

    public static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        public final Observer c;
        public final Function d;
        public Disposable e;

        public FlattenIterableObserver(Observer observer, Function function) {
            this.c = observer;
            this.d = function;
        }

        public final void dispose() {
            this.e.dispose();
            this.e = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            Disposable disposable = this.e;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.e = disposableHelper;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            Disposable disposable = this.e;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = disposableHelper;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (this.e != DisposableHelper.DISPOSED) {
                try {
                    for (Object next : (Iterable) this.d.apply(obj)) {
                        try {
                            try {
                                ObjectHelper.b(next, "The iterator returned a null value");
                                this.c.onNext(next);
                            } catch (Throwable th) {
                                Exceptions.a(th);
                                this.e.dispose();
                                onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.a(th2);
                            this.e.dispose();
                            onError(th2);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.a(th3);
                    this.e.dispose();
                    onError(th3);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableFlattenIterable(Observable observable, Function function) {
        super(observable);
        this.d = function;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new FlattenIterableObserver(observer, this.d));
    }
}
