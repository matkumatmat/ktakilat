package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public final class SingleDoOnSubscribe<T> extends Single<T> {

    public static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {
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

    public final void c(SingleObserver singleObserver) {
        throw null;
    }
}
