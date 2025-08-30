package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;
    public final int g;
    public final boolean i;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        public final Observer c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler f;
        public final SpscLinkedArrayQueue g;
        public final boolean i;
        public Disposable j;
        public volatile boolean k;
        public volatile boolean l;
        public Throwable m;

        public SkipLastTimedObserver(Observer observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.c = observer;
            this.d = j2;
            this.e = timeUnit;
            this.f = scheduler;
            this.g = new SpscLinkedArrayQueue(i2);
            this.i = z;
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                Observer observer = this.c;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.g;
                boolean z2 = this.i;
                TimeUnit timeUnit = this.e;
                Scheduler scheduler = this.f;
                long j2 = this.d;
                int i2 = 1;
                while (!this.k) {
                    boolean z3 = this.l;
                    Long l2 = (Long) spscLinkedArrayQueue.b();
                    if (l2 == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long b = scheduler.b(timeUnit);
                    if (!z && l2.longValue() > b - j2) {
                        z = true;
                    }
                    if (z3) {
                        if (!z2) {
                            Throwable th = this.m;
                            if (th != null) {
                                this.g.clear();
                                observer.onError(th);
                                return;
                            } else if (z) {
                                observer.onComplete();
                                return;
                            }
                        } else if (z) {
                            Throwable th2 = this.m;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (z) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        spscLinkedArrayQueue.poll();
                        observer.onNext(spscLinkedArrayQueue.poll());
                    }
                }
                this.g.clear();
            }
        }

        public final void dispose() {
            if (!this.k) {
                this.k = true;
                this.j.dispose();
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.k;
        }

        public final void onComplete() {
            this.l = true;
            a();
        }

        public final void onError(Throwable th) {
            this.m = th;
            this.l = true;
            a();
        }

        public final void onNext(Object obj) {
            this.g.a(Long.valueOf(this.f.b(this.e)), obj);
            a();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.j, disposable)) {
                this.j = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        super(observable);
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = i2;
        this.i = z;
    }

    public final void subscribeActual(Observer observer) {
        Observer observer2 = observer;
        this.c.subscribe(new SkipLastTimedObserver(observer2, this.d, this.e, this.f, this.g, this.i));
    }
}
