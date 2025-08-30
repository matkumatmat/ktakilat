package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class DetachObserver<T> implements Observer<T>, Disposable {
        public Observer c;
        public Disposable d;

        public final void dispose() {
            Disposable disposable = this.d;
            this.d = EmptyComponent.INSTANCE;
            this.c = EmptyComponent.asObserver();
            disposable.dispose();
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            Observer observer = this.c;
            this.d = EmptyComponent.INSTANCE;
            this.c = EmptyComponent.asObserver();
            observer.onComplete();
        }

        public final void onError(Throwable th) {
            Observer observer = this.c;
            this.d = EmptyComponent.INSTANCE;
            this.c = EmptyComponent.asObserver();
            observer.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableDetach(Observable observable) {
        super(observable);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.Observer, java.lang.Object, io.reactivex.internal.operators.observable.ObservableDetach$DetachObserver] */
    public final void subscribeActual(Observer observer) {
        ? obj = new Object();
        obj.c = observer;
        this.c.subscribe(obj);
    }
}
