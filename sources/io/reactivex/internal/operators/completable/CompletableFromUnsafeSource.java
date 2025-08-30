package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;

public final class CompletableFromUnsafeSource extends Completable {
    public final void c(CompletableObserver completableObserver) {
        throw null;
    }
}
