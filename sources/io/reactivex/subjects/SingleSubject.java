package io.reactivex.subjects;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {

    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        public final SingleObserver c;

        public SingleDisposable(SingleObserver singleObserver, SingleSubject singleSubject) {
            this.c = singleObserver;
            lazySet(singleSubject);
        }

        public final void dispose() {
            if (((SingleSubject) getAndSet((Object) null)) != null) {
                throw null;
            }
        }

        public final boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }
    }

    public final void c(SingleObserver singleObserver) {
        singleObserver.onSubscribe(new SingleDisposable(singleObserver, this));
        throw null;
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
        throw null;
    }

    public final void onSuccess(Object obj) {
        ObjectHelper.b(obj, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        throw null;
    }
}
