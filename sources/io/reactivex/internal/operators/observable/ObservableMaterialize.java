package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    public static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public Disposable d;

        public MaterializeObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            this.d.dispose();
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            Notification notification = Notification.b;
            Observer observer = this.c;
            observer.onNext(notification);
            observer.onComplete();
        }

        public final void onError(Throwable th) {
            Notification a2 = Notification.a(th);
            Observer observer = this.c;
            observer.onNext(a2);
            observer.onComplete();
        }

        public final void onNext(Object obj) {
            ObjectHelper.b(obj, "value is null");
            this.c.onNext(new Notification(obj));
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableMaterialize(Observable observable) {
        super(observable);
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new MaterializeObserver(observer));
    }
}
