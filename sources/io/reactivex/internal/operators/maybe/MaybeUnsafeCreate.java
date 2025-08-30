package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;

public final class MaybeUnsafeCreate<T> extends AbstractMaybeWithUpstream<T, T> {
    public final void c(MaybeObserver maybeObserver) {
        throw null;
    }
}
