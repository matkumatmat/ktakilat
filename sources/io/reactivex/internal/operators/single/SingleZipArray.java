package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R> extends Single<R> {

    public final class SingletonArrayFunc implements Function<T, R> {
        public final Object apply(Object obj) {
            throw null;
        }
    }

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;

        public final void dispose() {
            if (getAndSet(0) > 0) {
                throw null;
            }
        }

        public final boolean isDisposed() {
            if (get() <= 0) {
                return true;
            }
            return false;
        }
    }

    public static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    public final void c(SingleObserver singleObserver) {
        throw null;
    }
}
