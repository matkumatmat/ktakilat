package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observables.ConnectableObservable;
import rx.subscriptions.Subscriptions;

public final class OperatorPublish<T> extends ConnectableObservable<T> {
    final AtomicReference<PublishSubscriber<T>> current;
    final Observable<? extends T> source;

    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        final PublishSubscriber<T> parent;

        public InnerProducer(PublishSubscriber<T> publishSubscriber, Subscriber<? super T> subscriber) {
            this.parent = publishSubscriber;
            this.child = subscriber;
            lazySet(NOT_REQUESTED);
        }

        public boolean isUnsubscribed() {
            if (get() == UNSUBSCRIBED) {
                return true;
            }
            return false;
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == NOT_REQUESTED) {
                        throw new IllegalStateException("Produced without request");
                    } else if (j2 == UNSUBSCRIBED) {
                        return UNSUBSCRIBED;
                    } else {
                        j3 = j2 - j;
                        if (j3 < 0) {
                            StringBuilder sb = new StringBuilder("More produced (");
                            sb.append(j);
                            sb.append(") than requested (");
                            throw new IllegalStateException(ba.p(sb, j2, ")"));
                        }
                    }
                } while (!compareAndSet(j2, j3));
                return j3;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        public void request(long j) {
            long j2;
            long j3;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                do {
                    j2 = get();
                    if (j2 != UNSUBSCRIBED) {
                        if (j2 >= 0 && i == 0) {
                            return;
                        }
                        if (j2 == NOT_REQUESTED) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.dispatch();
            }
        }

        public void unsubscribe() {
            if (get() != UNSUBSCRIBED && getAndSet(UNSUBSCRIBED) != UNSUBSCRIBED) {
                this.parent.remove(this);
                this.parent.dispatch();
            }
        }
    }

    public static final class PublishSubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final AtomicReference<PublishSubscriber<T>> current;
        boolean emitting;
        boolean missed;
        final AtomicReference<InnerProducer[]> producers;
        final Queue<Object> queue;
        final AtomicBoolean shouldConnect;
        volatile Object terminalEvent;

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference) {
            Queue<Object> queue2;
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscArrayQueue<>(RxRingBuffer.SIZE);
            } else {
                queue2 = new SpscAtomicArrayQueue<>(RxRingBuffer.SIZE);
            }
            this.queue = queue2;
            this.producers = new AtomicReference<>(EMPTY);
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        public boolean add(InnerProducer<T> innerProducer) {
            innerProducer.getClass();
            while (true) {
                InnerProducer[] innerProducerArr = this.producers.get();
                if (innerProducerArr == TERMINATED) {
                    return false;
                }
                int length = innerProducerArr.length;
                InnerProducer[] innerProducerArr2 = new InnerProducer[(length + 1)];
                System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, length);
                innerProducerArr2[length] = innerProducer;
                AtomicReference<InnerProducer[]> atomicReference = this.producers;
                while (true) {
                    if (atomicReference.compareAndSet(innerProducerArr, innerProducerArr2)) {
                        return true;
                    }
                    if (atomicReference.get() != innerProducerArr) {
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[LOOP:2: B:21:0x0043->B:24:0x004e, LOOP_START] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x000f A[LOOP:0: B:6:0x000f->B:9:0x001a, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean checkTerminated(java.lang.Object r5, boolean r6) {
            /*
                r4 = this;
                r0 = 0
                if (r5 == 0) goto L_0x0071
                boolean r1 = rx.internal.operators.NotificationLite.isCompleted(r5)
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x003d
                if (r6 == 0) goto L_0x0071
                java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$PublishSubscriber<T>> r5 = r4.current
            L_0x000f:
                boolean r6 = r5.compareAndSet(r4, r2)
                if (r6 == 0) goto L_0x0016
                goto L_0x001c
            L_0x0016:
                java.lang.Object r6 = r5.get()
                if (r6 == r4) goto L_0x000f
            L_0x001c:
                java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$InnerProducer[]> r5 = r4.producers     // Catch:{ all -> 0x0033 }
                rx.internal.operators.OperatorPublish$InnerProducer[] r6 = TERMINATED     // Catch:{ all -> 0x0033 }
                java.lang.Object r5 = r5.getAndSet(r6)     // Catch:{ all -> 0x0033 }
                rx.internal.operators.OperatorPublish$InnerProducer[] r5 = (rx.internal.operators.OperatorPublish.InnerProducer[]) r5     // Catch:{ all -> 0x0033 }
                int r6 = r5.length     // Catch:{ all -> 0x0033 }
            L_0x0027:
                if (r0 >= r6) goto L_0x0035
                r1 = r5[r0]     // Catch:{ all -> 0x0033 }
                rx.Subscriber<? super T> r1 = r1.child     // Catch:{ all -> 0x0033 }
                r1.onCompleted()     // Catch:{ all -> 0x0033 }
                int r0 = r0 + 1
                goto L_0x0027
            L_0x0033:
                r5 = move-exception
                goto L_0x0039
            L_0x0035:
                r4.unsubscribe()
                return r3
            L_0x0039:
                r4.unsubscribe()
                throw r5
            L_0x003d:
                java.lang.Throwable r5 = rx.internal.operators.NotificationLite.getError(r5)
                java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$PublishSubscriber<T>> r6 = r4.current
            L_0x0043:
                boolean r1 = r6.compareAndSet(r4, r2)
                if (r1 == 0) goto L_0x004a
                goto L_0x0050
            L_0x004a:
                java.lang.Object r1 = r6.get()
                if (r1 == r4) goto L_0x0043
            L_0x0050:
                java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$InnerProducer[]> r6 = r4.producers     // Catch:{ all -> 0x0067 }
                rx.internal.operators.OperatorPublish$InnerProducer[] r1 = TERMINATED     // Catch:{ all -> 0x0067 }
                java.lang.Object r6 = r6.getAndSet(r1)     // Catch:{ all -> 0x0067 }
                rx.internal.operators.OperatorPublish$InnerProducer[] r6 = (rx.internal.operators.OperatorPublish.InnerProducer[]) r6     // Catch:{ all -> 0x0067 }
                int r1 = r6.length     // Catch:{ all -> 0x0067 }
            L_0x005b:
                if (r0 >= r1) goto L_0x0069
                r2 = r6[r0]     // Catch:{ all -> 0x0067 }
                rx.Subscriber<? super T> r2 = r2.child     // Catch:{ all -> 0x0067 }
                r2.onError(r5)     // Catch:{ all -> 0x0067 }
                int r0 = r0 + 1
                goto L_0x005b
            L_0x0067:
                r5 = move-exception
                goto L_0x006d
            L_0x0069:
                r4.unsubscribe()
                return r3
            L_0x006d:
                r4.unsubscribe()
                throw r5
            L_0x0071:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorPublish.PublishSubscriber.checkTerminated(java.lang.Object, boolean):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x00f2, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r0 = r1.terminalEvent;
            r4 = r1.queue.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            if (checkTerminated(r0, r4) == false) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
            if (r4 != false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
            r5 = r1.producers.get();
            r0 = r5.length;
            r6 = r5.length;
            r7 = androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL;
            r9 = 0;
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r9 >= r6) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            r13 = r5[r9].get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
            if (r13 < 0) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
            r7 = java.lang.Math.min(r7, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
            if (r13 != Long.MIN_VALUE) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
            r9 = r9 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
            if (r0 != r10) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
            r0 = r1.terminalEvent;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
            if (r1.queue.poll() != null) goto L_0x006a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0068, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x006a, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
            if (checkTerminated(r0, r4) == false) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0071, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0072, code lost:
            request(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0077, code lost:
            r9 = (long) r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007a, code lost:
            if (r9 >= r7) goto L_0x00c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x007c, code lost:
            r0 = r1.terminalEvent;
            r4 = r1.queue.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
            if (r4 != null) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0086, code lost:
            r15 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0088, code lost:
            r15 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x008d, code lost:
            if (checkTerminated(r0, r15) == false) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x008f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0090, code lost:
            if (r15 == false) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0092, code lost:
            r4 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0094, code lost:
            r4 = rx.internal.operators.NotificationLite.getValue(r4);
            r9 = r5.length;
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009a, code lost:
            if (r10 >= r9) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009c, code lost:
            r2 = r5[r10];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a4, code lost:
            if (r2.get() <= 0) goto L_0x00b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r2.child.onNext(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            r2.produced(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00af, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b0, code lost:
            r2.unsubscribe();
            rx.exceptions.Exceptions.throwOrReport(r0, (rx.Observer<?>) r2.child, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00bc, code lost:
            r6 = r6 + 1;
            r4 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c1, code lost:
            if (r6 <= 0) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c3, code lost:
            request(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c8, code lost:
            if (r7 == 0) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ca, code lost:
            if (r4 != false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00cf, code lost:
            monitor-enter(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00d2, code lost:
            if (r1.missed != false) goto L_0x00de;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00d4, code lost:
            r1.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d7, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d8, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x00d9, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x00db, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x00dc, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            r1.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x00e0, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x00e4, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x00e6, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x00e8, code lost:
            if (r2 == false) goto L_0x00ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x00ea, code lost:
            monitor-enter(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
            r1.emitting = false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dispatch() {
            /*
                r18 = this;
                r1 = r18
                monitor-enter(r18)
                boolean r0 = r1.emitting     // Catch:{ all -> 0x000c }
                r2 = 1
                if (r0 == 0) goto L_0x000f
                r1.missed = r2     // Catch:{ all -> 0x000c }
                monitor-exit(r18)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r0 = move-exception
                goto L_0x00f3
            L_0x000f:
                r1.emitting = r2     // Catch:{ all -> 0x000c }
                r3 = 0
                r1.missed = r3     // Catch:{ all -> 0x000c }
                monitor-exit(r18)     // Catch:{ all -> 0x000c }
            L_0x0015:
                java.lang.Object r0 = r1.terminalEvent     // Catch:{ all -> 0x004b }
                java.util.Queue<java.lang.Object> r4 = r1.queue     // Catch:{ all -> 0x004b }
                boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x004b }
                boolean r0 = r1.checkTerminated(r0, r4)     // Catch:{ all -> 0x004b }
                if (r0 == 0) goto L_0x0024
                return
            L_0x0024:
                if (r4 != 0) goto L_0x00cf
                java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$InnerProducer[]> r0 = r1.producers     // Catch:{ all -> 0x004b }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x004b }
                r5 = r0
                rx.internal.operators.OperatorPublish$InnerProducer[] r5 = (rx.internal.operators.OperatorPublish.InnerProducer[]) r5     // Catch:{ all -> 0x004b }
                int r0 = r5.length     // Catch:{ all -> 0x004b }
                int r6 = r5.length     // Catch:{ all -> 0x004b }
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r9 = 0
                r10 = 0
            L_0x0038:
                r11 = 0
                if (r9 >= r6) goto L_0x005a
                r13 = r5[r9]     // Catch:{ all -> 0x004b }
                long r13 = r13.get()     // Catch:{ all -> 0x004b }
                int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r15 < 0) goto L_0x004f
                long r7 = java.lang.Math.min(r7, r13)     // Catch:{ all -> 0x004b }
                goto L_0x0057
            L_0x004b:
                r0 = move-exception
                r2 = 0
                goto L_0x00e8
            L_0x004f:
                r11 = -9223372036854775808
                int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r15 != 0) goto L_0x0057
                int r10 = r10 + 1
            L_0x0057:
                int r9 = r9 + 1
                goto L_0x0038
            L_0x005a:
                r13 = 1
                if (r0 != r10) goto L_0x0076
                java.lang.Object r0 = r1.terminalEvent     // Catch:{ all -> 0x004b }
                java.util.Queue<java.lang.Object> r4 = r1.queue     // Catch:{ all -> 0x004b }
                java.lang.Object r4 = r4.poll()     // Catch:{ all -> 0x004b }
                if (r4 != 0) goto L_0x006a
                r4 = 1
                goto L_0x006b
            L_0x006a:
                r4 = 0
            L_0x006b:
                boolean r0 = r1.checkTerminated(r0, r4)     // Catch:{ all -> 0x004b }
                if (r0 == 0) goto L_0x0072
                return
            L_0x0072:
                r1.request(r13)     // Catch:{ all -> 0x004b }
                goto L_0x0015
            L_0x0076:
                r6 = 0
            L_0x0077:
                long r9 = (long) r6     // Catch:{ all -> 0x004b }
                int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r0 >= 0) goto L_0x00c1
                java.lang.Object r0 = r1.terminalEvent     // Catch:{ all -> 0x004b }
                java.util.Queue<java.lang.Object> r4 = r1.queue     // Catch:{ all -> 0x004b }
                java.lang.Object r4 = r4.poll()     // Catch:{ all -> 0x004b }
                if (r4 != 0) goto L_0x0088
                r15 = 1
                goto L_0x0089
            L_0x0088:
                r15 = 0
            L_0x0089:
                boolean r0 = r1.checkTerminated(r0, r15)     // Catch:{ all -> 0x004b }
                if (r0 == 0) goto L_0x0090
                return
            L_0x0090:
                if (r15 == 0) goto L_0x0094
                r4 = r15
                goto L_0x00c1
            L_0x0094:
                java.lang.Object r4 = rx.internal.operators.NotificationLite.getValue(r4)     // Catch:{ all -> 0x004b }
                int r9 = r5.length     // Catch:{ all -> 0x004b }
                r10 = 0
            L_0x009a:
                if (r10 >= r9) goto L_0x00bc
                r2 = r5[r10]     // Catch:{ all -> 0x004b }
                long r16 = r2.get()     // Catch:{ all -> 0x004b }
                int r0 = (r16 > r11 ? 1 : (r16 == r11 ? 0 : -1))
                if (r0 <= 0) goto L_0x00b8
                rx.Subscriber<? super T> r0 = r2.child     // Catch:{ all -> 0x00af }
                r0.onNext(r4)     // Catch:{ all -> 0x00af }
                r2.produced(r13)     // Catch:{ all -> 0x004b }
                goto L_0x00b8
            L_0x00af:
                r0 = move-exception
                r2.unsubscribe()     // Catch:{ all -> 0x004b }
                rx.Subscriber<? super T> r2 = r2.child     // Catch:{ all -> 0x004b }
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r0, (rx.Observer<?>) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x004b }
            L_0x00b8:
                int r10 = r10 + 1
                r2 = 1
                goto L_0x009a
            L_0x00bc:
                int r6 = r6 + 1
                r4 = r15
                r2 = 1
                goto L_0x0077
            L_0x00c1:
                if (r6 <= 0) goto L_0x00c6
                r1.request(r9)     // Catch:{ all -> 0x004b }
            L_0x00c6:
                int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r0 == 0) goto L_0x00cf
                if (r4 != 0) goto L_0x00cf
            L_0x00cc:
                r2 = 1
                goto L_0x0015
            L_0x00cf:
                monitor-enter(r18)     // Catch:{ all -> 0x004b }
                boolean r0 = r1.missed     // Catch:{ all -> 0x00db }
                if (r0 != 0) goto L_0x00de
                r1.emitting = r3     // Catch:{ all -> 0x00db }
                monitor-exit(r18)     // Catch:{ all -> 0x00d8 }
                return
            L_0x00d8:
                r0 = move-exception
                r2 = 1
                goto L_0x00e2
            L_0x00db:
                r0 = move-exception
                r2 = 0
                goto L_0x00e2
            L_0x00de:
                r1.missed = r3     // Catch:{ all -> 0x00db }
                monitor-exit(r18)     // Catch:{ all -> 0x00db }
                goto L_0x00cc
            L_0x00e2:
                monitor-exit(r18)     // Catch:{ all -> 0x00e6 }
                throw r0     // Catch:{ all -> 0x00e4 }
            L_0x00e4:
                r0 = move-exception
                goto L_0x00e8
            L_0x00e6:
                r0 = move-exception
                goto L_0x00e2
            L_0x00e8:
                if (r2 != 0) goto L_0x00f2
                monitor-enter(r18)
                r1.emitting = r3     // Catch:{ all -> 0x00ef }
                monitor-exit(r18)     // Catch:{ all -> 0x00ef }
                goto L_0x00f2
            L_0x00ef:
                r0 = move-exception
                monitor-exit(r18)     // Catch:{ all -> 0x00ef }
                throw r0
            L_0x00f2:
                throw r0
            L_0x00f3:
                monitor-exit(r18)     // Catch:{ all -> 0x000c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorPublish.PublishSubscriber.dispatch():void");
        }

        public void init() {
            add(Subscriptions.create(new Action0() {
                /* JADX WARNING: Removed duplicated region for block: B:1:0x000d A[LOOP:0: B:1:0x000d->B:4:0x0019, LOOP_START] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void call() {
                    /*
                        r3 = this;
                        rx.internal.operators.OperatorPublish$PublishSubscriber r0 = rx.internal.operators.OperatorPublish.PublishSubscriber.this
                        java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$InnerProducer[]> r0 = r0.producers
                        rx.internal.operators.OperatorPublish$InnerProducer[] r1 = rx.internal.operators.OperatorPublish.PublishSubscriber.TERMINATED
                        r0.getAndSet(r1)
                        rx.internal.operators.OperatorPublish$PublishSubscriber r0 = rx.internal.operators.OperatorPublish.PublishSubscriber.this
                        java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$PublishSubscriber<T>> r1 = r0.current
                    L_0x000d:
                        r2 = 0
                        boolean r2 = r1.compareAndSet(r0, r2)
                        if (r2 == 0) goto L_0x0015
                        goto L_0x001b
                    L_0x0015:
                        java.lang.Object r2 = r1.get()
                        if (r2 == r0) goto L_0x000d
                    L_0x001b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorPublish.PublishSubscriber.AnonymousClass1.call():void");
                }
            }));
        }

        public void onCompleted() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.completed();
                dispatch();
            }
        }

        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
            }
        }

        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                dispatch();
            }
        }

        public void onStart() {
            request((long) RxRingBuffer.SIZE);
        }

        public void remove(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            while (true) {
                InnerProducer[] innerProducerArr2 = this.producers.get();
                if (innerProducerArr2 != EMPTY && innerProducerArr2 != TERMINATED) {
                    int length = innerProducerArr2.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (innerProducerArr2[i].equals(innerProducer)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerProducerArr = EMPTY;
                        } else {
                            InnerProducer[] innerProducerArr3 = new InnerProducer[(length - 1)];
                            System.arraycopy(innerProducerArr2, 0, innerProducerArr3, 0, i);
                            System.arraycopy(innerProducerArr2, i + 1, innerProducerArr3, i, (length - i) - 1);
                            innerProducerArr = innerProducerArr3;
                        }
                        AtomicReference<InnerProducer[]> atomicReference = this.producers;
                        while (true) {
                            if (!atomicReference.compareAndSet(innerProducerArr2, innerProducerArr)) {
                                if (atomicReference.get() != innerProducerArr2) {
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private OperatorPublish(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<PublishSubscriber<T>> atomicReference) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new Observable.OnSubscribe<T>() {
            public void call(Subscriber<? super T> subscriber) {
                while (true) {
                    PublishSubscriber publishSubscriber = (PublishSubscriber) atomicReference.get();
                    if (publishSubscriber == null || publishSubscriber.isUnsubscribed()) {
                        PublishSubscriber publishSubscriber2 = new PublishSubscriber(atomicReference);
                        publishSubscriber2.init();
                        AtomicReference atomicReference = atomicReference;
                        while (true) {
                            if (!atomicReference.compareAndSet(publishSubscriber, publishSubscriber2)) {
                                if (atomicReference.get() != publishSubscriber) {
                                    break;
                                }
                            } else {
                                publishSubscriber = publishSubscriber2;
                                break;
                            }
                        }
                    }
                    InnerProducer innerProducer = new InnerProducer(publishSubscriber, subscriber);
                    if (publishSubscriber.add(innerProducer)) {
                        subscriber.add(innerProducer);
                        subscriber.setProducer(innerProducer);
                        return;
                    }
                }
            }
        }, observable, atomicReference);
    }

    public void connect(Action1<? super Subscription> action1) {
        PublishSubscriber<T> publishSubscriber;
        loop0:
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isUnsubscribed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.current);
            publishSubscriber2.init();
            AtomicReference<PublishSubscriber<T>> atomicReference = this.current;
            while (true) {
                if (atomicReference.compareAndSet(publishSubscriber, publishSubscriber2)) {
                    publishSubscriber = publishSubscriber2;
                    break loop0;
                } else if (atomicReference.get() != publishSubscriber) {
                }
            }
        }
        boolean z = false;
        if (!publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            z = true;
        }
        action1.call(publishSubscriber);
        if (z) {
            this.source.unsafeSubscribe(publishSubscriber);
        }
    }

    public static <T, R> Observable<R> create(Observable<? extends T> observable, Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return create(observable, func1, false);
    }

    public static <T, R> Observable<R> create(final Observable<? extends T> observable, final Func1<? super Observable<T>, ? extends Observable<R>> func1, final boolean z) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<R>() {
            public void call(final Subscriber<? super R> subscriber) {
                final OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(RxRingBuffer.SIZE, z);
                AnonymousClass1 r1 = new Subscriber<R>() {
                    public void onCompleted() {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onCompleted();
                    }

                    public void onError(Throwable th) {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onError(th);
                    }

                    public void onNext(R r) {
                        subscriber.onNext(r);
                    }

                    public void setProducer(Producer producer) {
                        subscriber.setProducer(producer);
                    }
                };
                subscriber.add(onSubscribePublishMulticast);
                subscriber.add(r1);
                ((Observable) func1.call(Observable.unsafeCreate(onSubscribePublishMulticast))).unsafeSubscribe(r1);
                observable.unsafeSubscribe(onSubscribePublishMulticast.subscriber());
            }
        });
    }
}
