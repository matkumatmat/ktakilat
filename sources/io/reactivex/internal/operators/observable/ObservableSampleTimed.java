package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;
    public final boolean g;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        public final AtomicInteger j = new AtomicInteger(1);

        public SampleTimedEmitLast(SerializedObserver serializedObserver, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(serializedObserver, j2, timeUnit, scheduler);
        }

        public final void a() {
            Object andSet = getAndSet((Object) null);
            SerializedObserver serializedObserver = this.c;
            if (andSet != null) {
                serializedObserver.onNext(andSet);
            }
            if (this.j.decrementAndGet() == 0) {
                serializedObserver.onComplete();
            }
        }

        public final void run() {
            AtomicInteger atomicInteger = this.j;
            if (atomicInteger.incrementAndGet() == 2) {
                Object andSet = getAndSet((Object) null);
                SerializedObserver serializedObserver = this.c;
                if (andSet != null) {
                    serializedObserver.onNext(andSet);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    serializedObserver.onComplete();
                }
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public final void a() {
            this.c.onComplete();
        }

        public final void run() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.c.onNext(andSet);
            }
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final SerializedObserver c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler f;
        public final AtomicReference g = new AtomicReference();
        public Disposable i;

        public SampleTimedObserver(SerializedObserver serializedObserver, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.c = serializedObserver;
            this.d = j;
            this.e = timeUnit;
            this.f = scheduler;
        }

        public abstract void a();

        public final void dispose() {
            DisposableHelper.dispose(this.g);
            this.i.dispose();
        }

        public final boolean isDisposed() {
            return this.i.isDisposed();
        }

        public final void onComplete() {
            DisposableHelper.dispose(this.g);
            a();
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.g);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            lazySet(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.c.onSubscribe(this);
                TimeUnit timeUnit = this.e;
                Scheduler scheduler = this.f;
                long j = this.d;
                DisposableHelper.replace(this.g, scheduler.e(this, j, j, timeUnit));
            }
        }
    }

    public ObservableSampleTimed(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observable);
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = z;
    }

    public final void subscribeActual(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        boolean z = this.g;
        ObservableSource observableSource = this.c;
        if (z) {
            observableSource.subscribe(new SampleTimedEmitLast(serializedObserver, this.d, this.e, this.f));
            return;
        }
        observableSource.subscribe(new SampleTimedObserver(serializedObserver, this.d, this.e, this.f));
    }
}
