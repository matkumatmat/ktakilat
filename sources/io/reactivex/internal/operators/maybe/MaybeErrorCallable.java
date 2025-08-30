package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class MaybeErrorCallable<T> extends Maybe<T> {
    public final void c(MaybeObserver maybeObserver) {
        maybeObserver.onSubscribe(EmptyDisposable.INSTANCE);
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            maybeObserver.onError(th);
        }
    }
}
