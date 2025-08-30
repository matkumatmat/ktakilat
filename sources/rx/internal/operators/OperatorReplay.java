package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.util.OpenHashSet;
import rx.observables.ConnectableObservable;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

public final class OperatorReplay<T> extends ConnectableObservable<T> implements Subscription {
    static final Func0 DEFAULT_UNBOUNDED_FACTORY = new Func0() {
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    final Func0<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Observable<? extends T> source;

    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node((Object) null, 0);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = (Node) initialHead.get();
                if (initialHead != null) {
                    Object leaveTransform = leaveTransform(initialHead.value);
                    if (!NotificationLite.isCompleted(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                        collection.add(NotificationLite.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.completed());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public Object enterTransform(Object obj) {
            return obj;
        }

        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public Node getInitialHead() {
            return (Node) get();
        }

        public boolean hasCompleted() {
            Object obj = this.tail.value;
            if (obj == null || !NotificationLite.isCompleted(leaveTransform(obj))) {
                return false;
            }
            return true;
        }

        public boolean hasError() {
            Object obj = this.tail.value;
            if (obj == null || !NotificationLite.isError(leaveTransform(obj))) {
                return false;
            }
            return true;
        }

        public Object leaveTransform(Object obj) {
            return obj;
        }

        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        public final void removeFirst() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        public final void removeSome(int i) {
            Node node = (Node) get();
            while (i > 0) {
                node = (Node) node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
            r0 = (rx.internal.operators.OperatorReplay.Node) r12.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
            if (r0 != null) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
            r0 = getInitialHead();
            r12.index = r0;
            r12.addTotalRequested(r0.index);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
            r1 = r12.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            if (r1 != null) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            r2 = r12.get();
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
            if (r6 == r2) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
            r8 = (rx.internal.operators.OperatorReplay.Node) r0.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0047, code lost:
            if (r8 == null) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0049, code lost:
            r0 = leaveTransform(r8.value);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
            if (rx.internal.operators.NotificationLite.accept(r1, r0) == false) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
            r12.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0058, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0059, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005b, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
            if (r12.isUnsubscribed() == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0065, code lost:
            r0 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0067, code lost:
            r12.index = null;
            rx.exceptions.Exceptions.throwIfFatal(r2);
            r12.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0073, code lost:
            if (rx.internal.operators.NotificationLite.isError(r0) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x007b, code lost:
            r1.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r2, rx.internal.operators.NotificationLite.getValue(r0)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0089, code lost:
            if (r6 == 0) goto L_0x0099;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008b, code lost:
            r12.index = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0094, code lost:
            if (r2 == androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x0099;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0096, code lost:
            r12.produced(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0099, code lost:
            monitor-enter(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009d, code lost:
            if (r12.missed != false) goto L_0x00a5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009f, code lost:
            r12.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a1, code lost:
            monitor-exit(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a3, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a5, code lost:
            r12.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a7, code lost:
            monitor-exit(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ab, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void replay(rx.internal.operators.OperatorReplay.InnerProducer<T> r12) {
            /*
                r11 = this;
                monitor-enter(r12)
                boolean r0 = r12.emitting     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r12.missed = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r12)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r0 = move-exception
                goto L_0x00ac
            L_0x000d:
                r12.emitting = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r12)     // Catch:{ all -> 0x000a }
            L_0x0010:
                boolean r0 = r12.isUnsubscribed()
                if (r0 == 0) goto L_0x0017
                return
            L_0x0017:
                java.lang.Object r0 = r12.index()
                rx.internal.operators.OperatorReplay$Node r0 = (rx.internal.operators.OperatorReplay.Node) r0
                if (r0 != 0) goto L_0x002a
                rx.internal.operators.OperatorReplay$Node r0 = r11.getInitialHead()
                r12.index = r0
                long r1 = r0.index
                r12.addTotalRequested(r1)
            L_0x002a:
                boolean r1 = r12.isUnsubscribed()
                if (r1 == 0) goto L_0x0031
                return
            L_0x0031:
                rx.Subscriber<? super T> r1 = r12.child
                if (r1 != 0) goto L_0x0036
                return
            L_0x0036:
                long r2 = r12.get()
                r4 = 0
                r6 = r4
            L_0x003d:
                int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r8 == 0) goto L_0x0087
                java.lang.Object r8 = r0.get()
                rx.internal.operators.OperatorReplay$Node r8 = (rx.internal.operators.OperatorReplay.Node) r8
                if (r8 == 0) goto L_0x0087
                java.lang.Object r0 = r8.value
                java.lang.Object r0 = r11.leaveTransform(r0)
                r9 = 0
                boolean r10 = rx.internal.operators.NotificationLite.accept(r1, r0)     // Catch:{ all -> 0x0059 }
                if (r10 == 0) goto L_0x005b
                r12.index = r9     // Catch:{ all -> 0x0059 }
                return
            L_0x0059:
                r2 = move-exception
                goto L_0x0067
            L_0x005b:
                r9 = 1
                long r6 = r6 + r9
                boolean r0 = r12.isUnsubscribed()
                if (r0 == 0) goto L_0x0065
                return
            L_0x0065:
                r0 = r8
                goto L_0x003d
            L_0x0067:
                r12.index = r9
                rx.exceptions.Exceptions.throwIfFatal(r2)
                r12.unsubscribe()
                boolean r12 = rx.internal.operators.NotificationLite.isError(r0)
                if (r12 != 0) goto L_0x0086
                boolean r12 = rx.internal.operators.NotificationLite.isCompleted(r0)
                if (r12 != 0) goto L_0x0086
                java.lang.Object r12 = rx.internal.operators.NotificationLite.getValue(r0)
                java.lang.Throwable r12 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r2, r12)
                r1.onError(r12)
            L_0x0086:
                return
            L_0x0087:
                int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r1 == 0) goto L_0x0099
                r12.index = r0
                r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 == 0) goto L_0x0099
                r12.produced(r6)
            L_0x0099:
                monitor-enter(r12)
                boolean r0 = r12.missed     // Catch:{ all -> 0x00a3 }
                r1 = 0
                if (r0 != 0) goto L_0x00a5
                r12.emitting = r1     // Catch:{ all -> 0x00a3 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a3 }
                return
            L_0x00a3:
                r0 = move-exception
                goto L_0x00aa
            L_0x00a5:
                r12.missed = r1     // Catch:{ all -> 0x00a3 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a3 }
                goto L_0x0010
            L_0x00aa:
                monitor-exit(r12)     // Catch:{ all -> 0x00a3 }
                throw r0
            L_0x00ac:
                monitor-exit(r12)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.BoundedReplayBuffer.replay(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }

        public final void setFirst(Node node) {
            set(node);
        }

        public void truncate() {
        }

        public void truncateFinal() {
        }
    }

    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        public void addTotalRequested(long j) {
            long j2;
            long j3;
            do {
                j2 = this.totalRequested.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                }
            } while (!this.totalRequested.compareAndSet(j2, j3));
        }

        public <U> U index() {
            return this.index;
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
                    if (j2 == UNSUBSCRIBED) {
                        return UNSUBSCRIBED;
                    }
                    j3 = j2 - j;
                    if (j3 < 0) {
                        StringBuilder sb = new StringBuilder("More produced (");
                        sb.append(j);
                        sb.append(") than requested (");
                        throw new IllegalStateException(ba.p(sb, j2, ")"));
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
                        if (j2 < 0 || i != 0) {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                addTotalRequested(j);
                this.parent.manageRequests(this);
                this.parent.buffer.replay(this);
            }
        }

        public void unsubscribe() {
            if (get() != UNSUBSCRIBED && getAndSet(UNSUBSCRIBED) != UNSUBSCRIBED) {
                this.parent.remove(this);
                this.parent.manageRequests(this);
                this.child = null;
            }
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    public static final class ReplaySubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final ReplayBuffer<T> buffer;
        boolean coordinateAll;
        List<InnerProducer<T>> coordinationQueue;
        boolean done;
        boolean emitting;
        long maxChildRequested;
        long maxUpstreamRequested;
        boolean missed;
        volatile Producer producer;
        final OpenHashSet<InnerProducer<T>> producers = new OpenHashSet<>();
        InnerProducer<T>[] producersCache = EMPTY;
        long producersCacheVersion;
        volatile long producersVersion;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        volatile boolean terminated;

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            request(0);
        }

        public boolean add(InnerProducer<T> innerProducer) {
            innerProducer.getClass();
            if (this.terminated) {
                return false;
            }
            synchronized (this.producers) {
                try {
                    if (this.terminated) {
                        return false;
                    }
                    this.producers.add(innerProducer);
                    this.producersVersion++;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public InnerProducer<T>[] copyProducers() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.producers) {
                Object[] values = this.producers.values();
                int length = values.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(values, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        public void init() {
            add(Subscriptions.create(new Action0() {
                public void call() {
                    if (!ReplaySubscriber.this.terminated) {
                        synchronized (ReplaySubscriber.this.producers) {
                            try {
                                if (!ReplaySubscriber.this.terminated) {
                                    ReplaySubscriber.this.producers.terminate();
                                    ReplaySubscriber.this.producersVersion++;
                                    ReplaySubscriber.this.terminated = true;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
            }));
        }

        public void makeRequest(long j, long j2) {
            long j3 = this.maxUpstreamRequested;
            Producer producer2 = this.producer;
            long j4 = j - j2;
            if (j4 != 0) {
                this.maxChildRequested = j;
                if (producer2 == null) {
                    long j5 = j3 + j4;
                    if (j5 < 0) {
                        j5 = LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                    this.maxUpstreamRequested = j5;
                } else if (j3 != 0) {
                    this.maxUpstreamRequested = 0;
                    producer2.request(j3 + j4);
                } else {
                    producer2.request(j4);
                }
            } else if (j3 != 0 && producer2 != null) {
                this.maxUpstreamRequested = 0;
                producer2.request(j3);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
            r0 = r9.maxChildRequested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
            if (r10 == null) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
            r3 = java.lang.Math.max(r0, r10.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
            r10 = copyProducers();
            r3 = r10.length;
            r4 = r0;
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            if (r6 >= r3) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
            r7 = r10[r6];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
            if (r7 == null) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
            r4 = java.lang.Math.max(r4, r7.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
            makeRequest(r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
            if (isUnsubscribed() == false) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0060, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            if (r9.missed != false) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0065, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0067, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0069, code lost:
            r10 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x006b, code lost:
            r9.missed = false;
            r10 = r9.coordinationQueue;
            r9.coordinationQueue = null;
            r0 = r9.coordinateAll;
            r9.coordinateAll = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0076, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0077, code lost:
            r3 = r9.maxChildRequested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0079, code lost:
            if (r10 == null) goto L_0x0097;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x007b, code lost:
            r10 = r10.iterator();
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0084, code lost:
            if (r10.hasNext() == false) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0086, code lost:
            r5 = java.lang.Math.max(r5, r10.next().totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0097, code lost:
            r5 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0098, code lost:
            if (r0 == false) goto L_0x00b3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009a, code lost:
            r10 = copyProducers();
            r0 = r10.length;
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a0, code lost:
            if (r1 >= r0) goto L_0x00b3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a2, code lost:
            r7 = r10[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a4, code lost:
            if (r7 == null) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a6, code lost:
            r5 = java.lang.Math.max(r5, r7.totalRequested.get());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b0, code lost:
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b3, code lost:
            makeRequest(r5, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b8, code lost:
            throw r10;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void manageRequests(rx.internal.operators.OperatorReplay.InnerProducer<T> r10) {
            /*
                r9 = this;
                boolean r0 = r9.isUnsubscribed()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                monitor-enter(r9)
                boolean r0 = r9.emitting     // Catch:{ all -> 0x001b }
                r1 = 1
                if (r0 == 0) goto L_0x0028
                if (r10 == 0) goto L_0x0022
                java.util.List<rx.internal.operators.OperatorReplay$InnerProducer<T>> r0 = r9.coordinationQueue     // Catch:{ all -> 0x001b }
                if (r0 != 0) goto L_0x001e
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x001b }
                r0.<init>()     // Catch:{ all -> 0x001b }
                r9.coordinationQueue = r0     // Catch:{ all -> 0x001b }
                goto L_0x001e
            L_0x001b:
                r10 = move-exception
                goto L_0x00b9
            L_0x001e:
                r0.add(r10)     // Catch:{ all -> 0x001b }
                goto L_0x0024
            L_0x0022:
                r9.coordinateAll = r1     // Catch:{ all -> 0x001b }
            L_0x0024:
                r9.missed = r1     // Catch:{ all -> 0x001b }
                monitor-exit(r9)     // Catch:{ all -> 0x001b }
                return
            L_0x0028:
                r9.emitting = r1     // Catch:{ all -> 0x001b }
                monitor-exit(r9)     // Catch:{ all -> 0x001b }
                long r0 = r9.maxChildRequested
                r2 = 0
                if (r10 == 0) goto L_0x003b
                java.util.concurrent.atomic.AtomicLong r10 = r10.totalRequested
                long r3 = r10.get()
                long r3 = java.lang.Math.max(r0, r3)
                goto L_0x0056
            L_0x003b:
                rx.internal.operators.OperatorReplay$InnerProducer[] r10 = r9.copyProducers()
                int r3 = r10.length
                r4 = r0
                r6 = 0
            L_0x0042:
                if (r6 >= r3) goto L_0x0055
                r7 = r10[r6]
                if (r7 == 0) goto L_0x0052
                java.util.concurrent.atomic.AtomicLong r7 = r7.totalRequested
                long r7 = r7.get()
                long r4 = java.lang.Math.max(r4, r7)
            L_0x0052:
                int r6 = r6 + 1
                goto L_0x0042
            L_0x0055:
                r3 = r4
            L_0x0056:
                r9.makeRequest(r3, r0)
            L_0x0059:
                boolean r10 = r9.isUnsubscribed()
                if (r10 == 0) goto L_0x0060
                return
            L_0x0060:
                monitor-enter(r9)
                boolean r10 = r9.missed     // Catch:{ all -> 0x0069 }
                if (r10 != 0) goto L_0x006b
                r9.emitting = r2     // Catch:{ all -> 0x0069 }
                monitor-exit(r9)     // Catch:{ all -> 0x0069 }
                return
            L_0x0069:
                r10 = move-exception
                goto L_0x00b7
            L_0x006b:
                r9.missed = r2     // Catch:{ all -> 0x0069 }
                java.util.List<rx.internal.operators.OperatorReplay$InnerProducer<T>> r10 = r9.coordinationQueue     // Catch:{ all -> 0x0069 }
                r0 = 0
                r9.coordinationQueue = r0     // Catch:{ all -> 0x0069 }
                boolean r0 = r9.coordinateAll     // Catch:{ all -> 0x0069 }
                r9.coordinateAll = r2     // Catch:{ all -> 0x0069 }
                monitor-exit(r9)     // Catch:{ all -> 0x0069 }
                long r3 = r9.maxChildRequested
                if (r10 == 0) goto L_0x0097
                java.util.Iterator r10 = r10.iterator()
                r5 = r3
            L_0x0080:
                boolean r1 = r10.hasNext()
                if (r1 == 0) goto L_0x0098
                java.lang.Object r1 = r10.next()
                rx.internal.operators.OperatorReplay$InnerProducer r1 = (rx.internal.operators.OperatorReplay.InnerProducer) r1
                java.util.concurrent.atomic.AtomicLong r1 = r1.totalRequested
                long r7 = r1.get()
                long r5 = java.lang.Math.max(r5, r7)
                goto L_0x0080
            L_0x0097:
                r5 = r3
            L_0x0098:
                if (r0 == 0) goto L_0x00b3
                rx.internal.operators.OperatorReplay$InnerProducer[] r10 = r9.copyProducers()
                int r0 = r10.length
                r1 = 0
            L_0x00a0:
                if (r1 >= r0) goto L_0x00b3
                r7 = r10[r1]
                if (r7 == 0) goto L_0x00b0
                java.util.concurrent.atomic.AtomicLong r7 = r7.totalRequested
                long r7 = r7.get()
                long r5 = java.lang.Math.max(r5, r7)
            L_0x00b0:
                int r1 = r1 + 1
                goto L_0x00a0
            L_0x00b3:
                r9.makeRequest(r5, r3)
                goto L_0x0059
            L_0x00b7:
                monitor-exit(r9)     // Catch:{ all -> 0x0069 }
                throw r10
            L_0x00b9:
                monitor-exit(r9)     // Catch:{ all -> 0x001b }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.ReplaySubscriber.manageRequests(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.complete();
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.error(th);
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        public void remove(InnerProducer<T> innerProducer) {
            if (!this.terminated) {
                synchronized (this.producers) {
                    try {
                        if (!this.terminated) {
                            this.producers.remove(innerProducer);
                            if (this.producers.isEmpty()) {
                                this.producersCache = EMPTY;
                            }
                            this.producersVersion++;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public void replay() {
            InnerProducer<T>[] innerProducerArr = this.producersCache;
            if (this.producersCacheVersion != this.producersVersion) {
                synchronized (this.producers) {
                    try {
                        innerProducerArr = this.producersCache;
                        Object[] values = this.producers.values();
                        int length = values.length;
                        if (innerProducerArr.length != length) {
                            innerProducerArr = new InnerProducer[length];
                            this.producersCache = innerProducerArr;
                        }
                        System.arraycopy(values, 0, innerProducerArr, 0, length);
                        this.producersCacheVersion = this.producersVersion;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            ReplayBuffer<T> replayBuffer = this.buffer;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    replayBuffer.replay(innerProducer);
                }
            }
        }

        public void setProducer(Producer producer2) {
            if (this.producer == null) {
                this.producer = producer2;
                manageRequests((InnerProducer) null);
                replay();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final Scheduler scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, Scheduler scheduler2) {
            this.scheduler = scheduler2;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        public Object enterTransform(Object obj) {
            return new Timestamped(this.scheduler.now(), obj);
        }

        public Node getInitialHead() {
            Node node;
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 == null) {
                    break;
                }
                Object obj2 = node2.value;
                Object leaveTransform = leaveTransform(obj2);
                if (NotificationLite.isCompleted(leaveTransform) || NotificationLite.isError(leaveTransform) || ((Timestamped) obj2).getTimestampMillis() > now) {
                    break;
                }
                obj = node2.get();
            }
            return node;
        }

        public Object leaveTransform(Object obj) {
            return ((Timestamped) obj).getValue();
        }

        public void truncate() {
            Node node;
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i2 = this.size;
                    if (i2 <= this.limit) {
                        if (((Timestamped) node2.value).getTimestampMillis() > now) {
                            break;
                        }
                        i++;
                        this.size--;
                        node3 = (Node) node2.get();
                    } else {
                        i++;
                        this.size = i2 - 1;
                        node3 = (Node) node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void truncateFinal() {
            /*
                r10 = this;
                rx.Scheduler r0 = r10.scheduler
                long r0 = r0.now()
                long r2 = r10.maxAgeInMillis
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                rx.internal.operators.OperatorReplay$Node r2 = (rx.internal.operators.OperatorReplay.Node) r2
                java.lang.Object r3 = r2.get()
                rx.internal.operators.OperatorReplay$Node r3 = (rx.internal.operators.OperatorReplay.Node) r3
                r4 = 0
            L_0x0016:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L_0x003a
                int r5 = r10.size
                r6 = 1
                if (r5 <= r6) goto L_0x003a
                java.lang.Object r5 = r2.value
                rx.schedulers.Timestamped r5 = (rx.schedulers.Timestamped) r5
                long r7 = r5.getTimestampMillis()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003a
                int r4 = r4 + 1
                int r3 = r10.size
                int r3 = r3 - r6
                r10.size = r3
                java.lang.Object r3 = r2.get()
                rx.internal.operators.OperatorReplay$Node r3 = (rx.internal.operators.OperatorReplay.Node) r3
                goto L_0x0016
            L_0x003a:
                if (r4 == 0) goto L_0x003f
                r10.setFirst(r3)
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.SizeAndTimeBoundReplayBuffer.truncateFinal():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        public void complete() {
            add(NotificationLite.completed());
            this.size++;
        }

        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            if (r13.isUnsubscribed() == false) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
            r0 = r12.size;
            r1 = (java.lang.Integer) r13.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
            if (r1 == null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
            r1 = r1.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            r3 = r13.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            if (r3 != null) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
            r4 = r13.get();
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            if (r8 == r4) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
            if (r1 >= r0) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
            r10 = get(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
            if (rx.internal.operators.NotificationLite.accept(r3, r10) == false) goto L_0x0045;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
            if (r13.isUnsubscribed() == false) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x004c, code lost:
            r1 = r1 + 1;
            r8 = r8 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0052, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0053, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r0);
            r13.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
            if (rx.internal.operators.NotificationLite.isError(r10) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0065, code lost:
            r3.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r0, rx.internal.operators.NotificationLite.getValue(r10)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0073, code lost:
            if (r8 == 0) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0075, code lost:
            r13.index = java.lang.Integer.valueOf(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0082, code lost:
            if (r4 == androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0084, code lost:
            r13.produced(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0087, code lost:
            monitor-enter(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x008a, code lost:
            if (r13.missed != false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008c, code lost:
            r13.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008e, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0090, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0092, code lost:
            r13.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0094, code lost:
            monitor-exit(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0098, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay(rx.internal.operators.OperatorReplay.InnerProducer<T> r13) {
            /*
                r12 = this;
                monitor-enter(r13)
                boolean r0 = r13.emitting     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r13.missed = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r13)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r0 = move-exception
                goto L_0x0099
            L_0x000d:
                r13.emitting = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r13)     // Catch:{ all -> 0x000a }
            L_0x0010:
                boolean r0 = r13.isUnsubscribed()
                if (r0 == 0) goto L_0x0017
                return
            L_0x0017:
                int r0 = r12.size
                java.lang.Object r1 = r13.index()
                java.lang.Integer r1 = (java.lang.Integer) r1
                r2 = 0
                if (r1 == 0) goto L_0x0027
                int r1 = r1.intValue()
                goto L_0x0028
            L_0x0027:
                r1 = 0
            L_0x0028:
                rx.Subscriber<? super T> r3 = r13.child
                if (r3 != 0) goto L_0x002d
                return
            L_0x002d:
                long r4 = r13.get()
                r6 = 0
                r8 = r6
            L_0x0034:
                int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r10 == 0) goto L_0x0071
                if (r1 >= r0) goto L_0x0071
                java.lang.Object r10 = r12.get(r1)
                boolean r10 = rx.internal.operators.NotificationLite.accept(r3, r10)     // Catch:{ all -> 0x0052 }
                if (r10 == 0) goto L_0x0045
                return
            L_0x0045:
                boolean r10 = r13.isUnsubscribed()
                if (r10 == 0) goto L_0x004c
                return
            L_0x004c:
                int r1 = r1 + 1
                r10 = 1
                long r8 = r8 + r10
                goto L_0x0034
            L_0x0052:
                r0 = move-exception
                rx.exceptions.Exceptions.throwIfFatal(r0)
                r13.unsubscribe()
                boolean r13 = rx.internal.operators.NotificationLite.isError(r10)
                if (r13 != 0) goto L_0x0070
                boolean r13 = rx.internal.operators.NotificationLite.isCompleted(r10)
                if (r13 != 0) goto L_0x0070
                java.lang.Object r13 = rx.internal.operators.NotificationLite.getValue(r10)
                java.lang.Throwable r13 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r0, r13)
                r3.onError(r13)
            L_0x0070:
                return
            L_0x0071:
                int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x0087
                java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                r13.index = r0
                r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x0087
                r13.produced(r8)
            L_0x0087:
                monitor-enter(r13)
                boolean r0 = r13.missed     // Catch:{ all -> 0x0090 }
                if (r0 != 0) goto L_0x0092
                r13.emitting = r2     // Catch:{ all -> 0x0090 }
                monitor-exit(r13)     // Catch:{ all -> 0x0090 }
                return
            L_0x0090:
                r0 = move-exception
                goto L_0x0097
            L_0x0092:
                r13.missed = r2     // Catch:{ all -> 0x0090 }
                monitor-exit(r13)     // Catch:{ all -> 0x0090 }
                goto L_0x0010
            L_0x0097:
                monitor-exit(r13)     // Catch:{ all -> 0x0090 }
                throw r0
            L_0x0099:
                monitor-exit(r13)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorReplay.UnboundedReplayBuffer.replay(rx.internal.operators.OperatorReplay$InnerProducer):void");
        }
    }

    private OperatorReplay(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<ReplaySubscriber<T>> atomicReference, Func0<? extends ReplayBuffer<T>> func0) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
        this.bufferFactory = func0;
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable) {
        return create(observable, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T, U, R> Observable<R> multicastSelector(final Func0<? extends ConnectableObservable<U>> func0, final Func1<? super Observable<U>, ? extends Observable<R>> func1) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<R>() {
            public void call(final Subscriber<? super R> subscriber) {
                try {
                    ConnectableObservable connectableObservable = (ConnectableObservable) func0.call();
                    ((Observable) func1.call(connectableObservable)).subscribe(subscriber);
                    connectableObservable.connect(new Action1<Subscription>() {
                        public void call(Subscription subscription) {
                            subscriber.add(subscription);
                        }
                    });
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) subscriber);
                }
            }
        });
    }

    public static <T> ConnectableObservable<T> observeOn(final ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        final Observable<T> observeOn = connectableObservable.observeOn(scheduler);
        return new ConnectableObservable<T>(new Observable.OnSubscribe<T>() {
            public void call(final Subscriber<? super T> subscriber) {
                observeOn.unsafeSubscribe(new Subscriber<T>(subscriber) {
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    public void onNext(T t) {
                        subscriber.onNext(t);
                    }
                });
            }
        }) {
            public void connect(Action1<? super Subscription> action1) {
                connectableObservable.connect(action1);
            }
        };
    }

    public void connect(Action1<? super Subscription> action1) {
        ReplaySubscriber<T> replaySubscriber;
        loop0:
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isUnsubscribed()) {
                break;
            }
            ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>((ReplayBuffer) this.bufferFactory.call());
            replaySubscriber2.init();
            AtomicReference<ReplaySubscriber<T>> atomicReference = this.current;
            while (true) {
                if (atomicReference.compareAndSet(replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break loop0;
                } else if (atomicReference.get() != replaySubscriber) {
                }
            }
        }
        boolean z = false;
        if (!replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true)) {
            z = true;
        }
        action1.call(replaySubscriber);
        if (z) {
            this.source.unsafeSubscribe(replaySubscriber);
        }
    }

    public boolean isUnsubscribed() {
        ReplaySubscriber replaySubscriber = this.current.get();
        if (replaySubscriber == null || replaySubscriber.isUnsubscribed()) {
            return true;
        }
        return false;
    }

    public void unsubscribe() {
        this.current.lazySet((Object) null);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, final int i) {
        if (i == Integer.MAX_VALUE) {
            return create(observable);
        }
        return create(observable, new Func0<ReplayBuffer<T>>() {
            public ReplayBuffer<T> call() {
                return new SizeBoundReplayBuffer(i);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(observable, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j, TimeUnit timeUnit, final Scheduler scheduler, final int i) {
        final long millis = timeUnit.toMillis(j);
        return create(observable, new Func0<ReplayBuffer<T>>() {
            public ReplayBuffer<T> call() {
                return new SizeAndTimeBoundReplayBuffer(i, millis, scheduler);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, final Func0<? extends ReplayBuffer<T>> func0) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new Observable.OnSubscribe<T>() {
            public void call(Subscriber<? super T> subscriber) {
                ReplaySubscriber replaySubscriber;
                loop0:
                while (true) {
                    replaySubscriber = (ReplaySubscriber) atomicReference.get();
                    if (replaySubscriber != null) {
                        break;
                    }
                    ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) func0.call());
                    replaySubscriber2.init();
                    AtomicReference atomicReference = atomicReference;
                    while (true) {
                        if (atomicReference.compareAndSet(replaySubscriber, replaySubscriber2)) {
                            replaySubscriber = replaySubscriber2;
                            break loop0;
                        } else if (atomicReference.get() != replaySubscriber) {
                        }
                    }
                }
                InnerProducer innerProducer = new InnerProducer(replaySubscriber, subscriber);
                replaySubscriber.add(innerProducer);
                subscriber.add(innerProducer);
                replaySubscriber.buffer.replay(innerProducer);
                subscriber.setProducer(innerProducer);
            }
        }, observable, atomicReference, func0);
    }
}
