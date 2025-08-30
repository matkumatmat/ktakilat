package rx.internal.producers;

import androidx.core.location.LocationRequestCompat;
import java.util.Iterator;
import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;

public final class ProducerObserverArbiter<T> implements Producer, Observer<T> {
    static final Producer NULL_PRODUCER = new Producer() {
        public void request(long j) {
        }
    };
    final Subscriber<? super T> child;
    Producer currentProducer;
    boolean emitting;
    volatile boolean hasError;
    Producer missedProducer;
    long missedRequested;
    Object missedTerminal;
    List<T> queue;
    long requested;

    public ProducerObserverArbiter(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    public void emitLoop() {
        long j;
        Producer producer;
        Object obj;
        List<T> list;
        boolean z;
        int i;
        boolean z2;
        long j2;
        Subscriber<? super T> subscriber = this.child;
        Producer producer2 = null;
        long j3 = 0;
        while (true) {
            synchronized (this) {
                try {
                    j = this.missedRequested;
                    producer = this.missedProducer;
                    obj = this.missedTerminal;
                    list = this.queue;
                    z = true;
                    i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i == 0 && producer == null && list == null && obj == null) {
                        this.emitting = false;
                        z2 = true;
                    } else {
                        this.missedRequested = 0;
                        this.missedProducer = null;
                        this.queue = null;
                        this.missedTerminal = null;
                        z2 = false;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (!z2) {
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (obj != null) {
                    if (obj != Boolean.TRUE) {
                        subscriber.onError((Throwable) obj);
                        return;
                    } else if (z) {
                        subscriber.onCompleted();
                        return;
                    }
                }
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            j2 = (long) list.size();
                            break;
                        }
                        T next = it.next();
                        if (!subscriber.isUnsubscribed()) {
                            if (this.hasError) {
                                break;
                            }
                            try {
                                subscriber.onNext(next);
                            } catch (Throwable th2) {
                                Exceptions.throwOrReport(th2, (Observer<?>) subscriber, (Object) next);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    j2 = 0;
                }
                long j4 = this.requested;
                if (j4 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    if (i != 0) {
                        j4 += j;
                        if (j4 < 0) {
                            j4 = Long.MAX_VALUE;
                        }
                    }
                    if (!(j2 == 0 || j4 == LocationRequestCompat.PASSIVE_INTERVAL)) {
                        j4 -= j2;
                        if (j4 < 0) {
                            throw new IllegalStateException("More produced than requested");
                        }
                    }
                    this.requested = j4;
                }
                if (producer == null) {
                    producer = this.currentProducer;
                    if (producer != null && i != 0) {
                        j3 = BackpressureUtils.addCap(j3, j);
                    }
                } else if (producer == NULL_PRODUCER) {
                    this.currentProducer = null;
                } else {
                    this.currentProducer = producer;
                    if (j4 != 0) {
                        j3 = BackpressureUtils.addCap(j3, j4);
                    }
                }
                producer2 = producer;
            } else if (j3 != 0 && producer2 != null) {
                producer2.request(j3);
                return;
            } else {
                return;
            }
        }
    }

    public void onCompleted() {
        synchronized (this) {
            try {
                if (this.emitting) {
                    this.missedTerminal = Boolean.TRUE;
                    return;
                }
                this.emitting = true;
                this.child.onCompleted();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void onError(Throwable th) {
        boolean z;
        synchronized (this) {
            try {
                if (this.emitting) {
                    this.missedTerminal = th;
                    z = false;
                } else {
                    this.emitting = true;
                    z = true;
                }
            } catch (Throwable th2) {
                while (true) {
                    throw th2;
                }
            }
        }
        if (z) {
            this.child.onError(th);
        } else {
            this.hasError = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.child.onNext(r5);
        r0 = r4.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r0 == androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r4.requested = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r4.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003e, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.emitting     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0019
            java.util.List<T> r0 = r4.queue     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0014
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0012 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0012 }
            r4.queue = r0     // Catch:{ all -> 0x0012 }
            goto L_0x0014
        L_0x0012:
            r5 = move-exception
            goto L_0x0042
        L_0x0014:
            r0.add(r5)     // Catch:{ all -> 0x0012 }
            monitor-exit(r4)     // Catch:{ all -> 0x0012 }
            return
        L_0x0019:
            r0 = 1
            r4.emitting = r0     // Catch:{ all -> 0x0012 }
            monitor-exit(r4)     // Catch:{ all -> 0x0012 }
            rx.Subscriber<? super T> r0 = r4.child     // Catch:{ all -> 0x0033 }
            r0.onNext(r5)     // Catch:{ all -> 0x0033 }
            long r0 = r4.requested     // Catch:{ all -> 0x0033 }
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0035
            r2 = 1
            long r0 = r0 - r2
            r4.requested = r0     // Catch:{ all -> 0x0033 }
            goto L_0x0035
        L_0x0033:
            r5 = move-exception
            goto L_0x0039
        L_0x0035:
            r4.emitLoop()     // Catch:{ all -> 0x0033 }
            return
        L_0x0039:
            monitor-enter(r4)
            r0 = 0
            r4.emitting = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            throw r5
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            throw r5
        L_0x0042:
            monitor-exit(r4)     // Catch:{ all -> 0x0012 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.onNext(java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        r2 = r6.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3 = r6.requested + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        if (r3 >= 0) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
        r3 = androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        r6.requested = r3;
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        r2.request(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r6.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003a, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request(long r7) {
        /*
            r6 = this;
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0040
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            monitor-enter(r6)
            boolean r2 = r6.emitting     // Catch:{ all -> 0x0015 }
            if (r2 == 0) goto L_0x0017
            long r0 = r6.missedRequested     // Catch:{ all -> 0x0015 }
            long r0 = r0 + r7
            r6.missedRequested = r0     // Catch:{ all -> 0x0015 }
            monitor-exit(r6)     // Catch:{ all -> 0x0015 }
            return
        L_0x0015:
            r7 = move-exception
            goto L_0x003e
        L_0x0017:
            r2 = 1
            r6.emitting = r2     // Catch:{ all -> 0x0015 }
            monitor-exit(r6)     // Catch:{ all -> 0x0015 }
            rx.Producer r2 = r6.currentProducer
            long r3 = r6.requested     // Catch:{ all -> 0x0034 }
            long r3 = r3 + r7
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 >= 0) goto L_0x0029
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0029:
            r6.requested = r3     // Catch:{ all -> 0x0034 }
            r6.emitLoop()     // Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x0033
            r2.request(r7)
        L_0x0033:
            return
        L_0x0034:
            r7 = move-exception
            monitor-enter(r6)
            r8 = 0
            r6.emitting = r8     // Catch:{ all -> 0x003b }
            monitor-exit(r6)     // Catch:{ all -> 0x003b }
            throw r7
        L_0x003b:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x003b }
            throw r7
        L_0x003e:
            monitor-exit(r6)     // Catch:{ all -> 0x0015 }
            throw r7
        L_0x0040:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "n >= 0 required"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.request(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0014, code lost:
        r5.currentProducer = r6;
        r0 = r5.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        if (r0 == 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0023, code lost:
        r6.request(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0027, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0028, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r5.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002d, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProducer(rx.Producer r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.emitting     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0010
            if (r6 == 0) goto L_0x0008
            goto L_0x000a
        L_0x0008:
            rx.Producer r6 = NULL_PRODUCER     // Catch:{ all -> 0x000e }
        L_0x000a:
            r5.missedProducer = r6     // Catch:{ all -> 0x000e }
            monitor-exit(r5)     // Catch:{ all -> 0x000e }
            return
        L_0x000e:
            r6 = move-exception
            goto L_0x0031
        L_0x0010:
            r0 = 1
            r5.emitting = r0     // Catch:{ all -> 0x000e }
            monitor-exit(r5)     // Catch:{ all -> 0x000e }
            r5.currentProducer = r6
            long r0 = r5.requested
            r5.emitLoop()     // Catch:{ all -> 0x0027 }
            if (r6 == 0) goto L_0x0026
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0026
            r6.request(r0)
        L_0x0026:
            return
        L_0x0027:
            r6 = move-exception
            monitor-enter(r5)
            r0 = 0
            r5.emitting = r0     // Catch:{ all -> 0x002e }
            monitor-exit(r5)     // Catch:{ all -> 0x002e }
            throw r6
        L_0x002e:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x002e }
            throw r6
        L_0x0031:
            monitor-exit(r5)     // Catch:{ all -> 0x000e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.setProducer(rx.Producer):void");
    }
}
