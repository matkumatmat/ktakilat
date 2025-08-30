package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    public final Observable c;
    public final Predicate d;

    public static final class AllObserver<T> implements Observer<T>, Disposable {
        public final SingleObserver c;
        public final Predicate d;
        public Disposable e;
        public boolean f;

        public AllObserver(SingleObserver singleObserver, Predicate predicate) {
            this.c = singleObserver;
            this.d = predicate;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                this.c.onSuccess(Boolean.TRUE);
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                try {
                    if (!this.d.test(obj)) {
                        this.f = true;
                        this.e.dispose();
                        this.c.onSuccess(Boolean.FALSE);
                    }
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

    public ObservableAllSingle(Observable observable, Predicate predicate) {
        this.c = observable;
        this.d = predicate;
    }

    public final Observable a() {
        return new ObservableAll(this.c, this.d);
    }

    public final void c(SingleObserver singleObserver) {
        this.c.subscribe(new AllObserver(singleObserver, this.d));
    }
}
