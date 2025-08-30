package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
public final class CompletableTakeUntilCompletable extends Completable {

    public static final class TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 3533011714830024923L;
        public final CompletableObserver c;
        public final OtherObserver d = new OtherObserver(this);
        public final AtomicBoolean e = new AtomicBoolean();

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5176264485428790318L;
            public final TakeUntilMainObserver c;

            public OtherObserver(TakeUntilMainObserver takeUntilMainObserver) {
                this.c = takeUntilMainObserver;
            }

            public final void onComplete() {
                TakeUntilMainObserver takeUntilMainObserver = this.c;
                if (takeUntilMainObserver.e.compareAndSet(false, true)) {
                    DisposableHelper.dispose(takeUntilMainObserver);
                    takeUntilMainObserver.c.onComplete();
                }
            }

            public final void onError(Throwable th) {
                TakeUntilMainObserver takeUntilMainObserver = this.c;
                if (takeUntilMainObserver.e.compareAndSet(false, true)) {
                    DisposableHelper.dispose(takeUntilMainObserver);
                    takeUntilMainObserver.c.onError(th);
                    return;
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public TakeUntilMainObserver(CompletableObserver completableObserver) {
            this.c = completableObserver;
        }

        public final void dispose() {
            if (this.e.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                DisposableHelper.dispose(this.d);
            }
        }

        public final boolean isDisposed() {
            return this.e.get();
        }

        public final void onComplete() {
            if (this.e.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.d);
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.e.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.d);
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public final void c(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new TakeUntilMainObserver(completableObserver));
        throw null;
    }
}
