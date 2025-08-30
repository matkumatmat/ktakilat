package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class MaybeNever extends Maybe<Object> {
    public final void c(MaybeObserver maybeObserver) {
        maybeObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
