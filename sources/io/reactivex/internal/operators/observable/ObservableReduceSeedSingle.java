package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceSeedSingle<T, R> extends Single<R> {
    public final Observable c;
    public final Object d;
    public final BiFunction e;

    public static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
        public final SingleObserver c;
        public final BiFunction d;
        public Object e;
        public Disposable f;

        public ReduceSeedObserver(SingleObserver singleObserver, BiFunction biFunction, Object obj) {
            this.c = singleObserver;
            this.e = obj;
            this.d = biFunction;
        }

        public final void dispose() {
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            Object obj = this.e;
            if (obj != null) {
                this.e = null;
                this.c.onSuccess(obj);
            }
        }

        public final void onError(Throwable th) {
            if (this.e != null) {
                this.e = null;
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            Object obj2 = this.e;
            if (obj2 != null) {
                try {
                    Object apply = this.d.apply(obj2, obj);
                    ObjectHelper.b(apply, "The reducer returned a null value");
                    this.e = apply;
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
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableReduceSeedSingle(Observable observable, Object obj, BiFunction biFunction) {
        this.c = observable;
        this.d = obj;
        this.e = biFunction;
    }

    public final void c(SingleObserver singleObserver) {
        this.c.subscribe(new ReduceSeedObserver(singleObserver, this.e, this.d));
    }
}
