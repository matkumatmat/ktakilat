package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUnsubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        public final MaybeObserver c;
        public Disposable d;

        public UnsubscribeOnMaybeObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable disposable = (Disposable) getAndSet(disposableHelper);
            if (disposable != disposableHelper) {
                this.d = disposable;
                throw null;
            }
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.c.onSuccess(obj);
        }

        public final void run() {
            this.d.dispose();
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        new UnsubscribeOnMaybeObserver(maybeObserver);
        throw null;
    }
}
