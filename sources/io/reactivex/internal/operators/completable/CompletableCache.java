package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

@Experimental
public final class CompletableCache extends Completable implements CompletableObserver {

    public final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        public final CompletableObserver c;

        public InnerCompletableCache(CompletableObserver completableObserver) {
            this.c = completableObserver;
        }

        public final void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.getClass();
                throw null;
            }
        }

        public final boolean isDisposed() {
            return get();
        }
    }

    public final void c(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new InnerCompletableCache(completableObserver));
        throw null;
    }

    public final void onComplete() {
        throw null;
    }

    public final void onError(Throwable th) {
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
    }
}
