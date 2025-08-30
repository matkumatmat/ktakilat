package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn extends Completable {

    public static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        public final CompletableObserver c;
        public final SequentialDisposable d = new SequentialDisposable();

        public SubscribeOnObserver(CompletableObserver completableObserver) {
            this.c = completableObserver;
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
            DisposableHelper.setOnce(this, disposable);
        }

        public final void run() {
            throw null;
        }
    }

    public final void c(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new SubscribeOnObserver(completableObserver));
        throw null;
    }
}
