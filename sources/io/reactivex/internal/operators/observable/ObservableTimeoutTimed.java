package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;
    public final ObservableSource g;

    public static final class FallbackObserver<T> implements Observer<T> {
        public final Observer c;
        public final AtomicReference d;

        public FallbackObserver(Observer observer, AtomicReference atomicReference) {
            this.c = observer;
            this.d = atomicReference;
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
            DisposableHelper.replace(this.d, disposable);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Observer c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public final SequentialDisposable g = new SequentialDisposable();
        public final AtomicLong i = new AtomicLong();
        public final AtomicReference j = new AtomicReference();
        public ObservableSource k;

        public TimeoutFallbackObserver(Observer observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource observableSource) {
            this.c = observer;
            this.d = j2;
            this.e = timeUnit;
            this.f = worker;
            this.k = observableSource;
        }

        public final void a(long j2) {
            if (this.i.compareAndSet(j2, LocationRequestCompat.PASSIVE_INTERVAL)) {
                DisposableHelper.dispose(this.j);
                ObservableSource observableSource = this.k;
                this.k = null;
                observableSource.subscribe(new FallbackObserver(this.c, this));
                this.f.dispose();
            }
        }

        public final void dispose() {
            DisposableHelper.dispose(this.j);
            DisposableHelper.dispose(this);
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            if (this.i.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.g.dispose();
                this.c.onComplete();
                this.f.dispose();
            }
        }

        public final void onError(Throwable th) {
            if (this.i.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.g.dispose();
                this.c.onError(th);
                this.f.dispose();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            AtomicLong atomicLong = this.i;
            long j2 = atomicLong.get();
            if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                long j3 = 1 + j2;
                if (atomicLong.compareAndSet(j2, j3)) {
                    SequentialDisposable sequentialDisposable = this.g;
                    ((Disposable) sequentialDisposable.get()).dispose();
                    this.c.onNext(obj);
                    sequentialDisposable.replace(this.f.c(new TimeoutTask(j3, this), this.d, this.e));
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.j, disposable);
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Observer c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public final SequentialDisposable g = new SequentialDisposable();
        public final AtomicReference i = new AtomicReference();

        public TimeoutObserver(Observer observer, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.c = observer;
            this.d = j;
            this.e = timeUnit;
            this.f = worker;
        }

        public final void a(long j) {
            if (compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                DisposableHelper.dispose(this.i);
                this.c.onError(new TimeoutException());
                this.f.dispose();
            }
        }

        public final void dispose() {
            DisposableHelper.dispose(this.i);
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.i.get());
        }

        public final void onComplete() {
            if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.g.dispose();
                this.c.onComplete();
                this.f.dispose();
            }
        }

        public final void onError(Throwable th) {
            if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.g.dispose();
                this.c.onError(th);
                this.f.dispose();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            long j = get();
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    SequentialDisposable sequentialDisposable = this.g;
                    ((Disposable) sequentialDisposable.get()).dispose();
                    this.c.onNext(obj);
                    sequentialDisposable.replace(this.f.c(new TimeoutTask(j2, this), this.d, this.e));
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.i, disposable);
        }
    }

    public interface TimeoutSupport {
        void a(long j);
    }

    public static final class TimeoutTask implements Runnable {
        public final Object c;
        public final long d;

        public TimeoutTask(long j, TimeoutSupport timeoutSupport) {
            this.d = j;
            this.c = timeoutSupport;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutSupport] */
        public final void run() {
            this.c.a(this.d);
        }
    }

    public ObservableTimeoutTimed(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource observableSource) {
        super(observable);
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = observableSource;
    }

    public final void subscribeActual(Observer observer) {
        ObservableSource observableSource = this.g;
        ObservableSource observableSource2 = this.c;
        Scheduler scheduler = this.f;
        if (observableSource == null) {
            Observer observer2 = observer;
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer2, this.d, this.e, scheduler.a());
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.g.replace(timeoutObserver.f.c(new TimeoutTask(0, timeoutObserver), timeoutObserver.d, timeoutObserver.e));
            observableSource2.subscribe(timeoutObserver);
            return;
        }
        Observer observer3 = observer;
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer3, this.d, this.e, scheduler.a(), this.g);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.g.replace(timeoutFallbackObserver.f.c(new TimeoutTask(0, timeoutFallbackObserver), timeoutFallbackObserver.d, timeoutFallbackObserver.e));
        observableSource2.subscribe(timeoutFallbackObserver);
    }
}
