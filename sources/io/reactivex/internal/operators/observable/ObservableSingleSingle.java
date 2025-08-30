package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableSingleSingle<T> extends Single<T> {
    public final Observable c;
    public final Object d;

    public static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        public final SingleObserver c;
        public final Object d;
        public Disposable e;
        public Object f;
        public boolean g;

        public SingleElementObserver(SingleObserver singleObserver, Object obj) {
            this.c = singleObserver;
            this.d = obj;
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
                Object obj = this.f;
                this.f = null;
                if (obj == null) {
                    obj = this.d;
                }
                SingleObserver singleObserver = this.c;
                if (obj != null) {
                    singleObserver.onSuccess(obj);
                } else {
                    singleObserver.onError(new NoSuchElementException());
                }
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
                if (this.f != null) {
                    this.g = true;
                    this.e.dispose();
                    this.c.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f = obj;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSingleSingle(Observable observable, Object obj) {
        this.c = observable;
        this.d = obj;
    }

    public final void c(SingleObserver singleObserver) {
        this.c.subscribe(new SingleElementObserver(singleObserver, this.d));
    }
}
