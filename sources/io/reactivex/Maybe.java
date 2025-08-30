package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;

public abstract class Maybe<T> implements MaybeSource<T> {
    public final void b(MaybeObserver maybeObserver) {
        ObjectHelper.b(maybeObserver, "observer is null");
        try {
            c(maybeObserver);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.a(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void c(MaybeObserver maybeObserver);
}
