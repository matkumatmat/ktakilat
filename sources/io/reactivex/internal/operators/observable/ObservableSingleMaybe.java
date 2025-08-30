package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableSingleMaybe<T> extends Maybe<T> {
    public final Observable c;

    public static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        public final MaybeObserver c;
        public Disposable d;
        public Object e;
        public boolean f;

        public SingleElementObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            this.d.dispose();
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                Object obj = this.e;
                this.e = null;
                MaybeObserver maybeObserver = this.c;
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
                }
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
                if (this.e != null) {
                    this.f = true;
                    this.d.dispose();
                    this.c.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.e = obj;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSingleMaybe(Observable observable) {
        this.c = observable;
    }

    public final void c(MaybeObserver maybeObserver) {
        this.c.subscribe(new SingleElementObserver(maybeObserver));
    }
}
