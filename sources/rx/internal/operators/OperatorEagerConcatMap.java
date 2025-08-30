package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

public final class OperatorEagerConcatMap<T, R> implements Observable.Operator<R, T> {
    final int bufferSize;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    private final int maxConcurrent;

    public static final class EagerInnerSubscriber<T> extends Subscriber<T> {
        volatile boolean done;
        Throwable error;
        final EagerOuterSubscriber<?, T> parent;
        final Queue<Object> queue;

        public EagerInnerSubscriber(EagerOuterSubscriber<?, T> eagerOuterSubscriber, int i) {
            Queue<Object> queue2;
            this.parent = eagerOuterSubscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscArrayQueue<>(i);
            } else {
                queue2 = new SpscAtomicArrayQueue<>(i);
            }
            this.queue = queue2;
            request((long) i);
        }

        public void onCompleted() {
            this.done = true;
            this.parent.drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        public void onNext(T t) {
            this.queue.offer(NotificationLite.next(t));
            this.parent.drain();
        }

        public void requestMore(long j) {
            request(j);
        }
    }

    public static final class EagerOuterProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = -657299606803478389L;
        final EagerOuterSubscriber<?, ?> parent;

        public EagerOuterProducer(EagerOuterSubscriber<?, ?> eagerOuterSubscriber) {
            this.parent = eagerOuterSubscriber;
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalStateException(e.j(j, "n >= 0 required but it was "));
            } else if (i > 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                this.parent.drain();
            }
        }
    }

    public static final class EagerOuterSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final Func1<? super T, ? extends Observable<? extends R>> mapper;
        private EagerOuterProducer sharedProducer;
        final Queue<EagerInnerSubscriber<R>> subscribers = new LinkedList();
        final AtomicInteger wip = new AtomicInteger();

        public EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2, Subscriber<? super R> subscriber) {
            long j;
            this.mapper = func1;
            this.bufferSize = i;
            this.actual = subscriber;
            if (i2 == Integer.MAX_VALUE) {
                j = LocationRequestCompat.PASSIVE_INTERVAL;
            } else {
                j = (long) i2;
            }
            request(j);
        }

        public void cleanup() {
            ArrayList arrayList;
            synchronized (this.subscribers) {
                arrayList = new ArrayList(this.subscribers);
                this.subscribers.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Subscription) it.next()).unsubscribe();
            }
        }

        public void drain() {
            EagerInnerSubscriber peek;
            boolean z;
            int i;
            boolean z2;
            if (this.wip.getAndIncrement() == 0) {
                EagerOuterProducer eagerOuterProducer = this.sharedProducer;
                Subscriber<? super R> subscriber = this.actual;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z3 = this.done;
                    synchronized (this.subscribers) {
                        peek = this.subscribers.peek();
                    }
                    boolean z4 = false;
                    if (peek == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z3) {
                        Throwable th = this.error;
                        if (th != null) {
                            cleanup();
                            subscriber.onError(th);
                            return;
                        } else if (z) {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (!z) {
                        long j = eagerOuterProducer.get();
                        Queue<Object> queue = peek.queue;
                        long j2 = 0;
                        while (true) {
                            boolean z5 = peek.done;
                            Object peek2 = queue.peek();
                            i = i2;
                            if (peek2 == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z5) {
                                Throwable th2 = peek.error;
                                if (th2 == null) {
                                    if (z2) {
                                        synchronized (this.subscribers) {
                                            this.subscribers.poll();
                                        }
                                        peek.unsubscribe();
                                        request(1);
                                        z4 = true;
                                        break;
                                    }
                                } else {
                                    cleanup();
                                    subscriber.onError(th2);
                                    return;
                                }
                            }
                            if (z2 || j == j2) {
                                break;
                            }
                            queue.poll();
                            try {
                                subscriber.onNext(NotificationLite.getValue(peek2));
                                j2++;
                                i2 = i;
                            } catch (Throwable th3) {
                                Exceptions.throwOrReport(th3, (Observer<?>) subscriber, peek2);
                                return;
                            }
                        }
                        if (j2 != 0) {
                            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                                BackpressureUtils.produced(eagerOuterProducer, j2);
                            }
                            if (!z4) {
                                peek.requestMore(j2);
                            }
                        }
                        if (z4) {
                            i2 = i;
                        }
                    } else {
                        i = i2;
                    }
                    i2 = this.wip.addAndGet(-i);
                    if (i2 == 0) {
                        return;
                    }
                }
                cleanup();
            }
        }

        public void init() {
            this.sharedProducer = new EagerOuterProducer(this);
            add(Subscriptions.create(new Action0() {
                public void call() {
                    EagerOuterSubscriber.this.cancelled = true;
                    if (EagerOuterSubscriber.this.wip.getAndIncrement() == 0) {
                        EagerOuterSubscriber.this.cleanup();
                    }
                }
            }));
            this.actual.add(this);
            this.actual.setProducer(this.sharedProducer);
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if (r3.cancelled == false) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            r0.unsafeSubscribe(r4);
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r4) {
            /*
                r3 = this;
                rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> r0 = r3.mapper     // Catch:{ all -> 0x0033 }
                java.lang.Object r0 = r0.call(r4)     // Catch:{ all -> 0x0033 }
                rx.Observable r0 = (rx.Observable) r0     // Catch:{ all -> 0x0033 }
                boolean r4 = r3.cancelled
                if (r4 == 0) goto L_0x000d
                return
            L_0x000d:
                rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber r4 = new rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber
                int r1 = r3.bufferSize
                r4.<init>(r3, r1)
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r1 = r3.subscribers
                monitor-enter(r1)
                boolean r2 = r3.cancelled     // Catch:{ all -> 0x001d }
                if (r2 == 0) goto L_0x001f
                monitor-exit(r1)     // Catch:{ all -> 0x001d }
                return
            L_0x001d:
                r4 = move-exception
                goto L_0x0031
            L_0x001f:
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r2 = r3.subscribers     // Catch:{ all -> 0x001d }
                r2.add(r4)     // Catch:{ all -> 0x001d }
                monitor-exit(r1)     // Catch:{ all -> 0x001d }
                boolean r1 = r3.cancelled
                if (r1 == 0) goto L_0x002a
                return
            L_0x002a:
                r0.unsafeSubscribe(r4)
                r3.drain()
                return
            L_0x0031:
                monitor-exit(r1)     // Catch:{ all -> 0x001d }
                throw r4
            L_0x0033:
                r0 = move-exception
                rx.Subscriber<? super R> r1 = r3.actual
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r0, (rx.Observer<?>) r1, (java.lang.Object) r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.onNext(java.lang.Object):void");
        }
    }

    public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        this.mapper = func1;
        this.bufferSize = i;
        this.maxConcurrent = i2;
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        EagerOuterSubscriber eagerOuterSubscriber = new EagerOuterSubscriber(this.mapper, this.bufferSize, this.maxConcurrent, subscriber);
        eagerOuterSubscriber.init();
        return eagerOuterSubscriber;
    }
}
