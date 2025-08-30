package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate<T> extends Observable<T> {
    public final ObservableOnSubscribe c;

    public static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;
        public final Observer c;

        public CreateEmitter(Observer observer) {
            this.c = observer;
        }

        public final void a(Disposable disposable) {
            DisposableHelper.set(this, disposable);
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            if (!isDisposed()) {
                try {
                    this.c.onComplete();
                } finally {
                    DisposableHelper.dispose(this);
                }
            }
        }

        public final void onError(Throwable th) {
            if (!isDisposed()) {
                try {
                    this.c.onError(th);
                } finally {
                    DisposableHelper.dispose(this);
                }
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onNext(Object obj) {
            if (obj == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!isDisposed()) {
                this.c.onNext(obj);
            }
        }

        public final String toString() {
            String simpleName = CreateEmitter.class.getSimpleName();
            String atomicReference = super.toString();
            return simpleName + "{" + atomicReference + "}";
        }
    }

    public static final class SerializedEmitter<T> extends AtomicInteger implements ObservableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;

        public final void a(Disposable disposable) {
            throw null;
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public ObservableCreate(ObservableOnSubscribe observableOnSubscribe) {
        this.c = observableOnSubscribe;
    }

    public final void subscribeActual(Observer observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.onSubscribe(createEmitter);
        try {
            this.c.d(createEmitter);
        } catch (Throwable th) {
            Exceptions.a(th);
            createEmitter.onError(th);
        }
    }
}
