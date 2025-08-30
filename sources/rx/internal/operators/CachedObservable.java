package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayProducer<?>[] EMPTY = new ReplayProducer[0];
        final SerialSubscription connection = new SerialSubscription();
        volatile boolean isConnected;
        volatile ReplayProducer<?>[] producers = EMPTY;
        final Observable<? extends T> source;
        boolean sourceDone;

        public CacheState(Observable<? extends T> observable, int i) {
            super(i);
            this.source = observable;
        }

        public void addProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length + 1)];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
                this.producers = replayProducerArr2;
            }
        }

        public void connect() {
            AnonymousClass1 r0 = new Subscriber<T>() {
                public void onCompleted() {
                    CacheState.this.onCompleted();
                }

                public void onError(Throwable th) {
                    CacheState.this.onError(th);
                }

                public void onNext(T t) {
                    CacheState.this.onNext(t);
                }
            };
            this.connection.set(r0);
            this.source.unsafeSubscribe(r0);
            this.isConnected = true;
        }

        public void dispatch() {
            for (ReplayProducer<?> replay : this.producers) {
                replay.replay();
            }
        }

        public void onCompleted() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.completed());
                this.connection.unsubscribe();
                dispatch();
            }
        }

        public void onError(Throwable th) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                this.connection.unsubscribe();
                dispatch();
            }
        }

        public void onNext(T t) {
            if (!this.sourceDone) {
                add(NotificationLite.next(t));
                dispatch();
            }
        }

        public void removeProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                try {
                    ReplayProducer<?>[] replayProducerArr = this.producers;
                    int length = replayProducerArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (replayProducerArr[i].equals(replayProducer)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            this.producers = EMPTY;
                            return;
                        }
                        ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length - 1)];
                        System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, i);
                        System.arraycopy(replayProducerArr, i + 1, replayProducerArr2, i, (length - i) - 1);
                        this.producers = replayProducerArr2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        final CacheState<T> state;

        public CachedSubscribe(CacheState<T> cacheState) {
            this.state = cacheState;
        }

        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer replayProducer = new ReplayProducer(subscriber, this.state);
            this.state.addProducer(replayProducer);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.connect();
            }
        }
    }

    public static final class ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        boolean emitting;
        int index;
        boolean missed;
        final CacheState<T> state;

        public ReplayProducer(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        public long produced(long j) {
            return addAndGet(-j);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x00e9, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2 = r15.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0013, code lost:
            r3 = get();
            r7 = (r3 > 0 ? 1 : (r3 == 0 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
            if (r7 >= 0) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
            r8 = r15.state.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            if (r8 == 0) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0026, code lost:
            r9 = r15.currentBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0028, code lost:
            if (r9 != null) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
            r9 = r15.state.head();
            r15.currentBuffer = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
            r10 = r9.length - 1;
            r11 = r15.index;
            r12 = r15.currentIndexInBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
            if (r7 != 0) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
            r3 = r9[r12];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
            if (rx.internal.operators.NotificationLite.isCompleted(r3) == false) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0047, code lost:
            r2.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x004f, code lost:
            r1 = r2;
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
            if (rx.internal.operators.NotificationLite.isError(r3) == false) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
            r2.onError(rx.internal.operators.NotificationLite.getError(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0063, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0064, code lost:
            if (r7 <= 0) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0066, code lost:
            r7 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0067, code lost:
            if (r11 >= r8) goto L_0x00b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006b, code lost:
            if (r3 <= 0) goto L_0x00b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x0074;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0073, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0074, code lost:
            if (r12 != r10) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0076, code lost:
            r9 = (java.lang.Object[]) r9[r10];
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x007b, code lost:
            r13 = r9[r12];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0081, code lost:
            if (rx.internal.operators.NotificationLite.accept(r2, r13) == false) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0086, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0087, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0088, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x008a, code lost:
            r12 = r12 + 1;
            r11 = r11 + 1;
            r3 = r3 - 1;
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0094, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0095, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a0, code lost:
            if (rx.internal.operators.NotificationLite.isError(r13) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00a8, code lost:
            r2.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, rx.internal.operators.NotificationLite.getValue(r13)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b4, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ba, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x00bd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00bc, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00bd, code lost:
            r15.index = r11;
            r15.currentIndexInBuffer = r12;
            r15.currentBuffer = r9;
            produced((long) r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c7, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x00ca, code lost:
            if (r15.missed != false) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x00cc, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x00cf, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x00d0, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x00d2, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x00d3, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x00d7, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x00dc, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x00dd, code lost:
            r4 = r1;
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x00df, code lost:
            if (r4 == false) goto L_0x00e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x00e1, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x00a8 A[Catch:{ all -> 0x004e }] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x00e1  */
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
                goto L_0x00ea
            L_0x000d:
                r15.emitting = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                r0 = 0
                rx.Subscriber<? super T> r2 = r15.child     // Catch:{ all -> 0x0033 }
            L_0x0013:
                long r3 = r15.get()     // Catch:{ all -> 0x0033 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 >= 0) goto L_0x001e
                return
            L_0x001e:
                rx.internal.operators.CachedObservable$CacheState<T> r8 = r15.state     // Catch:{ all -> 0x0033 }
                int r8 = r8.size()     // Catch:{ all -> 0x0033 }
                if (r8 == 0) goto L_0x00c7
                java.lang.Object[] r9 = r15.currentBuffer     // Catch:{ all -> 0x0033 }
                if (r9 != 0) goto L_0x0037
                rx.internal.operators.CachedObservable$CacheState<T> r9 = r15.state     // Catch:{ all -> 0x0033 }
                java.lang.Object[] r9 = r9.head()     // Catch:{ all -> 0x0033 }
                r15.currentBuffer = r9     // Catch:{ all -> 0x0033 }
                goto L_0x0037
            L_0x0033:
                r1 = move-exception
                r4 = 0
                goto L_0x00df
            L_0x0037:
                int r10 = r9.length     // Catch:{ all -> 0x0033 }
                int r10 = r10 - r1
                int r11 = r15.index     // Catch:{ all -> 0x0033 }
                int r12 = r15.currentIndexInBuffer     // Catch:{ all -> 0x0033 }
                if (r7 != 0) goto L_0x0064
                r3 = r9[r12]     // Catch:{ all -> 0x0033 }
                boolean r4 = rx.internal.operators.NotificationLite.isCompleted(r3)     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x0053
                r2.onCompleted()     // Catch:{ all -> 0x0033 }
                r15.unsubscribe()     // Catch:{ all -> 0x004e }
                return
            L_0x004e:
                r2 = move-exception
                r1 = r2
                r4 = 1
                goto L_0x00df
            L_0x0053:
                boolean r4 = rx.internal.operators.NotificationLite.isError(r3)     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x00c7
                java.lang.Throwable r3 = rx.internal.operators.NotificationLite.getError(r3)     // Catch:{ all -> 0x0033 }
                r2.onError(r3)     // Catch:{ all -> 0x0033 }
                r15.unsubscribe()     // Catch:{ all -> 0x004e }
                return
            L_0x0064:
                if (r7 <= 0) goto L_0x00c7
                r7 = 0
            L_0x0067:
                if (r11 >= r8) goto L_0x00b6
                int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r13 <= 0) goto L_0x00b6
                boolean r13 = r2.isUnsubscribed()     // Catch:{ all -> 0x0033 }
                if (r13 == 0) goto L_0x0074
                return
            L_0x0074:
                if (r12 != r10) goto L_0x007b
                r9 = r9[r10]     // Catch:{ all -> 0x0033 }
                java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x0033 }
                r12 = 0
            L_0x007b:
                r13 = r9[r12]     // Catch:{ all -> 0x0033 }
                boolean r14 = rx.internal.operators.NotificationLite.accept(r2, r13)     // Catch:{ all -> 0x0094 }
                if (r14 == 0) goto L_0x008a
                r15.unsubscribe()     // Catch:{ all -> 0x0087 }
                return
            L_0x0087:
                r3 = move-exception
                r4 = 1
                goto L_0x0096
            L_0x008a:
                int r12 = r12 + 1
                int r11 = r11 + 1
                r13 = 1
                long r3 = r3 - r13
                int r7 = r7 + 1
                goto L_0x0067
            L_0x0094:
                r3 = move-exception
                r4 = 0
            L_0x0096:
                rx.exceptions.Exceptions.throwIfFatal(r3)     // Catch:{ all -> 0x00b4 }
                r15.unsubscribe()     // Catch:{ all -> 0x004e }
                boolean r4 = rx.internal.operators.NotificationLite.isError(r13)     // Catch:{ all -> 0x004e }
                if (r4 != 0) goto L_0x00b3
                boolean r4 = rx.internal.operators.NotificationLite.isCompleted(r13)     // Catch:{ all -> 0x004e }
                if (r4 != 0) goto L_0x00b3
                java.lang.Object r4 = rx.internal.operators.NotificationLite.getValue(r13)     // Catch:{ all -> 0x004e }
                java.lang.Throwable r3 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, r4)     // Catch:{ all -> 0x004e }
                r2.onError(r3)     // Catch:{ all -> 0x004e }
            L_0x00b3:
                return
            L_0x00b4:
                r1 = move-exception
                goto L_0x00df
            L_0x00b6:
                boolean r3 = r2.isUnsubscribed()     // Catch:{ all -> 0x0033 }
                if (r3 == 0) goto L_0x00bd
                return
            L_0x00bd:
                r15.index = r11     // Catch:{ all -> 0x0033 }
                r15.currentIndexInBuffer = r12     // Catch:{ all -> 0x0033 }
                r15.currentBuffer = r9     // Catch:{ all -> 0x0033 }
                long r3 = (long) r7     // Catch:{ all -> 0x0033 }
                r15.produced(r3)     // Catch:{ all -> 0x0033 }
            L_0x00c7:
                monitor-enter(r15)     // Catch:{ all -> 0x0033 }
                boolean r3 = r15.missed     // Catch:{ all -> 0x00d2 }
                if (r3 != 0) goto L_0x00d5
                r15.emitting = r0     // Catch:{ all -> 0x00d2 }
                monitor-exit(r15)     // Catch:{ all -> 0x00d0 }
                return
            L_0x00d0:
                r2 = move-exception
                goto L_0x00da
            L_0x00d2:
                r2 = move-exception
                r1 = 0
                goto L_0x00da
            L_0x00d5:
                r15.missed = r0     // Catch:{ all -> 0x00d2 }
                monitor-exit(r15)     // Catch:{ all -> 0x00d2 }
                goto L_0x0013
            L_0x00da:
                monitor-exit(r15)     // Catch:{ all -> 0x00d0 }
                throw r2     // Catch:{ all -> 0x00dc }
            L_0x00dc:
                r2 = move-exception
                r4 = r1
                r1 = r2
            L_0x00df:
                if (r4 != 0) goto L_0x00e9
                monitor-enter(r15)
                r15.emitting = r0     // Catch:{ all -> 0x00e6 }
                monitor-exit(r15)     // Catch:{ all -> 0x00e6 }
                goto L_0x00e9
            L_0x00e6:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00e6 }
                throw r0
            L_0x00e9:
                throw r1
            L_0x00ea:
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.CachedObservable.ReplayProducer.replay():void");
        }

        public void request(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 >= 0) {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(j2, j3));
            replay();
        }

        public void unsubscribe() {
            if (get() >= 0 && getAndSet(-1) >= 0) {
                this.state.removeProducer(this);
            }
        }
    }

    private CachedObservable(Observable.OnSubscribe<T> onSubscribe, CacheState<T> cacheState) {
        super(onSubscribe);
        this.state = cacheState;
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable) {
        return from(observable, 16);
    }

    public boolean hasObservers() {
        if (this.state.producers.length != 0) {
            return true;
        }
        return false;
    }

    public boolean isConnected() {
        return this.state.isConnected;
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable, int i) {
        if (i >= 1) {
            CacheState cacheState = new CacheState(observable, i);
            return new CachedObservable<>(new CachedSubscribe(cacheState), cacheState);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }
}
