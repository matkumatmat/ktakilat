package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {
    public final Scheduler d;
    public final TimeUnit e;

    public static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public final TimeUnit d;
        public final Scheduler e;
        public long f;
        public Disposable g;

        public TimeIntervalObserver(Observer observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.c = observer;
            this.e = scheduler;
            this.d = timeUnit;
        }

        public final void dispose() {
            this.g.dispose();
        }

        public final boolean isDisposed() {
            return this.g.isDisposed();
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            Scheduler scheduler = this.e;
            TimeUnit timeUnit = this.d;
            long b = scheduler.b(timeUnit);
            long j = this.f;
            this.f = b;
            this.c.onNext(new Timed(obj, b - j, timeUnit));
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.f = this.e.b(this.d);
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableTimeInterval(Observable observable, TimeUnit timeUnit, Scheduler scheduler) {
        super(observable);
        this.d = scheduler;
        this.e = timeUnit;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new TimeIntervalObserver(observer, this.e, this.d));
    }
}
