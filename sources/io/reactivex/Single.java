package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;

public abstract class Single<T> implements SingleSource<T> {
    public final void b(SingleObserver singleObserver) {
        ObjectHelper.b(singleObserver, "subscriber is null");
        try {
            c(singleObserver);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.a(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void c(SingleObserver singleObserver);
}
