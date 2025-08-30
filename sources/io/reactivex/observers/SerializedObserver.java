package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

public final class SerializedObserver<T> implements Observer<T>, Disposable {
    public final Observer c;
    public Disposable d;
    public boolean e;
    public AppendOnlyLinkedArrayList f;
    public volatile boolean g;

    public SerializedObserver(Observer observer) {
        this.c = observer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r2 = r6.c;
        r0 = r0.f681a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        if (r0 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
        if (r3 >= 4) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        r5 = r0[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001c, code lost:
        if (r5 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        if (io.reactivex.internal.util.NotificationLite.acceptFull((java.lang.Object) r5, r2) == false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0025, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0026, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0029, code lost:
        r0 = r0[4];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r6 = this;
        L_0x0000:
            monitor-enter(r6)
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = r6.f     // Catch:{ all -> 0x000a }
            r1 = 0
            if (r0 != 0) goto L_0x000c
            r6.e = r1     // Catch:{ all -> 0x000a }
            monitor-exit(r6)     // Catch:{ all -> 0x000a }
            return
        L_0x000a:
            r0 = move-exception
            goto L_0x002e
        L_0x000c:
            r2 = 0
            r6.f = r2     // Catch:{ all -> 0x000a }
            monitor-exit(r6)     // Catch:{ all -> 0x000a }
            io.reactivex.Observer r2 = r6.c
            java.lang.Object[] r0 = r0.f681a
        L_0x0014:
            if (r0 == 0) goto L_0x0000
            r3 = 0
        L_0x0017:
            r4 = 4
            if (r3 >= r4) goto L_0x0029
            r5 = r0[r3]
            if (r5 != 0) goto L_0x001f
            goto L_0x0029
        L_0x001f:
            boolean r4 = io.reactivex.internal.util.NotificationLite.acceptFull((java.lang.Object) r5, r2)
            if (r4 == 0) goto L_0x0026
            return
        L_0x0026:
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0029:
            r0 = r0[r4]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L_0x0014
        L_0x002e:
            monitor-exit(r6)     // Catch:{ all -> 0x000a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.a():void");
    }

    public final void dispose() {
        this.d.dispose();
    }

    public final boolean isDisposed() {
        return this.d.isDisposed();
    }

    public final void onComplete() {
        if (!this.g) {
            synchronized (this) {
                try {
                    if (!this.g) {
                        if (this.e) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                                this.f = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.b(NotificationLite.complete());
                            return;
                        }
                        this.g = true;
                        this.e = true;
                        this.c.onComplete();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r1 == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        io.reactivex.plugins.RxJavaPlugins.b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        r3.c.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.g
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.b(r4)
            return
        L_0x0008:
            monitor-enter(r3)
            boolean r0 = r3.g     // Catch:{ all -> 0x0022 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0033
        L_0x000f:
            boolean r0 = r3.e     // Catch:{ all -> 0x0022 }
            r2 = 0
            if (r0 == 0) goto L_0x002e
            r3.g = r1     // Catch:{ all -> 0x0022 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = r3.f     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0024
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0022 }
            r0.<init>()     // Catch:{ all -> 0x0022 }
            r3.f = r0     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r4 = move-exception
            goto L_0x0040
        L_0x0024:
            java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.error(r4)     // Catch:{ all -> 0x0022 }
            java.lang.Object[] r0 = r0.f681a     // Catch:{ all -> 0x0022 }
            r0[r2] = r4     // Catch:{ all -> 0x0022 }
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            return
        L_0x002e:
            r3.g = r1     // Catch:{ all -> 0x0022 }
            r3.e = r1     // Catch:{ all -> 0x0022 }
            r1 = 0
        L_0x0033:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x003a
            io.reactivex.plugins.RxJavaPlugins.b(r4)
            return
        L_0x003a:
            io.reactivex.Observer r0 = r3.c
            r0.onError(r4)
            return
        L_0x0040:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public final void onNext(Object obj) {
        if (!this.g) {
            if (obj == null) {
                this.d.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                try {
                    if (!this.g) {
                        if (this.e) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                                this.f = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.b(NotificationLite.next(obj));
                            return;
                        }
                        this.e = true;
                        this.c.onNext(obj);
                        a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.d, disposable)) {
            this.d = disposable;
            this.c.onSubscribe(this);
        }
    }
}
