package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    public Object c;

    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        public final SingleObserver c;
        public final SingleCache d;

        public CacheDisposable(SingleObserver singleObserver, SingleCache singleCache) {
            this.c = singleObserver;
            this.d = singleCache;
        }

        public final void dispose() {
            if (compareAndSet(false, true)) {
                this.d.getClass();
                throw null;
            }
        }

        public final boolean isDisposed() {
            return get();
        }
    }

    public final void c(SingleObserver singleObserver) {
        singleObserver.onSubscribe(new CacheDisposable(singleObserver, this));
        throw null;
    }

    public final void onError(Throwable th) {
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
    }

    public final void onSuccess(Object obj) {
        this.c = obj;
        throw null;
    }
}
