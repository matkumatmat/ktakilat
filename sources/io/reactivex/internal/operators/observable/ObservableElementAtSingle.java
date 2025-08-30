package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {
    public final Observable c;
    public final long d;
    public final Object e;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        public final SingleObserver c;
        public final long d;
        public final Object e;
        public Disposable f;
        public long g;
        public boolean i;

        public ElementAtObserver(SingleObserver singleObserver, long j, Object obj) {
            this.c = singleObserver;
            this.d = j;
            this.e = obj;
        }

        public final void dispose() {
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            if (!this.i) {
                this.i = true;
                SingleObserver singleObserver = this.c;
                Object obj = this.e;
                if (obj != null) {
                    singleObserver.onSuccess(obj);
                } else {
                    singleObserver.onError(new NoSuchElementException());
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.b(th);
                return;
            }
            this.i = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.i) {
                long j = this.g;
                if (j == this.d) {
                    this.i = true;
                    this.f.dispose();
                    this.c.onSuccess(obj);
                    return;
                }
                this.g = j + 1;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtSingle(Observable observable, long j, Object obj) {
        this.c = observable;
        this.d = j;
        this.e = obj;
    }

    public final Observable a() {
        return new ObservableElementAt(this.c, this.d, this.e, true);
    }

    public final void c(SingleObserver singleObserver) {
        this.c.subscribe(new ElementAtObserver(singleObserver, this.d, this.e));
    }
}
