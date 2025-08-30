package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        public final Observer c;
        public Disposable d;
        public volatile Iterator e;
        public volatile boolean f;

        public FlatMapIterableObserver(Observer observer) {
            this.c = observer;
        }

        public final void clear() {
            this.e = null;
        }

        public final void dispose() {
            this.f = true;
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final boolean isEmpty() {
            if (this.e == null) {
                return true;
            }
            return false;
        }

        public final void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            this.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.c.onError(th);
            }
        }

        public final Object poll() {
            Iterator it = this.e;
            if (it == null) {
                return null;
            }
            Object next = it.next();
            ObjectHelper.b(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.e = null;
            }
            return next;
        }

        public final int requestFusion(int i) {
            return (i & 2) != 0 ? 2 : 0;
        }
    }

    public final void subscribeActual(Observer observer) {
        new FlatMapIterableObserver(observer);
        throw null;
    }
}
