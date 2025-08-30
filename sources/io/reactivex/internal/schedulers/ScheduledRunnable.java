package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    public static final Object d = new Object();
    public static final Object e = new Object();
    public static final Object f = new Object();
    public static final Object g = new Object();
    private static final long serialVersionUID = -6120223772001106981L;
    public final Runnable c;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.c = runnable;
        lazySet(0, disposableContainer);
    }

    public Object call() {
        run();
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r8 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r8.get(r0)
            java.lang.Object r2 = g
            r3 = 0
            if (r1 == r2) goto L_0x0031
            java.lang.Object r4 = e
            if (r1 == r4) goto L_0x0031
            java.lang.Object r5 = f
            if (r1 != r5) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            r6 = 2
            java.lang.Object r6 = r8.get(r6)
            java.lang.Thread r7 = java.lang.Thread.currentThread()
            if (r6 == r7) goto L_0x0020
            r6 = 1
            goto L_0x0021
        L_0x0020:
            r6 = 0
        L_0x0021:
            if (r6 == 0) goto L_0x0024
            r4 = r5
        L_0x0024:
            boolean r0 = r8.compareAndSet(r0, r1, r4)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0031
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r6)
        L_0x0031:
            java.lang.Object r0 = r8.get(r3)
            if (r0 == r2) goto L_0x0049
            java.lang.Object r1 = d
            if (r0 == r1) goto L_0x0049
            if (r0 != 0) goto L_0x003e
            goto L_0x0049
        L_0x003e:
            boolean r1 = r8.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0031
            io.reactivex.internal.disposables.DisposableContainer r0 = (io.reactivex.internal.disposables.DisposableContainer) r0
            r0.c(r8)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledRunnable.dispose():void");
    }

    public boolean isDisposed() {
        Object obj = get(0);
        if (obj == d || obj == g) {
            return true;
        }
        return false;
    }

    public void run() {
        Object obj;
        Object obj2;
        Object obj3 = f;
        Object obj4 = e;
        Object obj5 = d;
        Object obj6 = g;
        lazySet(2, Thread.currentThread());
        try {
            this.c.run();
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj7 = get(0);
            if (!(obj7 == obj5 || !compareAndSet(0, obj7, obj6) || obj7 == null)) {
                ((DisposableContainer) obj7).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == obj4 || obj2 == obj3 || compareAndSet(1, obj2, obj6)) {
                    throw th;
                }
                obj2 = get(1);
                break;
            } while (compareAndSet(1, obj2, obj6));
            throw th;
        }
        lazySet(2, (Object) null);
        Object obj8 = get(0);
        if (!(obj8 == obj5 || !compareAndSet(0, obj8, obj6) || obj8 == null)) {
            ((DisposableContainer) obj8).c(this);
        }
        do {
            obj = get(1);
            if (obj == obj4 || obj == obj3 || compareAndSet(1, obj, obj6)) {
            }
            obj = get(1);
            return;
        } while (compareAndSet(1, obj, obj6));
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != g) {
                if (obj == e) {
                    future.cancel(false);
                    return;
                } else if (obj == f) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
