package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public final long d;
    public final long e;
    public final TimeUnit f;
    public final Scheduler g;
    public final long i;
    public final int j;
    public final boolean k;

    public static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        public final long j;
        public final TimeUnit k;
        public final Scheduler l;
        public final int m;
        public final boolean n;
        public final long o;
        public final Scheduler.Worker p;
        public long q;
        public long r;
        public Disposable s;
        public UnicastSubject t;
        public volatile boolean u;
        public final AtomicReference v = new AtomicReference();

        public static final class ConsumerIndexHolder implements Runnable {
            public final long c;
            public final WindowExactBoundedObserver d;

            public ConsumerIndexHolder(long j, WindowExactBoundedObserver windowExactBoundedObserver) {
                this.c = j;
                this.d = windowExactBoundedObserver;
            }

            public final void run() {
                WindowExactBoundedObserver windowExactBoundedObserver = this.d;
                if (!windowExactBoundedObserver.f) {
                    windowExactBoundedObserver.e.offer(this);
                } else {
                    windowExactBoundedObserver.u = true;
                    windowExactBoundedObserver.g();
                }
                if (windowExactBoundedObserver.b()) {
                    windowExactBoundedObserver.h();
                }
            }
        }

        public WindowExactBoundedObserver(SerializedObserver serializedObserver, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, long j3, boolean z) {
            super(serializedObserver, new MpscLinkedQueue());
            this.j = j2;
            this.k = timeUnit;
            this.l = scheduler;
            this.m = i;
            this.o = j3;
            this.n = z;
            if (z) {
                this.p = scheduler.a();
            } else {
                this.p = null;
            }
        }

        public final void dispose() {
            this.f = true;
        }

        public final void g() {
            DisposableHelper.dispose(this.v);
            Scheduler.Worker worker = this.p;
            if (worker != null) {
                worker.dispose();
            }
        }

        public final void h() {
            boolean z;
            UnicastSubject unicastSubject;
            MpscLinkedQueue mpscLinkedQueue = this.e;
            SerializedObserver serializedObserver = this.d;
            UnicastSubject unicastSubject2 = this.t;
            int i = 1;
            while (!this.u) {
                boolean z2 = this.g;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z2 && (z || z3)) {
                    this.t = null;
                    mpscLinkedQueue.clear();
                    g();
                    Throwable th = this.i;
                    if (th != null) {
                        unicastSubject2.onError(th);
                        return;
                    } else {
                        unicastSubject2.onComplete();
                        return;
                    }
                } else if (z) {
                    i = f(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    if (z3) {
                        ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                        if (this.n || this.r == consumerIndexHolder.c) {
                            unicastSubject2.onComplete();
                            this.q = 0;
                            unicastSubject = new UnicastSubject(this.m);
                            this.t = unicastSubject;
                            serializedObserver.onNext(unicastSubject);
                        }
                    } else {
                        unicastSubject2.onNext(NotificationLite.getValue(poll));
                        long j2 = this.q + 1;
                        if (j2 >= this.o) {
                            this.r++;
                            this.q = 0;
                            unicastSubject2.onComplete();
                            unicastSubject = new UnicastSubject(this.m);
                            this.t = unicastSubject;
                            this.d.onNext(unicastSubject);
                            if (this.n) {
                                Disposable disposable = (Disposable) this.v.get();
                                disposable.dispose();
                                Scheduler.Worker worker = this.p;
                                ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.r, this);
                                long j3 = this.j;
                                Disposable d = worker.d(consumerIndexHolder2, j3, j3, this.k);
                                AtomicReference atomicReference = this.v;
                                while (true) {
                                    if (!atomicReference.compareAndSet(disposable, d)) {
                                        if (atomicReference.get() != disposable) {
                                            d.dispose();
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        } else {
                            this.q = j2;
                        }
                    }
                    unicastSubject2 = unicastSubject;
                }
            }
            this.s.dispose();
            mpscLinkedQueue.clear();
            g();
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final void onComplete() {
            this.g = true;
            if (b()) {
                h();
            }
            this.d.onComplete();
            g();
        }

        public final void onError(Throwable th) {
            this.i = th;
            this.g = true;
            if (b()) {
                h();
            }
            this.d.onError(th);
            g();
        }

        public final void onNext(Object obj) {
            if (!this.u) {
                if (c()) {
                    UnicastSubject unicastSubject = this.t;
                    unicastSubject.onNext(obj);
                    long j2 = this.q + 1;
                    if (j2 >= this.o) {
                        this.r++;
                        this.q = 0;
                        unicastSubject.onComplete();
                        UnicastSubject unicastSubject2 = new UnicastSubject(this.m);
                        this.t = unicastSubject2;
                        this.d.onNext(unicastSubject2);
                        if (this.n) {
                            ((Disposable) this.v.get()).dispose();
                            Scheduler.Worker worker = this.p;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.r, this);
                            long j3 = this.j;
                            DisposableHelper.replace(this.v, worker.d(consumerIndexHolder, j3, j3, this.k));
                        }
                    } else {
                        this.q = j2;
                    }
                    if (f(-1) == 0) {
                        return;
                    }
                } else {
                    this.e.offer(NotificationLite.next(obj));
                    if (!b()) {
                        return;
                    }
                }
                h();
            }
        }

        public final void onSubscribe(Disposable disposable) {
            Disposable disposable2;
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                SerializedObserver serializedObserver = this.d;
                serializedObserver.onSubscribe(this);
                if (!this.f) {
                    UnicastSubject unicastSubject = new UnicastSubject(this.m);
                    this.t = unicastSubject;
                    serializedObserver.onNext(unicastSubject);
                    ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.r, this);
                    if (this.n) {
                        Scheduler.Worker worker = this.p;
                        long j2 = this.j;
                        disposable2 = worker.d(consumerIndexHolder, j2, j2, this.k);
                    } else {
                        Scheduler scheduler = this.l;
                        long j3 = this.j;
                        disposable2 = scheduler.e(consumerIndexHolder, j3, j3, this.k);
                    }
                    DisposableHelper.replace(this.v, disposable2);
                }
            }
        }
    }

    public static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        public static final Object r = new Object();
        public final long j;
        public final TimeUnit k;
        public final Scheduler l;
        public final int m;
        public Disposable n;
        public UnicastSubject o;
        public final AtomicReference p = new AtomicReference();
        public volatile boolean q;

        public WindowExactUnboundedObserver(SerializedObserver serializedObserver, long j2, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(serializedObserver, new MpscLinkedQueue());
            this.j = j2;
            this.k = timeUnit;
            this.l = scheduler;
            this.m = i;
        }

        public final void dispose() {
            this.f = true;
        }

        public final void g() {
            MpscLinkedQueue mpscLinkedQueue = this.e;
            SerializedObserver serializedObserver = this.d;
            UnicastSubject unicastSubject = this.o;
            int i = 1;
            while (true) {
                boolean z = this.q;
                boolean z2 = this.g;
                Object poll = mpscLinkedQueue.poll();
                Object obj = r;
                if (!z2 || !(poll == null || poll == obj)) {
                    if (poll == null) {
                        i = f(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == obj) {
                        unicastSubject.onComplete();
                        if (!z) {
                            UnicastSubject unicastSubject2 = new UnicastSubject(this.m);
                            this.o = unicastSubject2;
                            serializedObserver.onNext(unicastSubject2);
                            unicastSubject = unicastSubject2;
                        } else {
                            this.n.dispose();
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.o = null;
            mpscLinkedQueue.clear();
            DisposableHelper.dispose(this.p);
            Throwable th = this.i;
            if (th != null) {
                unicastSubject.onError(th);
            } else {
                unicastSubject.onComplete();
            }
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final void onComplete() {
            this.g = true;
            if (b()) {
                g();
            }
            DisposableHelper.dispose(this.p);
            this.d.onComplete();
        }

        public final void onError(Throwable th) {
            this.i = th;
            this.g = true;
            if (b()) {
                g();
            }
            DisposableHelper.dispose(this.p);
            this.d.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.q) {
                if (c()) {
                    this.o.onNext(obj);
                    if (f(-1) == 0) {
                        return;
                    }
                } else {
                    this.e.offer(NotificationLite.next(obj));
                    if (!b()) {
                        return;
                    }
                }
                g();
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.n, disposable)) {
                this.n = disposable;
                this.o = new UnicastSubject(this.m);
                SerializedObserver serializedObserver = this.d;
                serializedObserver.onSubscribe(this);
                serializedObserver.onNext(this.o);
                if (!this.f) {
                    Scheduler scheduler = this.l;
                    long j2 = this.j;
                    DisposableHelper.replace(this.p, scheduler.e(this, j2, j2, this.k));
                }
            }
        }

        public final void run() {
            if (this.f) {
                this.q = true;
                DisposableHelper.dispose(this.p);
            }
            this.e.offer(r);
            if (b()) {
                g();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        public final long j;
        public final long k;
        public final TimeUnit l;
        public final Scheduler.Worker m;
        public final int n;
        public final LinkedList o = new LinkedList();
        public Disposable p;
        public volatile boolean q;

        public final class CompletionTask implements Runnable {
            public final UnicastSubject c;

            public CompletionTask(UnicastSubject unicastSubject) {
                this.c = unicastSubject;
            }

            public final void run() {
                WindowSkipObserver windowSkipObserver = WindowSkipObserver.this;
                windowSkipObserver.getClass();
                windowSkipObserver.e.offer(new SubjectWork(this.c, false));
                if (windowSkipObserver.b()) {
                    windowSkipObserver.g();
                }
            }
        }

        public static final class SubjectWork<T> {

            /* renamed from: a  reason: collision with root package name */
            public final UnicastSubject f675a;
            public final boolean b;

            public SubjectWork(UnicastSubject unicastSubject, boolean z) {
                this.f675a = unicastSubject;
                this.b = z;
            }
        }

        public WindowSkipObserver(SerializedObserver serializedObserver, long j2, long j3, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(serializedObserver, new MpscLinkedQueue());
            this.j = j2;
            this.k = j3;
            this.l = timeUnit;
            this.m = worker;
            this.n = i;
        }

        public final void dispose() {
            this.f = true;
        }

        public final void g() {
            boolean z;
            MpscLinkedQueue mpscLinkedQueue = this.e;
            SerializedObserver serializedObserver = this.d;
            LinkedList<UnicastSubject> linkedList = this.o;
            int i = 1;
            while (!this.q) {
                boolean z2 = this.g;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = poll instanceof SubjectWork;
                if (z2 && (z || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.i;
                    if (th != null) {
                        for (UnicastSubject onError : linkedList) {
                            onError.onError(th);
                        }
                    } else {
                        for (UnicastSubject onComplete : linkedList) {
                            onComplete.onComplete();
                        }
                    }
                    this.m.dispose();
                    linkedList.clear();
                    return;
                } else if (z) {
                    i = f(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.b) {
                        linkedList.remove(subjectWork.f675a);
                        subjectWork.f675a.onComplete();
                        if (linkedList.isEmpty() && this.f) {
                            this.q = true;
                        }
                    } else if (!this.f) {
                        UnicastSubject unicastSubject = new UnicastSubject(this.n);
                        linkedList.add(unicastSubject);
                        serializedObserver.onNext(unicastSubject);
                        this.m.c(new CompletionTask(unicastSubject), this.j, this.l);
                    }
                } else {
                    for (UnicastSubject onNext : linkedList) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.p.dispose();
            this.m.dispose();
            mpscLinkedQueue.clear();
            linkedList.clear();
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final void onComplete() {
            this.g = true;
            if (b()) {
                g();
            }
            this.d.onComplete();
            this.m.dispose();
        }

        public final void onError(Throwable th) {
            this.i = th;
            this.g = true;
            if (b()) {
                g();
            }
            this.d.onError(th);
            this.m.dispose();
        }

        public final void onNext(Object obj) {
            if (c()) {
                for (UnicastSubject onNext : this.o) {
                    onNext.onNext(obj);
                }
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.e.offer(obj);
                if (!b()) {
                    return;
                }
            }
            g();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.p, disposable)) {
                this.p = disposable;
                this.d.onSubscribe(this);
                if (!this.f) {
                    UnicastSubject unicastSubject = new UnicastSubject(this.n);
                    this.o.add(unicastSubject);
                    this.d.onNext(unicastSubject);
                    this.m.c(new CompletionTask(unicastSubject), this.j, this.l);
                    Scheduler.Worker worker = this.m;
                    long j2 = this.k;
                    worker.d(this, j2, j2, this.l);
                }
            }
        }

        public final void run() {
            SubjectWork subjectWork = new SubjectWork(new UnicastSubject(this.n), true);
            if (!this.f) {
                this.e.offer(subjectWork);
            }
            if (b()) {
                g();
            }
        }
    }

    public ObservableWindowTimed(Observable observable, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, long j4, int i2, boolean z) {
        super(observable);
        this.d = j2;
        this.e = j3;
        this.f = timeUnit;
        this.g = scheduler;
        this.i = j4;
        this.j = i2;
        this.k = z;
    }

    public final void subscribeActual(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ObservableSource observableSource = this.c;
        long j2 = this.d;
        long j3 = this.e;
        if (j2 == j3) {
            long j4 = this.i;
            if (j4 == LocationRequestCompat.PASSIVE_INTERVAL) {
                observableSource.subscribe(new WindowExactUnboundedObserver(serializedObserver, j2, this.f, this.g, this.j));
                return;
            }
            observableSource.subscribe(new WindowExactBoundedObserver(serializedObserver, j2, this.f, this.g, this.j, j4, this.k));
            return;
        }
        observableSource.subscribe(new WindowSkipObserver(serializedObserver, j2, j3, this.f, this.g.a(), this.j));
    }
}
