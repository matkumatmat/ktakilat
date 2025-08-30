package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray extends Completable {

    public static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -8360547806504310570L;

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                throw null;
            }
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }
    }

    public final void c(CompletableObserver completableObserver) {
        new AtomicBoolean();
        throw null;
    }
}
