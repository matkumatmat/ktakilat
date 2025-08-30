package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableLastMaybe<T> extends Maybe<T> {
    public final Observable c;

    public static final class LastObserver<T> implements Observer<T>, Disposable {
        public final MaybeObserver c;
        public Disposable d;
        public Object e;

        public LastObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            if (this.d == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            Object obj = this.e;
            MaybeObserver maybeObserver = this.c;
            if (obj != null) {
                this.e = null;
                maybeObserver.onSuccess(obj);
                return;
            }
            maybeObserver.onComplete();
        }

        public final void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            this.e = null;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.e = obj;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableLastMaybe(Observable observable) {
        this.c = observable;
    }

    public final void c(MaybeObserver maybeObserver) {
        this.c.subscribe(new LastObserver(maybeObserver));
    }
}
