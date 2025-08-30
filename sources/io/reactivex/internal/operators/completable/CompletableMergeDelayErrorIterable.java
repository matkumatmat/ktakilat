package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.exceptions.Exceptions;

public final class CompletableMergeDelayErrorIterable extends Completable {
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
