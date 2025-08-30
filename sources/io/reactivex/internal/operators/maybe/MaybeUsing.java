package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUsing<T, D> extends Maybe<T> {

    public static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -674404550052917487L;
        public Disposable c;

        public final void dispose() {
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
            if (getAndSet(this) != this) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    RxJavaPlugins.b(th);
                }
            }
        }

        public final boolean isDisposed() {
            return this.c.isDisposed();
        }

        public final void onComplete() {
            this.c = DisposableHelper.DISPOSED;
            throw null;
        }

        public final void onError(Throwable th) {
            this.c = DisposableHelper.DISPOSED;
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                throw null;
            }
        }

        public final void onSuccess(Object obj) {
            this.c = DisposableHelper.DISPOSED;
            throw null;
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
