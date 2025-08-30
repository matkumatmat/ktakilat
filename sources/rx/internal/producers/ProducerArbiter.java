package rx.internal.producers;

import rx.Producer;

public final class ProducerArbiter implements Producer {
    static final Producer NULL_PRODUCER = new Producer() {
        public void request(long j) {
        }
    };
    Producer currentProducer;
    boolean emitting;
    long missedProduced;
    Producer missedProducer;
    long missedRequested;
    long requested;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r9 = r14.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r9 == androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r9 = r9 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        if (r9 < 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r9 != androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        r9 = r9 - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r9 < 0) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        r14.requested = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        throw new java.lang.IllegalStateException("more produced than requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        r14.requested = androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL;
        r9 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        if (r4 == null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        if (r4 != NULL_PRODUCER) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        r14.currentProducer = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        r14.currentProducer = r4;
        r4.request(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
        r2 = r14.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        if (r7 == 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
        r2.request(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void emitLoop() {
        /*
            r14 = this;
        L_0x0000:
            monitor-enter(r14)
            long r0 = r14.missedRequested     // Catch:{ all -> 0x0018 }
            long r2 = r14.missedProduced     // Catch:{ all -> 0x0018 }
            rx.Producer r4 = r14.missedProducer     // Catch:{ all -> 0x0018 }
            r5 = 0
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x001a
            int r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x001a
            if (r4 != 0) goto L_0x001a
            r0 = 0
            r14.emitting = r0     // Catch:{ all -> 0x0018 }
            monitor-exit(r14)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r0 = move-exception
            goto L_0x0063
        L_0x001a:
            r14.missedRequested = r5     // Catch:{ all -> 0x0018 }
            r14.missedProduced = r5     // Catch:{ all -> 0x0018 }
            r8 = 0
            r14.missedProducer = r8     // Catch:{ all -> 0x0018 }
            monitor-exit(r14)     // Catch:{ all -> 0x0018 }
            long r9 = r14.requested
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x004a
            long r9 = r9 + r0
            int r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r13 < 0) goto L_0x0047
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0037
            goto L_0x0047
        L_0x0037:
            long r9 = r9 - r2
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x003f
            r14.requested = r9
            goto L_0x004a
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "more produced than requested"
            r0.<init>(r1)
            throw r0
        L_0x0047:
            r14.requested = r11
            r9 = r11
        L_0x004a:
            if (r4 == 0) goto L_0x0059
            rx.Producer r0 = NULL_PRODUCER
            if (r4 != r0) goto L_0x0053
            r14.currentProducer = r8
            goto L_0x0000
        L_0x0053:
            r14.currentProducer = r4
            r4.request(r9)
            goto L_0x0000
        L_0x0059:
            rx.Producer r2 = r14.currentProducer
            if (r2 == 0) goto L_0x0000
            if (r7 == 0) goto L_0x0000
            r2.request(r0)
            goto L_0x0000
        L_0x0063:
            monitor-exit(r14)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerArbiter.emitLoop():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2 = r7.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        if (r2 == androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        r2 = r2 - r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        if (r2 < 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        r7.requested = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        throw new java.lang.IllegalStateException("more items arrived than were requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r7.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003e, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void produced(long r8) {
        /*
            r7 = this;
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0044
            monitor-enter(r7)
            boolean r2 = r7.emitting     // Catch:{ all -> 0x0012 }
            if (r2 == 0) goto L_0x0014
            long r0 = r7.missedProduced     // Catch:{ all -> 0x0012 }
            long r0 = r0 + r8
            r7.missedProduced = r0     // Catch:{ all -> 0x0012 }
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            return
        L_0x0012:
            r8 = move-exception
            goto L_0x0042
        L_0x0014:
            r2 = 1
            r7.emitting = r2     // Catch:{ all -> 0x0012 }
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            long r2 = r7.requested     // Catch:{ all -> 0x002b }
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0035
            long r2 = r2 - r8
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r8 < 0) goto L_0x002d
            r7.requested = r2     // Catch:{ all -> 0x002b }
            goto L_0x0035
        L_0x002b:
            r8 = move-exception
            goto L_0x0039
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002b }
            java.lang.String r9 = "more items arrived than were requested"
            r8.<init>(r9)     // Catch:{ all -> 0x002b }
            throw r8     // Catch:{ all -> 0x002b }
        L_0x0035:
            r7.emitLoop()     // Catch:{ all -> 0x002b }
            return
        L_0x0039:
            monitor-enter(r7)
            r9 = 0
            r7.emitting = r9     // Catch:{ all -> 0x003f }
            monitor-exit(r7)     // Catch:{ all -> 0x003f }
            throw r8
        L_0x003f:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x003f }
            throw r8
        L_0x0042:
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            throw r8
        L_0x0044:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "n > 0 required"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerArbiter.produced(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = r5.requested + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        if (r2 >= 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        r2 = androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
        r5.requested = r2;
        r0 = r5.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
        if (r0 == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        r0.request(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0033, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0037, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r5.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x003c, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request(long r6) {
        /*
            r5 = this;
            r0 = 0
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0042
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            monitor-enter(r5)
            boolean r2 = r5.emitting     // Catch:{ all -> 0x0015 }
            if (r2 == 0) goto L_0x0017
            long r0 = r5.missedRequested     // Catch:{ all -> 0x0015 }
            long r0 = r0 + r6
            r5.missedRequested = r0     // Catch:{ all -> 0x0015 }
            monitor-exit(r5)     // Catch:{ all -> 0x0015 }
            return
        L_0x0015:
            r6 = move-exception
            goto L_0x0040
        L_0x0017:
            r2 = 1
            r5.emitting = r2     // Catch:{ all -> 0x0015 }
            monitor-exit(r5)     // Catch:{ all -> 0x0015 }
            long r2 = r5.requested     // Catch:{ all -> 0x0031 }
            long r2 = r2 + r6
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0027
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0027:
            r5.requested = r2     // Catch:{ all -> 0x0031 }
            rx.Producer r0 = r5.currentProducer     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0033
            r0.request(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x0033
        L_0x0031:
            r6 = move-exception
            goto L_0x0037
        L_0x0033:
            r5.emitLoop()     // Catch:{ all -> 0x0031 }
            return
        L_0x0037:
            monitor-enter(r5)
            r7 = 0
            r5.emitting = r7     // Catch:{ all -> 0x003d }
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            throw r6
        L_0x003d:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            throw r6
        L_0x0040:
            monitor-exit(r5)     // Catch:{ all -> 0x0015 }
            throw r6
        L_0x0042:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "n >= 0 required"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerArbiter.request(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2.currentProducer = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0016, code lost:
        if (r3 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0018, code lost:
        r3.request(r2.requested);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0020, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0024, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r2.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0029, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProducer(rx.Producer r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.emitting     // Catch:{ all -> 0x000a }
            if (r0 == 0) goto L_0x0010
            if (r3 != 0) goto L_0x000c
            rx.Producer r3 = NULL_PRODUCER     // Catch:{ all -> 0x000a }
            goto L_0x000c
        L_0x000a:
            r3 = move-exception
            goto L_0x002d
        L_0x000c:
            r2.missedProducer = r3     // Catch:{ all -> 0x000a }
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            return
        L_0x0010:
            r0 = 1
            r2.emitting = r0     // Catch:{ all -> 0x000a }
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            r2.currentProducer = r3     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x0020
            long r0 = r2.requested     // Catch:{ all -> 0x001e }
            r3.request(r0)     // Catch:{ all -> 0x001e }
            goto L_0x0020
        L_0x001e:
            r3 = move-exception
            goto L_0x0024
        L_0x0020:
            r2.emitLoop()     // Catch:{ all -> 0x001e }
            return
        L_0x0024:
            monitor-enter(r2)
            r0 = 0
            r2.emitting = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            throw r3
        L_0x002a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            throw r3
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerArbiter.setProducer(rx.Producer):void");
    }
}
