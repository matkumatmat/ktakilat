package rx.internal.util;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback backpressureQueueCallback) {
        this.actual = backpressureQueueCallback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r2 = get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r5 = r13.actual;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        r9 = (r2 > 0 ? 1 : (r2 == 0 ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        if (r9 > 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        if (r1 == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        if (r1 == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0026, code lost:
        if (r5.peek() != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r5.complete(r13.exception);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0030, code lost:
        if (r9 != 0) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0033, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r9 = r5.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003a, code lost:
        if (r9 != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003c, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r1 = r13.terminated;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0043, code lost:
        if (r5.peek() == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0045, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0047, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0053, code lost:
        if (get() != androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0055, code lost:
        if (r2 != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0057, code lost:
        if (r1 != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005b, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x005c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x005d, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x005f, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r9 = addAndGet((long) (-r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0069, code lost:
        if (r9 == 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006b, code lost:
        if (r2 != false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x006d, code lost:
        if (r1 == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x006f, code lost:
        if (r2 == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0072, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0073, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0075, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0076, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x007a, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x007c, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0082, code lost:
        if (r5.accept(r9) == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0084, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0085, code lost:
        r2 = r2 - 1;
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x008b, code lost:
        if (r0 == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x008d, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0095, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.emitting     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x000a
            monitor-exit(r13)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r0 = move-exception
            goto L_0x0096
        L_0x000a:
            r0 = 1
            r13.emitting = r0     // Catch:{ all -> 0x0007 }
            boolean r1 = r13.terminated     // Catch:{ all -> 0x0007 }
            monitor-exit(r13)     // Catch:{ all -> 0x0007 }
            long r2 = r13.get()
            r4 = 0
            rx.internal.util.BackpressureDrainManager$BackpressureQueueCallback r5 = r13.actual     // Catch:{ all -> 0x0033 }
        L_0x0017:
            r6 = 0
        L_0x0018:
            r7 = 0
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0020
            if (r1 == 0) goto L_0x003c
        L_0x0020:
            if (r1 == 0) goto L_0x0036
            java.lang.Object r10 = r5.peek()     // Catch:{ all -> 0x0033 }
            if (r10 != 0) goto L_0x0030
            java.lang.Throwable r1 = r13.exception     // Catch:{ all -> 0x002e }
            r5.complete(r1)     // Catch:{ all -> 0x002e }
            return
        L_0x002e:
            r1 = move-exception
            goto L_0x008b
        L_0x0030:
            if (r9 != 0) goto L_0x0036
            goto L_0x003c
        L_0x0033:
            r1 = move-exception
            r0 = 0
            goto L_0x008b
        L_0x0036:
            java.lang.Object r9 = r5.poll()     // Catch:{ all -> 0x0033 }
            if (r9 != 0) goto L_0x007e
        L_0x003c:
            monitor-enter(r13)     // Catch:{ all -> 0x0033 }
            boolean r1 = r13.terminated     // Catch:{ all -> 0x0075 }
            java.lang.Object r2 = r5.peek()     // Catch:{ all -> 0x0075 }
            if (r2 == 0) goto L_0x0047
            r2 = 1
            goto L_0x0048
        L_0x0047:
            r2 = 0
        L_0x0048:
            long r9 = r13.get()     // Catch:{ all -> 0x0075 }
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0061
            if (r2 != 0) goto L_0x005f
            if (r1 != 0) goto L_0x005f
            r13.emitting = r4     // Catch:{ all -> 0x005d }
            monitor-exit(r13)     // Catch:{ all -> 0x005d }
            return
        L_0x005d:
            r1 = move-exception
            goto L_0x007c
        L_0x005f:
            r2 = r11
            goto L_0x0073
        L_0x0061:
            int r3 = -r6
            long r9 = (long) r3
            long r9 = r13.addAndGet(r9)     // Catch:{ all -> 0x0075 }
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x006d
            if (r2 != 0) goto L_0x0072
        L_0x006d:
            if (r1 == 0) goto L_0x0078
            if (r2 == 0) goto L_0x0072
            goto L_0x0078
        L_0x0072:
            r2 = r9
        L_0x0073:
            monitor-exit(r13)     // Catch:{ all -> 0x0075 }
            goto L_0x0017
        L_0x0075:
            r1 = move-exception
            r0 = 0
            goto L_0x007c
        L_0x0078:
            r13.emitting = r4     // Catch:{ all -> 0x005d }
            monitor-exit(r13)     // Catch:{ all -> 0x005d }
            return
        L_0x007c:
            monitor-exit(r13)     // Catch:{ all -> 0x005d }
            throw r1     // Catch:{ all -> 0x002e }
        L_0x007e:
            boolean r7 = r5.accept(r9)     // Catch:{ all -> 0x0033 }
            if (r7 == 0) goto L_0x0085
            return
        L_0x0085:
            r7 = 1
            long r2 = r2 - r7
            int r6 = r6 + 1
            goto L_0x0018
        L_0x008b:
            if (r0 != 0) goto L_0x0095
            monitor-enter(r13)
            r13.emitting = r4     // Catch:{ all -> 0x0092 }
            monitor-exit(r13)     // Catch:{ all -> 0x0092 }
            goto L_0x0095
        L_0x0092:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0092 }
            throw r0
        L_0x0095:
            throw r1
        L_0x0096:
            monitor-exit(r13)     // Catch:{ all -> 0x0007 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.BackpressureDrainManager.drain():void");
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    public void request(long j) {
        boolean z;
        if (j != 0) {
            while (true) {
                long j2 = get();
                boolean z2 = true;
                if (j2 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                long j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                    break;
                }
                if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                    j3 = j;
                } else {
                    if (j2 <= LocationRequestCompat.PASSIVE_INTERVAL - j) {
                        j3 = j2 + j;
                    }
                    z2 = z;
                }
                if (compareAndSet(j2, j3)) {
                    z = z2;
                    break;
                }
            }
            if (z) {
                drain();
            }
        }
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminate(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
        }
    }

    public void terminateAndDrain(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
            drain();
        }
    }
}
