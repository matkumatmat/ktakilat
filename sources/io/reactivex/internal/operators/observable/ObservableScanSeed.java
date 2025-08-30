package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final BiFunction d;
    public final Callable e;

    public static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {
        public final Observer c;
        public final BiFunction d;
        public Object e;
        public Disposable f;
        public boolean g;

        public ScanSeedObserver(Observer observer, BiFunction biFunction, Object obj) {
            this.c = observer;
            this.d = biFunction;
            this.e = obj;
        }

        public final void dispose() {
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            if (!this.g) {
                this.g = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.b(th);
                return;
            }
            this.g = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.g) {
                try {
                    Object apply = this.d.apply(this.e, obj);
                    ObjectHelper.b(apply, "The accumulator returned a null value");
                    this.e = apply;
                    this.c.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.f.dispose();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                Observer observer = this.c;
                observer.onSubscribe(this);
                observer.onNext(this.e);
            }
        }
    }

    public ObservableScanSeed(Observable observable, Callable callable, BiFunction biFunction) {
        super(observable);
        this.d = biFunction;
        this.e = callable;
    }

    public final void subscribeActual(Observer observer) {
        try {
            Object call = this.e.call();
            ObjectHelper.b(call, "The seed supplied is null");
            this.c.subscribe(new ScanSeedObserver(observer, this.d, call));
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
