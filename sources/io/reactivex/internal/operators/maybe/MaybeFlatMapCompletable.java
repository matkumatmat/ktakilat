package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapCompletable<T> extends Completable {

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;
        public final CompletableObserver c;

        public FlatMapCompletableObserver(CompletableObserver completableObserver) {
            this.c = completableObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
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
            DisposableHelper.replace(this, disposable);
        }

        public final void onSuccess(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                onError(th);
            }
        }
    }

    public final void c(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new FlatMapCompletableObserver(completableObserver));
        throw null;
    }
}
