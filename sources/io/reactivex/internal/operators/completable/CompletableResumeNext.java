package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class CompletableResumeNext extends Completable {

    public final class ResumeNext implements CompletableObserver {

        public final class OnErrorObserver implements CompletableObserver {
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

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                new CompositeException(th2, th);
                throw null;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }
    }

    public final void c(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new SequentialDisposable());
        throw null;
    }
}
