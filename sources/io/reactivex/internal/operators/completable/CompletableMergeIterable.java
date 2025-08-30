package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableMergeIterable extends Completable {

    public static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
        private static final long serialVersionUID = -7730517613164279224L;

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.disposables.Disposable, java.lang.Object] */
    public final void c(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new Object());
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            completableObserver.onError(th);
        }
    }
}
