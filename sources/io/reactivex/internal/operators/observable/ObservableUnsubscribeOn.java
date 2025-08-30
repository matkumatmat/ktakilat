package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    public final Scheduler d;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1015244841293359600L;
        public final Observer c;
        public final Scheduler d;
        public Disposable e;

        public final class DisposeTask implements Runnable {
            public DisposeTask() {
            }

            public final void run() {
                UnsubscribeObserver.this.e.dispose();
            }
        }

        public UnsubscribeObserver(Observer observer, Scheduler scheduler) {
            this.c = observer;
            this.d = scheduler;
        }

        public final void dispose() {
            if (compareAndSet(false, true)) {
                this.d.c(new DisposeTask());
            }
        }

        public final boolean isDisposed() {
            return get();
        }

        public final void onComplete() {
            if (!get()) {
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.b(th);
            } else {
                this.c.onError(th);
            }
        }

        public final void onNext(Object obj) {
            if (!get()) {
                this.c.onNext(obj);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(Observable observable, Scheduler scheduler) {
        super(observable);
        this.d = scheduler;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new UnsubscribeObserver(observer, this.d));
    }
}
