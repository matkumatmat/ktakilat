package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletablePeek extends Completable {

    public final class CompletableObserverImplementation implements CompletableObserver, Disposable {
        public DisposableHelper c;

        public final void dispose() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(th);
                this.c.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.c.isDisposed();
        }

        public final void onComplete() {
            if (this.c != DisposableHelper.DISPOSED) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.c == DisposableHelper.DISPOSED) {
                RxJavaPlugins.b(th);
                return;
            }
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                new CompositeException(th, th2);
                throw null;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                disposable.dispose();
                this.c = DisposableHelper.DISPOSED;
                throw null;
            }
        }
    }

    public final void c(CompletableObserver completableObserver) {
        throw null;
    }
}
