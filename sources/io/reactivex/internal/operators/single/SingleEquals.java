package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleEquals<T> extends Single<Boolean> {

    public static class InnerObserver<T> implements SingleObserver<T> {
        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }

        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.disposables.Disposable, java.lang.Object] */
    public final void c(SingleObserver singleObserver) {
        new AtomicInteger();
        singleObserver.onSubscribe(new Object());
        throw null;
    }
}
