package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {
    public final ConnectableObservable c;
    public final int d = 1;
    public RefConnection e;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        public final ObservableRefCount c;
        public long d;
        public boolean e;

        public RefConnection(ObservableRefCount observableRefCount) {
            this.c = observableRefCount;
        }

        public final void accept(Object obj) {
            DisposableHelper.replace(this, (Disposable) obj);
        }

        public final void run() {
            this.c.d(this);
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        public final Observer c;
        public final ObservableRefCount d;
        public final RefConnection e;
        public Disposable f;

        public RefCountObserver(Observer observer, ObservableRefCount observableRefCount, RefConnection refConnection) {
            this.c = observer;
            this.d = observableRefCount;
            this.e = refConnection;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dispose() {
            /*
                r7 = this;
                io.reactivex.disposables.Disposable r0 = r7.f
                r0.dispose()
                r0 = 0
                r1 = 1
                boolean r0 = r7.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0035
                io.reactivex.internal.operators.observable.ObservableRefCount r0 = r7.d
                io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r1 = r7.e
                monitor-enter(r0)
                io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r2 = r0.e     // Catch:{ all -> 0x0018 }
                if (r2 != 0) goto L_0x001a
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                goto L_0x0035
            L_0x0018:
                r1 = move-exception
                goto L_0x0033
            L_0x001a:
                long r2 = r1.d     // Catch:{ all -> 0x0018 }
                r4 = 1
                long r2 = r2 - r4
                r1.d = r2     // Catch:{ all -> 0x0018 }
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L_0x0031
                boolean r2 = r1.e     // Catch:{ all -> 0x0018 }
                if (r2 != 0) goto L_0x002c
                goto L_0x0031
            L_0x002c:
                r0.d(r1)     // Catch:{ all -> 0x0018 }
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                goto L_0x0035
            L_0x0031:
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                goto L_0x0035
            L_0x0033:
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                throw r1
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableRefCount.RefCountObserver.dispose():void");
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            if (compareAndSet(false, true)) {
                this.d.c(this.e);
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.d.c(this.e);
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(ConnectableObservable connectableObservable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        TrampolineScheduler trampolineScheduler = Schedulers.d;
        this.c = connectableObservable;
    }

    public final void c(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (this.e != null) {
                    this.e = null;
                    refConnection.getClass();
                    ConnectableObservable connectableObservable = this.c;
                    if (connectableObservable instanceof Disposable) {
                        ((Disposable) connectableObservable).dispose();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (refConnection.d == 0 && refConnection == this.e) {
                    this.e = null;
                    DisposableHelper.dispose(refConnection);
                    ConnectableObservable connectableObservable = this.c;
                    if (connectableObservable instanceof Disposable) {
                        ((Disposable) connectableObservable).dispose();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void subscribeActual(Observer observer) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            try {
                refConnection = this.e;
                if (refConnection == null) {
                    refConnection = new RefConnection(this);
                    this.e = refConnection;
                }
                long j = refConnection.d + 1;
                refConnection.d = j;
                if (refConnection.e || j != ((long) this.d)) {
                    z = false;
                } else {
                    z = true;
                    refConnection.e = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.c.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.c.c(refConnection);
        }
    }
}
