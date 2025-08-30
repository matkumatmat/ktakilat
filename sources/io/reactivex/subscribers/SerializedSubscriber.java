package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscription;

public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    public final FlowableSubscriber c;
    public Subscription d;
    public boolean e;
    public AppendOnlyLinkedArrayList f;
    public volatile boolean g;

    public SerializedSubscriber(FlowableSubscriber flowableSubscriber) {
        this.c = flowableSubscriber;
    }

    public final void a() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f;
                    if (appendOnlyLinkedArrayList == null) {
                        this.e = false;
                        return;
                    }
                    this.f = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        } while (!appendOnlyLinkedArrayList.a(this.c));
    }

    public final void cancel() {
        this.d.cancel();
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
            io.reactivex.FlowableSubscriber r0 = r3.c
            r0.onError(r4)
            return
        L_0x0040:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    public final void onNext(Object obj) {
        if (!this.g) {
            if (obj == null) {
                this.d.cancel();
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

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.d, subscription)) {
            this.d = subscription;
            this.c.onSubscribe(this);
        }
    }

    public final void request(long j) {
        this.d.request(j);
    }
}
