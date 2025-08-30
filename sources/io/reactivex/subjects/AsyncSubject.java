package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class AsyncSubject<T> extends Subject<T> {

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        public final AsyncSubject e;

        public AsyncDisposable(Observer observer, AsyncSubject asyncSubject) {
            super(observer);
            this.e = asyncSubject;
        }

        public final void dispose() {
            if (tryDispose()) {
                this.e.getClass();
                throw null;
            }
        }
    }

    public final void onComplete() {
        throw null;
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        throw null;
    }

    public final void onNext(Object obj) {
        ObjectHelper.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
        throw null;
    }

    public final void subscribeActual(Observer observer) {
        observer.onSubscribe(new AsyncDisposable(observer, this));
        throw null;
    }
}
