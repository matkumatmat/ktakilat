package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {

    public static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {
        public Disposable c;

        public final void dispose() {
            Disposable disposable = this.c;
            this.c = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public final boolean isDisposed() {
            return this.c.isDisposed();
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
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
