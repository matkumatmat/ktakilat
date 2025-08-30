package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;
    public final boolean g;

    public static final class DelayObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public final boolean g;
        public Disposable i;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            public final void run() {
                DelayObserver delayObserver = DelayObserver.this;
                try {
                    delayObserver.c.onComplete();
                } finally {
                    delayObserver.f.dispose();
                }
            }
        }

        public final class OnError implements Runnable {
            public final Throwable c;

            public OnError(Throwable th) {
                this.c = th;
            }

            public final void run() {
                DelayObserver delayObserver = DelayObserver.this;
                try {
                    delayObserver.c.onError(this.c);
                } finally {
                    delayObserver.f.dispose();
                }
            }
        }

        public final class OnNext implements Runnable {
            public final Object c;

            public OnNext(Object obj) {
                this.c = obj;
            }

            public final void run() {
                DelayObserver.this.c.onNext(this.c);
            }
        }

        public DelayObserver(Observer observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.c = observer;
            this.d = j;
            this.e = timeUnit;
            this.f = worker;
            this.g = z;
        }

        public final void dispose() {
            this.i.dispose();
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            this.f.c(new OnComplete(), this.d, this.e);
        }

        public final void onError(Throwable th) {
            long j;
            OnError onError = new OnError(th);
            if (this.g) {
                j = this.d;
            } else {
                j = 0;
            }
            this.f.c(onError, j, this.e);
        }

        public final void onNext(Object obj) {
            this.f.c(new OnNext(obj), this.d, this.e);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observable);
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = z;
    }

    public final void subscribeActual(Observer observer) {
        SerializedObserver serializedObserver;
        if (this.g) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.c.subscribe(new DelayObserver(serializedObserver, this.d, this.e, this.f.a(), this.g));
    }
}
