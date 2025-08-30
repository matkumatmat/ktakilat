package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval extends Observable<Long> {
    public final Scheduler c;
    public final long d;
    public final long e;
    public final TimeUnit f;

    public static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        public final Observer c;
        public long d;

        public IntervalObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public final void run() {
            if (get() != DisposableHelper.DISPOSED) {
                long j = this.d;
                this.d = 1 + j;
                this.c.onNext(Long.valueOf(j));
            }
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.d = j;
        this.e = j2;
        this.f = timeUnit;
        this.c = scheduler;
    }

    public final void subscribeActual(Observer observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        Scheduler scheduler = this.c;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker a2 = scheduler.a();
            DisposableHelper.setOnce(intervalObserver, a2);
            IntervalObserver intervalObserver2 = intervalObserver;
            a2.d(intervalObserver2, this.d, this.e, this.f);
            return;
        }
        IntervalObserver intervalObserver3 = intervalObserver;
        DisposableHelper.setOnce(intervalObserver, scheduler.e(intervalObserver3, this.d, this.e, this.f));
    }
}
