package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;

    public static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        public final SerializedObserver c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public Disposable g;
        public volatile boolean i;
        public boolean j;

        public DebounceTimedObserver(SerializedObserver serializedObserver, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.c = serializedObserver;
            this.d = j2;
            this.e = timeUnit;
            this.f = worker;
        }

        public final void dispose() {
            this.g.dispose();
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            if (!this.j) {
                this.j = true;
                this.c.onComplete();
                this.f.dispose();
            }
        }

        public final void onError(Throwable th) {
            if (this.j) {
                RxJavaPlugins.b(th);
                return;
            }
            this.j = true;
            this.c.onError(th);
            this.f.dispose();
        }

        public final void onNext(Object obj) {
            if (!this.i && !this.j) {
                this.i = true;
                this.c.onNext(obj);
                Disposable disposable = (Disposable) get();
                if (disposable != null) {
                    disposable.dispose();
                }
                DisposableHelper.replace(this, this.f.c(this, this.d, this.e));
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void run() {
            this.i = false;
        }
    }

    public ObservableThrottleFirstTimed(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(observable);
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.d, this.e, this.f.a()));
    }
}
