package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.Functions;

public final class CompletableFromAction extends Completable {
    public final void c(CompletableObserver completableObserver) {
        Disposable a2 = Disposables.a(Functions.b);
        completableObserver.onSubscribe(a2);
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            if (!a2.isDisposed()) {
                completableObserver.onError(th);
            }
        }
    }
}
