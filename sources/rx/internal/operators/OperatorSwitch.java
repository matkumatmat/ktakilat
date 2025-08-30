package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayError;

    public static final class Holder {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);
    }

    public static final class HolderDelayError {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);
    }

    public static final class InnerSubscriber<T> extends Subscriber<T> {
        /* access modifiers changed from: private */
        public final long id;
        private final SwitchSubscriber<T> parent;

        public InnerSubscriber(long j, SwitchSubscriber<T> switchSubscriber) {
            this.id = j;
            this.parent = switchSubscriber;
        }

        public void onCompleted() {
            this.parent.complete(this.id);
        }

        public void onError(Throwable th) {
            this.parent.error(th, this.id);
        }

        public void onNext(T t) {
            this.parent.emit(t, this);
        }

        public void setProducer(Producer producer) {
            this.parent.innerProducer(producer, this.id);
        }
    }

    public static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        final Subscriber<? super T> child;
        final boolean delayError;
        boolean emitting;
        Throwable error;
        final AtomicLong index;
        boolean innerActive;
        volatile boolean mainDone;
        boolean missed;
        Producer producer;
        final SpscLinkedArrayQueue<Object> queue;
        long requested;
        final SerialSubscription serial = new SerialSubscription();

        public SwitchSubscriber(Subscriber<? super T> subscriber, boolean z) {
            this.child = subscriber;
            this.delayError = z;
            this.index = new AtomicLong();
            this.queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);
        }

        public boolean checkTerminated(boolean z, boolean z2, Throwable th, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z3) {
            if (this.delayError) {
                if (!z || z2 || !z3) {
                    return false;
                }
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            } else if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            } else if (!z || z2 || !z3) {
                return false;
            } else {
                subscriber.onCompleted();
                return true;
            }
        }

        public void childRequested(long j) {
            Producer producer2;
            synchronized (this) {
                producer2 = this.producer;
                this.requested = BackpressureUtils.addCap(this.requested, j);
            }
            if (producer2 != null) {
                producer2.request(j);
            }
            drain();
        }

        public void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        public void complete(long j) {
            synchronized (this) {
                try {
                    if (this.index.get() == j) {
                        this.innerActive = false;
                        this.producer = null;
                        drain();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            r9 = r8.queue;
            r10 = r8.index;
            r11 = r8.child;
            r12 = r1;
            r14 = r3;
            r15 = r8.mainDone;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            r16 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            r18 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
            if (r18 == 0) goto L_0x0077;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
            r19 = r9.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
            if (checkTerminated(r15, r0, r14, r9, r11, r19) == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
            if (r19 == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
            r2 = rx.internal.operators.NotificationLite.getValue(r9.poll());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
            if (r10.get() != rx.internal.operators.OperatorSwitch.InnerSubscriber.access$000((rx.internal.operators.OperatorSwitch.InnerSubscriber) r9.poll())) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
            r11.onNext(r2);
            r16 = r16 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
            if (r18 != 0) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x0080;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x007f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
            if (checkTerminated(r8.mainDone, r0, r14, r9, r11, r9.isEmpty()) == false) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0092, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0093, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r0 = r8.requested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x009d, code lost:
            if (r0 == androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x00a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x009f, code lost:
            r0 = r0 - r16;
            r8.requested = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a3, code lost:
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00aa, code lost:
            if (r8.missed != false) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ac, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ae, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00af, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b0, code lost:
            r8.missed = false;
            r15 = r8.mainDone;
            r0 = r8.innerActive;
            r14 = r8.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b8, code lost:
            if (r14 == null) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ba, code lost:
            r1 = TERMINAL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bc, code lost:
            if (r14 == r1) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c0, code lost:
            if (r8.delayError != false) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c2, code lost:
            r8.error = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c4, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c8, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r20 = this;
                r8 = r20
                monitor-enter(r20)
                boolean r0 = r8.emitting     // Catch:{ all -> 0x000c }
                r1 = 1
                if (r0 == 0) goto L_0x000f
                r8.missed = r1     // Catch:{ all -> 0x000c }
                monitor-exit(r20)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r0 = move-exception
                goto L_0x00c9
            L_0x000f:
                r8.emitting = r1     // Catch:{ all -> 0x000c }
                boolean r0 = r8.innerActive     // Catch:{ all -> 0x000c }
                long r1 = r8.requested     // Catch:{ all -> 0x000c }
                java.lang.Throwable r3 = r8.error     // Catch:{ all -> 0x000c }
                if (r3 == 0) goto L_0x0023
                java.lang.Throwable r4 = TERMINAL_ERROR     // Catch:{ all -> 0x000c }
                if (r3 == r4) goto L_0x0023
                boolean r5 = r8.delayError     // Catch:{ all -> 0x000c }
                if (r5 != 0) goto L_0x0023
                r8.error = r4     // Catch:{ all -> 0x000c }
            L_0x0023:
                monitor-exit(r20)     // Catch:{ all -> 0x000c }
                rx.internal.util.atomic.SpscLinkedArrayQueue<java.lang.Object> r9 = r8.queue
                java.util.concurrent.atomic.AtomicLong r10 = r8.index
                rx.Subscriber<? super T> r11 = r8.child
                boolean r4 = r8.mainDone
                r12 = r1
                r14 = r3
                r15 = r4
            L_0x002f:
                r1 = 0
                r16 = r1
            L_0x0033:
                int r18 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
                if (r18 == 0) goto L_0x0077
                boolean r1 = r11.isUnsubscribed()
                if (r1 == 0) goto L_0x003e
                return
            L_0x003e:
                boolean r19 = r9.isEmpty()
                r1 = r20
                r2 = r15
                r3 = r0
                r4 = r14
                r5 = r9
                r6 = r11
                r7 = r19
                boolean r1 = r1.checkTerminated(r2, r3, r4, r5, r6, r7)
                if (r1 == 0) goto L_0x0052
                return
            L_0x0052:
                if (r19 == 0) goto L_0x0055
                goto L_0x0077
            L_0x0055:
                java.lang.Object r1 = r9.poll()
                rx.internal.operators.OperatorSwitch$InnerSubscriber r1 = (rx.internal.operators.OperatorSwitch.InnerSubscriber) r1
                java.lang.Object r2 = r9.poll()
                java.lang.Object r2 = rx.internal.operators.NotificationLite.getValue(r2)
                long r3 = r10.get()
                long r5 = r1.id
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 != 0) goto L_0x0033
                r11.onNext(r2)
                r1 = 1
                long r16 = r16 + r1
                goto L_0x0033
            L_0x0077:
                if (r18 != 0) goto L_0x0093
                boolean r1 = r11.isUnsubscribed()
                if (r1 == 0) goto L_0x0080
                return
            L_0x0080:
                boolean r2 = r8.mainDone
                boolean r7 = r9.isEmpty()
                r1 = r20
                r3 = r0
                r4 = r14
                r5 = r9
                r6 = r11
                boolean r0 = r1.checkTerminated(r2, r3, r4, r5, r6, r7)
                if (r0 == 0) goto L_0x0093
                return
            L_0x0093:
                monitor-enter(r20)
                long r0 = r8.requested     // Catch:{ all -> 0x00a5 }
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L_0x00a3
                long r0 = r0 - r16
                r8.requested = r0     // Catch:{ all -> 0x00a5 }
            L_0x00a3:
                r12 = r0
                goto L_0x00a7
            L_0x00a5:
                r0 = move-exception
                goto L_0x00c7
            L_0x00a7:
                boolean r0 = r8.missed     // Catch:{ all -> 0x00a5 }
                r1 = 0
                if (r0 != 0) goto L_0x00b0
                r8.emitting = r1     // Catch:{ all -> 0x00a5 }
                monitor-exit(r20)     // Catch:{ all -> 0x00a5 }
                return
            L_0x00b0:
                r8.missed = r1     // Catch:{ all -> 0x00a5 }
                boolean r15 = r8.mainDone     // Catch:{ all -> 0x00a5 }
                boolean r0 = r8.innerActive     // Catch:{ all -> 0x00a5 }
                java.lang.Throwable r14 = r8.error     // Catch:{ all -> 0x00a5 }
                if (r14 == 0) goto L_0x00c4
                java.lang.Throwable r1 = TERMINAL_ERROR     // Catch:{ all -> 0x00a5 }
                if (r14 == r1) goto L_0x00c4
                boolean r2 = r8.delayError     // Catch:{ all -> 0x00a5 }
                if (r2 != 0) goto L_0x00c4
                r8.error = r1     // Catch:{ all -> 0x00a5 }
            L_0x00c4:
                monitor-exit(r20)     // Catch:{ all -> 0x00a5 }
                goto L_0x002f
            L_0x00c7:
                monitor-exit(r20)     // Catch:{ all -> 0x00a5 }
                throw r0
            L_0x00c9:
                monitor-exit(r20)     // Catch:{ all -> 0x000c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorSwitch.SwitchSubscriber.drain():void");
        }

        public void emit(T t, InnerSubscriber<T> innerSubscriber) {
            synchronized (this) {
                try {
                    if (this.index.get() == innerSubscriber.id) {
                        this.queue.offer(innerSubscriber, NotificationLite.next(t));
                        drain();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void error(Throwable th, long j) {
            boolean z;
            synchronized (this) {
                try {
                    if (this.index.get() == j) {
                        z = updateError(th);
                        this.innerActive = false;
                        this.producer = null;
                    } else {
                        z = true;
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
            if (z) {
                drain();
            } else {
                pluginError(th);
            }
        }

        public void init() {
            this.child.add(this.serial);
            this.child.add(Subscriptions.create(new Action0() {
                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() {
                public void request(long j) {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i > 0) {
                        SwitchSubscriber.this.childRequested(j);
                    } else if (i < 0) {
                        throw new IllegalArgumentException(e.j(j, "n >= 0 expected but it was "));
                    }
                }
            });
        }

        public void innerProducer(Producer producer2, long j) {
            synchronized (this) {
                try {
                    if (this.index.get() == j) {
                        long j2 = this.requested;
                        this.producer = producer2;
                        producer2.request(j2);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void onCompleted() {
            this.mainDone = true;
            drain();
        }

        public void onError(Throwable th) {
            boolean updateError;
            synchronized (this) {
                updateError = updateError(th);
            }
            if (updateError) {
                this.mainDone = true;
                drain();
                return;
            }
            pluginError(th);
        }

        public void pluginError(Throwable th) {
            RxJavaHooks.onError(th);
        }

        public boolean updateError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == TERMINAL_ERROR) {
                return false;
            }
            if (th2 == null) {
                this.error = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.error = new CompositeException((Collection<? extends Throwable>) arrayList);
            } else {
                this.error = new CompositeException(th2, th);
            }
            return true;
        }

        public void onNext(Observable<? extends T> observable) {
            InnerSubscriber innerSubscriber;
            long incrementAndGet = this.index.incrementAndGet();
            Subscription subscription = this.serial.get();
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                innerSubscriber = new InnerSubscriber(incrementAndGet, this);
                this.innerActive = true;
                this.producer = null;
            }
            this.serial.set(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
        }
    }

    public OperatorSwitch(boolean z) {
        this.delayError = z;
    }

    public static <T> OperatorSwitch<T> instance(boolean z) {
        if (z) {
            return HolderDelayError.INSTANCE;
        }
        return Holder.INSTANCE;
    }

    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        SwitchSubscriber switchSubscriber = new SwitchSubscriber(subscriber, this.delayError);
        subscriber.add(switchSubscriber);
        switchSubscriber.init();
        return switchSubscriber;
    }
}
