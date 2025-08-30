package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn<T> extends Single<T> {

    public static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        public final SingleObserver c;
        public Object d;
        public Throwable e;

        public ObserveOnSingleObserver(SingleObserver singleObserver) {
            this.c = singleObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onError(Throwable th) {
            this.e = th;
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.d = obj;
            throw null;
        }

        public final void run() {
            Throwable th = this.e;
            SingleObserver singleObserver = this.c;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.d);
            }
        }
    }

    public final void c(SingleObserver singleObserver) {
        new ObserveOnSingleObserver(singleObserver);
        throw null;
    }
}
