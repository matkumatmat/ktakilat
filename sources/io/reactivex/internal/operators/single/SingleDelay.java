package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class SingleDelay<T> extends Single<T> {

    public final class Delay implements SingleObserver<T> {

        public final class OnError implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public final class OnSuccess implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }

        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    public final void c(SingleObserver singleObserver) {
        singleObserver.onSubscribe(new SequentialDisposable());
        throw null;
    }
}
