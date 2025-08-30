package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public final class CompletableFromSingle<T> extends Completable {

    public static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }

        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    public final void c(CompletableObserver completableObserver) {
        throw null;
    }
}
