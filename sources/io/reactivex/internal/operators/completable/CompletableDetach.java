package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
public final class CompletableDetach extends Completable {

    public static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        public CompletableObserver c;
        public Disposable d;

        public final void dispose() {
            this.c = null;
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.c;
            if (completableObserver != null) {
                this.c = null;
                completableObserver.onComplete();
            }
        }

        public final void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.c;
            if (completableObserver != null) {
                this.c = null;
                completableObserver.onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.internal.operators.completable.CompletableDetach$DetachCompletableObserver, java.lang.Object] */
    public final void c(CompletableObserver completableObserver) {
        new Object().c = completableObserver;
        throw null;
    }
}
