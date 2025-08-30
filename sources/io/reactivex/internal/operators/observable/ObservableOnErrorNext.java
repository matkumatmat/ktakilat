package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    public final Function d;
    public final boolean e;

    public static final class OnErrorNextObserver<T> implements Observer<T> {
        public final Observer c;
        public final Function d;
        public final boolean e;
        public final SequentialDisposable f = new SequentialDisposable();
        public boolean g;
        public boolean i;

        public OnErrorNextObserver(Observer observer, Function function, boolean z) {
            this.c = observer;
            this.d = function;
            this.e = z;
        }

        public final void onComplete() {
            if (!this.i) {
                this.i = true;
                this.g = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            boolean z = this.g;
            Observer observer = this.c;
            if (!z) {
                this.g = true;
                if (!this.e || (th instanceof Exception)) {
                    try {
                        ObservableSource observableSource = (ObservableSource) this.d.apply(th);
                        if (observableSource == null) {
                            NullPointerException nullPointerException = new NullPointerException("Observable is null");
                            nullPointerException.initCause(th);
                            observer.onError(nullPointerException);
                            return;
                        }
                        observableSource.subscribe(this);
                    } catch (Throwable th2) {
                        Exceptions.a(th2);
                        observer.onError(new CompositeException(th, th2));
                    }
                } else {
                    observer.onError(th);
                }
            } else if (this.i) {
                RxJavaPlugins.b(th);
            } else {
                observer.onError(th);
            }
        }

        public final void onNext(Object obj) {
            if (!this.i) {
                this.c.onNext(obj);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            this.f.replace(disposable);
        }
    }

    public ObservableOnErrorNext(Observable observable, Function function, boolean z) {
        super(observable);
        this.d = function;
        this.e = z;
    }

    public final void subscribeActual(Observer observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.d, this.e);
        observer.onSubscribe(onErrorNextObserver.f);
        this.c.subscribe(onErrorNextObserver);
    }
}
