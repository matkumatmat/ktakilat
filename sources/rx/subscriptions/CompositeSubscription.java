package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription implements Subscription {
    private Set<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public CompositeSubscription() {
    }

    private static void unsubscribeFromAll(Collection<Subscription> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (Subscription unsubscribe : collection) {
                try {
                    unsubscribe.unsubscribe();
                } catch (Throwable th) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    public void add(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.unsubscribed) {
                synchronized (this) {
                    try {
                        if (!this.unsubscribed) {
                            if (this.subscriptions == null) {
                                this.subscriptions = new HashSet(4);
                            }
                            this.subscriptions.add(subscription);
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    public void addAll(Subscription... subscriptionArr) {
        int i = 0;
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    if (!this.unsubscribed) {
                        if (this.subscriptions == null) {
                            this.subscriptions = new HashSet(subscriptionArr.length);
                        }
                        int length = subscriptionArr.length;
                        while (i < length) {
                            Subscription subscription = subscriptionArr[i];
                            if (!subscription.isUnsubscribed()) {
                                this.subscriptions.add(subscription);
                            }
                            i++;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        int length2 = subscriptionArr.length;
        while (i < length2) {
            subscriptionArr[i].unsubscribe();
            i++;
        }
    }

    public void clear() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    Set<Subscription> set = this.subscriptions;
                    if (set != null) {
                        this.subscriptions = null;
                        unsubscribeFromAll(set);
                    }
                }
            }
        }
    }

    public boolean hasSubscriptions() {
        Set<Subscription> set;
        boolean z = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.unsubscribed && (set = this.subscriptions) != null && !set.isEmpty()) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        r2.unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.Subscription r2) {
        /*
            r1 = this;
            boolean r0 = r1.unsubscribed
            if (r0 != 0) goto L_0x001f
            monitor-enter(r1)
            boolean r0 = r1.unsubscribed     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x001b
            java.util.Set<rx.Subscription> r0 = r1.subscriptions     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x000e
            goto L_0x001b
        L_0x000e:
            boolean r0 = r0.remove(r2)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x001f
            r2.unsubscribe()
            goto L_0x001f
        L_0x0019:
            r2 = move-exception
            goto L_0x001d
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return
        L_0x001d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.remove(rx.Subscription):void");
    }

    public void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                try {
                    if (!this.unsubscribed) {
                        this.unsubscribed = true;
                        Set<Subscription> set = this.subscriptions;
                        this.subscriptions = null;
                        unsubscribeFromAll(set);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public CompositeSubscription(Subscription... subscriptionArr) {
        this.subscriptions = new HashSet(Arrays.asList(subscriptionArr));
    }
}
