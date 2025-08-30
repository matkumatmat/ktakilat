package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    public static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);
    }

    public static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);
    }

    public static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int LIMIT = (RxRingBuffer.SIZE / 4);
        volatile boolean done;
        final long id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j) {
            this.parent = mergeSubscriber;
            this.id = j;
        }

        public void onCompleted() {
            this.done = true;
            this.parent.emit();
        }

        public void onError(Throwable th) {
            this.parent.getOrCreateErrorQueue().offer(th);
            this.done = true;
            this.parent.emit();
        }

        public void onNext(T t) {
            this.parent.tryEmit(this, t);
        }

        public void onStart() {
            int i = RxRingBuffer.SIZE;
            this.outstanding = i;
            request((long) i);
        }

        public void requestMore(long j) {
            int i = this.outstanding - ((int) j);
            if (i > LIMIT) {
                this.outstanding = i;
                return;
            }
            int i2 = RxRingBuffer.SIZE;
            this.outstanding = i2;
            int i3 = i2 - i;
            if (i3 > 0) {
                request((long) i3);
            }
        }
    }

    public static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.subscriber = mergeSubscriber;
        }

        public long produced(int i) {
            return addAndGet((long) (-i));
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                if (get() != LocationRequestCompat.PASSIVE_INTERVAL) {
                    BackpressureUtils.getAndAddRequest(this, j);
                    this.subscriber.emit();
                }
            } else if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }
    }

    public static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z, int i) {
            this.child = subscriber;
            this.delayErrors = z;
            this.maxConcurrent = i;
            if (i == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(LocationRequestCompat.PASSIVE_INTERVAL);
                return;
            }
            this.scalarEmissionLimit = Math.max(1, i >> 1);
            request((long) i);
        }

        private void reportError() {
            ArrayList arrayList = new ArrayList(this.errors);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException((Collection<? extends Throwable>) arrayList));
            }
        }

        public void addInner(InnerSubscriber<T> innerSubscriber) {
            getOrCreateComposite().add(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        public boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (this.delayErrors || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                reportError();
                return true;
            } finally {
                unsubscribe();
            }
        }

        public void emit() {
            synchronized (this) {
                try {
                    if (this.emitting) {
                        this.missed = true;
                        return;
                    }
                    this.emitting = true;
                    emitLoop();
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void emitEmpty() {
            int i = this.scalarEmissionCount + 1;
            if (i == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore((long) i);
                return;
            }
            this.scalarEmissionCount = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:164:0x01a7, code lost:
            r0 = th;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x01ad  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitLoop() {
            /*
                r23 = this;
                r1 = r23
                r2 = 0
                rx.Subscriber<? super T> r3 = r1.child     // Catch:{ all -> 0x005f }
            L_0x0005:
                boolean r0 = r23.checkTerminate()     // Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x000c
                return
            L_0x000c:
                java.util.Queue<java.lang.Object> r4 = r1.queue     // Catch:{ all -> 0x005f }
                rx.internal.operators.OperatorMerge$MergeProducer<T> r0 = r1.producer     // Catch:{ all -> 0x005f }
                long r5 = r0.get()     // Catch:{ all -> 0x005f }
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 != 0) goto L_0x001f
                r10 = 1
                goto L_0x0020
            L_0x001f:
                r10 = 0
            L_0x0020:
                r11 = 1
                r14 = 0
                if (r4 == 0) goto L_0x009c
                r0 = 0
            L_0x0027:
                r16 = r5
                r6 = 0
                r5 = r0
                r0 = 0
            L_0x002c:
                int r18 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r18 <= 0) goto L_0x007a
                java.lang.Object r18 = r4.poll()     // Catch:{ all -> 0x005f }
                boolean r0 = r23.checkTerminate()     // Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x003b
                return
            L_0x003b:
                if (r18 != 0) goto L_0x0040
                r0 = r18
                goto L_0x007a
            L_0x0040:
                java.lang.Object r0 = rx.internal.operators.NotificationLite.getValue(r18)     // Catch:{ all -> 0x005f }
                r3.onNext(r0)     // Catch:{ all -> 0x0048 }
                goto L_0x006c
            L_0x0048:
                r0 = move-exception
                r19 = r0
                boolean r0 = r1.delayErrors     // Catch:{ all -> 0x005f }
                if (r0 != 0) goto L_0x0063
                rx.exceptions.Exceptions.throwIfFatal(r19)     // Catch:{ all -> 0x005f }
                r23.unsubscribe()     // Catch:{ all -> 0x005b }
                r4 = r19
                r3.onError(r4)     // Catch:{ all -> 0x005b }
                return
            L_0x005b:
                r0 = move-exception
                r9 = 1
                goto L_0x01ab
            L_0x005f:
                r0 = move-exception
                r9 = 0
                goto L_0x01ab
            L_0x0063:
                r7 = r19
                java.util.Queue r0 = r23.getOrCreateErrorQueue()     // Catch:{ all -> 0x005f }
                r0.offer(r7)     // Catch:{ all -> 0x005f }
            L_0x006c:
                int r5 = r5 + 1
                int r6 = r6 + 1
                long r16 = r16 - r11
                r0 = r18
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x002c
            L_0x007a:
                if (r6 <= 0) goto L_0x008c
                if (r10 == 0) goto L_0x0084
                r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x008c
            L_0x0084:
                rx.internal.operators.OperatorMerge$MergeProducer<T> r7 = r1.producer     // Catch:{ all -> 0x005f }
                long r6 = r7.produced(r6)     // Catch:{ all -> 0x005f }
                r16 = r6
            L_0x008c:
                int r6 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r6 == 0) goto L_0x009f
                if (r0 != 0) goto L_0x0093
                goto L_0x009f
            L_0x0093:
                r0 = r5
                r5 = r16
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0027
            L_0x009c:
                r16 = r5
                r5 = 0
            L_0x009f:
                boolean r0 = r1.done     // Catch:{ all -> 0x005f }
                java.util.Queue<java.lang.Object> r4 = r1.queue     // Catch:{ all -> 0x005f }
                rx.internal.operators.OperatorMerge$InnerSubscriber<?>[] r6 = r1.innerSubscribers     // Catch:{ all -> 0x005f }
                int r7 = r6.length     // Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x00c5
                if (r4 == 0) goto L_0x00b0
                boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x00c5
            L_0x00b0:
                if (r7 != 0) goto L_0x00c5
                java.util.concurrent.ConcurrentLinkedQueue<java.lang.Throwable> r0 = r1.errors     // Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x00c1
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x00bd
                goto L_0x00c1
            L_0x00bd:
                r23.reportError()     // Catch:{ all -> 0x005f }
                goto L_0x00c4
            L_0x00c1:
                r3.onCompleted()     // Catch:{ all -> 0x005f }
            L_0x00c4:
                return
            L_0x00c5:
                if (r7 <= 0) goto L_0x0187
                r8 = r10
                long r9 = r1.lastId     // Catch:{ all -> 0x005f }
                int r0 = r1.lastIndex     // Catch:{ all -> 0x005f }
                if (r7 <= r0) goto L_0x00d6
                r4 = r6[r0]     // Catch:{ all -> 0x005f }
                long r11 = r4.id     // Catch:{ all -> 0x005f }
                int r4 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r4 == 0) goto L_0x00f5
            L_0x00d6:
                if (r7 > r0) goto L_0x00d9
                r0 = 0
            L_0x00d9:
                r4 = 0
            L_0x00da:
                if (r4 >= r7) goto L_0x00ed
                r11 = r6[r0]     // Catch:{ all -> 0x005f }
                long r11 = r11.id     // Catch:{ all -> 0x005f }
                int r22 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r22 != 0) goto L_0x00e5
                goto L_0x00ed
            L_0x00e5:
                int r0 = r0 + 1
                if (r0 != r7) goto L_0x00ea
                r0 = 0
            L_0x00ea:
                int r4 = r4 + 1
                goto L_0x00da
            L_0x00ed:
                r1.lastIndex = r0     // Catch:{ all -> 0x005f }
                r4 = r6[r0]     // Catch:{ all -> 0x005f }
                long r9 = r4.id     // Catch:{ all -> 0x005f }
                r1.lastId = r9     // Catch:{ all -> 0x005f }
            L_0x00f5:
                r4 = 0
                r9 = 0
            L_0x00f7:
                if (r4 >= r7) goto L_0x017e
                boolean r10 = r23.checkTerminate()     // Catch:{ all -> 0x005f }
                if (r10 == 0) goto L_0x0100
                return
            L_0x0100:
                r10 = r6[r0]     // Catch:{ all -> 0x005f }
                r11 = 0
            L_0x0103:
                r12 = 0
            L_0x0104:
                int r22 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r22 <= 0) goto L_0x011a
                boolean r22 = r23.checkTerminate()     // Catch:{ all -> 0x005f }
                if (r22 == 0) goto L_0x010f
                return
            L_0x010f:
                rx.internal.util.RxRingBuffer r13 = r10.queue     // Catch:{ all -> 0x005f }
                if (r13 != 0) goto L_0x0114
                goto L_0x011a
            L_0x0114:
                java.lang.Object r11 = r13.poll()     // Catch:{ all -> 0x005f }
                if (r11 != 0) goto L_0x011d
            L_0x011a:
                r20 = 1
                goto L_0x013d
            L_0x011d:
                java.lang.Object r13 = rx.internal.operators.NotificationLite.getValue(r11)     // Catch:{ all -> 0x005f }
                r3.onNext(r13)     // Catch:{ all -> 0x012b }
                r20 = 1
                long r16 = r16 - r20
                int r12 = r12 + 1
                goto L_0x0104
            L_0x012b:
                r0 = move-exception
                r4 = r0
                rx.exceptions.Exceptions.throwIfFatal(r4)     // Catch:{ all -> 0x005b }
                r3.onError(r4)     // Catch:{ all -> 0x0137 }
                r23.unsubscribe()     // Catch:{ all -> 0x005b }
                return
            L_0x0137:
                r0 = move-exception
                r3 = r0
                r23.unsubscribe()     // Catch:{ all -> 0x005b }
                throw r3     // Catch:{ all -> 0x005b }
            L_0x013d:
                if (r12 <= 0) goto L_0x0151
                if (r8 != 0) goto L_0x0148
                rx.internal.operators.OperatorMerge$MergeProducer<T> r13 = r1.producer     // Catch:{ all -> 0x005f }
                long r16 = r13.produced(r12)     // Catch:{ all -> 0x005f }
                goto L_0x014d
            L_0x0148:
                r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x014d:
                long r12 = (long) r12     // Catch:{ all -> 0x005f }
                r10.requestMore(r12)     // Catch:{ all -> 0x005f }
            L_0x0151:
                int r12 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r12 == 0) goto L_0x0157
                if (r11 != 0) goto L_0x0103
            L_0x0157:
                boolean r11 = r10.done     // Catch:{ all -> 0x005f }
                rx.internal.util.RxRingBuffer r13 = r10.queue     // Catch:{ all -> 0x005f }
                if (r11 == 0) goto L_0x0172
                if (r13 == 0) goto L_0x0165
                boolean r11 = r13.isEmpty()     // Catch:{ all -> 0x005f }
                if (r11 == 0) goto L_0x0172
            L_0x0165:
                r1.removeInner(r10)     // Catch:{ all -> 0x005f }
                boolean r9 = r23.checkTerminate()     // Catch:{ all -> 0x005f }
                if (r9 == 0) goto L_0x016f
                return
            L_0x016f:
                int r5 = r5 + 1
                r9 = 1
            L_0x0172:
                if (r12 != 0) goto L_0x0175
                goto L_0x017e
            L_0x0175:
                int r0 = r0 + 1
                if (r0 != r7) goto L_0x017a
                r0 = 0
            L_0x017a:
                int r4 = r4 + 1
                goto L_0x00f7
            L_0x017e:
                r1.lastIndex = r0     // Catch:{ all -> 0x005f }
                r0 = r6[r0]     // Catch:{ all -> 0x005f }
                long r6 = r0.id     // Catch:{ all -> 0x005f }
                r1.lastId = r6     // Catch:{ all -> 0x005f }
                goto L_0x0188
            L_0x0187:
                r9 = 0
            L_0x0188:
                if (r5 <= 0) goto L_0x018e
                long r4 = (long) r5     // Catch:{ all -> 0x005f }
                r1.request(r4)     // Catch:{ all -> 0x005f }
            L_0x018e:
                if (r9 == 0) goto L_0x0192
                goto L_0x0005
            L_0x0192:
                monitor-enter(r23)     // Catch:{ all -> 0x005f }
                boolean r0 = r1.missed     // Catch:{ all -> 0x01a3 }
                if (r0 != 0) goto L_0x019e
                r1.emitting = r2     // Catch:{ all -> 0x019b }
                monitor-exit(r23)     // Catch:{ all -> 0x019b }
                return
            L_0x019b:
                r0 = move-exception
                r9 = 1
                goto L_0x01a5
            L_0x019e:
                r1.missed = r2     // Catch:{ all -> 0x01a3 }
                monitor-exit(r23)     // Catch:{ all -> 0x01a3 }
                goto L_0x0005
            L_0x01a3:
                r0 = move-exception
                r9 = 0
            L_0x01a5:
                monitor-exit(r23)     // Catch:{ all -> 0x01a9 }
                throw r0     // Catch:{ all -> 0x01a7 }
            L_0x01a7:
                r0 = move-exception
                goto L_0x01ab
            L_0x01a9:
                r0 = move-exception
                goto L_0x01a5
            L_0x01ab:
                if (r9 != 0) goto L_0x01b5
                monitor-enter(r23)
                r1.emitting = r2     // Catch:{ all -> 0x01b2 }
                monitor-exit(r23)     // Catch:{ all -> 0x01b2 }
                goto L_0x01b5
            L_0x01b2:
                r0 = move-exception
                monitor-exit(r23)     // Catch:{ all -> 0x01b2 }
                throw r0
            L_0x01b5:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitLoop():void");
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void emitScalar(rx.internal.operators.OperatorMerge.InnerSubscriber<T> r5, T r6, long r7) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.Subscriber<? super T> r2 = r4.child     // Catch:{ all -> 0x0008 }
                r2.onNext(r6)     // Catch:{ all -> 0x0008 }
                goto L_0x0023
            L_0x0008:
                r6 = move-exception
                boolean r2 = r4.delayErrors     // Catch:{ all -> 0x0019 }
                if (r2 != 0) goto L_0x001c
                rx.exceptions.Exceptions.throwIfFatal(r6)     // Catch:{ all -> 0x0019 }
                r5.unsubscribe()     // Catch:{ all -> 0x0017 }
                r5.onError(r6)     // Catch:{ all -> 0x0017 }
                return
            L_0x0017:
                r5 = move-exception
                goto L_0x004a
            L_0x0019:
                r5 = move-exception
                r0 = 0
                goto L_0x004a
            L_0x001c:
                java.util.Queue r2 = r4.getOrCreateErrorQueue()     // Catch:{ all -> 0x0019 }
                r2.offer(r6)     // Catch:{ all -> 0x0019 }
            L_0x0023:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 == 0) goto L_0x0031
                rx.internal.operators.OperatorMerge$MergeProducer<T> r6 = r4.producer     // Catch:{ all -> 0x0019 }
                r6.produced(r0)     // Catch:{ all -> 0x0019 }
            L_0x0031:
                r6 = 1
                r5.requestMore(r6)     // Catch:{ all -> 0x0019 }
                monitor-enter(r4)     // Catch:{ all -> 0x0019 }
                boolean r5 = r4.missed     // Catch:{ all -> 0x003f }
                if (r5 != 0) goto L_0x0041
                r4.emitting = r1     // Catch:{ all -> 0x003f }
                monitor-exit(r4)     // Catch:{ all -> 0x003f }
                return
            L_0x003f:
                r5 = move-exception
                goto L_0x0048
            L_0x0041:
                r4.missed = r1     // Catch:{ all -> 0x003f }
                monitor-exit(r4)     // Catch:{ all -> 0x003f }
                r4.emitLoop()
                return
            L_0x0048:
                monitor-exit(r4)     // Catch:{ all -> 0x003f }
                throw r5     // Catch:{ all -> 0x0017 }
            L_0x004a:
                if (r0 != 0) goto L_0x0054
                monitor-enter(r4)
                r4.emitting = r1     // Catch:{ all -> 0x0051 }
                monitor-exit(r4)     // Catch:{ all -> 0x0051 }
                goto L_0x0054
            L_0x0051:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0051 }
                throw r5
            L_0x0054:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(rx.internal.operators.OperatorMerge$InnerSubscriber, java.lang.Object, long):void");
        }

        public CompositeSubscription getOrCreateComposite() {
            boolean z;
            CompositeSubscription compositeSubscription = this.subscriptions;
            if (compositeSubscription == null) {
                synchronized (this) {
                    try {
                        compositeSubscription = this.subscriptions;
                        if (compositeSubscription == null) {
                            compositeSubscription = new CompositeSubscription();
                            this.subscriptions = compositeSubscription;
                            z = true;
                        } else {
                            z = false;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (z) {
                    add(compositeSubscription);
                }
            }
            return compositeSubscription;
        }

        public Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    try {
                        concurrentLinkedQueue = this.errors;
                        if (concurrentLinkedQueue == null) {
                            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                            this.errors = concurrentLinkedQueue;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        public void onError(Throwable th) {
            getOrCreateErrorQueue().offer(th);
            this.done = true;
            emit();
        }

        public void queueScalar(InnerSubscriber<T> innerSubscriber, T t) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer == null) {
                rxRingBuffer = RxRingBuffer.getSpscInstance();
                innerSubscriber.add(rxRingBuffer);
                innerSubscriber.queue = rxRingBuffer;
            }
            try {
                rxRingBuffer.onNext(NotificationLite.next(t));
            } catch (MissingBackpressureException e) {
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e);
            } catch (IllegalStateException e2) {
                if (!innerSubscriber.isUnsubscribed()) {
                    innerSubscriber.unsubscribe();
                    innerSubscriber.onError(e2);
                }
            }
        }

        public void removeInner(InnerSubscriber<T> innerSubscriber) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer != null) {
                rxRingBuffer.release();
            }
            this.subscriptions.remove(innerSubscriber);
            synchronized (this.innerGuard) {
                try {
                    InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                    int length = innerSubscriberArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (innerSubscriber.equals(innerSubscriberArr[i])) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            this.innerSubscribers = EMPTY;
                            return;
                        }
                        InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[(length - 1)];
                        System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                        System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                        this.innerSubscribers = innerSubscriberArr2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void requestMore(long j) {
            request(j);
        }

        public void tryEmit(InnerSubscriber<T> innerSubscriber, T t) {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    try {
                        j = this.producer.get();
                        if (!this.emitting && j != 0) {
                            z = true;
                            this.emitting = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z) {
                RxRingBuffer rxRingBuffer = innerSubscriber.queue;
                if (rxRingBuffer == null || rxRingBuffer.isEmpty()) {
                    emitScalar(innerSubscriber, t, j);
                    return;
                }
                queueScalar(innerSubscriber, t);
                emitLoop();
                return;
            }
            queueScalar(innerSubscriber, t);
            emit();
        }

        public void onNext(Observable<? extends T> observable) {
            if (observable != null) {
                if (observable == Observable.empty()) {
                    emitEmpty();
                } else if (observable instanceof ScalarSynchronousObservable) {
                    tryEmit(((ScalarSynchronousObservable) observable).get());
                } else {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    addInner(innerSubscriber);
                    observable.unsafeSubscribe(innerSubscriber);
                    emit();
                }
            }
        }

        public void queueScalar(T t) {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> queue2 = this.queue;
            if (queue2 == null) {
                int i = this.maxConcurrent;
                if (i == Integer.MAX_VALUE) {
                    queue2 = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else {
                    if (!Pow2.isPowerOfTwo(i)) {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                    } else if (UnsafeAccess.isUnsafeAvailable()) {
                        spscExactAtomicArrayQueue = new SpscArrayQueue<>(i);
                    } else {
                        spscExactAtomicArrayQueue = new SpscAtomicArrayQueue<>(i);
                    }
                    queue2 = spscExactAtomicArrayQueue;
                }
                this.queue = queue2;
            }
            if (!queue2.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            }
        }

        public void tryEmit(T t) {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    try {
                        j = this.producer.get();
                        if (!this.emitting && j != 0) {
                            z = true;
                            this.emitting = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z) {
                Queue<Object> queue2 = this.queue;
                if (queue2 == null || queue2.isEmpty()) {
                    emitScalar(t, j);
                    return;
                }
                queueScalar(t);
                emitLoop();
                return;
            }
            queueScalar(t);
            emit();
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void emitScalar(T r5, long r6) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.Subscriber<? super T> r2 = r4.child     // Catch:{ all -> 0x0008 }
                r2.onNext(r5)     // Catch:{ all -> 0x0008 }
                goto L_0x0023
            L_0x0008:
                r5 = move-exception
                boolean r2 = r4.delayErrors     // Catch:{ all -> 0x0019 }
                if (r2 != 0) goto L_0x001c
                rx.exceptions.Exceptions.throwIfFatal(r5)     // Catch:{ all -> 0x0019 }
                r4.unsubscribe()     // Catch:{ all -> 0x0017 }
                r4.onError(r5)     // Catch:{ all -> 0x0017 }
                return
            L_0x0017:
                r5 = move-exception
                goto L_0x0055
            L_0x0019:
                r5 = move-exception
                r0 = 0
                goto L_0x0055
            L_0x001c:
                java.util.Queue r2 = r4.getOrCreateErrorQueue()     // Catch:{ all -> 0x0019 }
                r2.offer(r5)     // Catch:{ all -> 0x0019 }
            L_0x0023:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r5 == 0) goto L_0x0031
                rx.internal.operators.OperatorMerge$MergeProducer<T> r5 = r4.producer     // Catch:{ all -> 0x0019 }
                r5.produced(r0)     // Catch:{ all -> 0x0019 }
            L_0x0031:
                int r5 = r4.scalarEmissionCount     // Catch:{ all -> 0x0019 }
                int r5 = r5 + r0
                int r6 = r4.scalarEmissionLimit     // Catch:{ all -> 0x0019 }
                if (r5 != r6) goto L_0x003f
                r4.scalarEmissionCount = r1     // Catch:{ all -> 0x0019 }
                long r5 = (long) r5     // Catch:{ all -> 0x0019 }
                r4.requestMore(r5)     // Catch:{ all -> 0x0019 }
                goto L_0x0041
            L_0x003f:
                r4.scalarEmissionCount = r5     // Catch:{ all -> 0x0019 }
            L_0x0041:
                monitor-enter(r4)     // Catch:{ all -> 0x0019 }
                boolean r5 = r4.missed     // Catch:{ all -> 0x004a }
                if (r5 != 0) goto L_0x004c
                r4.emitting = r1     // Catch:{ all -> 0x004a }
                monitor-exit(r4)     // Catch:{ all -> 0x004a }
                return
            L_0x004a:
                r5 = move-exception
                goto L_0x0053
            L_0x004c:
                r4.missed = r1     // Catch:{ all -> 0x004a }
                monitor-exit(r4)     // Catch:{ all -> 0x004a }
                r4.emitLoop()
                return
            L_0x0053:
                monitor-exit(r4)     // Catch:{ all -> 0x004a }
                throw r5     // Catch:{ all -> 0x0017 }
            L_0x0055:
                if (r0 != 0) goto L_0x005f
                monitor-enter(r4)
                r4.emitting = r1     // Catch:{ all -> 0x005c }
                monitor-exit(r4)     // Catch:{ all -> 0x005c }
                goto L_0x005f
            L_0x005c:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x005c }
                throw r5
            L_0x005f:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(java.lang.Object, long):void");
        }
    }

    public OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.maxConcurrent = i;
    }

    public static <T> OperatorMerge<T> instance(boolean z) {
        if (z) {
            return HolderDelayErrors.INSTANCE;
        }
        return HolderNoDelay.INSTANCE;
    }

    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        MergeSubscriber mergeSubscriber = new MergeSubscriber(subscriber, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> mergeProducer = new MergeProducer<>(mergeSubscriber);
        mergeSubscriber.producer = mergeProducer;
        subscriber.add(mergeSubscriber);
        subscriber.setProducer(mergeProducer);
        return mergeSubscriber;
    }

    public static <T> OperatorMerge<T> instance(boolean z, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(ba.k(i, "maxConcurrent > 0 required but it was "));
        } else if (i == Integer.MAX_VALUE) {
            return instance(z);
        } else {
            return new OperatorMerge<>(z, i);
        }
    }
}
