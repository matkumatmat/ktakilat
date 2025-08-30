package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    public final long d;
    public final long e;
    public final TimeUnit f;
    public final Scheduler g;
    public final Callable i;
    public final int j;
    public final boolean k;

    public static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        public final Callable j;
        public final long k;
        public final TimeUnit l;
        public final int m;
        public final boolean n;
        public final Scheduler.Worker o;
        public Collection p;
        public Disposable q;
        public Disposable r;
        public long s;
        public long t;

        public BufferExactBoundedObserver(SerializedObserver serializedObserver, Callable callable, long j2, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(serializedObserver, new MpscLinkedQueue());
            this.j = callable;
            this.k = j2;
            this.l = timeUnit;
            this.m = i;
            this.n = z;
            this.o = worker;
        }

        public final void a(SerializedObserver serializedObserver, Object obj) {
            serializedObserver.onNext((Collection) obj);
        }

        public final void dispose() {
            if (!this.f) {
                this.f = true;
                this.r.dispose();
                this.o.dispose();
                synchronized (this) {
                    this.p = null;
                }
            }
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final void onComplete() {
            Collection collection;
            this.o.dispose();
            synchronized (this) {
                collection = this.p;
                this.p = null;
            }
            this.e.offer(collection);
            this.g = true;
            if (b()) {
                QueueDrainHelper.b(this.e, this.d, this, this);
            }
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                this.p = null;
            }
            this.d.onError(th);
            this.o.dispose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r7.n == false) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r7.q.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            e(r0, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8 = r7.j.call();
            io.reactivex.internal.functions.ObjectHelper.b(r8, "The buffer supplied is null");
            r8 = (java.util.Collection) r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r7.p = r8;
            r7.t++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0045, code lost:
            if (r7.n == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
            r0 = r7.o;
            r4 = r7.k;
            r7.q = r0.d(r7, r4, r4, r7.l);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
            io.reactivex.exceptions.Exceptions.a(r8);
            r7.d.onError(r8);
            dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0065, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(java.lang.Object r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.util.Collection r0 = r7.p     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r8 = move-exception
                goto L_0x0066
            L_0x0009:
                r0.add(r8)     // Catch:{ all -> 0x0007 }
                int r8 = r0.size()     // Catch:{ all -> 0x0007 }
                int r1 = r7.m     // Catch:{ all -> 0x0007 }
                if (r8 >= r1) goto L_0x0016
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                return
            L_0x0016:
                r8 = 0
                r7.p = r8     // Catch:{ all -> 0x0007 }
                long r1 = r7.s     // Catch:{ all -> 0x0007 }
                r3 = 1
                long r1 = r1 + r3
                r7.s = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                boolean r8 = r7.n
                if (r8 == 0) goto L_0x002a
                io.reactivex.disposables.Disposable r8 = r7.q
                r8.dispose()
            L_0x002a:
                r7.e(r0, r7)
                java.util.concurrent.Callable r8 = r7.j     // Catch:{ all -> 0x0059 }
                java.lang.Object r8 = r8.call()     // Catch:{ all -> 0x0059 }
                java.lang.String r0 = "The buffer supplied is null"
                io.reactivex.internal.functions.ObjectHelper.b(r8, r0)     // Catch:{ all -> 0x0059 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0059 }
                monitor-enter(r7)
                r7.p = r8     // Catch:{ all -> 0x0056 }
                long r0 = r7.t     // Catch:{ all -> 0x0056 }
                long r0 = r0 + r3
                r7.t = r0     // Catch:{ all -> 0x0056 }
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                boolean r8 = r7.n
                if (r8 == 0) goto L_0x0055
                io.reactivex.Scheduler$Worker r0 = r7.o
                long r4 = r7.k
                java.util.concurrent.TimeUnit r6 = r7.l
                r1 = r7
                r2 = r4
                io.reactivex.disposables.Disposable r8 = r0.d(r1, r2, r4, r6)
                r7.q = r8
            L_0x0055:
                return
            L_0x0056:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                throw r8
            L_0x0059:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.a(r8)
                io.reactivex.observers.SerializedObserver r0 = r7.d
                r0.onError(r8)
                r7.dispose()
                return
            L_0x0066:
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.onNext(java.lang.Object):void");
        }

        public final void onSubscribe(Disposable disposable) {
            SerializedObserver serializedObserver = this.d;
            if (DisposableHelper.validate(this.r, disposable)) {
                this.r = disposable;
                try {
                    Object call = this.j.call();
                    ObjectHelper.b(call, "The buffer supplied is null");
                    this.p = (Collection) call;
                    serializedObserver.onSubscribe(this);
                    TimeUnit timeUnit = this.l;
                    Scheduler.Worker worker = this.o;
                    long j2 = this.k;
                    this.q = worker.d(this, j2, j2, timeUnit);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, (Observer<?>) serializedObserver);
                    this.o.dispose();
                }
            }
        }

        public final void run() {
            try {
                Object call = this.j.call();
                ObjectHelper.b(call, "The bufferSupplier returned a null buffer");
                Collection collection = (Collection) call;
                synchronized (this) {
                    Collection collection2 = this.p;
                    if (collection2 != null) {
                        if (this.s == this.t) {
                            this.p = collection;
                            e(collection2, this);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                dispose();
                this.d.onError(th);
            }
        }
    }

    public static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        public final Callable j;
        public final long k;
        public final TimeUnit l;
        public final Scheduler m;
        public Disposable n;
        public Collection o;
        public final AtomicReference p = new AtomicReference();

        public BufferExactUnboundedObserver(SerializedObserver serializedObserver, Callable callable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(serializedObserver, new MpscLinkedQueue());
            this.j = callable;
            this.k = j2;
            this.l = timeUnit;
            this.m = scheduler;
        }

        public final void a(SerializedObserver serializedObserver, Object obj) {
            this.d.onNext((Collection) obj);
        }

        public final void dispose() {
            DisposableHelper.dispose(this.p);
            this.n.dispose();
        }

        public final boolean isDisposed() {
            if (this.p.get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            Collection collection;
            synchronized (this) {
                collection = this.o;
                this.o = null;
            }
            if (collection != null) {
                this.e.offer(collection);
                this.g = true;
                if (b()) {
                    QueueDrainHelper.b(this.e, this.d, (Disposable) null, this);
                }
            }
            DisposableHelper.dispose(this.p);
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                this.o = null;
            }
            this.d.onError(th);
            DisposableHelper.dispose(this.p);
        }

        public final void onNext(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.o;
                    if (collection != null) {
                        collection.add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.n, disposable)) {
                this.n = disposable;
                try {
                    Object call = this.j.call();
                    ObjectHelper.b(call, "The buffer supplied is null");
                    this.o = (Collection) call;
                    this.d.onSubscribe(this);
                    if (!this.f) {
                        Scheduler scheduler = this.m;
                        long j2 = this.k;
                        Disposable e = scheduler.e(this, j2, j2, this.l);
                        AtomicReference atomicReference = this.p;
                        while (!atomicReference.compareAndSet((Object) null, e)) {
                            if (atomicReference.get() != null) {
                                e.dispose();
                                return;
                            }
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.a(th);
                    dispose();
                    EmptyDisposable.error(th, (Observer<?>) this.d);
                }
            }
        }

        public final void run() {
            Collection collection;
            try {
                Object call = this.j.call();
                ObjectHelper.b(call, "The bufferSupplier returned a null buffer");
                Collection collection2 = (Collection) call;
                synchronized (this) {
                    try {
                        collection = this.o;
                        if (collection != null) {
                            this.o = collection2;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (collection == null) {
                    DisposableHelper.dispose(this.p);
                } else {
                    d(collection, this);
                }
            } catch (Throwable th2) {
                Exceptions.a(th2);
                this.d.onError(th2);
                dispose();
            }
        }
    }

    public static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        public final Callable j;
        public final long k;
        public final long l;
        public final TimeUnit m;
        public final Scheduler.Worker n;
        public final LinkedList o = new LinkedList();
        public Disposable p;

        public final class RemoveFromBuffer implements Runnable {
            public final Collection c;

            public RemoveFromBuffer(Collection collection) {
                this.c = collection;
            }

            public final void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.o.remove(this.c);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.e(this.c, bufferSkipBoundedObserver.n);
            }
        }

        public final class RemoveFromBufferEmit implements Runnable {
            public final Collection c;

            public RemoveFromBufferEmit(Collection collection) {
                this.c = collection;
            }

            public final void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.o.remove(this.c);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.e(this.c, bufferSkipBoundedObserver.n);
            }
        }

        public BufferSkipBoundedObserver(SerializedObserver serializedObserver, Callable callable, long j2, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(serializedObserver, new MpscLinkedQueue());
            this.j = callable;
            this.k = j2;
            this.l = j3;
            this.m = timeUnit;
            this.n = worker;
        }

        public final void a(SerializedObserver serializedObserver, Object obj) {
            serializedObserver.onNext((Collection) obj);
        }

        public final void dispose() {
            if (!this.f) {
                this.f = true;
                synchronized (this) {
                    this.o.clear();
                }
                this.p.dispose();
                this.n.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.o);
                this.o.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.e.offer((Collection) it.next());
            }
            this.g = true;
            if (b()) {
                QueueDrainHelper.b(this.e, this.d, this.n, this);
            }
        }

        public final void onError(Throwable th) {
            this.g = true;
            synchronized (this) {
                this.o.clear();
            }
            this.d.onError(th);
            this.n.dispose();
        }

        public final void onNext(Object obj) {
            synchronized (this) {
                try {
                    for (Collection add : this.o) {
                        add.add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            Scheduler.Worker worker = this.n;
            SerializedObserver serializedObserver = this.d;
            if (DisposableHelper.validate(this.p, disposable)) {
                this.p = disposable;
                try {
                    Object call = this.j.call();
                    ObjectHelper.b(call, "The buffer supplied is null");
                    Collection collection = (Collection) call;
                    this.o.add(collection);
                    serializedObserver.onSubscribe(this);
                    TimeUnit timeUnit = this.m;
                    Scheduler.Worker worker2 = this.n;
                    long j2 = this.l;
                    worker2.d(this, j2, j2, timeUnit);
                    worker.c(new RemoveFromBufferEmit(collection), this.k, this.m);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, (Observer<?>) serializedObserver);
                    worker.dispose();
                }
            }
        }

        public final void run() {
            if (!this.f) {
                try {
                    Object call = this.j.call();
                    ObjectHelper.b(call, "The bufferSupplier returned a null buffer");
                    Collection collection = (Collection) call;
                    synchronized (this) {
                        try {
                            if (!this.f) {
                                this.o.add(collection);
                                this.n.c(new RemoveFromBuffer(collection), this.k, this.m);
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    this.d.onError(th2);
                    dispose();
                }
            }
        }
    }

    public ObservableBufferTimed(Observable observable, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, Callable callable, int i2, boolean z) {
        super(observable);
        this.d = j2;
        this.e = j3;
        this.f = timeUnit;
        this.g = scheduler;
        this.i = callable;
        this.j = i2;
        this.k = z;
    }

    public final void subscribeActual(Observer observer) {
        long j2 = this.e;
        ObservableSource observableSource = this.c;
        long j3 = this.d;
        if (j3 == j2 && this.j == Integer.MAX_VALUE) {
            observableSource.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.i, j3, this.f, this.g));
            return;
        }
        Scheduler.Worker a2 = this.g.a();
        long j4 = this.d;
        long j5 = this.e;
        if (j4 == j5) {
            observableSource.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.i, j4, this.f, this.j, this.k, a2));
        } else {
            observableSource.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.i, j4, j5, this.f, a2));
        }
    }
}
