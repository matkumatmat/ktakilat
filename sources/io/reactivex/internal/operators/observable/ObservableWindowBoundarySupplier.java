package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public final Callable d;
    public final int e;

    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        public final WindowBoundaryMainObserver d;
        public boolean e;

        public WindowBoundaryInnerObserver(WindowBoundaryMainObserver windowBoundaryMainObserver) {
            this.d = windowBoundaryMainObserver;
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                WindowBoundaryMainObserver windowBoundaryMainObserver = this.d;
                windowBoundaryMainObserver.l.dispose();
                windowBoundaryMainObserver.m = true;
                windowBoundaryMainObserver.b();
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            WindowBoundaryMainObserver windowBoundaryMainObserver = this.d;
            windowBoundaryMainObserver.l.dispose();
            if (windowBoundaryMainObserver.i.addThrowable(th)) {
                windowBoundaryMainObserver.m = true;
                windowBoundaryMainObserver.b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        /* JADX WARNING: Removed duplicated region for block: B:4:0x000f A[LOOP:0: B:4:0x000f->B:7:0x001b, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(java.lang.Object r3) {
            /*
                r2 = this;
                boolean r3 = r2.e
                if (r3 == 0) goto L_0x0005
                return
            L_0x0005:
                r3 = 1
                r2.e = r3
                r2.dispose()
                io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$WindowBoundaryMainObserver r3 = r2.d
                java.util.concurrent.atomic.AtomicReference r0 = r3.e
            L_0x000f:
                r1 = 0
                boolean r1 = r0.compareAndSet(r2, r1)
                if (r1 == 0) goto L_0x0017
                goto L_0x001d
            L_0x0017:
                java.lang.Object r1 = r0.get()
                if (r1 == r2) goto L_0x000f
            L_0x001d:
                java.lang.Object r0 = io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryMainObserver.p
                io.reactivex.internal.queue.MpscLinkedQueue r1 = r3.g
                r1.offer(r0)
                r3.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver.onNext(java.lang.Object):void");
        }
    }

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final WindowBoundaryInnerObserver o = new WindowBoundaryInnerObserver((WindowBoundaryMainObserver) null);
        public static final Object p = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final Observer c;
        public final int d;
        public final AtomicReference e = new AtomicReference();
        public final AtomicInteger f = new AtomicInteger(1);
        public final MpscLinkedQueue g = new MpscLinkedQueue();
        public final AtomicThrowable i = new AtomicThrowable();
        public final AtomicBoolean j = new AtomicBoolean();
        public final Callable k;
        public Disposable l;
        public volatile boolean m;
        public UnicastSubject n;

        public WindowBoundaryMainObserver(Observer observer, int i2, Callable callable) {
            this.c = observer;
            this.d = i2;
            this.k = callable;
        }

        public final void a() {
            AtomicReference atomicReference = this.e;
            WindowBoundaryInnerObserver windowBoundaryInnerObserver = o;
            Disposable disposable = (Disposable) atomicReference.getAndSet(windowBoundaryInnerObserver);
            if (disposable != null && disposable != windowBoundaryInnerObserver) {
                disposable.dispose();
            }
        }

        public final void b() {
            boolean z;
            if (getAndIncrement() == 0) {
                Observer observer = this.c;
                MpscLinkedQueue mpscLinkedQueue = this.g;
                AtomicThrowable atomicThrowable = this.i;
                int i2 = 1;
                while (this.f.get() != 0) {
                    UnicastSubject unicastSubject = this.n;
                    boolean z2 = this.m;
                    if (!z2 || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastSubject != null) {
                                    this.n = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.n = null;
                                unicastSubject.onError(terminate);
                            }
                            observer.onError(terminate);
                            return;
                        } else if (z) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != p) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.n = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.j.get()) {
                                UnicastSubject unicastSubject2 = new UnicastSubject(this, this.d);
                                this.n = unicastSubject2;
                                this.f.getAndIncrement();
                                try {
                                    Object call = this.k.call();
                                    ObjectHelper.b(call, "The other Callable returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) call;
                                    WindowBoundaryInnerObserver windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                                    AtomicReference atomicReference = this.e;
                                    while (true) {
                                        if (!atomicReference.compareAndSet((Object) null, windowBoundaryInnerObserver)) {
                                            if (atomicReference.get() != null) {
                                                break;
                                            }
                                        } else {
                                            observableSource.subscribe(windowBoundaryInnerObserver);
                                            observer.onNext(unicastSubject2);
                                            break;
                                        }
                                    }
                                } catch (Throwable th) {
                                    Exceptions.a(th);
                                    atomicThrowable.addThrowable(th);
                                    this.m = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastSubject != null) {
                            this.n = null;
                            unicastSubject.onError(terminate2);
                        }
                        observer.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.n = null;
            }
        }

        public final void dispose() {
            if (this.j.compareAndSet(false, true)) {
                a();
                if (this.f.decrementAndGet() == 0) {
                    this.l.dispose();
                }
            }
        }

        public final boolean isDisposed() {
            return this.j.get();
        }

        public final void onComplete() {
            a();
            this.m = true;
            b();
        }

        public final void onError(Throwable th) {
            a();
            if (this.i.addThrowable(th)) {
                this.m = true;
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            this.g.offer(obj);
            b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.l, disposable)) {
                this.l = disposable;
                this.c.onSubscribe(this);
                this.g.offer(p);
                b();
            }
        }

        public final void run() {
            if (this.f.decrementAndGet() == 0) {
                this.l.dispose();
            }
        }
    }

    public ObservableWindowBoundarySupplier(Observable observable, Callable callable, int i) {
        super(observable);
        this.d = callable;
        this.e = i;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new WindowBoundaryMainObserver(observer, this.e, this.d));
    }
}
