package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

@Experimental
public final class SingleDoFinally<T> extends Single<T> {

    public static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;
        public final SingleObserver c;
        public Disposable d;

        public DoFinallyObserver(SingleObserver singleObserver) {
            this.c = singleObserver;
        }

        public final void a() {
            if (compareAndSet(0, 1)) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    RxJavaPlugins.b(th);
                }
            }
        }

        public final void dispose() {
            this.d.dispose();
            a();
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
            a();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.c.onSuccess(obj);
            a();
        }
    }

    public final void c(SingleObserver singleObserver) {
        new DoFinallyObserver(singleObserver);
        throw null;
    }
}
