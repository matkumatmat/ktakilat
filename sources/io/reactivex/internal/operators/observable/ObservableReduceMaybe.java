package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceMaybe<T> extends Maybe<T> {
    public final Observable c;
    public final BiFunction d;

    public static final class ReduceObserver<T> implements Observer<T>, Disposable {
        public final MaybeObserver c;
        public final BiFunction d;
        public boolean e;
        public Object f;
        public Disposable g;

        public ReduceObserver(MaybeObserver maybeObserver, BiFunction biFunction) {
            this.c = maybeObserver;
            this.d = biFunction;
        }

        public final void dispose() {
            this.g.dispose();
        }

        public final boolean isDisposed() {
            return this.g.isDisposed();
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                Object obj = this.f;
                this.f = null;
                MaybeObserver maybeObserver = this.c;
                if (obj != null) {
                    maybeObserver.onSuccess(obj);
                } else {
                    maybeObserver.onComplete();
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            this.f = null;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                Object obj2 = this.f;
                if (obj2 == null) {
                    this.f = obj;
                    return;
                }
                try {
                    Object apply = this.d.apply(obj2, obj);
                    ObjectHelper.b(apply, "The reducer returned a null value");
                    this.f = apply;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.g.dispose();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableReduceMaybe(Observable observable, BiFunction biFunction) {
        this.c = observable;
        this.d = biFunction;
    }

    public final void c(MaybeObserver maybeObserver) {
        this.c.subscribe(new ReduceObserver(maybeObserver, this.d));
    }
}
