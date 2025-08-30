package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    public final Callable d;
    public final Callable e;

    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        public final BufferBoundarySupplierObserver d;
        public boolean e;

        public BufferBoundaryObserver(BufferBoundarySupplierObserver bufferBoundarySupplierObserver) {
            this.d = bufferBoundarySupplierObserver;
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                this.d.g();
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            this.d.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                this.e = true;
                dispose();
                this.d.g();
            }
        }
    }

    public static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        public final Callable j;
        public final Callable k;
        public Disposable l;
        public final AtomicReference m = new AtomicReference();
        public Collection n;

        public BufferBoundarySupplierObserver(SerializedObserver serializedObserver, Callable callable, Callable callable2) {
            super(serializedObserver, new MpscLinkedQueue());
            this.j = callable;
            this.k = callable2;
        }

        public final void a(SerializedObserver serializedObserver, Object obj) {
            this.d.onNext((Collection) obj);
        }

        public final void dispose() {
            if (!this.f) {
                this.f = true;
                this.l.dispose();
                DisposableHelper.dispose(this.m);
                if (b()) {
                    this.e.clear();
                }
            }
        }

        public final void g() {
            try {
                Object call = this.j.call();
                ObjectHelper.b(call, "The buffer supplied is null");
                Collection collection = (Collection) call;
                try {
                    Object call2 = this.k.call();
                    ObjectHelper.b(call2, "The boundary ObservableSource supplied is null");
                    ObservableSource observableSource = (ObservableSource) call2;
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (DisposableHelper.replace(this.m, bufferBoundaryObserver)) {
                        synchronized (this) {
                            try {
                                Collection collection2 = this.n;
                                if (collection2 != null) {
                                    this.n = collection;
                                    observableSource.subscribe(bufferBoundaryObserver);
                                    d(collection2, this);
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    this.f = true;
                    this.l.dispose();
                    this.d.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.a(th3);
                dispose();
                this.d.onError(th3);
            }
        }

        public final boolean isDisposed() {
            return this.f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x000d, code lost:
            r2.e.offer(r0);
            r2.g = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (b() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            io.reactivex.internal.util.QueueDrainHelper.b(r2.e, r2.d, r2, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
                r2 = this;
                monitor-enter(r2)
                java.util.Collection r0 = r2.n     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r0 = move-exception
                goto L_0x0023
            L_0x0009:
                r1 = 0
                r2.n = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                io.reactivex.internal.queue.MpscLinkedQueue r1 = r2.e
                r1.offer(r0)
                r0 = 1
                r2.g = r0
                boolean r0 = r2.b()
                if (r0 == 0) goto L_0x0022
                io.reactivex.internal.queue.MpscLinkedQueue r0 = r2.e
                io.reactivex.observers.SerializedObserver r1 = r2.d
                io.reactivex.internal.util.QueueDrainHelper.b(r0, r1, r2, r2)
            L_0x0022:
                return
            L_0x0023:
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver.onComplete():void");
        }

        public final void onError(Throwable th) {
            dispose();
            this.d.onError(th);
        }

        public final void onNext(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.n;
                    if (collection != null) {
                        collection.add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.l, disposable)) {
                this.l = disposable;
                SerializedObserver serializedObserver = this.d;
                try {
                    Object call = this.j.call();
                    ObjectHelper.b(call, "The buffer supplied is null");
                    this.n = (Collection) call;
                    try {
                        Object call2 = this.k.call();
                        ObjectHelper.b(call2, "The boundary ObservableSource supplied is null");
                        ObservableSource observableSource = (ObservableSource) call2;
                        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                        this.m.set(bufferBoundaryObserver);
                        serializedObserver.onSubscribe(this);
                        if (!this.f) {
                            observableSource.subscribe(bufferBoundaryObserver);
                        }
                    } catch (Throwable th) {
                        Exceptions.a(th);
                        this.f = true;
                        disposable.dispose();
                        EmptyDisposable.error(th, (Observer<?>) serializedObserver);
                    }
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    this.f = true;
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) serializedObserver);
                }
            }
        }
    }

    public ObservableBufferBoundarySupplier(Observable observable, Callable callable, Callable callable2) {
        super(observable);
        this.d = callable;
        this.e = callable2;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.e, this.d));
    }
}
