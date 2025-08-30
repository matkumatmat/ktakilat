package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class SingleJust<T> extends Single<T> {
    public final void c(SingleObserver singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.INSTANCE);
        singleObserver.onSuccess((Object) null);
    }
}
