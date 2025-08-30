package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {

    public static final class Holder {
        static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();
    }

    public static final class LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final Subscriber<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        LatestSubscriber<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            lazySet(NOT_REQUESTED);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r2 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            if (r2 != Long.MIN_VALUE) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
            r4 = r9.value.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            if (r2 <= 0) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            r2 = EMPTY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
            if (r4 == r2) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
            r9.child.onNext(r4);
            r3 = r9.value;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
            if (r3.compareAndSet(r4, r2) == false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
            if (r3.get() == r4) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
            produced(1);
            r4 = EMPTY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
            if (r4 != EMPTY) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
            if (r9.done == false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0055, code lost:
            r2 = r9.terminal;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0057, code lost:
            if (r2 == null) goto L_0x005f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0059, code lost:
            r9.child.onError(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005f, code lost:
            r9.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0067, code lost:
            if (r9.missed != false) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0069, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x006d, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x006f, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0070, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            r9.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0074, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0078, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0079, code lost:
            r8 = r2;
            r2 = r1;
            r1 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x007c, code lost:
            if (r2 == false) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x007e, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0086, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emit() {
            /*
                r9 = this;
                monitor-enter(r9)
                boolean r0 = r9.emitting     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r9.missed = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r9)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r0 = move-exception
                goto L_0x0087
            L_0x000d:
                r9.emitting = r1     // Catch:{ all -> 0x000a }
                r0 = 0
                r9.missed = r0     // Catch:{ all -> 0x000a }
                monitor-exit(r9)     // Catch:{ all -> 0x000a }
            L_0x0013:
                long r2 = r9.get()     // Catch:{ all -> 0x004a }
                r4 = -9223372036854775808
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L_0x001e
                goto L_0x006c
            L_0x001e:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r4 = r9.value     // Catch:{ all -> 0x004a }
                java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x004a }
                r5 = 0
                int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r7 <= 0) goto L_0x004d
                java.lang.Object r2 = EMPTY     // Catch:{ all -> 0x004a }
                if (r4 == r2) goto L_0x004d
                rx.Subscriber<? super T> r3 = r9.child     // Catch:{ all -> 0x004a }
                r3.onNext(r4)     // Catch:{ all -> 0x004a }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r9.value     // Catch:{ all -> 0x004a }
            L_0x0035:
                boolean r5 = r3.compareAndSet(r4, r2)     // Catch:{ all -> 0x004a }
                if (r5 == 0) goto L_0x003c
                goto L_0x0042
            L_0x003c:
                java.lang.Object r5 = r3.get()     // Catch:{ all -> 0x004a }
                if (r5 == r4) goto L_0x0035
            L_0x0042:
                r2 = 1
                r9.produced(r2)     // Catch:{ all -> 0x004a }
                java.lang.Object r4 = EMPTY     // Catch:{ all -> 0x004a }
                goto L_0x004d
            L_0x004a:
                r1 = move-exception
                r2 = 0
                goto L_0x007c
            L_0x004d:
                java.lang.Object r2 = EMPTY     // Catch:{ all -> 0x004a }
                if (r4 != r2) goto L_0x0064
                boolean r2 = r9.done     // Catch:{ all -> 0x004a }
                if (r2 == 0) goto L_0x0064
                java.lang.Throwable r2 = r9.terminal     // Catch:{ all -> 0x004a }
                if (r2 == 0) goto L_0x005f
                rx.Subscriber<? super T> r3 = r9.child     // Catch:{ all -> 0x004a }
                r3.onError(r2)     // Catch:{ all -> 0x004a }
                goto L_0x0064
            L_0x005f:
                rx.Subscriber<? super T> r2 = r9.child     // Catch:{ all -> 0x004a }
                r2.onCompleted()     // Catch:{ all -> 0x004a }
            L_0x0064:
                monitor-enter(r9)     // Catch:{ all -> 0x004a }
                boolean r2 = r9.missed     // Catch:{ all -> 0x006f }
                if (r2 != 0) goto L_0x0072
                r9.emitting = r0     // Catch:{ all -> 0x006f }
                monitor-exit(r9)     // Catch:{ all -> 0x006d }
            L_0x006c:
                return
            L_0x006d:
                r2 = move-exception
                goto L_0x0076
            L_0x006f:
                r2 = move-exception
                r1 = 0
                goto L_0x0076
            L_0x0072:
                r9.missed = r0     // Catch:{ all -> 0x006f }
                monitor-exit(r9)     // Catch:{ all -> 0x006f }
                goto L_0x0013
            L_0x0076:
                monitor-exit(r9)     // Catch:{ all -> 0x006d }
                throw r2     // Catch:{ all -> 0x0078 }
            L_0x0078:
                r2 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
            L_0x007c:
                if (r2 != 0) goto L_0x0086
                monitor-enter(r9)
                r9.emitting = r0     // Catch:{ all -> 0x0083 }
                monitor-exit(r9)     // Catch:{ all -> 0x0083 }
                goto L_0x0086
            L_0x0083:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0083 }
                throw r0
            L_0x0086:
                throw r1
            L_0x0087:
                monitor-exit(r9)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.emit():void");
        }

        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        public void onError(Throwable th) {
            this.terminal = th;
            this.done = true;
            emit();
        }

        public void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        public long produced(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 < 0) {
                    return j2;
                }
                j3 = j2 - j;
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        public void request(long j) {
            long j2;
            int i;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        i = (j2 > NOT_REQUESTED ? 1 : (j2 == NOT_REQUESTED ? 0 : -1));
                        if (i == 0) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                if (i == 0) {
                    this.parent.requestMore(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                emit();
            }
        }

        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    public static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        public LatestSubscriber(LatestEmitter<T> latestEmitter) {
            this.producer = latestEmitter;
        }

        public void onCompleted() {
            this.producer.onCompleted();
        }

        public void onError(Throwable th) {
            this.producer.onError(th);
        }

        public void onNext(T t) {
            this.producer.onNext(t);
        }

        public void onStart() {
            request(0);
        }

        public void requestMore(long j) {
            request(j);
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return Holder.INSTANCE;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        LatestEmitter latestEmitter = new LatestEmitter(subscriber);
        LatestSubscriber<? super T> latestSubscriber = new LatestSubscriber<>(latestEmitter);
        latestEmitter.parent = latestSubscriber;
        subscriber.add(latestSubscriber);
        subscriber.add(latestEmitter);
        subscriber.setProducer(latestEmitter);
        return latestSubscriber;
    }
}
