package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorSubject<T> extends Subject<T> {
    public static final Object[] j = new Object[0];
    public static final BehaviorDisposable[] k = new BehaviorDisposable[0];
    public static final BehaviorDisposable[] l = new BehaviorDisposable[0];
    public final AtomicReference c = new AtomicReference();
    public final AtomicReference d = new AtomicReference(k);
    public final Lock e;
    public final Lock f;
    public final AtomicReference g = new AtomicReference();
    public long i;

    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        public final Observer c;
        public final BehaviorSubject d;
        public boolean e;
        public boolean f;
        public AppendOnlyLinkedArrayList g;
        public boolean i;
        public volatile boolean j;
        public long k;

        public BehaviorDisposable(Observer observer, BehaviorSubject behaviorSubject) {
            this.c = observer;
            this.d = behaviorSubject;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
            r0.c(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.j
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = r2.g     // Catch:{ all -> 0x000f }
                if (r0 != 0) goto L_0x0011
                r0 = 0
                r2.f = r0     // Catch:{ all -> 0x000f }
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                return
            L_0x000f:
                r0 = move-exception
                goto L_0x0019
            L_0x0011:
                r1 = 0
                r2.g = r1     // Catch:{ all -> 0x000f }
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                r0.c(r2)
                goto L_0x0000
            L_0x0019:
                monitor-exit(r2)     // Catch:{ all -> 0x000f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.a():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0032, code lost:
            r3.i = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(java.lang.Object r4, long r5) {
            /*
                r3 = this;
                boolean r0 = r3.j
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r3.i
                if (r0 != 0) goto L_0x0037
                monitor-enter(r3)
                boolean r0 = r3.j     // Catch:{ all -> 0x0010 }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x0010:
                r4 = move-exception
                goto L_0x0035
            L_0x0012:
                long r0 = r3.k     // Catch:{ all -> 0x0010 }
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 != 0) goto L_0x001a
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x001a:
                boolean r5 = r3.f     // Catch:{ all -> 0x0010 }
                if (r5 == 0) goto L_0x002e
                io.reactivex.internal.util.AppendOnlyLinkedArrayList r5 = r3.g     // Catch:{ all -> 0x0010 }
                if (r5 != 0) goto L_0x0029
                io.reactivex.internal.util.AppendOnlyLinkedArrayList r5 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0010 }
                r5.<init>()     // Catch:{ all -> 0x0010 }
                r3.g = r5     // Catch:{ all -> 0x0010 }
            L_0x0029:
                r5.b(r4)     // Catch:{ all -> 0x0010 }
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                return
            L_0x002e:
                r5 = 1
                r3.e = r5     // Catch:{ all -> 0x0010 }
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                r3.i = r5
                goto L_0x0037
            L_0x0035:
                monitor-exit(r3)     // Catch:{ all -> 0x0010 }
                throw r4
            L_0x0037:
                r3.test(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.b(java.lang.Object, long):void");
        }

        public final void dispose() {
            if (!this.j) {
                this.j = true;
                this.d.d(this);
            }
        }

        public final boolean isDisposed() {
            return this.j;
        }

        public final boolean test(Object obj) {
            if (this.j || NotificationLite.accept(obj, this.c)) {
                return true;
            }
            return false;
        }
    }

    public BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.e = reentrantReadWriteLock.readLock();
        this.f = reentrantReadWriteLock.writeLock();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.reactivex.subjects.BehaviorSubject$BehaviorDisposable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(io.reactivex.subjects.BehaviorSubject.BehaviorDisposable r8) {
        /*
            r7 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference r0 = r7.d
            java.lang.Object r1 = r0.get()
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r1 = (io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[]) r1
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
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r2 = k
            goto L_0x0031
        L_0x0022:
            int r6 = r2 + -1
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r6 = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[r6]
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.d(io.reactivex.subjects.BehaviorSubject$BehaviorDisposable):void");
    }

    public final void onComplete() {
        AtomicReference atomicReference = this.g;
        Throwable th = ExceptionHelper.f682a;
        while (!atomicReference.compareAndSet((Object) null, th)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        Object complete = NotificationLite.complete();
        AtomicReference atomicReference2 = this.d;
        BehaviorDisposable[] behaviorDisposableArr = l;
        BehaviorDisposable[] behaviorDisposableArr2 = (BehaviorDisposable[]) atomicReference2.getAndSet(behaviorDisposableArr);
        if (behaviorDisposableArr2 != behaviorDisposableArr) {
            Lock lock = this.f;
            lock.lock();
            this.i++;
            this.c.lazySet(complete);
            lock.unlock();
        }
        for (BehaviorDisposable b : behaviorDisposableArr2) {
            b.b(complete, this.i);
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicReference atomicReference = this.g;
        while (!atomicReference.compareAndSet((Object) null, th)) {
            if (atomicReference.get() != null) {
                RxJavaPlugins.b(th);
                return;
            }
        }
        Object error = NotificationLite.error(th);
        AtomicReference atomicReference2 = this.d;
        BehaviorDisposable[] behaviorDisposableArr = l;
        BehaviorDisposable[] behaviorDisposableArr2 = (BehaviorDisposable[]) atomicReference2.getAndSet(behaviorDisposableArr);
        if (behaviorDisposableArr2 != behaviorDisposableArr) {
            Lock lock = this.f;
            lock.lock();
            this.i++;
            this.c.lazySet(error);
            lock.unlock();
        }
        for (BehaviorDisposable b : behaviorDisposableArr2) {
            b.b(error, this.i);
        }
    }

    public final void onNext(Object obj) {
        ObjectHelper.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.g.get() == null) {
            Object next = NotificationLite.next(obj);
            Lock lock = this.f;
            lock.lock();
            this.i++;
            this.c.lazySet(next);
            lock.unlock();
            for (BehaviorDisposable b : (BehaviorDisposable[]) this.d.get()) {
                b.b(next, this.i);
            }
        }
    }

    public final void onSubscribe(Disposable disposable) {
        if (this.g.get() != null) {
            disposable.dispose();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0078, code lost:
        if (r0.test(r7) == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007b, code lost:
        r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void subscribeActual(io.reactivex.Observer r7) {
        /*
            r6 = this;
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable r0 = new io.reactivex.subjects.BehaviorSubject$BehaviorDisposable
            r0.<init>(r7, r6)
            r7.onSubscribe(r0)
        L_0x0008:
            java.util.concurrent.atomic.AtomicReference r1 = r6.d
            java.lang.Object r2 = r1.get()
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r2 = (io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[]) r2
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r3 = l
            if (r2 != r3) goto L_0x0028
            java.util.concurrent.atomic.AtomicReference r0 = r6.g
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Throwable r1 = io.reactivex.internal.util.ExceptionHelper.f682a
            if (r0 != r1) goto L_0x0024
            r7.onComplete()
            goto L_0x007e
        L_0x0024:
            r7.onError(r0)
            goto L_0x007e
        L_0x0028:
            int r3 = r2.length
            int r4 = r3 + 1
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r4 = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[r4]
            r5 = 0
            java.lang.System.arraycopy(r2, r5, r4, r5, r3)
            r4[r3] = r0
        L_0x0033:
            boolean r3 = r1.compareAndSet(r2, r4)
            if (r3 == 0) goto L_0x0081
            boolean r7 = r0.j
            if (r7 == 0) goto L_0x0041
            r6.d(r0)
            goto L_0x007e
        L_0x0041:
            boolean r7 = r0.j
            if (r7 == 0) goto L_0x0046
            goto L_0x007e
        L_0x0046:
            monitor-enter(r0)
            boolean r7 = r0.j     // Catch:{ all -> 0x004d }
            if (r7 == 0) goto L_0x004f
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            goto L_0x007e
        L_0x004d:
            r7 = move-exception
            goto L_0x007f
        L_0x004f:
            boolean r7 = r0.e     // Catch:{ all -> 0x004d }
            if (r7 == 0) goto L_0x0055
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            goto L_0x007e
        L_0x0055:
            io.reactivex.subjects.BehaviorSubject r7 = r0.d     // Catch:{ all -> 0x004d }
            java.util.concurrent.locks.Lock r1 = r7.e     // Catch:{ all -> 0x004d }
            r1.lock()     // Catch:{ all -> 0x004d }
            long r2 = r7.i     // Catch:{ all -> 0x004d }
            r0.k = r2     // Catch:{ all -> 0x004d }
            java.util.concurrent.atomic.AtomicReference r7 = r7.c     // Catch:{ all -> 0x004d }
            java.lang.Object r7 = r7.get()     // Catch:{ all -> 0x004d }
            r1.unlock()     // Catch:{ all -> 0x004d }
            r1 = 1
            if (r7 == 0) goto L_0x006d
            r5 = 1
        L_0x006d:
            r0.f = r5     // Catch:{ all -> 0x004d }
            r0.e = r1     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            if (r7 == 0) goto L_0x007e
            boolean r7 = r0.test(r7)
            if (r7 == 0) goto L_0x007b
            goto L_0x007e
        L_0x007b:
            r0.a()
        L_0x007e:
            return
        L_0x007f:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r7
        L_0x0081:
            java.lang.Object r3 = r1.get()
            if (r3 == r2) goto L_0x0033
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.subscribeActual(io.reactivex.Observer):void");
    }
}
