package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableObserveOn extends Completable {

    public static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        public final CompletableObserver c;
        public Throwable d;

        public ObserveOnCompletableObserver(CompletableObserver completableObserver) {
            this.c = completableObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            this.d = th;
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.c.onSubscribe(this);
            }
        }

        public final void run() {
            Throwable th = this.d;
            CompletableObserver completableObserver = this.c;
            if (th != null) {
                this.d = null;
                completableObserver.onError(th);
                return;
            }
            completableObserver.onComplete();
        }
    }

    public final void c(CompletableObserver completableObserver) {
        new ObserveOnCompletableObserver(completableObserver);
        throw null;
    }
}
