package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
public final class SingleDetach<T> extends Single<T> {

    public static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        public SingleObserver c;
        public Disposable d;

        public final void dispose() {
            this.c = null;
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            SingleObserver singleObserver = this.c;
            if (singleObserver != null) {
                this.c = null;
                singleObserver.onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.d = DisposableHelper.DISPOSED;
            SingleObserver singleObserver = this.c;
            if (singleObserver != null) {
                this.c = null;
                singleObserver.onSuccess(obj);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.internal.operators.single.SingleDetach$DetachSingleObserver, java.lang.Object] */
    public final void c(SingleObserver singleObserver) {
        new Object().c = singleObserver;
        throw null;
    }
}
