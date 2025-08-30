package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableDelay extends Completable {

    public static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
        private static final long serialVersionUID = 465972761105851022L;
        public final CompletableObserver c;
        public Throwable d;

        public Delay(CompletableObserver completableObserver) {
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
            this.d = null;
            CompletableObserver completableObserver = this.c;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        }
    }

    public final void c(CompletableObserver completableObserver) {
        new Delay(completableObserver);
        throw null;
    }
}
