package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {
    public final Observable c;
    public final long d;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        public final MaybeObserver c;
        public final long d;
        public Disposable e;
        public long f;
        public boolean g;

        public ElementAtObserver(MaybeObserver maybeObserver, long j) {
            this.c = maybeObserver;
            this.d = j;
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
                long j = this.f;
                if (j == this.d) {
                    this.g = true;
                    this.e.dispose();
                    this.c.onSuccess(obj);
                    return;
                }
                this.f = j + 1;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtMaybe(Observable observable, long j) {
        this.c = observable;
        this.d = j;
    }

    public final Observable a() {
        return new ObservableElementAt(this.c, this.d, (Object) null, false);
    }

    public final void c(MaybeObserver maybeObserver) {
        this.c.subscribe(new ElementAtObserver(maybeObserver, this.d));
    }
}
