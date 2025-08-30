package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {

    public static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {
        public Disposable c;
        public volatile Iterator d;
        public volatile boolean e;

        public final void clear() {
            this.d = null;
        }

        public final void dispose() {
            this.e = true;
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.e;
        }

        public final boolean isEmpty() {
            if (this.d == null) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            this.c = DisposableHelper.DISPOSED;
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                throw null;
            }
        }

        public final void onSuccess(Object obj) {
            throw null;
        }

        public final Object poll() {
            Iterator it = this.d;
            if (it == null) {
                return null;
            }
            Object next = it.next();
            ObjectHelper.b(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.d = null;
            }
            return next;
        }

        public final int requestFusion(int i) {
            return (i & 2) != 0 ? 2 : 0;
        }
    }

    public final void subscribeActual(Observer observer) {
        throw null;
    }
}
