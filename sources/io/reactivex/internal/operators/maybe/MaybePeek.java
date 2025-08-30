package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        public DisposableHelper c;

        public final void a(Throwable th) {
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                new CompositeException(th, th2);
                this.c = DisposableHelper.DISPOSED;
                throw null;
            }
        }

        public final void dispose() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(th);
                this.c.dispose();
                this.c = DisposableHelper.DISPOSED;
            }
        }

        public final boolean isDisposed() {
            return this.c.isDisposed();
        }

        public final void onComplete() {
            if (this.c != DisposableHelper.DISPOSED) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    a(th);
                    throw null;
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.c == DisposableHelper.DISPOSED) {
                RxJavaPlugins.b(th);
            } else {
                a(th);
                throw null;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    disposable.dispose();
                    this.c = DisposableHelper.DISPOSED;
                    throw null;
                }
            }
        }

        public final void onSuccess(Object obj) {
            if (this.c != DisposableHelper.DISPOSED) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    a(th);
                    throw null;
                }
            }
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        throw null;
    }
}
