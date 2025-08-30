package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    public final Function d;
    public final boolean e;
    public final int f;
    public final int g;

    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        public final long c;
        public final MergeObserver d;
        public volatile boolean e;
        public volatile SimpleQueue f;
        public int g;

        public InnerObserver(MergeObserver mergeObserver, long j) {
            this.c = j;
            this.d = mergeObserver;
        }

        public final void onComplete() {
            this.e = true;
            this.d.c();
        }

        public final void onError(Throwable th) {
            if (this.d.k.addThrowable(th)) {
                MergeObserver mergeObserver = this.d;
                if (!mergeObserver.e) {
                    mergeObserver.b();
                }
                this.e = true;
                this.d.c();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (this.g == 0) {
                MergeObserver mergeObserver = this.d;
                if (mergeObserver.get() != 0 || !mergeObserver.compareAndSet(0, 1)) {
                    SimpleQueue simpleQueue = this.f;
                    if (simpleQueue == null) {
                        simpleQueue = new SpscLinkedArrayQueue(mergeObserver.g);
                        this.f = simpleQueue;
                    }
                    simpleQueue.offer(obj);
                    if (mergeObserver.getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    mergeObserver.c.onNext(obj);
                    if (mergeObserver.decrementAndGet() == 0) {
                        return;
                    }
                }
                mergeObserver.d();
                return;
            }
            this.d.c();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.g = requestFusion;
                    this.f = queueDisposable;
                    this.e = true;
                    this.d.c();
                } else if (requestFusion == 2) {
                    this.g = requestFusion;
                    this.f = queueDisposable;
                }
            }
        }
    }

    public static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        public static final InnerObserver[] t = new InnerObserver[0];
        public static final InnerObserver[] u = new InnerObserver[0];
        public final Observer c;
        public final Function d;
        public final boolean e;
        public final int f;
        public final int g;
        public volatile SimplePlainQueue i;
        public volatile boolean j;
        public final AtomicThrowable k = new AtomicThrowable();
        public volatile boolean l;
        public final AtomicReference m;
        public Disposable n;
        public long o;
        public long p;
        public int q;
        public final ArrayDeque r;
        public int s;

        public MergeObserver(int i2, int i3, Observer observer, Function function, boolean z) {
            this.c = observer;
            this.d = function;
            this.e = z;
            this.f = i2;
            this.g = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.r = new ArrayDeque(i2);
            }
            this.m = new AtomicReference(t);
        }

        public final boolean a() {
            if (this.l) {
                return true;
            }
            Throwable th = (Throwable) this.k.get();
            if (this.e || th == null) {
                return false;
            }
            b();
            Throwable terminate = this.k.terminate();
            if (terminate != ExceptionHelper.f682a) {
                this.c.onError(terminate);
            }
            return true;
        }

        public final boolean b() {
            InnerObserver[] innerObserverArr;
            this.n.dispose();
            AtomicReference atomicReference = this.m;
            InnerObserver[] innerObserverArr2 = (InnerObserver[]) atomicReference.get();
            InnerObserver[] innerObserverArr3 = u;
            if (innerObserverArr2 == innerObserverArr3 || (innerObserverArr = (InnerObserver[]) atomicReference.getAndSet(innerObserverArr3)) == innerObserverArr3) {
                return false;
            }
            for (InnerObserver innerObserver : innerObserverArr) {
                innerObserver.getClass();
                DisposableHelper.dispose(innerObserver);
            }
            return true;
        }

        public final void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b5, code lost:
            if (r12 != null) goto L_0x00a3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d() {
            /*
                r14 = this;
                io.reactivex.Observer r0 = r14.c
                r1 = 1
                r2 = 1
            L_0x0004:
                boolean r3 = r14.a()
                if (r3 == 0) goto L_0x000b
                return
            L_0x000b:
                io.reactivex.internal.fuseable.SimplePlainQueue r3 = r14.i
                if (r3 == 0) goto L_0x0023
            L_0x000f:
                boolean r4 = r14.a()
                if (r4 == 0) goto L_0x0016
                return
            L_0x0016:
                java.lang.Object r4 = r3.poll()
                if (r4 != 0) goto L_0x001f
                if (r4 != 0) goto L_0x000f
                goto L_0x0023
            L_0x001f:
                r0.onNext(r4)
                goto L_0x000f
            L_0x0023:
                boolean r3 = r14.j
                io.reactivex.internal.fuseable.SimplePlainQueue r4 = r14.i
                java.util.concurrent.atomic.AtomicReference r5 = r14.m
                java.lang.Object r5 = r5.get()
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r5 = (io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[]) r5
                int r6 = r5.length
                int r7 = r14.f
                r8 = 2147483647(0x7fffffff, float:NaN)
                r9 = 0
                if (r7 == r8) goto L_0x0044
                monitor-enter(r14)
                java.util.ArrayDeque r7 = r14.r     // Catch:{ all -> 0x0041 }
                int r7 = r7.size()     // Catch:{ all -> 0x0041 }
                monitor-exit(r14)     // Catch:{ all -> 0x0041 }
                goto L_0x0045
            L_0x0041:
                r0 = move-exception
                monitor-exit(r14)     // Catch:{ all -> 0x0041 }
                throw r0
            L_0x0044:
                r7 = 0
            L_0x0045:
                if (r3 == 0) goto L_0x0067
                if (r4 == 0) goto L_0x004f
                boolean r3 = r4.isEmpty()
                if (r3 == 0) goto L_0x0067
            L_0x004f:
                if (r6 != 0) goto L_0x0067
                if (r7 != 0) goto L_0x0067
                io.reactivex.internal.util.AtomicThrowable r1 = r14.k
                java.lang.Throwable r1 = r1.terminate()
                java.lang.Throwable r2 = io.reactivex.internal.util.ExceptionHelper.f682a
                if (r1 == r2) goto L_0x0066
                if (r1 != 0) goto L_0x0063
                r0.onComplete()
                goto L_0x0066
            L_0x0063:
                r0.onError(r1)
            L_0x0066:
                return
            L_0x0067:
                if (r6 == 0) goto L_0x0104
                long r3 = r14.p
                int r7 = r14.q
                if (r6 <= r7) goto L_0x0077
                r10 = r5[r7]
                long r10 = r10.c
                int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r12 == 0) goto L_0x0096
            L_0x0077:
                if (r6 > r7) goto L_0x007a
                r7 = 0
            L_0x007a:
                r10 = 0
            L_0x007b:
                if (r10 >= r6) goto L_0x008e
                r11 = r5[r7]
                long r11 = r11.c
                int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
                if (r13 != 0) goto L_0x0086
                goto L_0x008e
            L_0x0086:
                int r7 = r7 + 1
                if (r7 != r6) goto L_0x008b
                r7 = 0
            L_0x008b:
                int r10 = r10 + 1
                goto L_0x007b
            L_0x008e:
                r14.q = r7
                r3 = r5[r7]
                long r3 = r3.c
                r14.p = r3
            L_0x0096:
                r3 = 0
                r4 = 0
            L_0x0098:
                if (r3 >= r6) goto L_0x00fb
                boolean r10 = r14.a()
                if (r10 == 0) goto L_0x00a1
                return
            L_0x00a1:
                r10 = r5[r7]
            L_0x00a3:
                boolean r11 = r14.a()
                if (r11 == 0) goto L_0x00aa
                return
            L_0x00aa:
                io.reactivex.internal.fuseable.SimpleQueue r11 = r10.f
                if (r11 != 0) goto L_0x00af
                goto L_0x00b7
            L_0x00af:
                java.lang.Object r12 = r11.poll()     // Catch:{ all -> 0x00e0 }
                if (r12 != 0) goto L_0x00d6
                if (r12 != 0) goto L_0x00a3
            L_0x00b7:
                boolean r11 = r10.e
                io.reactivex.internal.fuseable.SimpleQueue r12 = r10.f
                if (r11 == 0) goto L_0x00d0
                if (r12 == 0) goto L_0x00c5
                boolean r11 = r12.isEmpty()
                if (r11 == 0) goto L_0x00d0
            L_0x00c5:
                r14.e(r10)
                boolean r4 = r14.a()
                if (r4 == 0) goto L_0x00cf
                return
            L_0x00cf:
                r4 = 1
            L_0x00d0:
                int r7 = r7 + 1
                if (r7 != r6) goto L_0x00f9
                r7 = 0
                goto L_0x00f9
            L_0x00d6:
                r0.onNext(r12)
                boolean r12 = r14.a()
                if (r12 == 0) goto L_0x00af
                return
            L_0x00e0:
                r4 = move-exception
                io.reactivex.exceptions.Exceptions.a(r4)
                io.reactivex.internal.disposables.DisposableHelper.dispose(r10)
                io.reactivex.internal.util.AtomicThrowable r11 = r14.k
                r11.addThrowable(r4)
                boolean r4 = r14.a()
                if (r4 == 0) goto L_0x00f3
                return
            L_0x00f3:
                r14.e(r10)
                int r3 = r3 + 1
                r4 = 1
            L_0x00f9:
                int r3 = r3 + r1
                goto L_0x0098
            L_0x00fb:
                r14.q = r7
                r3 = r5[r7]
                long r5 = r3.c
                r14.p = r5
                r9 = r4
            L_0x0104:
                if (r9 == 0) goto L_0x0127
                int r3 = r14.f
                if (r3 == r8) goto L_0x0004
                monitor-enter(r14)
                java.util.ArrayDeque r3 = r14.r     // Catch:{ all -> 0x011d }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x011d }
                io.reactivex.ObservableSource r3 = (io.reactivex.ObservableSource) r3     // Catch:{ all -> 0x011d }
                if (r3 != 0) goto L_0x011f
                int r3 = r14.s     // Catch:{ all -> 0x011d }
                int r3 = r3 - r1
                r14.s = r3     // Catch:{ all -> 0x011d }
                monitor-exit(r14)     // Catch:{ all -> 0x011d }
                goto L_0x0004
            L_0x011d:
                r0 = move-exception
                goto L_0x0125
            L_0x011f:
                monitor-exit(r14)     // Catch:{ all -> 0x011d }
                r14.f(r3)
                goto L_0x0004
            L_0x0125:
                monitor-exit(r14)     // Catch:{ all -> 0x011d }
                throw r0
            L_0x0127:
                int r2 = -r2
                int r2 = r14.addAndGet(r2)
                if (r2 != 0) goto L_0x0004
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.d():void");
        }

        public final void dispose() {
            Throwable terminate;
            if (!this.l) {
                this.l = true;
                if (b() && (terminate = this.k.terminate()) != null && terminate != ExceptionHelper.f682a) {
                    RxJavaPlugins.b(terminate);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void e(io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver r8) {
            /*
                r7 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r7.m
                java.lang.Object r1 = r0.get()
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r1 = (io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[]) r1
                int r2 = r1.length
                if (r2 != 0) goto L_0x000c
                return
            L_0x000c:
                r3 = 0
                r4 = 0
            L_0x000e:
                if (r4 >= r2) goto L_0x0018
                r5 = r1[r4]
                if (r5 != r8) goto L_0x0015
                goto L_0x0019
            L_0x0015:
                int r4 = r4 + 1
                goto L_0x000e
            L_0x0018:
                r4 = -1
            L_0x0019:
                if (r4 >= 0) goto L_0x001c
                return
            L_0x001c:
                r5 = 1
                if (r2 != r5) goto L_0x0022
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r2 = t
                goto L_0x0031
            L_0x0022:
                int r6 = r2 + -1
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r6 = new io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[r6]
                java.lang.System.arraycopy(r1, r3, r6, r3, r4)
                int r3 = r4 + 1
                int r2 = r2 - r4
                int r2 = r2 - r5
                java.lang.System.arraycopy(r1, r3, r6, r4, r2)
                r2 = r6
            L_0x0031:
                boolean r3 = r0.compareAndSet(r1, r2)
                if (r3 == 0) goto L_0x0038
                return
            L_0x0038:
                java.lang.Object r3 = r0.get()
                if (r3 == r1) goto L_0x0031
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.e(io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            if (decrementAndGet() == 0) goto L_0x006b;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void f(io.reactivex.ObservableSource r7) {
            /*
                r6 = this;
            L_0x0000:
                boolean r0 = r7 instanceof java.util.concurrent.Callable
                r1 = 0
                if (r0 == 0) goto L_0x008c
                java.util.concurrent.Callable r7 = (java.util.concurrent.Callable) r7
                r0 = 1
                r2 = 2147483647(0x7fffffff, float:NaN)
                java.lang.Object r7 = r7.call()     // Catch:{ all -> 0x005f }
                if (r7 != 0) goto L_0x0012
                goto L_0x006b
            L_0x0012:
                int r3 = r6.get()
                if (r3 != 0) goto L_0x002a
                boolean r3 = r6.compareAndSet(r1, r0)
                if (r3 == 0) goto L_0x002a
                io.reactivex.Observer r3 = r6.c
                r3.onNext(r7)
                int r7 = r6.decrementAndGet()
                if (r7 != 0) goto L_0x005b
                goto L_0x006b
            L_0x002a:
                io.reactivex.internal.fuseable.SimplePlainQueue r3 = r6.i
                if (r3 != 0) goto L_0x0043
                int r3 = r6.f
                if (r3 != r2) goto L_0x003a
                io.reactivex.internal.queue.SpscLinkedArrayQueue r3 = new io.reactivex.internal.queue.SpscLinkedArrayQueue
                int r4 = r6.g
                r3.<init>(r4)
                goto L_0x0041
            L_0x003a:
                io.reactivex.internal.queue.SpscArrayQueue r3 = new io.reactivex.internal.queue.SpscArrayQueue
                int r4 = r6.f
                r3.<init>(r4)
            L_0x0041:
                r6.i = r3
            L_0x0043:
                boolean r7 = r3.offer(r7)
                if (r7 != 0) goto L_0x0054
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r3 = "Scalar queue full?!"
                r7.<init>(r3)
                r6.onError(r7)
                goto L_0x006b
            L_0x0054:
                int r7 = r6.getAndIncrement()
                if (r7 == 0) goto L_0x005b
                goto L_0x00bb
            L_0x005b:
                r6.d()
                goto L_0x006b
            L_0x005f:
                r7 = move-exception
                io.reactivex.exceptions.Exceptions.a(r7)
                io.reactivex.internal.util.AtomicThrowable r3 = r6.k
                r3.addThrowable(r7)
                r6.c()
            L_0x006b:
                int r7 = r6.f
                if (r7 == r2) goto L_0x00bb
                monitor-enter(r6)
                java.util.ArrayDeque r7 = r6.r     // Catch:{ all -> 0x0081 }
                java.lang.Object r7 = r7.poll()     // Catch:{ all -> 0x0081 }
                io.reactivex.ObservableSource r7 = (io.reactivex.ObservableSource) r7     // Catch:{ all -> 0x0081 }
                if (r7 != 0) goto L_0x0083
                int r1 = r6.s     // Catch:{ all -> 0x0081 }
                int r1 = r1 - r0
                r6.s = r1     // Catch:{ all -> 0x0081 }
                r1 = 1
                goto L_0x0083
            L_0x0081:
                r7 = move-exception
                goto L_0x008a
            L_0x0083:
                monitor-exit(r6)     // Catch:{ all -> 0x0081 }
                if (r1 == 0) goto L_0x0000
                r6.c()
                goto L_0x00bb
            L_0x008a:
                monitor-exit(r6)     // Catch:{ all -> 0x0081 }
                throw r7
            L_0x008c:
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver r0 = new io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver
                long r2 = r6.o
                r4 = 1
                long r4 = r4 + r2
                r6.o = r4
                r0.<init>(r6, r2)
            L_0x0098:
                java.util.concurrent.atomic.AtomicReference r2 = r6.m
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r3 = (io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[]) r3
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r4 = u
                if (r3 != r4) goto L_0x00a8
                io.reactivex.internal.disposables.DisposableHelper.dispose(r0)
                goto L_0x00bb
            L_0x00a8:
                int r4 = r3.length
                int r5 = r4 + 1
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r5 = new io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[r5]
                java.lang.System.arraycopy(r3, r1, r5, r1, r4)
                r5[r4] = r0
            L_0x00b2:
                boolean r4 = r2.compareAndSet(r3, r5)
                if (r4 == 0) goto L_0x00bc
                r7.subscribe(r0)
            L_0x00bb:
                return
            L_0x00bc:
                java.lang.Object r4 = r2.get()
                if (r4 == r3) goto L_0x00b2
                goto L_0x0098
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.f(io.reactivex.ObservableSource):void");
        }

        public final boolean isDisposed() {
            return this.l;
        }

        public final void onComplete() {
            if (!this.j) {
                this.j = true;
                c();
            }
        }

        public final void onError(Throwable th) {
            if (this.j) {
                RxJavaPlugins.b(th);
            } else if (this.k.addThrowable(th)) {
                this.j = true;
                c();
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onNext(Object obj) {
            if (!this.j) {
                try {
                    Object apply = this.d.apply(obj);
                    ObjectHelper.b(apply, "The mapper returned a null ObservableSource");
                    ObservableSource observableSource = (ObservableSource) apply;
                    if (this.f != Integer.MAX_VALUE) {
                        synchronized (this) {
                            try {
                                int i2 = this.s;
                                if (i2 == this.f) {
                                    this.r.offer(observableSource);
                                    return;
                                }
                                this.s = i2 + 1;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    f(observableSource);
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    this.n.dispose();
                    onError(th2);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.n, disposable)) {
                this.n = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(ObservableSource observableSource, Function function, boolean z, int i, int i2) {
        super(observableSource);
        this.d = function;
        this.e = z;
        this.f = i;
        this.g = i2;
    }

    public final void subscribeActual(Observer observer) {
        ObservableSource observableSource = this.c;
        if (!ObservableScalarXMap.b(observableSource, observer, this.d)) {
            observableSource.subscribe(new MergeObserver(this.f, this.g, observer, this.d, this.e));
        }
    }
}
