package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeObserveOn<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        public final MaybeObserver c;
        public Object d;
        public Throwable e;

        public ObserveOnMaybeObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            this.e = th;
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.d = obj;
            throw null;
        }

        public final void run() {
            Throwable th = this.e;
            MaybeObserver maybeObserver = this.c;
            if (th != null) {
                this.e = null;
                maybeObserver.onError(th);
                return;
            }
            Object obj = this.d;
            if (obj != null) {
                this.d = null;
                maybeObserver.onSuccess(obj);
                return;
            }
            maybeObserver.onComplete();
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        new ObserveOnMaybeObserver(maybeObserver);
        throw null;
    }
}
