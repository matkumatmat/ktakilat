package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithTime<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public static final class DebounceState<T> {
        boolean emitting;
        boolean hasValue;
        int index;
        boolean terminate;
        T value;

        public synchronized void clear() {
            this.index++;
            this.value = null;
            this.hasValue = false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r4.onNext(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
            if (r2.terminate != false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
            r2.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0028, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0029, code lost:
            r4.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x002e, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x002f, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0030, code lost:
            rx.exceptions.Exceptions.throwOrReport(r4, (rx.Observer<?>) r5, (java.lang.Object) r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0033, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emit(int r3, rx.Subscriber<T> r4, rx.Subscriber<?> r5) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.emitting     // Catch:{ all -> 0x0034 }
                if (r0 != 0) goto L_0x0036
                boolean r0 = r2.hasValue     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0036
                int r0 = r2.index     // Catch:{ all -> 0x0034 }
                if (r3 == r0) goto L_0x000e
                goto L_0x0036
            L_0x000e:
                T r3 = r2.value     // Catch:{ all -> 0x0034 }
                r0 = 0
                r2.value = r0     // Catch:{ all -> 0x0034 }
                r0 = 0
                r2.hasValue = r0     // Catch:{ all -> 0x0034 }
                r1 = 1
                r2.emitting = r1     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r4.onNext(r3)     // Catch:{ all -> 0x002f }
                monitor-enter(r2)
                boolean r3 = r2.terminate     // Catch:{ all -> 0x0026 }
                if (r3 != 0) goto L_0x0028
                r2.emitting = r0     // Catch:{ all -> 0x0026 }
                monitor-exit(r2)     // Catch:{ all -> 0x0026 }
                return
            L_0x0026:
                r3 = move-exception
                goto L_0x002d
            L_0x0028:
                monitor-exit(r2)     // Catch:{ all -> 0x0026 }
                r4.onCompleted()
                return
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x0026 }
                throw r3
            L_0x002f:
                r4 = move-exception
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r4, (rx.Observer<?>) r5, (java.lang.Object) r3)
                return
            L_0x0034:
                r3 = move-exception
                goto L_0x0038
            L_0x0036:
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0038:
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDebounceWithTime.DebounceState.emit(int, rx.Subscriber, rx.Subscriber):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r2 == false) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r5.onNext(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
            rx.exceptions.Exceptions.throwOrReport(r5, (rx.Observer<?>) r6, (java.lang.Object) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            r5.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitAndComplete(rx.Subscriber<T> r5, rx.Subscriber<?> r6) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r4.emitting     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000c
                r4.terminate = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r4)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r5 = move-exception
                goto L_0x0028
            L_0x000c:
                T r0 = r4.value     // Catch:{ all -> 0x000a }
                boolean r2 = r4.hasValue     // Catch:{ all -> 0x000a }
                r3 = 0
                r4.value = r3     // Catch:{ all -> 0x000a }
                r3 = 0
                r4.hasValue = r3     // Catch:{ all -> 0x000a }
                r4.emitting = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r4)     // Catch:{ all -> 0x000a }
                if (r2 == 0) goto L_0x0024
                r5.onNext(r0)     // Catch:{ all -> 0x001f }
                goto L_0x0024
            L_0x001f:
                r5 = move-exception
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r5, (rx.Observer<?>) r6, (java.lang.Object) r0)
                return
            L_0x0024:
                r5.onCompleted()
                return
            L_0x0028:
                monitor-exit(r4)     // Catch:{ all -> 0x000a }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDebounceWithTime.DebounceState.emitAndComplete(rx.Subscriber, rx.Subscriber):void");
        }

        public synchronized int next(T t) {
            int i;
            this.value = t;
            this.hasValue = true;
            i = this.index + 1;
            this.index = i;
            return i;
        }
    }

    public OperatorDebounceWithTime(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(createWorker);
        serializedSubscriber.add(serialSubscription);
        return new Subscriber<T>(subscriber) {
            final Subscriber<?> self = this;
            final DebounceState<T> state = new DebounceState<>();

            public void onCompleted() {
                this.state.emitAndComplete(serializedSubscriber, this);
            }

            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                unsubscribe();
                this.state.clear();
            }

            public void onNext(T t) {
                final int next = this.state.next(t);
                SerialSubscription serialSubscription = serialSubscription;
                Scheduler.Worker worker = createWorker;
                AnonymousClass1 r2 = new Action0() {
                    public void call() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        r0.state.emit(next, serializedSubscriber, r0.self);
                    }
                };
                OperatorDebounceWithTime operatorDebounceWithTime = OperatorDebounceWithTime.this;
                serialSubscription.set(worker.schedule(r2, operatorDebounceWithTime.timeout, operatorDebounceWithTime.unit));
            }

            public void onStart() {
                request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        };
    }
}
