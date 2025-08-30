package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.ExecutionException;

public final class MaybeFromFuture<T> extends Maybe<T> {
    public final void c(MaybeObserver maybeObserver) {
        Disposable a2 = Disposables.a(Functions.b);
        maybeObserver.onSubscribe(a2);
        if (!a2.isDisposed()) {
            try {
                throw null;
            } catch (Throwable th) {
                th = th;
                if (th instanceof ExecutionException) {
                    th = th.getCause();
                }
                Exceptions.a(th);
                if (!a2.isDisposed()) {
                    maybeObserver.onError(th);
                }
            }
        }
    }
}
