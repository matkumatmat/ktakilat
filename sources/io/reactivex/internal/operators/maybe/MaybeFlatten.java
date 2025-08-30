package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten<T, R> extends AbstractMaybeWithUpstream<T, R> {

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        public final MaybeObserver c;
        public Disposable d;

        public final class InnerObserver implements MaybeObserver<R> {
            public final void onComplete() {
                throw null;
            }

            public final void onError(Throwable th) {
                throw null;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce((AtomicReference<Disposable>) null, disposable);
            }

            public final void onSuccess(Object obj) {
                throw null;
            }
        }

        public FlatMapMaybeObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
            this.d.dispose();
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
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            try {
                throw null;
            } catch (Exception e) {
                Exceptions.a(e);
                this.c.onError(e);
            }
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        new FlatMapMaybeObserver(maybeObserver);
        throw null;
    }
}
