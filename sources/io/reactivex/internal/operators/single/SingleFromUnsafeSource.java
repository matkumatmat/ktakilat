package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public final class SingleFromUnsafeSource<T> extends Single<T> {
    public final void c(SingleObserver singleObserver) {
        throw null;
    }
}
