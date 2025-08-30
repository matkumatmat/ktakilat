package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
    public final PublishSubject c;
    public boolean d;
    public AppendOnlyLinkedArrayList e;
    public volatile boolean f;

    public SerializedSubject(PublishSubject publishSubject) {
        this.c = publishSubject;
    }

    public final void d() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.e;
                    if (appendOnlyLinkedArrayList == null) {
                        this.d = false;
                        return;
                    }
                    this.e = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            appendOnlyLinkedArrayList.c(this);
        }
    }

    public final void onComplete() {
        if (!this.f) {
            synchronized (this) {
                try {
                    if (!this.f) {
                        this.f = true;
                        if (this.d) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.e;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                                this.e = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.b(NotificationLite.complete());
                            return;
                        }
                        this.d = true;
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

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r1 == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        io.reactivex.plugins.RxJavaPlugins.b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        r3.c.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.f
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.b(r4)
            return
        L_0x0008:
            monitor-enter(r3)
            boolean r0 = r3.f     // Catch:{ all -> 0x0022 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0031
        L_0x000f:
            r3.f = r1     // Catch:{ all -> 0x0022 }
            boolean r0 = r3.d     // Catch:{ all -> 0x0022 }
            r2 = 0
            if (r0 == 0) goto L_0x002e
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = r3.e     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0024
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0022 }
            r0.<init>()     // Catch:{ all -> 0x0022 }
            r3.e = r0     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r4 = move-exception
            goto L_0x003e
        L_0x0024:
            java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.error(r4)     // Catch:{ all -> 0x0022 }
            java.lang.Object[] r0 = r0.f681a     // Catch:{ all -> 0x0022 }
            r0[r2] = r4     // Catch:{ all -> 0x0022 }
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            return
        L_0x002e:
            r3.d = r1     // Catch:{ all -> 0x0022 }
            r1 = 0
        L_0x0031:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0038
            io.reactivex.plugins.RxJavaPlugins.b(r4)
            return
        L_0x0038:
            io.reactivex.subjects.PublishSubject r0 = r3.c
            r0.onError(r4)
            return
        L_0x003e:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.SerializedSubject.onError(java.lang.Throwable):void");
    }

    public final void onNext(Object obj) {
        if (!this.f) {
            synchronized (this) {
                try {
                    if (!this.f) {
                        if (this.d) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.e;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                                this.e = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.b(NotificationLite.next(obj));
                            return;
                        }
                        this.d = true;
                        this.c.onNext(obj);
                        d();
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
        boolean z = true;
        if (!this.f) {
            synchronized (this) {
                try {
                    if (!this.f) {
                        if (this.d) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.e;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList();
                                this.e = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.b(NotificationLite.disposable(disposable));
                            return;
                        }
                        this.d = true;
                        z = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            disposable.dispose();
            return;
        }
        this.c.onSubscribe(disposable);
        d();
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(observer);
    }

    public final boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.c);
    }
}
