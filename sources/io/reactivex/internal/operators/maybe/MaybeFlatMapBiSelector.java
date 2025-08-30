package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {

    public static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {
        public final InnerObserver c;

        public static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            public final MaybeObserver c;
            public Object d;

            public InnerObserver(MaybeObserver maybeObserver) {
                this.c = maybeObserver;
            }

            public final void onComplete() {
                this.c.onComplete();
            }

            public final void onError(Throwable th) {
                this.c.onError(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onSuccess(Object obj) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.c.onError(th);
                }
            }
        }

        public FlatMapBiMainObserver(MaybeObserver maybeObserver) {
            this.c = new InnerObserver(maybeObserver);
        }

        public final void dispose() {
            DisposableHelper.dispose(this.c);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.c.get());
        }

        public final void onComplete() {
            this.c.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            InnerObserver innerObserver = this.c;
            if (DisposableHelper.setOnce(innerObserver, disposable)) {
                innerObserver.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.c.c.onError(th);
            }
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        new FlatMapBiMainObserver(maybeObserver);
        throw null;
    }
}
