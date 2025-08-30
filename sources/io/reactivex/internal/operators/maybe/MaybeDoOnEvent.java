package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        public Disposable c;

        public final void dispose() {
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.c.isDisposed();
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            this.c = DisposableHelper.DISPOSED;
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                new CompositeException(th, th2);
                throw null;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                throw null;
            }
        }

        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        throw null;
    }
}
