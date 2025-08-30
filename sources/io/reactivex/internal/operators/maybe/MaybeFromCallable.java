package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {
    public final void c(MaybeObserver maybeObserver) {
        Disposable a2 = Disposables.a(Functions.b);
        maybeObserver.onSubscribe(a2);
        if (!a2.isDisposed()) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                if (!a2.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.b(th);
                }
            }
        }
    }

    public final Object call() {
        throw null;
    }
}
