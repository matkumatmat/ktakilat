package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDematerialize<T> extends AbstractObservableWithUpstream<Notification<T>, T> {

    public static final class DematerializeObserver<T> implements Observer<Notification<T>>, Disposable {
        public final Observer c;
        public boolean d;
        public Disposable e;

        public DematerializeObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
                return;
            }
            this.d = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            Notification notification = (Notification) obj;
            if (this.d) {
                if (NotificationLite.isError(notification.f656a)) {
                    RxJavaPlugins.b(notification.b());
                }
            } else if (NotificationLite.isError(notification.f656a)) {
                this.e.dispose();
                onError(notification.b());
            } else if (notification.f656a == null) {
                this.e.dispose();
                onComplete();
            } else {
                this.c.onNext(notification.c());
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableDematerialize(Observable observable) {
        super(observable);
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DematerializeObserver(observer));
    }
}
