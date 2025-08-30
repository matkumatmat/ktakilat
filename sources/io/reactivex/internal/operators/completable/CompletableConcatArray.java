package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray extends Completable {

    public static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        public final CompletableObserver c;
        public int d;
        public final SequentialDisposable e = new SequentialDisposable();

        public ConcatInnerObserver(CompletableObserver completableObserver) {
            this.c = completableObserver;
        }

        public final void a() {
            SequentialDisposable sequentialDisposable = this.e;
            if (!sequentialDisposable.isDisposed() && getAndIncrement() == 0 && !sequentialDisposable.isDisposed()) {
                this.d++;
                throw null;
            }
        }

        public final void onComplete() {
            a();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.e.replace(disposable);
        }
    }

    public final void c(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver);
        completableObserver.onSubscribe(concatInnerObserver.e);
        concatInnerObserver.a();
    }
}
