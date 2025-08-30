package rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.operators.BackpressureUtils;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class UnicastSubject<T> extends Subject<T, T> {
    final State<T> state;

    public static final class State<T> extends AtomicLong implements Producer, Observer<T>, Observable.OnSubscribe<T>, Subscription {
        private static final long serialVersionUID = -9044104859202255786L;
        volatile boolean caughtUp;
        final boolean delayError;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        final Queue<Object> queue;
        final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference<>();
        final AtomicReference<Action0> terminateOnce;

        public State(int i, boolean z, Action0 action0) {
            AtomicReference<Action0> atomicReference;
            Queue<Object> queue2;
            Queue<Object> spscLinkedAtomicQueue;
            if (action0 != null) {
                atomicReference = new AtomicReference<>(action0);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            this.delayError = z;
            if (i <= 1) {
                if (UnsafeAccess.isUnsafeAvailable()) {
                    spscLinkedAtomicQueue = new SpscLinkedQueue<>();
                } else {
                    spscLinkedAtomicQueue = new SpscLinkedAtomicQueue<>();
                }
                queue2 = spscLinkedAtomicQueue;
            } else if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscUnboundedArrayQueue<>(i);
            } else {
                queue2 = new SpscUnboundedAtomicArrayQueue<>(i);
            }
            this.queue = queue2;
        }

        public boolean checkTerminated(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber2) {
            if (subscriber2.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.error;
                if (th != null && !z3) {
                    this.queue.clear();
                    subscriber2.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    if (th != null) {
                        subscriber2.onError(th);
                    } else {
                        subscriber2.onCompleted();
                    }
                    return true;
                }
            }
        }

        public void doTerminate() {
            Action0 action0;
            AtomicReference<Action0> atomicReference = this.terminateOnce;
            if (atomicReference != null && (action0 = atomicReference.get()) != null) {
                while (!atomicReference.compareAndSet(action0, (Object) null)) {
                    if (atomicReference.get() != action0) {
                        return;
                    }
                }
                action0.call();
            }
        }

        public boolean isUnsubscribed() {
            return this.done;
        }

        public void onCompleted() {
            boolean z;
            if (!this.done) {
                doTerminate();
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        z = this.caughtUp;
                    }
                    if (!z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onCompleted();
            }
        }

        public void onError(Throwable th) {
            boolean z;
            if (!this.done) {
                doTerminate();
                this.error = th;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        z = this.caughtUp;
                    }
                    if (!z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onError(th);
            }
        }

        public void onNext(T t) {
            boolean z;
            if (!this.done) {
                if (!this.caughtUp) {
                    synchronized (this) {
                        try {
                            if (!this.caughtUp) {
                                this.queue.offer(NotificationLite.next(t));
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
                        replay();
                        return;
                    }
                }
                Subscriber subscriber2 = this.subscriber.get();
                try {
                    subscriber2.onNext(t);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber2, (Object) t);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
            r0 = r15.queue;
            r2 = r15.delayError;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r3 = r15.subscriber.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
            if (r3 == null) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            if (checkTerminated(r15.done, r0.isEmpty(), r2, r3) == false) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
            r5 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
            if (r5 != androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            r7 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
            if (r5 == 0) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
            r12 = r15.done;
            r13 = r0.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
            if (r13 != null) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
            r14 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
            if (checkTerminated(r12, r14, r2, r3) == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
            if (r14 == false) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0058, code lost:
            r12 = rx.internal.operators.NotificationLite.getValue(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r3.onNext(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005f, code lost:
            r5 = r5 - 1;
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0065, code lost:
            r0.clear();
            rx.exceptions.Exceptions.throwIfFatal(r1);
            r3.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r12));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0072, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0073, code lost:
            if (r7 != false) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0077, code lost:
            if (r10 == 0) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0079, code lost:
            addAndGet(-r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x007e, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x007f, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0082, code lost:
            if (r15.missed != false) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0084, code lost:
            if (r7 == false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008a, code lost:
            if (r0.isEmpty() == false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008c, code lost:
            r15.caughtUp = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x008f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0091, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0093, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0094, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0095, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0097, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x009b, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay() {
            /*
                r15 = this;
                monitor-enter(r15)
                boolean r0 = r15.emitting     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r15.missed = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r0 = move-exception
                goto L_0x009c
            L_0x000d:
                r15.emitting = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                java.util.Queue<java.lang.Object> r0 = r15.queue
                boolean r2 = r15.delayError
            L_0x0014:
                java.util.concurrent.atomic.AtomicReference<rx.Subscriber<? super T>> r3 = r15.subscriber
                java.lang.Object r3 = r3.get()
                rx.Subscriber r3 = (rx.Subscriber) r3
                r4 = 0
                if (r3 == 0) goto L_0x007e
                boolean r5 = r15.done
                boolean r6 = r0.isEmpty()
                boolean r5 = r15.checkTerminated(r5, r6, r2, r3)
                if (r5 == 0) goto L_0x002c
                return
            L_0x002c:
                long r5 = r15.get()
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 != 0) goto L_0x003b
                r7 = 1
                goto L_0x003c
            L_0x003b:
                r7 = 0
            L_0x003c:
                r8 = 0
                r10 = r8
            L_0x003f:
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L_0x0073
                boolean r12 = r15.done
                java.lang.Object r13 = r0.poll()
                if (r13 != 0) goto L_0x004d
                r14 = 1
                goto L_0x004e
            L_0x004d:
                r14 = 0
            L_0x004e:
                boolean r12 = r15.checkTerminated(r12, r14, r2, r3)
                if (r12 == 0) goto L_0x0055
                return
            L_0x0055:
                if (r14 == 0) goto L_0x0058
                goto L_0x0073
            L_0x0058:
                java.lang.Object r12 = rx.internal.operators.NotificationLite.getValue(r13)
                r3.onNext(r12)     // Catch:{ all -> 0x0064 }
                r12 = 1
                long r5 = r5 - r12
                long r10 = r10 + r12
                goto L_0x003f
            L_0x0064:
                r1 = move-exception
                r0.clear()
                rx.exceptions.Exceptions.throwIfFatal(r1)
                java.lang.Throwable r0 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r12)
                r3.onError(r0)
                return
            L_0x0073:
                if (r7 != 0) goto L_0x007f
                int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r3 == 0) goto L_0x007f
                long r5 = -r10
                r15.addAndGet(r5)
                goto L_0x007f
            L_0x007e:
                r7 = 0
            L_0x007f:
                monitor-enter(r15)
                boolean r3 = r15.missed     // Catch:{ all -> 0x008f }
                if (r3 != 0) goto L_0x0095
                if (r7 == 0) goto L_0x0091
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x008f }
                if (r0 == 0) goto L_0x0091
                r15.caughtUp = r1     // Catch:{ all -> 0x008f }
                goto L_0x0091
            L_0x008f:
                r0 = move-exception
                goto L_0x009a
            L_0x0091:
                r15.emitting = r4     // Catch:{ all -> 0x008f }
                monitor-exit(r15)     // Catch:{ all -> 0x008f }
                return
            L_0x0095:
                r15.missed = r4     // Catch:{ all -> 0x008f }
                monitor-exit(r15)     // Catch:{ all -> 0x008f }
                goto L_0x0014
            L_0x009a:
                monitor-exit(r15)     // Catch:{ all -> 0x008f }
                throw r0
            L_0x009c:
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.UnicastSubject.State.replay():void");
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (i > 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                replay();
            } else if (this.done) {
                replay();
            }
        }

        public void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                try {
                    if (!this.emitting) {
                        this.emitting = true;
                        this.queue.clear();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void call(Subscriber<? super T> subscriber2) {
            AtomicReference<Subscriber<? super T>> atomicReference = this.subscriber;
            while (!atomicReference.compareAndSet((Object) null, subscriber2)) {
                if (atomicReference.get() != null) {
                    subscriber2.onError(new IllegalStateException("Only a single subscriber is allowed"));
                    return;
                }
            }
            subscriber2.add(this);
            subscriber2.setProducer(this);
        }
    }

    private UnicastSubject(State<T> state2) {
        super(state2);
        this.state = state2;
    }

    public static <T> UnicastSubject<T> create() {
        return create(16);
    }

    public boolean hasObservers() {
        if (this.state.subscriber.get() != null) {
            return true;
        }
        return false;
    }

    public void onCompleted() {
        this.state.onCompleted();
    }

    public void onError(Throwable th) {
        this.state.onError(th);
    }

    public void onNext(T t) {
        this.state.onNext(t);
    }

    public static <T> UnicastSubject<T> create(int i) {
        return new UnicastSubject<>(new State(i, false, (Action0) null));
    }

    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(new State(16, z, (Action0) null));
    }

    public static <T> UnicastSubject<T> create(int i, Action0 action0) {
        return new UnicastSubject<>(new State(i, false, action0));
    }

    public static <T> UnicastSubject<T> create(int i, Action0 action0, boolean z) {
        return new UnicastSubject<>(new State(i, z, action0));
    }
}
