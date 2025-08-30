package rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import rx.Observer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public class RxRingBuffer implements Subscription {
    public static final int SIZE;
    private Queue<Object> queue;
    private final int size;
    public volatile Object terminalState;

    static {
        int i;
        if (PlatformDependent.isAndroid()) {
            i = 16;
        } else {
            i = 128;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                StringBuilder t = e.t("Failed to set 'rx.buffer.size' with value ", property, " => ");
                t.append(e.getMessage());
                printStream.println(t.toString());
            }
        }
        SIZE = i;
    }

    private RxRingBuffer(Queue<Object> queue2, int i) {
        this.queue = queue2;
        this.size = i;
    }

    public static RxRingBuffer getSpmcInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(true, SIZE);
        }
        return new RxRingBuffer();
    }

    public static RxRingBuffer getSpscInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(false, SIZE);
        }
        return new RxRingBuffer();
    }

    public boolean accept(Object obj, Observer observer) {
        return NotificationLite.accept(observer, obj);
    }

    public Throwable asError(Object obj) {
        return NotificationLite.getError(obj);
    }

    public int available() {
        return this.size - count();
    }

    public int capacity() {
        return this.size;
    }

    public int count() {
        Queue<Object> queue2 = this.queue;
        if (queue2 == null) {
            return 0;
        }
        return queue2.size();
    }

    public Object getValue(Object obj) {
        return NotificationLite.getValue(obj);
    }

    public boolean isCompleted(Object obj) {
        return NotificationLite.isCompleted(obj);
    }

    public boolean isEmpty() {
        Queue<Object> queue2 = this.queue;
        if (queue2 == null || queue2.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isError(Object obj) {
        return NotificationLite.isError(obj);
    }

    public boolean isUnsubscribed() {
        if (this.queue == null) {
            return true;
        }
        return false;
    }

    public void onCompleted() {
        if (this.terminalState == null) {
            this.terminalState = NotificationLite.completed();
        }
    }

    public void onError(Throwable th) {
        if (this.terminalState == null) {
            this.terminalState = NotificationLite.error(th);
        }
    }

    public void onNext(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            try {
                Queue<Object> queue2 = this.queue;
                z = true;
                z2 = false;
                if (queue2 != null) {
                    z2 = !queue2.offer(NotificationLite.next(obj));
                    z = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (z2) {
            throw new MissingBackpressureException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object peek() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Queue<java.lang.Object> r0 = r3.queue     // Catch:{ all -> 0x0008 }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r3)     // Catch:{ all -> 0x0008 }
            r0 = 0
            return r0
        L_0x0008:
            r0 = move-exception
            goto L_0x001d
        L_0x000a:
            java.lang.Object r1 = r0.peek()     // Catch:{ all -> 0x0008 }
            java.lang.Object r2 = r3.terminalState     // Catch:{ all -> 0x0008 }
            if (r1 != 0) goto L_0x001b
            if (r2 == 0) goto L_0x001b
            java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x0008 }
            if (r0 != 0) goto L_0x001b
            r1 = r2
        L_0x001b:
            monitor-exit(r3)     // Catch:{ all -> 0x0008 }
            return r1
        L_0x001d:
            monitor-exit(r3)     // Catch:{ all -> 0x0008 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.RxRingBuffer.peek():java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object poll() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Queue<java.lang.Object> r0 = r4.queue     // Catch:{ all -> 0x0008 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r4)     // Catch:{ all -> 0x0008 }
            return r1
        L_0x0008:
            r0 = move-exception
            goto L_0x001f
        L_0x000a:
            java.lang.Object r2 = r0.poll()     // Catch:{ all -> 0x0008 }
            java.lang.Object r3 = r4.terminalState     // Catch:{ all -> 0x0008 }
            if (r2 != 0) goto L_0x001d
            if (r3 == 0) goto L_0x001d
            java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x0008 }
            if (r0 != 0) goto L_0x001d
            r4.terminalState = r1     // Catch:{ all -> 0x0008 }
            r2 = r3
        L_0x001d:
            monitor-exit(r4)     // Catch:{ all -> 0x0008 }
            return r2
        L_0x001f:
            monitor-exit(r4)     // Catch:{ all -> 0x0008 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.RxRingBuffer.poll():java.lang.Object");
    }

    public synchronized void release() {
    }

    public void unsubscribe() {
        release();
    }

    private RxRingBuffer(boolean z, int i) {
        this.queue = z ? new SpmcArrayQueue<>(i) : new SpscArrayQueue<>(i);
        this.size = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RxRingBuffer() {
        /*
            r2 = this;
            rx.internal.util.atomic.SpscAtomicArrayQueue r0 = new rx.internal.util.atomic.SpscAtomicArrayQueue
            int r1 = SIZE
            r0.<init>(r1)
            r2.<init>((java.util.Queue<java.lang.Object>) r0, (int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.RxRingBuffer.<init>():void");
    }
}
