package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableDisposeOn extends Completable {

    public static final class CompletableObserverImplementation implements CompletableObserver, Disposable, Runnable {
        public Disposable c;
        public volatile boolean d;

        public final void dispose() {
            this.d = true;
            throw null;
        }

        public final boolean isDisposed() {
            return this.d;
        }

        public final void onComplete() {
            if (!this.d) {
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
                return;
            }
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                throw null;
            }
        }

        public final void run() {
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
        }
    }

    public final void c(CompletableObserver completableObserver) {
        throw null;
    }
}
