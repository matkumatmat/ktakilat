package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableIntervalRange extends Observable<Long> {
    public final Scheduler c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final TimeUnit i;

    public static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        public final Observer c;
        public final long d;
        public long e;

        public IntervalRangeObserver(Observer observer, long j, long j2) {
            this.c = observer;
            this.e = j;
            this.d = j2;
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
            if (!isDisposed()) {
                long j = this.e;
                Long valueOf = Long.valueOf(j);
                Observer observer = this.c;
                observer.onNext(valueOf);
                if (j == this.d) {
                    DisposableHelper.dispose(this);
                    observer.onComplete();
                    return;
                }
                this.e = j + 1;
            }
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.f = j3;
        this.g = j4;
        this.i = timeUnit;
        this.c = scheduler;
        this.d = j;
        this.e = j2;
    }

    public final void subscribeActual(Observer observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.d, this.e);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.c;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker a2 = scheduler.a();
            DisposableHelper.setOnce(intervalRangeObserver, a2);
            IntervalRangeObserver intervalRangeObserver2 = intervalRangeObserver;
            a2.d(intervalRangeObserver2, this.f, this.g, this.i);
            return;
        }
        IntervalRangeObserver intervalRangeObserver3 = intervalRangeObserver;
        DisposableHelper.setOnce(intervalRangeObserver, scheduler.e(intervalRangeObserver3, this.f, this.g, this.i));
    }
}
