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
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    public final ObservableSource d;
    public final Callable e;

    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        public final BufferExactBoundaryObserver d;

        public BufferBoundaryObserver(BufferExactBoundaryObserver bufferExactBoundaryObserver) {
            this.d = bufferExactBoundaryObserver;
        }

        public final void onComplete() {
            this.d.onComplete();
        }

        public final void onError(Throwable th) {
            this.d.onError(th);
        }

        public final void onNext(Object obj) {
            BufferExactBoundaryObserver bufferExactBoundaryObserver = this.d;
            bufferExactBoundaryObserver.getClass();
            try {
                Object call = bufferExactBoundaryObserver.j.call();
                ObjectHelper.b(call, "The buffer supplied is null");
                Collection collection = (Collection) call;
                synchronized (bufferExactBoundaryObserver) {
                    try {
                        Collection collection2 = bufferExactBoundaryObserver.n;
                        if (collection2 != null) {
                            bufferExactBoundaryObserver.n = collection;
                            bufferExactBoundaryObserver.d(collection2, bufferExactBoundaryObserver);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.a(th2);
                bufferExactBoundaryObserver.dispose();
                bufferExactBoundaryObserver.d.onError(th2);
            }
        }
    }

    public static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        public final Callable j;
        public final ObservableSource k;
        public Disposable l;
        public Disposable m;
        public Collection n;

        public BufferExactBoundaryObserver(SerializedObserver serializedObserver, Callable callable, ObservableSource observableSource) {
            super(serializedObserver, new MpscLinkedQueue());
            this.j = callable;
            this.k = observableSource;
        }

        public final void a(SerializedObserver serializedObserver, Object obj) {
            this.d.onNext((Collection) obj);
        }

        public final void dispose() {
            if (!this.f) {
                this.f = true;
                ((DisposableObserver) this.m).dispose();
                this.l.dispose();
                if (b()) {
                    this.e.clear();
                }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver.onComplete():void");
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
                try {
                    Object call = this.j.call();
                    ObjectHelper.b(call, "The buffer supplied is null");
                    this.n = (Collection) call;
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.m = bufferBoundaryObserver;
                    this.d.onSubscribe(this);
                    if (!this.f) {
                        this.k.subscribe(bufferBoundaryObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.f = true;
                    disposable.dispose();
                    EmptyDisposable.error(th, (Observer<?>) this.d);
                }
            }
        }
    }

    public ObservableBufferExactBoundary(Observable observable, ObservableSource observableSource, Callable callable) {
        super(observable);
        this.d = observableSource;
        this.e = callable;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.e, this.d));
    }
}
