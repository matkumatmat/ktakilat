package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.internal.operators.NotificationLite;

public class SerializedObserver<T> implements Observer<T> {
    private final Observer<? super T> actual;
    private boolean emitting;
    private FastList queue;
    private volatile boolean terminated;

    public static final class FastList {
        Object[] array;
        int size;

        public void add(Object obj) {
            int i = this.size;
            Object[] objArr = this.array;
            if (objArr == null) {
                objArr = new Object[16];
                this.array = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[((i >> 2) + i)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.array = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.size = i + 1;
        }
    }

    public SerializedObserver(Observer<? super T> observer) {
        this.actual = observer;
    }

    public void onCompleted() {
        if (!this.terminated) {
            synchronized (this) {
                try {
                    if (!this.terminated) {
                        this.terminated = true;
                        if (this.emitting) {
                            FastList fastList = this.queue;
                            if (fastList == null) {
                                fastList = new FastList();
                                this.queue = fastList;
                            }
                            fastList.add(NotificationLite.completed());
                            return;
                        }
                        this.emitting = true;
                        this.actual.onCompleted();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public void onError(Throwable th) {
        Exceptions.throwIfFatal(th);
        if (!this.terminated) {
            synchronized (this) {
                try {
                    if (!this.terminated) {
                        this.terminated = true;
                        if (this.emitting) {
                            FastList fastList = this.queue;
                            if (fastList == null) {
                                fastList = new FastList();
                                this.queue = fastList;
                            }
                            fastList.add(NotificationLite.error(th));
                            return;
                        }
                        this.emitting = true;
                        this.actual.onError(th);
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r6.actual.onNext(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002f, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1 = r6.queue;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0033, code lost:
        if (r1 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0035, code lost:
        r6.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0037, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0039, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003b, code lost:
        r6.queue = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x003e, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x003f, code lost:
        r1 = r1.array;
        r3 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0042, code lost:
        if (r2 >= r3) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0044, code lost:
        r4 = r1[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0046, code lost:
        if (r4 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x004f, code lost:
        if (rx.internal.operators.NotificationLite.accept(r6.actual, r4) == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0051, code lost:
        r6.terminated = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0053, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0054, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0056, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0059, code lost:
        r6.terminated = true;
        rx.exceptions.Exceptions.throwIfFatal(r1);
        r6.actual.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0067, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0069, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006b, code lost:
        r6.terminated = true;
        rx.exceptions.Exceptions.throwOrReport(r1, (rx.Observer<?>) r6.actual, (java.lang.Object) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0072, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r7) {
        /*
            r6 = this;
            boolean r0 = r6.terminated
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r6)
            boolean r0 = r6.terminated     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r6)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r7 = move-exception
            goto L_0x0073
        L_0x000e:
            boolean r0 = r6.emitting     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x0026
            rx.observers.SerializedObserver$FastList r0 = r6.queue     // Catch:{ all -> 0x000c }
            if (r0 != 0) goto L_0x001d
            rx.observers.SerializedObserver$FastList r0 = new rx.observers.SerializedObserver$FastList     // Catch:{ all -> 0x000c }
            r0.<init>()     // Catch:{ all -> 0x000c }
            r6.queue = r0     // Catch:{ all -> 0x000c }
        L_0x001d:
            java.lang.Object r7 = rx.internal.operators.NotificationLite.next(r7)     // Catch:{ all -> 0x000c }
            r0.add(r7)     // Catch:{ all -> 0x000c }
            monitor-exit(r6)     // Catch:{ all -> 0x000c }
            return
        L_0x0026:
            r0 = 1
            r6.emitting = r0     // Catch:{ all -> 0x000c }
            monitor-exit(r6)     // Catch:{ all -> 0x000c }
            rx.Observer<? super T> r1 = r6.actual     // Catch:{ all -> 0x006a }
            r1.onNext(r7)     // Catch:{ all -> 0x006a }
        L_0x002f:
            monitor-enter(r6)
            rx.observers.SerializedObserver$FastList r1 = r6.queue     // Catch:{ all -> 0x0039 }
            r2 = 0
            if (r1 != 0) goto L_0x003b
            r6.emitting = r2     // Catch:{ all -> 0x0039 }
            monitor-exit(r6)     // Catch:{ all -> 0x0039 }
            return
        L_0x0039:
            r7 = move-exception
            goto L_0x0068
        L_0x003b:
            r3 = 0
            r6.queue = r3     // Catch:{ all -> 0x0039 }
            monitor-exit(r6)     // Catch:{ all -> 0x0039 }
            java.lang.Object[] r1 = r1.array
            int r3 = r1.length
        L_0x0042:
            if (r2 >= r3) goto L_0x002f
            r4 = r1[r2]
            if (r4 != 0) goto L_0x0049
            goto L_0x002f
        L_0x0049:
            rx.Observer<? super T> r5 = r6.actual     // Catch:{ all -> 0x0054 }
            boolean r4 = rx.internal.operators.NotificationLite.accept(r5, r4)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0056
            r6.terminated = r0     // Catch:{ all -> 0x0054 }
            return
        L_0x0054:
            r1 = move-exception
            goto L_0x0059
        L_0x0056:
            int r2 = r2 + 1
            goto L_0x0042
        L_0x0059:
            r6.terminated = r0
            rx.exceptions.Exceptions.throwIfFatal(r1)
            rx.Observer<? super T> r0 = r6.actual
            java.lang.Throwable r7 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r7)
            r0.onError(r7)
            return
        L_0x0068:
            monitor-exit(r6)     // Catch:{ all -> 0x0039 }
            throw r7
        L_0x006a:
            r1 = move-exception
            r6.terminated = r0
            rx.Observer<? super T> r0 = r6.actual
            rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r1, (rx.Observer<?>) r0, (java.lang.Object) r7)
            return
        L_0x0073:
            monitor-exit(r6)     // Catch:{ all -> 0x000c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observers.SerializedObserver.onNext(java.lang.Object):void");
    }
}
