package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final long e;
    public final TimeUnit f;
    public final Scheduler g;
    public final int i;
    public final boolean j;

    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        public final Observer c;
        public final long d;
        public final long e;
        public final TimeUnit f;
        public final Scheduler g;
        public final SpscLinkedArrayQueue i;
        public final boolean j;
        public Disposable k;
        public volatile boolean l;
        public Throwable m;

        public TakeLastTimedObserver(Observer observer, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.c = observer;
            this.d = j2;
            this.e = j3;
            this.f = timeUnit;
            this.g = scheduler;
            this.i = new SpscLinkedArrayQueue(i2);
            this.j = z;
        }

        public final void a() {
            Throwable th;
            if (compareAndSet(false, true)) {
                Observer observer = this.c;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.i;
                boolean z = this.j;
                while (!this.l) {
                    if (z || (th = this.m) == null) {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            Throwable th2 = this.m;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = spscLinkedArrayQueue.poll();
                            if (((Long) poll).longValue() >= this.g.b(this.f) - this.e) {
                                observer.onNext(poll2);
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public final void dispose() {
            if (!this.l) {
                this.l = true;
                this.k.dispose();
                if (compareAndSet(false, true)) {
                    this.i.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.l;
        }

        public final void onComplete() {
            a();
        }

        public final void onError(Throwable th) {
            this.m = th;
            a();
        }

        public final void onNext(Object obj) {
            boolean z;
            long j2;
            long j3;
            long b = this.g.b(this.f);
            long j4 = this.d;
            if (j4 == LocationRequestCompat.PASSIVE_INTERVAL) {
                z = true;
            } else {
                z = false;
            }
            Long valueOf = Long.valueOf(b);
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.i;
            spscLinkedArrayQueue.a(valueOf, obj);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.b()).longValue() > b - this.e) {
                    if (!z) {
                        AtomicLong atomicLong = spscLinkedArrayQueue.k;
                        long j5 = atomicLong.get();
                        while (true) {
                            j2 = spscLinkedArrayQueue.c.get();
                            j3 = atomicLong.get();
                            if (j5 == j3) {
                                break;
                            }
                            j5 = j3;
                        }
                        if (((long) (((int) (j2 - j3)) >> 1)) <= j4) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(Observable observable, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        super(observable);
        this.d = j2;
        this.e = j3;
        this.f = timeUnit;
        this.g = scheduler;
        this.i = i2;
        this.j = z;
    }

    public final void subscribeActual(Observer observer) {
        Observer observer2 = observer;
        this.c.subscribe(new TakeLastTimedObserver(observer2, this.d, this.e, this.f, this.g, this.i, this.j));
    }
}
