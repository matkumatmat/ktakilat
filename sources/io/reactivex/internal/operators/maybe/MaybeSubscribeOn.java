package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {

    public static final class SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 8571289934935992137L;
        public final SequentialDisposable c = new SequentialDisposable();
        public final MaybeObserver d;

        public SubscribeOnMaybeObserver(MaybeObserver maybeObserver) {
            this.d = maybeObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
            this.c.dispose();
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            this.d.onComplete();
        }

        public final void onError(Throwable th) {
            this.d.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(Object obj) {
            this.d.onSuccess(obj);
        }
    }

    public static final class SubscribeTask<T> implements Runnable {
        public final void run() {
            throw null;
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        maybeObserver.onSubscribe(new SubscribeOnMaybeObserver(maybeObserver));
        throw null;
    }
}
