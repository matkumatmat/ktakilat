package io.reactivex.processors;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscription;

final class SerializedProcessor<T> extends FlowableProcessor<T> {
    public boolean d;
    public AppendOnlyLinkedArrayList e;
    public volatile boolean f;

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }

    public final void f() {
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
            appendOnlyLinkedArrayList.a((FlowableSubscriber) null);
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
                        throw null;
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
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
        throw null;
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
            goto L_0x003a
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
            r4 = 0
            throw r4
        L_0x003a:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.SerializedProcessor.onError(java.lang.Throwable):void");
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
                        throw null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public final void onSubscribe(Subscription subscription) {
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
                            appendOnlyLinkedArrayList.b(NotificationLite.subscription(subscription));
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
            subscription.cancel();
            return;
        }
        throw null;
    }
}
