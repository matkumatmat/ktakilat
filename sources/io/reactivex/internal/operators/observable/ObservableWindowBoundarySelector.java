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
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public final ObservableSource d;
    public final Function e;
    public final int f;

    public static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {
        public final WindowBoundaryMainObserver d;
        public final UnicastSubject e;
        public boolean f;

        public OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver windowBoundaryMainObserver, UnicastSubject unicastSubject) {
            this.d = windowBoundaryMainObserver;
            this.e = unicastSubject;
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                WindowBoundaryMainObserver windowBoundaryMainObserver = this.d;
                windowBoundaryMainObserver.m.c(this);
                windowBoundaryMainObserver.e.offer(new WindowOperation(this.e, (Object) null));
                if (windowBoundaryMainObserver.b()) {
                    windowBoundaryMainObserver.g();
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            WindowBoundaryMainObserver windowBoundaryMainObserver = this.d;
            windowBoundaryMainObserver.n.dispose();
            windowBoundaryMainObserver.m.dispose();
            windowBoundaryMainObserver.onError(th);
        }

        public final void onNext(Object obj) {
            dispose();
            onComplete();
        }
    }

    public static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {
        public final WindowBoundaryMainObserver d;

        public OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver windowBoundaryMainObserver) {
            this.d = windowBoundaryMainObserver;
        }

        public final void onComplete() {
            this.d.onComplete();
        }

        public final void onError(Throwable th) {
            WindowBoundaryMainObserver windowBoundaryMainObserver = this.d;
            windowBoundaryMainObserver.n.dispose();
            windowBoundaryMainObserver.m.dispose();
            windowBoundaryMainObserver.onError(th);
        }

        public final void onNext(Object obj) {
            WindowBoundaryMainObserver windowBoundaryMainObserver = this.d;
            windowBoundaryMainObserver.getClass();
            windowBoundaryMainObserver.e.offer(new WindowOperation((UnicastSubject) null, obj));
            if (windowBoundaryMainObserver.b()) {
                windowBoundaryMainObserver.g();
            }
        }
    }

    public static final class WindowOperation<T, B> {

        /* renamed from: a  reason: collision with root package name */
        public final UnicastSubject f674a;
        public final Object b;

        public WindowOperation(UnicastSubject unicastSubject, Object obj) {
            this.f674a = unicastSubject;
            this.b = obj;
        }
    }

    public ObservableWindowBoundarySelector(Observable observable, ObservableSource observableSource, Function function, int i) {
        super(observable);
        this.d = observableSource;
        this.e = function;
        this.f = i;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.d, this.e, this.f));
    }

    public static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        public final ObservableSource j;
        public final Function k;
        public final int l;
        public final CompositeDisposable m;
        public Disposable n;
        public final AtomicReference o = new AtomicReference();
        public final ArrayList p;
        public final AtomicLong q;

        /* JADX WARNING: type inference failed for: r3v1, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public WindowBoundaryMainObserver(SerializedObserver serializedObserver, ObservableSource observableSource, Function function, int i) {
            super(serializedObserver, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.q = atomicLong;
            this.j = observableSource;
            this.k = function;
            this.l = i;
            this.m = new Object();
            this.p = new ArrayList();
            atomicLong.lazySet(1);
        }

        public final void dispose() {
            this.f = true;
        }

        public final void g() {
            boolean z;
            MpscLinkedQueue mpscLinkedQueue = this.e;
            SerializedObserver serializedObserver = this.d;
            ArrayList arrayList = this.p;
            int i = 1;
            while (true) {
                boolean z2 = this.g;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    this.m.dispose();
                    DisposableHelper.dispose(this.o);
                    Throwable th = this.i;
                    if (th != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((UnicastSubject) it.next()).onError(th);
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((UnicastSubject) it2.next()).onComplete();
                        }
                    }
                    arrayList.clear();
                    return;
                } else if (z) {
                    i = f(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    UnicastSubject unicastSubject = windowOperation.f674a;
                    if (unicastSubject != null) {
                        if (arrayList.remove(unicastSubject)) {
                            windowOperation.f674a.onComplete();
                            if (this.q.decrementAndGet() == 0) {
                                this.m.dispose();
                                DisposableHelper.dispose(this.o);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f) {
                        UnicastSubject unicastSubject2 = new UnicastSubject(this.l);
                        arrayList.add(unicastSubject2);
                        serializedObserver.onNext(unicastSubject2);
                        try {
                            Object apply = this.k.apply(windowOperation.b);
                            ObjectHelper.b(apply, "The ObservableSource supplied is null");
                            ObservableSource observableSource = (ObservableSource) apply;
                            OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver = new OperatorWindowBoundaryCloseObserver(this, unicastSubject2);
                            if (this.m.b(operatorWindowBoundaryCloseObserver)) {
                                this.q.getAndIncrement();
                                observableSource.subscribe(operatorWindowBoundaryCloseObserver);
                            }
                        } catch (Throwable th2) {
                            Exceptions.a(th2);
                            this.f = true;
                            serializedObserver.onError(th2);
                        }
                    }
                } else {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        ((UnicastSubject) it3.next()).onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final void onComplete() {
            if (!this.g) {
                this.g = true;
                if (b()) {
                    g();
                }
                if (this.q.decrementAndGet() == 0) {
                    this.m.dispose();
                }
                this.d.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.b(th);
                return;
            }
            this.i = th;
            this.g = true;
            if (b()) {
                g();
            }
            if (this.q.decrementAndGet() == 0) {
                this.m.dispose();
            }
            this.d.onError(th);
        }

        public final void onNext(Object obj) {
            if (c()) {
                Iterator it = this.p.iterator();
                while (it.hasNext()) {
                    ((UnicastSubject) it.next()).onNext(obj);
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
            g();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.n, disposable)) {
                this.n = disposable;
                this.d.onSubscribe(this);
                if (!this.f) {
                    OperatorWindowBoundaryOpenObserver operatorWindowBoundaryOpenObserver = new OperatorWindowBoundaryOpenObserver(this);
                    AtomicReference atomicReference = this.o;
                    while (!atomicReference.compareAndSet((Object) null, operatorWindowBoundaryOpenObserver)) {
                        if (atomicReference.get() != null) {
                            return;
                        }
                    }
                    this.q.getAndIncrement();
                    this.j.subscribe(operatorWindowBoundaryOpenObserver);
                }
            }
        }

        public final void a(SerializedObserver serializedObserver, Object obj) {
        }
    }
}
