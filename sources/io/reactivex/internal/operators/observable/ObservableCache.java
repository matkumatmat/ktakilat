package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> {
    public final CacheState d;
    public final AtomicBoolean e = new AtomicBoolean();

    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        public static final ReplayDisposable[] m = new ReplayDisposable[0];
        public static final ReplayDisposable[] n = new ReplayDisposable[0];
        public final Observable i;
        public final SequentialDisposable j = new SequentialDisposable();
        public final AtomicReference k = new AtomicReference(m);
        public boolean l;

        public CacheState(Observable observable, int i2) {
            super(i2);
            this.i = observable;
        }

        public final void onComplete() {
            if (!this.l) {
                this.l = true;
                a(NotificationLite.complete());
                this.j.dispose();
                for (ReplayDisposable a2 : (ReplayDisposable[]) this.k.getAndSet(n)) {
                    a2.a();
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.l) {
                this.l = true;
                a(NotificationLite.error(th));
                this.j.dispose();
                for (ReplayDisposable a2 : (ReplayDisposable[]) this.k.getAndSet(n)) {
                    a2.a();
                }
            }
        }

        public final void onNext(Object obj) {
            if (!this.l) {
                a(NotificationLite.next(obj));
                for (ReplayDisposable a2 : (ReplayDisposable[]) this.k.get()) {
                    a2.a();
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            this.j.update(disposable);
        }
    }

    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 7058506693698832024L;
        public final Observer c;
        public final CacheState d;
        public Object[] e;
        public int f;
        public int g;
        public volatile boolean i;

        public ReplayDisposable(Observer observer, CacheState cacheState) {
            this.c = observer;
            this.d = cacheState;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                Observer observer = this.c;
                int i2 = 1;
                while (!this.i) {
                    int i3 = this.d.f;
                    if (i3 != 0) {
                        Object[] objArr = this.e;
                        if (objArr == null) {
                            objArr = this.d.d;
                            this.e = objArr;
                        }
                        int length = objArr.length - 1;
                        int i4 = this.g;
                        int i5 = this.f;
                        while (i4 < i3) {
                            if (!this.i) {
                                if (i5 == length) {
                                    objArr = (Object[]) objArr[length];
                                    i5 = 0;
                                }
                                if (!NotificationLite.accept(objArr[i5], observer)) {
                                    i5++;
                                    i4++;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!this.i) {
                            this.g = i4;
                            this.f = i5;
                            this.e = objArr;
                        } else {
                            return;
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dispose() {
            /*
                r8 = this;
                boolean r0 = r8.i
                if (r0 != 0) goto L_0x004b
                r0 = 1
                r8.i = r0
                io.reactivex.internal.operators.observable.ObservableCache$CacheState r1 = r8.d
            L_0x0009:
                java.util.concurrent.atomic.AtomicReference r2 = r1.k
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable[] r3 = (io.reactivex.internal.operators.observable.ObservableCache.ReplayDisposable[]) r3
                int r4 = r3.length
                if (r4 != 0) goto L_0x0015
                goto L_0x004b
            L_0x0015:
                r5 = 0
                r6 = 0
            L_0x0017:
                if (r6 >= r4) goto L_0x0025
                r7 = r3[r6]
                boolean r7 = r7.equals(r8)
                if (r7 == 0) goto L_0x0022
                goto L_0x0026
            L_0x0022:
                int r6 = r6 + 1
                goto L_0x0017
            L_0x0025:
                r6 = -1
            L_0x0026:
                if (r6 >= 0) goto L_0x0029
                goto L_0x004b
            L_0x0029:
                if (r4 != r0) goto L_0x002e
                io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable[] r4 = io.reactivex.internal.operators.observable.ObservableCache.CacheState.m
                goto L_0x003d
            L_0x002e:
                int r7 = r4 + -1
                io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable[] r7 = new io.reactivex.internal.operators.observable.ObservableCache.ReplayDisposable[r7]
                java.lang.System.arraycopy(r3, r5, r7, r5, r6)
                int r5 = r6 + 1
                int r4 = r4 - r6
                int r4 = r4 - r0
                java.lang.System.arraycopy(r3, r5, r7, r6, r4)
                r4 = r7
            L_0x003d:
                boolean r5 = r2.compareAndSet(r3, r4)
                if (r5 == 0) goto L_0x0044
                goto L_0x004b
            L_0x0044:
                java.lang.Object r5 = r2.get()
                if (r5 == r3) goto L_0x003d
                goto L_0x0009
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCache.ReplayDisposable.dispose():void");
        }

        public final boolean isDisposed() {
            return this.i;
        }
    }

    public ObservableCache(Observable observable, CacheState cacheState) {
        super(observable);
        this.d = cacheState;
    }

    public static ObservableCache c(Observable observable, int i) {
        ObjectHelper.c(i, "capacityHint");
        return new ObservableCache(observable, new CacheState(observable, i));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void subscribeActual(io.reactivex.Observer r7) {
        /*
            r6 = this;
            io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable r0 = new io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable
            io.reactivex.internal.operators.observable.ObservableCache$CacheState r1 = r6.d
            r0.<init>(r7, r1)
            r7.onSubscribe(r0)
        L_0x000a:
            java.util.concurrent.atomic.AtomicReference r7 = r1.k
            java.lang.Object r2 = r7.get()
            io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable[] r2 = (io.reactivex.internal.operators.observable.ObservableCache.ReplayDisposable[]) r2
            io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable[] r3 = io.reactivex.internal.operators.observable.ObservableCache.CacheState.n
            r4 = 0
            if (r2 != r3) goto L_0x0018
            goto L_0x0028
        L_0x0018:
            int r3 = r2.length
            int r5 = r3 + 1
            io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable[] r5 = new io.reactivex.internal.operators.observable.ObservableCache.ReplayDisposable[r5]
            java.lang.System.arraycopy(r2, r4, r5, r4, r3)
            r5[r3] = r0
        L_0x0022:
            boolean r3 = r7.compareAndSet(r2, r5)
            if (r3 == 0) goto L_0x0040
        L_0x0028:
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.e
            boolean r2 = r7.get()
            if (r2 != 0) goto L_0x003c
            r2 = 1
            boolean r7 = r7.compareAndSet(r4, r2)
            if (r7 == 0) goto L_0x003c
            io.reactivex.Observable r7 = r1.i
            r7.subscribe(r1)
        L_0x003c:
            r0.a()
            return
        L_0x0040:
            java.lang.Object r3 = r7.get()
            if (r3 == r2) goto L_0x0022
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCache.subscribeActual(io.reactivex.Observer):void");
    }
}
