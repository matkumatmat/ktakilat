package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableTimeout extends Completable {

    public final class DisposeTask implements Runnable {

        public final class DisposeObserver implements CompletableObserver {
            public final void onComplete() {
                throw null;
            }

            public final void onError(Throwable th) {
                throw null;
            }

            public final void onSubscribe(Disposable disposable) {
                throw null;
            }
        }

        public final void run() {
            throw null;
        }
    }

    public static final class TimeOutObserver implements CompletableObserver {
        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.disposables.Disposable, java.lang.Object] */
    public final void c(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new Object());
        new AtomicBoolean();
        throw null;
    }
}
