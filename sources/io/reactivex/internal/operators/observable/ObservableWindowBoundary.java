package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public final ObservableSource d;
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
                DisposableHelper.dispose(windowBoundaryMainObserver.f);
                windowBoundaryMainObserver.l = true;
                windowBoundaryMainObserver.a();
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            WindowBoundaryMainObserver windowBoundaryMainObserver = this.d;
            DisposableHelper.dispose(windowBoundaryMainObserver.f);
            if (windowBoundaryMainObserver.j.addThrowable(th)) {
                windowBoundaryMainObserver.l = true;
                windowBoundaryMainObserver.a();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                Object obj2 = WindowBoundaryMainObserver.n;
                WindowBoundaryMainObserver windowBoundaryMainObserver = this.d;
                windowBoundaryMainObserver.i.offer(obj2);
                windowBoundaryMainObserver.a();
            }
        }
    }

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final Object n = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final Observer c;
        public final int d;
        public final WindowBoundaryInnerObserver e = new WindowBoundaryInnerObserver(this);
        public final AtomicReference f = new AtomicReference();
        public final AtomicInteger g = new AtomicInteger(1);
        public final MpscLinkedQueue i = new MpscLinkedQueue();
        public final AtomicThrowable j = new AtomicThrowable();
        public final AtomicBoolean k = new AtomicBoolean();
        public volatile boolean l;
        public UnicastSubject m;

        public WindowBoundaryMainObserver(Observer observer, int i2) {
            this.c = observer;
            this.d = i2;
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                Observer observer = this.c;
                MpscLinkedQueue mpscLinkedQueue = this.i;
                AtomicThrowable atomicThrowable = this.j;
                int i2 = 1;
                while (this.g.get() != 0) {
                    UnicastSubject unicastSubject = this.m;
                    boolean z2 = this.l;
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
                                    this.m = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.m = null;
                                unicastSubject.onError(terminate);
                            }
                            observer.onError(terminate);
                            return;
                        } else if (z) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != n) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.m = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.k.get()) {
                                UnicastSubject unicastSubject2 = new UnicastSubject(this, this.d);
                                this.m = unicastSubject2;
                                this.g.getAndIncrement();
                                observer.onNext(unicastSubject2);
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastSubject != null) {
                            this.m = null;
                            unicastSubject.onError(terminate2);
                        }
                        observer.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.m = null;
            }
        }

        public final void dispose() {
            if (this.k.compareAndSet(false, true)) {
                this.e.dispose();
                if (this.g.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.f);
                }
            }
        }

        public final boolean isDisposed() {
            return this.k.get();
        }

        public final void onComplete() {
            this.e.dispose();
            this.l = true;
            a();
        }

        public final void onError(Throwable th) {
            this.e.dispose();
            if (this.j.addThrowable(th)) {
                this.l = true;
                a();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            this.i.offer(obj);
            a();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f, disposable)) {
                this.i.offer(n);
                a();
            }
        }

        public final void run() {
            if (this.g.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.f);
            }
        }
    }

    public ObservableWindowBoundary(Observable observable, ObservableSource observableSource, int i) {
        super(observable);
        this.d = observableSource;
        this.e = i;
    }

    public final void subscribeActual(Observer observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.e);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.d.subscribe(windowBoundaryMainObserver.e);
        this.c.subscribe(windowBoundaryMainObserver);
    }
}
