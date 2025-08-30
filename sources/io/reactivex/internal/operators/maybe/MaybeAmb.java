package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MaybeAmb<T> extends Maybe<T> {

    public static final class AmbMaybeObserver<T> extends AtomicBoolean implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -7044685185359438206L;

        public final void dispose() {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public final boolean isDisposed() {
            return get();
        }

        public final void onComplete() {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                RxJavaPlugins.b(th);
                return;
            }
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }

        public final void onSuccess(Object obj) {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (MaybeObserver<?>) maybeObserver);
        }
    }
}
