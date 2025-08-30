package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTakeUntilMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;
        public final MaybeObserver c;
        public final TakeUntilOtherMaybeObserver d = new TakeUntilOtherMaybeObserver(this);

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            public final TakeUntilMainMaybeObserver c;

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver takeUntilMainMaybeObserver) {
                this.c = takeUntilMainMaybeObserver;
            }

            public final void onComplete() {
                TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = this.c;
                takeUntilMainMaybeObserver.getClass();
                if (DisposableHelper.dispose(takeUntilMainMaybeObserver)) {
                    takeUntilMainMaybeObserver.c.onComplete();
                }
            }

            public final void onError(Throwable th) {
                TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = this.c;
                takeUntilMainMaybeObserver.getClass();
                if (DisposableHelper.dispose(takeUntilMainMaybeObserver)) {
                    takeUntilMainMaybeObserver.c.onError(th);
                } else {
                    RxJavaPlugins.b(th);
                }
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onSuccess(Object obj) {
                TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = this.c;
                takeUntilMainMaybeObserver.getClass();
                if (DisposableHelper.dispose(takeUntilMainMaybeObserver)) {
                    takeUntilMainMaybeObserver.c.onComplete();
                }
            }
        }

        public TakeUntilMainMaybeObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.d);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            DisposableHelper.dispose(this.d);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.c.onError(th);
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(Object obj) {
            DisposableHelper.dispose(this.d);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.c.onSuccess(obj);
            }
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        maybeObserver.onSubscribe(new TakeUntilMainMaybeObserver(maybeObserver));
        throw null;
    }
}
