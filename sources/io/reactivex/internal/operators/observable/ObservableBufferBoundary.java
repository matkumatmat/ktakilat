package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {
    public final Callable d;
    public final ObservableSource e;
    public final Function f;

    public static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;
        public final Observer c;
        public final Callable d;
        public final ObservableSource e;
        public final Function f;
        public final CompositeDisposable g = new Object();
        public final AtomicReference i = new AtomicReference();
        public final AtomicThrowable j = new AtomicThrowable();
        public volatile boolean k;
        public final SpscLinkedArrayQueue l = new SpscLinkedArrayQueue(Observable.bufferSize());
        public volatile boolean m;
        public long n;
        public LinkedHashMap o = new LinkedHashMap();

        public static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            public final BufferBoundaryObserver c;

            public BufferOpenObserver(BufferBoundaryObserver bufferBoundaryObserver) {
                this.c = bufferBoundaryObserver;
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

            public final void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                BufferBoundaryObserver bufferBoundaryObserver = this.c;
                bufferBoundaryObserver.g.c(this);
                if (bufferBoundaryObserver.g.d() == 0) {
                    DisposableHelper.dispose(bufferBoundaryObserver.i);
                    bufferBoundaryObserver.k = true;
                    bufferBoundaryObserver.b();
                }
            }

            public final void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                BufferBoundaryObserver bufferBoundaryObserver = this.c;
                DisposableHelper.dispose(bufferBoundaryObserver.i);
                bufferBoundaryObserver.g.c(this);
                bufferBoundaryObserver.onError(th);
            }

            public final void onNext(Object obj) {
                BufferBoundaryObserver bufferBoundaryObserver = this.c;
                bufferBoundaryObserver.getClass();
                try {
                    Object call = bufferBoundaryObserver.d.call();
                    ObjectHelper.b(call, "The bufferSupplier returned a null Collection");
                    Collection collection = (Collection) call;
                    Object apply = bufferBoundaryObserver.f.apply(obj);
                    ObjectHelper.b(apply, "The bufferClose returned a null ObservableSource");
                    ObservableSource observableSource = (ObservableSource) apply;
                    long j = bufferBoundaryObserver.n;
                    bufferBoundaryObserver.n = 1 + j;
                    synchronized (bufferBoundaryObserver) {
                        try {
                            LinkedHashMap linkedHashMap = bufferBoundaryObserver.o;
                            if (linkedHashMap != null) {
                                linkedHashMap.put(Long.valueOf(j), collection);
                                BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(bufferBoundaryObserver, j);
                                bufferBoundaryObserver.g.b(bufferCloseObserver);
                                observableSource.subscribe(bufferCloseObserver);
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    DisposableHelper.dispose(bufferBoundaryObserver.i);
                    bufferBoundaryObserver.onError(th2);
                }
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        /* JADX WARNING: type inference failed for: r1v2, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public BufferBoundaryObserver(Observer observer, ObservableSource observableSource, Function function, Callable callable) {
            this.c = observer;
            this.d = callable;
            this.e = observableSource;
            this.f = function;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            if (r4 == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
            r3.k = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver r4, long r5) {
            /*
                r3 = this;
                io.reactivex.disposables.CompositeDisposable r0 = r3.g
                r0.c(r4)
                io.reactivex.disposables.CompositeDisposable r4 = r3.g
                int r4 = r4.d()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference r4 = r3.i
                io.reactivex.internal.disposables.DisposableHelper.dispose(r4)
                r4 = 1
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.LinkedHashMap r1 = r3.o     // Catch:{ all -> 0x001d }
                if (r1 != 0) goto L_0x001f
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                return
            L_0x001d:
                r4 = move-exception
                goto L_0x0035
            L_0x001f:
                io.reactivex.internal.queue.SpscLinkedArrayQueue r2 = r3.l     // Catch:{ all -> 0x001d }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x001d }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x001d }
                r2.offer(r5)     // Catch:{ all -> 0x001d }
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                if (r4 == 0) goto L_0x0031
                r3.k = r0
            L_0x0031:
                r3.b()
                return
            L_0x0035:
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.a(io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver, long):void");
        }

        public final void b() {
            boolean z;
            if (getAndIncrement() == 0) {
                Observer observer = this.c;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.l;
                int i2 = 1;
                while (!this.m) {
                    boolean z2 = this.k;
                    if (!z2 || this.j.get() == null) {
                        Collection collection = (Collection) spscLinkedArrayQueue.poll();
                        if (collection == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            observer.onComplete();
                            return;
                        } else if (z) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            observer.onNext(collection);
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(this.j.terminate());
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public final void dispose() {
            if (DisposableHelper.dispose(this.i)) {
                this.m = true;
                this.g.dispose();
                synchronized (this) {
                    this.o = null;
                }
                if (getAndIncrement() != 0) {
                    this.l.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.i.get());
        }

        public final void onComplete() {
            this.g.dispose();
            synchronized (this) {
                try {
                    LinkedHashMap linkedHashMap = this.o;
                    if (linkedHashMap != null) {
                        for (Collection offer : linkedHashMap.values()) {
                            this.l.offer(offer);
                        }
                        this.o = null;
                        this.k = true;
                        b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.j.addThrowable(th)) {
                this.g.dispose();
                synchronized (this) {
                    this.o = null;
                }
                this.k = true;
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            synchronized (this) {
                try {
                    LinkedHashMap linkedHashMap = this.o;
                    if (linkedHashMap != null) {
                        for (Collection add : linkedHashMap.values()) {
                            add.add(obj);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.i, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.g.b(bufferOpenObserver);
                this.e.subscribe(bufferOpenObserver);
            }
        }
    }

    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        public final BufferBoundaryObserver c;
        public final long d;

        public BufferCloseObserver(BufferBoundaryObserver bufferBoundaryObserver, long j) {
            this.c = bufferBoundaryObserver;
            this.d = j;
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

        public final void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.c.a(this, this.d);
            }
        }

        public final void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                BufferBoundaryObserver bufferBoundaryObserver = this.c;
                DisposableHelper.dispose(bufferBoundaryObserver.i);
                bufferBoundaryObserver.g.c(this);
                bufferBoundaryObserver.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.c.a(this, this.d);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableBufferBoundary(Observable observable, ObservableSource observableSource, Function function, Callable callable) {
        super(observable);
        this.e = observableSource;
        this.f = function;
        this.d = callable;
    }

    public final void subscribeActual(Observer observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.e, this.f, this.d);
        observer.onSubscribe(bufferBoundaryObserver);
        this.c.subscribe(bufferBoundaryObserver);
    }
}
