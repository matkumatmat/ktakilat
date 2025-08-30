package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {
    public final ObservableSource d;
    public final Function e;
    public final ObservableSource f;

    public static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;
        public final Object c;
        public final long d;

        public TimeoutConsumer(long j, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.d = j;
            this.c = timeoutSelectorSupport;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Object, io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutSupport] */
        public final void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.c.a(this.d);
            }
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Object, io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutSelectorSupport] */
        public final void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.c.b(this.d, th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.Object, io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutSupport] */
        public final void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                disposable.dispose();
                lazySet(disposableHelper);
                this.c.a(this.d);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = -7508389464265974549L;
        public final Observer c;
        public final Function d;
        public final SequentialDisposable e = new SequentialDisposable();
        public final AtomicLong f;
        public final AtomicReference g;
        public ObservableSource i;

        public TimeoutFallbackObserver(ObservableSource observableSource, Observer observer, Function function) {
            this.c = observer;
            this.d = function;
            this.i = observableSource;
            this.f = new AtomicLong();
            this.g = new AtomicReference();
        }

        public final void a(long j) {
            if (this.f.compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                DisposableHelper.dispose(this.g);
                ObservableSource observableSource = this.i;
                this.i = null;
                observableSource.subscribe(new ObservableTimeoutTimed.FallbackObserver(this.c, this));
            }
        }

        public final void b(long j, Throwable th) {
            if (this.f.compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                DisposableHelper.dispose(this);
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void dispose() {
            DisposableHelper.dispose(this.g);
            DisposableHelper.dispose(this);
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            if (this.f.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                SequentialDisposable sequentialDisposable = this.e;
                sequentialDisposable.dispose();
                this.c.onComplete();
                sequentialDisposable.dispose();
            }
        }

        public final void onError(Throwable th) {
            if (this.f.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                SequentialDisposable sequentialDisposable = this.e;
                sequentialDisposable.dispose();
                this.c.onError(th);
                sequentialDisposable.dispose();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            AtomicLong atomicLong = this.f;
            long j = atomicLong.get();
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                long j2 = 1 + j;
                if (atomicLong.compareAndSet(j, j2)) {
                    SequentialDisposable sequentialDisposable = this.e;
                    Disposable disposable = (Disposable) sequentialDisposable.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    Observer observer = this.c;
                    observer.onNext(obj);
                    try {
                        Object apply = this.d.apply(obj);
                        ObjectHelper.b(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        ObservableSource observableSource = (ObservableSource) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (sequentialDisposable.replace(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.a(th);
                        ((Disposable) this.g.get()).dispose();
                        atomicLong.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL);
                        observer.onError(th);
                    }
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.g, disposable);
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Observer c;
        public final Function d;
        public final SequentialDisposable e = new SequentialDisposable();
        public final AtomicReference f = new AtomicReference();

        public TimeoutObserver(Observer observer, Function function) {
            this.c = observer;
            this.d = function;
        }

        public final void a(long j) {
            if (compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                DisposableHelper.dispose(this.f);
                this.c.onError(new TimeoutException());
            }
        }

        public final void b(long j, Throwable th) {
            if (compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                DisposableHelper.dispose(this.f);
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void dispose() {
            DisposableHelper.dispose(this.f);
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f.get());
        }

        public final void onComplete() {
            if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.e.dispose();
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.e.dispose();
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            long j = get();
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    SequentialDisposable sequentialDisposable = this.e;
                    Disposable disposable = (Disposable) sequentialDisposable.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    Observer observer = this.c;
                    observer.onNext(obj);
                    try {
                        Object apply = this.d.apply(obj);
                        ObjectHelper.b(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        ObservableSource observableSource = (ObservableSource) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (sequentialDisposable.replace(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.a(th);
                        ((Disposable) this.f.get()).dispose();
                        getAndSet(LocationRequestCompat.PASSIVE_INTERVAL);
                        observer.onError(th);
                    }
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f, disposable);
        }
    }

    public interface TimeoutSelectorSupport extends ObservableTimeoutTimed.TimeoutSupport {
        void b(long j, Throwable th);
    }

    public ObservableTimeout(Observable observable, ObservableSource observableSource, Function function, ObservableSource observableSource2) {
        super(observable);
        this.d = observableSource;
        this.e = function;
        this.f = observableSource2;
    }

    public final void subscribeActual(Observer observer) {
        ObservableSource observableSource = this.c;
        ObservableSource observableSource2 = this.d;
        Function function = this.e;
        ObservableSource observableSource3 = this.f;
        if (observableSource3 == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, function);
            observer.onSubscribe(timeoutObserver);
            if (observableSource2 != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, timeoutObserver);
                if (timeoutObserver.e.replace(timeoutConsumer)) {
                    observableSource2.subscribe(timeoutConsumer);
                }
            }
            observableSource.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observableSource3, observer, function);
        observer.onSubscribe(timeoutFallbackObserver);
        if (observableSource2 != null) {
            TimeoutConsumer timeoutConsumer2 = new TimeoutConsumer(0, timeoutFallbackObserver);
            if (timeoutFallbackObserver.e.replace(timeoutConsumer2)) {
                observableSource2.subscribe(timeoutConsumer2);
            }
        }
        observableSource.subscribe(timeoutFallbackObserver);
    }
}
