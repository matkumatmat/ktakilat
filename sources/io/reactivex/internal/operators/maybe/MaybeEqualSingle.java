package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeEqualSingle<T> extends Single<Boolean> {

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        public final SingleObserver c;
        public final EqualObserver d = new EqualObserver(this);
        public final EqualObserver e = new EqualObserver(this);

        public EqualCoordinator(SingleObserver singleObserver) {
            super(2);
            this.c = singleObserver;
        }

        public final void a() {
            boolean z;
            if (decrementAndGet() == 0) {
                Object obj = this.d.d;
                Object obj2 = this.e.d;
                SingleObserver singleObserver = this.c;
                if (obj == null || obj2 == null) {
                    if (obj == null && obj2 == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    singleObserver.onSuccess(Boolean.valueOf(z));
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    singleObserver.onError(th);
                }
            }
        }

        public final void dispose() {
            EqualObserver equalObserver = this.d;
            equalObserver.getClass();
            DisposableHelper.dispose(equalObserver);
            EqualObserver equalObserver2 = this.e;
            equalObserver2.getClass();
            DisposableHelper.dispose(equalObserver2);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.d.get());
        }
    }

    public static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        public final EqualCoordinator c;
        public Object d;

        public EqualObserver(EqualCoordinator equalCoordinator) {
            this.c = equalCoordinator;
        }

        public final void onComplete() {
            this.c.a();
        }

        public final void onError(Throwable th) {
            EqualCoordinator equalCoordinator = this.c;
            if (equalCoordinator.getAndSet(0) > 0) {
                EqualObserver equalObserver = equalCoordinator.d;
                if (this == equalObserver) {
                    EqualObserver equalObserver2 = equalCoordinator.e;
                    equalObserver2.getClass();
                    DisposableHelper.dispose(equalObserver2);
                } else {
                    equalObserver.getClass();
                    DisposableHelper.dispose(equalObserver);
                }
                equalCoordinator.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(Object obj) {
            this.d = obj;
            this.c.a();
        }
    }

    public final void c(SingleObserver singleObserver) {
        singleObserver.onSubscribe(new EqualCoordinator(singleObserver));
        throw null;
    }
}
