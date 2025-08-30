package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;

public final class CompletableDoOnEvent extends Completable {

    public final class DoOnEvent implements CompletableObserver {
        public final void onComplete() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                throw null;
            }
        }

        public final void onError(Throwable th) {
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                new CompositeException(th, th2);
                throw null;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }
    }

    public final void c(CompletableObserver completableObserver) {
        throw null;
    }
}
