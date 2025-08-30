package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleFromCallable<T> extends Single<T> {
    public final void c(SingleObserver singleObserver) {
        Disposable a2 = Disposables.a(Functions.b);
        singleObserver.onSubscribe(a2);
        if (!a2.isDisposed()) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                if (!a2.isDisposed()) {
                    singleObserver.onError(th);
                } else {
                    RxJavaPlugins.b(th);
                }
            }
        }
    }
}
