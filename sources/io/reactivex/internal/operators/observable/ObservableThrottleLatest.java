package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;
    public final boolean g;

    public static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        public final Observer c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public final boolean g;
        public final AtomicReference i = new AtomicReference();
        public Disposable j;
        public volatile boolean k;
        public Throwable l;
        public volatile boolean m;
        public volatile boolean n;
        public boolean o;

        public ThrottleLatestObserver(Observer observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.c = observer;
            this.d = j2;
            this.e = timeUnit;
            this.f = worker;
            this.g = z;
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                AtomicReference atomicReference = this.i;
                Observer observer = this.c;
                int i2 = 1;
                while (!this.m) {
                    boolean z2 = this.k;
                    if (!z2 || this.l == null) {
                        if (atomicReference.get() == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2) {
                            Object andSet = atomicReference.getAndSet((Object) null);
                            if (!z && this.g) {
                                observer.onNext(andSet);
                            }
                            observer.onComplete();
                            this.f.dispose();
                            return;
                        }
                        if (z) {
                            if (this.n) {
                                this.o = false;
                                this.n = false;
                            }
                        } else if (!this.o || this.n) {
                            observer.onNext(atomicReference.getAndSet((Object) null));
                            this.n = false;
                            this.o = true;
                            this.f.c(this, this.d, this.e);
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        observer.onError(this.l);
                        this.f.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public final void dispose() {
            this.m = true;
            this.j.dispose();
            this.f.dispose();
            if (getAndIncrement() == 0) {
                this.i.lazySet((Object) null);
            }
        }

        public final boolean isDisposed() {
            return this.m;
        }

        public final void onComplete() {
            this.k = true;
            a();
        }

        public final void onError(Throwable th) {
            this.l = th;
            this.k = true;
            a();
        }

        public final void onNext(Object obj) {
            this.i.set(obj);
            a();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.j, disposable)) {
                this.j = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void run() {
            this.n = true;
            a();
        }
    }

    public ObservableThrottleLatest(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observable);
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = z;
    }

    public final void subscribeActual(Observer observer) {
        Observer observer2 = observer;
        this.c.subscribe(new ThrottleLatestObserver(observer2, this.d, this.e, this.f.a(), this.g));
    }
}
