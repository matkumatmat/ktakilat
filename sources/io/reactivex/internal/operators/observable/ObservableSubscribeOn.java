package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    public final Scheduler d;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8094547886072529208L;
        public final Observer c;
        public final AtomicReference d = new AtomicReference();

        public SubscribeOnObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            DisposableHelper.dispose(this.d);
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public final class SubscribeTask implements Runnable {
        public final SubscribeOnObserver c;

        public SubscribeTask(SubscribeOnObserver subscribeOnObserver) {
            this.c = subscribeOnObserver;
        }

        public final void run() {
            ObservableSubscribeOn.this.c.subscribe(this.c);
        }
    }

    public ObservableSubscribeOn(Observable observable, Scheduler scheduler) {
        super(observable);
        this.d = scheduler;
    }

    public final void subscribeActual(Observer observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        DisposableHelper.setOnce(subscribeOnObserver, this.d.c(new SubscribeTask(subscribeOnObserver)));
    }
}
