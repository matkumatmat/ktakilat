package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final Function d;
    public final int e;
    public final boolean f;

    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        public final SwitchMapObserver c;
        public final long d;
        public final int e;
        public volatile SimpleQueue f;
        public volatile boolean g;

        public SwitchMapInnerObserver(SwitchMapObserver switchMapObserver, long j, int i) {
            this.c = switchMapObserver;
            this.d = j;
            this.e = i;
        }

        public final void onComplete() {
            if (this.d == this.c.m) {
                this.g = true;
                this.c.b();
            }
        }

        public final void onError(Throwable th) {
            SwitchMapObserver switchMapObserver = this.c;
            switchMapObserver.getClass();
            if (this.d != switchMapObserver.m || !switchMapObserver.g.addThrowable(th)) {
                RxJavaPlugins.b(th);
                return;
            }
            if (!switchMapObserver.f) {
                switchMapObserver.k.dispose();
            }
            this.g = true;
            switchMapObserver.b();
        }

        public final void onNext(Object obj) {
            if (this.d == this.c.m) {
                if (obj != null) {
                    this.f.offer(obj);
                }
                this.c.b();
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f = queueDisposable;
                        this.g = true;
                        this.c.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f = queueDisposable;
                        return;
                    }
                }
                this.f = new SpscLinkedArrayQueue(this.e);
            }
        }
    }

    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final SwitchMapInnerObserver n;
        private static final long serialVersionUID = -3491074160481096299L;
        public final Observer c;
        public final Function d;
        public final int e;
        public final boolean f;
        public final AtomicThrowable g;
        public volatile boolean i;
        public volatile boolean j;
        public Disposable k;
        public final AtomicReference l = new AtomicReference();
        public volatile long m;

        static {
            SwitchMapInnerObserver switchMapInnerObserver = new SwitchMapInnerObserver((SwitchMapObserver) null, -1, 1);
            n = switchMapInnerObserver;
            DisposableHelper.dispose(switchMapInnerObserver);
        }

        public SwitchMapObserver(Observer observer, Function function, int i2, boolean z) {
            this.c = observer;
            this.d = function;
            this.e = i2;
            this.f = z;
            this.g = new AtomicThrowable();
        }

        public final void a() {
            SwitchMapInnerObserver switchMapInnerObserver;
            AtomicReference atomicReference = this.l;
            SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.get();
            SwitchMapInnerObserver switchMapInnerObserver3 = n;
            if (switchMapInnerObserver2 != switchMapInnerObserver3 && (switchMapInnerObserver = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver3)) != switchMapInnerObserver3 && switchMapInnerObserver != null) {
                DisposableHelper.dispose(switchMapInnerObserver);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x000f A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x006b A[LOOP:1: B:35:0x006b->B:38:0x0076, LOOP_START] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A[LOOP:2: B:44:0x008f->B:47:0x009b, LOOP_START] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3 A[LOOP:4: B:65:0x00d3->B:68:0x00de, LOOP_START] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x00fb A[LOOP:5: B:78:0x00fb->B:81:0x0106, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.Observer r0 = r13.c
                java.util.concurrent.atomic.AtomicReference r1 = r13.l
                boolean r2 = r13.f
                r3 = 1
                r4 = 1
            L_0x000f:
                boolean r5 = r13.j
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                boolean r5 = r13.i
                r6 = 0
                if (r5 == 0) goto L_0x0052
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L_0x0021
                r5 = 1
                goto L_0x0022
            L_0x0021:
                r5 = 0
            L_0x0022:
                if (r2 == 0) goto L_0x0038
                if (r5 == 0) goto L_0x0052
                io.reactivex.internal.util.AtomicThrowable r1 = r13.g
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0034
                r0.onError(r1)
                goto L_0x0037
            L_0x0034:
                r0.onComplete()
            L_0x0037:
                return
            L_0x0038:
                io.reactivex.internal.util.AtomicThrowable r7 = r13.g
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x004c
                io.reactivex.internal.util.AtomicThrowable r1 = r13.g
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L_0x004c:
                if (r5 == 0) goto L_0x0052
                r0.onComplete()
                return
            L_0x0052:
                java.lang.Object r5 = r1.get()
                io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver r5 = (io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver) r5
                if (r5 == 0) goto L_0x0113
                io.reactivex.internal.fuseable.SimpleQueue r7 = r5.f
                if (r7 == 0) goto L_0x0113
                boolean r8 = r5.g
                r9 = 0
                if (r8 == 0) goto L_0x009f
                boolean r8 = r7.isEmpty()
                if (r2 == 0) goto L_0x0079
                if (r8 == 0) goto L_0x009f
            L_0x006b:
                boolean r6 = r1.compareAndSet(r5, r9)
                if (r6 == 0) goto L_0x0072
                goto L_0x000f
            L_0x0072:
                java.lang.Object r6 = r1.get()
                if (r6 == r5) goto L_0x006b
                goto L_0x000f
            L_0x0079:
                io.reactivex.internal.util.AtomicThrowable r10 = r13.g
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x008d
                io.reactivex.internal.util.AtomicThrowable r1 = r13.g
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L_0x008d:
                if (r8 == 0) goto L_0x009f
            L_0x008f:
                boolean r6 = r1.compareAndSet(r5, r9)
                if (r6 == 0) goto L_0x0097
                goto L_0x000f
            L_0x0097:
                java.lang.Object r6 = r1.get()
                if (r6 == r5) goto L_0x008f
                goto L_0x000f
            L_0x009f:
                r8 = 0
            L_0x00a0:
                boolean r10 = r13.j
                if (r10 == 0) goto L_0x00a5
                return
            L_0x00a5:
                java.lang.Object r10 = r1.get()
                if (r5 == r10) goto L_0x00ad
            L_0x00ab:
                r8 = 1
                goto L_0x010b
            L_0x00ad:
                if (r2 != 0) goto L_0x00c3
                io.reactivex.internal.util.AtomicThrowable r10 = r13.g
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x00c3
                io.reactivex.internal.util.AtomicThrowable r1 = r13.g
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L_0x00c3:
                boolean r10 = r5.g
                java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x00ca }
                goto L_0x00f2
            L_0x00ca:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.a(r8)
                io.reactivex.internal.util.AtomicThrowable r11 = r13.g
                r11.addThrowable(r8)
            L_0x00d3:
                boolean r8 = r1.compareAndSet(r5, r9)
                if (r8 == 0) goto L_0x00da
                goto L_0x00e0
            L_0x00da:
                java.lang.Object r8 = r1.get()
                if (r8 == r5) goto L_0x00d3
            L_0x00e0:
                if (r2 != 0) goto L_0x00ed
                r13.a()
                io.reactivex.disposables.Disposable r8 = r13.k
                r8.dispose()
                r13.i = r3
                goto L_0x00f0
            L_0x00ed:
                io.reactivex.internal.disposables.DisposableHelper.dispose(r5)
            L_0x00f0:
                r11 = r9
                r8 = 1
            L_0x00f2:
                if (r11 != 0) goto L_0x00f6
                r12 = 1
                goto L_0x00f7
            L_0x00f6:
                r12 = 0
            L_0x00f7:
                if (r10 == 0) goto L_0x0109
                if (r12 == 0) goto L_0x0109
            L_0x00fb:
                boolean r6 = r1.compareAndSet(r5, r9)
                if (r6 == 0) goto L_0x0102
                goto L_0x0108
            L_0x0102:
                java.lang.Object r6 = r1.get()
                if (r6 == r5) goto L_0x00fb
            L_0x0108:
                goto L_0x00ab
            L_0x0109:
                if (r12 == 0) goto L_0x010f
            L_0x010b:
                if (r8 == 0) goto L_0x0113
                goto L_0x000f
            L_0x010f:
                r0.onNext(r11)
                goto L_0x00a0
            L_0x0113:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.b():void");
        }

        public final void dispose() {
            if (!this.j) {
                this.j = true;
                this.k.dispose();
                a();
            }
        }

        public final boolean isDisposed() {
            return this.j;
        }

        public final void onComplete() {
            if (!this.i) {
                this.i = true;
                b();
            }
        }

        public final void onError(Throwable th) {
            if (this.i || !this.g.addThrowable(th)) {
                RxJavaPlugins.b(th);
                return;
            }
            if (!this.f) {
                a();
            }
            this.i = true;
            b();
        }

        public final void onNext(Object obj) {
            long j2 = this.m + 1;
            this.m = j2;
            SwitchMapInnerObserver switchMapInnerObserver = (SwitchMapInnerObserver) this.l.get();
            if (switchMapInnerObserver != null) {
                DisposableHelper.dispose(switchMapInnerObserver);
            }
            try {
                Object apply = this.d.apply(obj);
                ObjectHelper.b(apply, "The ObservableSource returned is null");
                ObservableSource observableSource = (ObservableSource) apply;
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this, j2, this.e);
                while (true) {
                    SwitchMapInnerObserver switchMapInnerObserver3 = (SwitchMapInnerObserver) this.l.get();
                    if (switchMapInnerObserver3 != n) {
                        AtomicReference atomicReference = this.l;
                        while (true) {
                            if (atomicReference.compareAndSet(switchMapInnerObserver3, switchMapInnerObserver2)) {
                                observableSource.subscribe(switchMapInnerObserver2);
                                return;
                            } else if (atomicReference.get() != switchMapInnerObserver3) {
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                this.k.dispose();
                onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource observableSource, Function function, int i, boolean z) {
        super(observableSource);
        this.d = function;
        this.e = i;
        this.f = z;
    }

    public final void subscribeActual(Observer observer) {
        ObservableSource observableSource = this.c;
        Function function = this.d;
        if (!ObservableScalarXMap.b(observableSource, observer, function)) {
            observableSource.subscribe(new SwitchMapObserver(observer, function, this.e, this.f));
        }
    }
}
