package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public final class CompletableToSingle<T> extends Single<T> {

    public final class ToSingle implements CompletableObserver {
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

    public final void c(SingleObserver singleObserver) {
        throw null;
    }
}
