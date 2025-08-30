package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {
    public final Observable c;
    public final Object d;

    public static final class LastObserver<T> implements Observer<T>, Disposable {
        public final SingleObserver c;
        public final Object d;
        public Disposable e;
        public Object f;

        public LastObserver(SingleObserver singleObserver, Object obj) {
            this.c = singleObserver;
            this.d = obj;
        }

        public final void dispose() {
            this.e.dispose();
            this.e = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            if (this.e == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            this.e = DisposableHelper.DISPOSED;
            Object obj = this.f;
            SingleObserver singleObserver = this.c;
            if (obj != null) {
                this.f = null;
                singleObserver.onSuccess(obj);
                return;
            }
            Object obj2 = this.d;
            if (obj2 != null) {
                singleObserver.onSuccess(obj2);
            } else {
                singleObserver.onError(new NoSuchElementException());
            }
        }

        public final void onError(Throwable th) {
            this.e = DisposableHelper.DISPOSED;
            this.f = null;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.f = obj;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableLastSingle(Observable observable, Object obj) {
        this.c = observable;
        this.d = obj;
    }

    public final void c(SingleObserver singleObserver) {
        this.c.subscribe(new LastObserver(singleObserver, this.d));
    }
}
