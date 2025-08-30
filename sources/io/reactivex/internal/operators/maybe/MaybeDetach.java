package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        public MaybeObserver c;
        public Disposable d;

        public final void dispose() {
            this.c = null;
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            MaybeObserver maybeObserver = this.c;
            if (maybeObserver != null) {
                this.c = null;
                maybeObserver.onComplete();
            }
        }

        public final void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            MaybeObserver maybeObserver = this.c;
            if (maybeObserver != null) {
                this.c = null;
                maybeObserver.onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.d = DisposableHelper.DISPOSED;
            MaybeObserver maybeObserver = this.c;
            if (maybeObserver != null) {
                this.c = null;
                maybeObserver.onSuccess(obj);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.internal.operators.maybe.MaybeDetach$DetachMaybeObserver, java.lang.Object] */
    public final void c(MaybeObserver maybeObserver) {
        new Object().c = maybeObserver;
        throw null;
    }
}
