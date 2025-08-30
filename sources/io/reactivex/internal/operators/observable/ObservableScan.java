package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
    public final BiFunction d;

    public static final class ScanObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public final BiFunction d;
        public Disposable e;
        public Object f;
        public boolean g;

        public ScanObserver(Observer observer, BiFunction biFunction) {
            this.c = observer;
            this.d = biFunction;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
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
                Object obj2 = this.f;
                Observer observer = this.c;
                if (obj2 == null) {
                    this.f = obj;
                    observer.onNext(obj);
                    return;
                }
                try {
                    Object apply = this.d.apply(obj2, obj);
                    ObjectHelper.b(apply, "The value returned by the accumulator is null");
                    this.f = apply;
                    observer.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.e.dispose();
                    onError(th);
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

    public ObservableScan(Observable observable, BiFunction biFunction) {
        super(observable);
        this.d = biFunction;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new ScanObserver(observer, this.d));
    }
}
