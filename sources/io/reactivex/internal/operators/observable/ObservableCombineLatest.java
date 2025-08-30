package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {
    public final ObservableSource[] c;
    public final Iterable d;
    public final Function e;
    public final int f;
    public final boolean g;

    public static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        public final LatestCoordinator c;
        public final int d;

        public CombinerObserver(LatestCoordinator latestCoordinator, int i) {
            this.c = latestCoordinator;
            this.d = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
            if (r4 == r2.length) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
            if (r1 == false) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
            r0.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
            r0.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
                r5 = this;
                io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator r0 = r5.c
                int r1 = r5.d
                monitor-enter(r0)
                java.lang.Object[] r2 = r0.f     // Catch:{ all -> 0x000b }
                if (r2 != 0) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                goto L_0x002a
            L_0x000b:
                r1 = move-exception
                goto L_0x002b
            L_0x000d:
                r1 = r2[r1]     // Catch:{ all -> 0x000b }
                r3 = 1
                if (r1 != 0) goto L_0x0014
                r1 = 1
                goto L_0x0015
            L_0x0014:
                r1 = 0
            L_0x0015:
                if (r1 != 0) goto L_0x001f
                int r4 = r0.n     // Catch:{ all -> 0x000b }
                int r4 = r4 + r3
                r0.n = r4     // Catch:{ all -> 0x000b }
                int r2 = r2.length     // Catch:{ all -> 0x000b }
                if (r4 != r2) goto L_0x0021
            L_0x001f:
                r0.k = r3     // Catch:{ all -> 0x000b }
            L_0x0021:
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                if (r1 == 0) goto L_0x0027
                r0.a()
            L_0x0027:
                r0.c()
            L_0x002a:
                return
            L_0x002b:
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver.onComplete():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            if (r3 == r5.length) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
            r2 = r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onError(java.lang.Throwable r5) {
            /*
                r4 = this;
                io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator r0 = r4.c
                int r1 = r4.d
                io.reactivex.internal.util.AtomicThrowable r2 = r0.l
                boolean r2 = r2.addThrowable(r5)
                if (r2 == 0) goto L_0x003b
                boolean r5 = r0.i
                r2 = 1
                if (r5 == 0) goto L_0x0032
                monitor-enter(r0)
                java.lang.Object[] r5 = r0.f     // Catch:{ all -> 0x0018 }
                if (r5 != 0) goto L_0x001a
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                goto L_0x003e
            L_0x0018:
                r5 = move-exception
                goto L_0x0030
            L_0x001a:
                r1 = r5[r1]     // Catch:{ all -> 0x0018 }
                if (r1 != 0) goto L_0x0020
                r1 = 1
                goto L_0x0021
            L_0x0020:
                r1 = 0
            L_0x0021:
                if (r1 != 0) goto L_0x002b
                int r3 = r0.n     // Catch:{ all -> 0x0018 }
                int r3 = r3 + r2
                r0.n = r3     // Catch:{ all -> 0x0018 }
                int r5 = r5.length     // Catch:{ all -> 0x0018 }
                if (r3 != r5) goto L_0x002d
            L_0x002b:
                r0.k = r2     // Catch:{ all -> 0x0018 }
            L_0x002d:
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                r2 = r1
                goto L_0x0032
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0018 }
                throw r5
            L_0x0032:
                if (r2 == 0) goto L_0x0037
                r0.a()
            L_0x0037:
                r0.c()
                goto L_0x003e
            L_0x003b:
                io.reactivex.plugins.RxJavaPlugins.b(r5)
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver.onError(java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
            if (r6 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r0.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(java.lang.Object r6) {
            /*
                r5 = this;
                io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator r0 = r5.c
                int r1 = r5.d
                monitor-enter(r0)
                java.lang.Object[] r2 = r0.f     // Catch:{ all -> 0x000b }
                if (r2 != 0) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                goto L_0x002e
            L_0x000b:
                r6 = move-exception
                goto L_0x002f
            L_0x000d:
                r3 = r2[r1]     // Catch:{ all -> 0x000b }
                int r4 = r0.m     // Catch:{ all -> 0x000b }
                if (r3 != 0) goto L_0x0017
                int r4 = r4 + 1
                r0.m = r4     // Catch:{ all -> 0x000b }
            L_0x0017:
                r2[r1] = r6     // Catch:{ all -> 0x000b }
                int r6 = r2.length     // Catch:{ all -> 0x000b }
                if (r4 != r6) goto L_0x0027
                io.reactivex.internal.queue.SpscLinkedArrayQueue r6 = r0.g     // Catch:{ all -> 0x000b }
                java.lang.Object r1 = r2.clone()     // Catch:{ all -> 0x000b }
                r6.offer(r1)     // Catch:{ all -> 0x000b }
                r6 = 1
                goto L_0x0028
            L_0x0027:
                r6 = 0
            L_0x0028:
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                if (r6 == 0) goto L_0x002e
                r0.c()
            L_0x002e:
                return
            L_0x002f:
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver.onNext(java.lang.Object):void");
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        public final Observer c;
        public final Function d;
        public final CombinerObserver[] e;
        public Object[] f;
        public final SpscLinkedArrayQueue g;
        public final boolean i;
        public volatile boolean j;
        public volatile boolean k;
        public final AtomicThrowable l = new AtomicThrowable();
        public int m;
        public int n;

        public LatestCoordinator(int i2, int i3, Observer observer, Function function, boolean z) {
            this.c = observer;
            this.d = function;
            this.i = z;
            this.f = new Object[i2];
            CombinerObserver[] combinerObserverArr = new CombinerObserver[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                combinerObserverArr[i4] = new CombinerObserver(this, i4);
            }
            this.e = combinerObserverArr;
            this.g = new SpscLinkedArrayQueue(i3);
        }

        public final void a() {
            for (CombinerObserver combinerObserver : this.e) {
                combinerObserver.getClass();
                DisposableHelper.dispose(combinerObserver);
            }
        }

        public final void b(SpscLinkedArrayQueue spscLinkedArrayQueue) {
            synchronized (this) {
                this.f = null;
            }
            spscLinkedArrayQueue.clear();
        }

        public final void c() {
            boolean z;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.g;
                Observer observer = this.c;
                boolean z2 = this.i;
                int i2 = 1;
                while (!this.j) {
                    if (z2 || this.l.get() == null) {
                        boolean z3 = this.k;
                        Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                        if (objArr == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z3 && z) {
                            b(spscLinkedArrayQueue);
                            Throwable terminate = this.l.terminate();
                            if (terminate == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(terminate);
                                return;
                            }
                        } else if (z) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            try {
                                Object apply = this.d.apply(objArr);
                                ObjectHelper.b(apply, "The combiner returned a null value");
                                observer.onNext(apply);
                            } catch (Throwable th) {
                                Exceptions.a(th);
                                this.l.addThrowable(th);
                                a();
                                b(spscLinkedArrayQueue);
                                observer.onError(this.l.terminate());
                                return;
                            }
                        }
                    } else {
                        a();
                        b(spscLinkedArrayQueue);
                        observer.onError(this.l.terminate());
                        return;
                    }
                }
                b(spscLinkedArrayQueue);
            }
        }

        public final void dispose() {
            if (!this.j) {
                this.j = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.g);
                }
            }
        }

        public final boolean isDisposed() {
            return this.j;
        }
    }

    public ObservableCombineLatest(ObservableSource[] observableSourceArr, Iterable iterable, Function function, int i, boolean z) {
        this.c = observableSourceArr;
        this.d = iterable;
        this.e = function;
        this.f = i;
        this.g = z;
    }

    public final void subscribeActual(Observer observer) {
        int i;
        ObservableSource[] observableSourceArr = this.c;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            i = 0;
            for (ObservableSource observableSource : this.d) {
                if (i == observableSourceArr.length) {
                    ObservableSource[] observableSourceArr2 = new ObservableSource[((i >> 2) + i)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i] = observableSource;
                i++;
            }
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
            return;
        }
        Observer observer2 = observer;
        LatestCoordinator latestCoordinator = new LatestCoordinator(i, this.f, observer2, this.e, this.g);
        CombinerObserver[] combinerObserverArr = latestCoordinator.e;
        int length = combinerObserverArr.length;
        latestCoordinator.c.onSubscribe(latestCoordinator);
        for (int i2 = 0; i2 < length && !latestCoordinator.k && !latestCoordinator.j; i2++) {
            observableSourceArr[i2].subscribe(combinerObserverArr[i2]);
        }
    }
}
