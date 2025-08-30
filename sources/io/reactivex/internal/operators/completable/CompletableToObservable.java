package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class CompletableToObservable<T> extends Observable<T> {

    public static final class ObserverCompletableObserver extends BasicQueueDisposable<Void> implements CompletableObserver {
        public Disposable c;

        public final void clear() {
        }

        public final void dispose() {
            this.c.dispose();
        }

        public final boolean isDisposed() {
            return this.c.isDisposed();
        }

        public final boolean isEmpty() {
            return true;
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                throw null;
            }
        }

        public final /* bridge */ /* synthetic */ Object poll() {
            return null;
        }

        public final int requestFusion(int i) {
            return i & 2;
        }
    }

    public final void subscribeActual(Observer observer) {
        throw null;
    }
}
