package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

public final class OperatorWindowWithTime<T> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    final Scheduler scheduler;
    final int size;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    public static final class CountedSerializedSubject<T> {
        final Observer<T> consumer;
        int count;
        final Observable<T> producer;

        public CountedSerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    public final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        boolean emitting;
        final Object guard = new Object();
        List<Object> queue;
        volatile State<T> state = State.empty();
        final Scheduler.Worker worker;

        public ExactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker2) {
            this.child = new SerializedSubscriber(subscriber);
            this.worker = worker2;
            subscriber.add(Subscriptions.create(new Action0(OperatorWindowWithTime.this) {
                public void call() {
                    if (ExactSubscriber.this.state.consumer == null) {
                        ExactSubscriber.this.unsubscribe();
                    }
                }
            }));
        }

        public void complete() {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        public boolean drain(List<Object> list) {
            if (list == null) {
                return true;
            }
            Iterator<Object> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (next == OperatorWindowWithTime.NEXT_SUBJECT) {
                    if (!replaceSubject()) {
                        return false;
                    }
                } else if (NotificationLite.isError(next)) {
                    error(NotificationLite.getError(next));
                    break;
                } else if (NotificationLite.isCompleted(next)) {
                    complete();
                    break;
                } else if (!emitValue(next)) {
                    return false;
                }
            }
            return true;
        }

        public boolean emitValue(T t) {
            State<T> state2;
            State<T> state3 = this.state;
            if (state3.consumer == null) {
                if (!replaceSubject()) {
                    return false;
                }
                state3 = this.state;
            }
            state3.consumer.onNext(t);
            if (state3.count == OperatorWindowWithTime.this.size - 1) {
                state3.consumer.onCompleted();
                state2 = state3.clear();
            } else {
                state2 = state3.next();
            }
            this.state = state2;
            return true;
        }

        public void error(Throwable th) {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
            if (replaceSubject() != false) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
            r2 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x002f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r2 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0035, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r3 = r6.queue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0038, code lost:
            if (r3 != null) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x003a, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x003d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x003e, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0040, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0041, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r6.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0046, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x004b, code lost:
            if (drain(r3) != false) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x004d, code lost:
            r2 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x004f, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0052, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0053, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0057, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0058, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x005c, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x005d, code lost:
            r5 = r2;
            r2 = r1;
            r1 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0060, code lost:
            if (r2 == false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0064, code lost:
            monitor-enter(r6.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x006c, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void nextWindow() {
            /*
                r6 = this;
                java.lang.Object r0 = r6.guard
                monitor-enter(r0)
                boolean r1 = r6.emitting     // Catch:{ all -> 0x0013 }
                if (r1 == 0) goto L_0x001e
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0013 }
                if (r1 != 0) goto L_0x0015
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0013 }
                r1.<init>()     // Catch:{ all -> 0x0013 }
                r6.queue = r1     // Catch:{ all -> 0x0013 }
                goto L_0x0015
            L_0x0013:
                r1 = move-exception
                goto L_0x006d
            L_0x0015:
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0013 }
                java.lang.Object r2 = rx.internal.operators.OperatorWindowWithTime.NEXT_SUBJECT     // Catch:{ all -> 0x0013 }
                r1.add(r2)     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                return
            L_0x001e:
                r1 = 1
                r6.emitting = r1     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                r0 = 0
                boolean r2 = r6.replaceSubject()     // Catch:{ all -> 0x0057 }
                if (r2 != 0) goto L_0x0033
                java.lang.Object r2 = r6.guard
                monitor-enter(r2)
                r6.emitting = r0     // Catch:{ all -> 0x0030 }
                monitor-exit(r2)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0030 }
                throw r0
            L_0x0033:
                java.lang.Object r2 = r6.guard     // Catch:{ all -> 0x0057 }
                monitor-enter(r2)     // Catch:{ all -> 0x0057 }
                java.util.List<java.lang.Object> r3 = r6.queue     // Catch:{ all -> 0x0040 }
                if (r3 != 0) goto L_0x0043
                r6.emitting = r0     // Catch:{ all -> 0x0040 }
                monitor-exit(r2)     // Catch:{ all -> 0x003e }
                return
            L_0x003e:
                r3 = move-exception
                goto L_0x005a
            L_0x0040:
                r3 = move-exception
                r1 = 0
                goto L_0x005a
            L_0x0043:
                r4 = 0
                r6.queue = r4     // Catch:{ all -> 0x0040 }
                monitor-exit(r2)     // Catch:{ all -> 0x0040 }
                boolean r2 = r6.drain(r3)     // Catch:{ all -> 0x0057 }
                if (r2 != 0) goto L_0x0033
                java.lang.Object r2 = r6.guard
                monitor-enter(r2)
                r6.emitting = r0     // Catch:{ all -> 0x0054 }
                monitor-exit(r2)     // Catch:{ all -> 0x0054 }
                return
            L_0x0054:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0054 }
                throw r0
            L_0x0057:
                r1 = move-exception
                r2 = 0
                goto L_0x0060
            L_0x005a:
                monitor-exit(r2)     // Catch:{ all -> 0x003e }
                throw r3     // Catch:{ all -> 0x005c }
            L_0x005c:
                r2 = move-exception
                r5 = r2
                r2 = r1
                r1 = r5
            L_0x0060:
                if (r2 != 0) goto L_0x006c
                java.lang.Object r2 = r6.guard
                monitor-enter(r2)
                r6.emitting = r0     // Catch:{ all -> 0x0069 }
                monitor-exit(r2)     // Catch:{ all -> 0x0069 }
                goto L_0x006c
            L_0x0069:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0069 }
                throw r0
            L_0x006c:
                throw r1
            L_0x006d:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.nextWindow():void");
        }

        public void onCompleted() {
            synchronized (this.guard) {
                try {
                    if (this.emitting) {
                        if (this.queue == null) {
                            this.queue = new ArrayList();
                        }
                        this.queue.add(NotificationLite.completed());
                        return;
                    }
                    List<Object> list = this.queue;
                    this.queue = null;
                    this.emitting = true;
                    try {
                        drain(list);
                        complete();
                    } catch (Throwable th) {
                        error(th);
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
        }

        public void onError(Throwable th) {
            synchronized (this.guard) {
                try {
                    if (this.emitting) {
                        this.queue = Collections.singletonList(NotificationLite.error(th));
                        return;
                    }
                    this.queue = null;
                    this.emitting = true;
                    error(th);
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (emitValue(r5) != false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            r5 = r4.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x002d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r5 = r4.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0033, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r2 = r4.queue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0036, code lost:
            if (r2 != null) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0038, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x003b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x003c, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x003e, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x003f, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r4.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0044, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0049, code lost:
            if (drain(r2) != false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x004b, code lost:
            r5 = r4.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x004d, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0050, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0051, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0055, code lost:
            r5 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0056, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x005a, code lost:
            r5 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x005b, code lost:
            if (r1 == false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x005f, code lost:
            monitor-enter(r4.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            r4.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0067, code lost:
            throw r5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r5) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.guard
                monitor-enter(r0)
                boolean r1 = r4.emitting     // Catch:{ all -> 0x0013 }
                if (r1 == 0) goto L_0x001c
                java.util.List<java.lang.Object> r1 = r4.queue     // Catch:{ all -> 0x0013 }
                if (r1 != 0) goto L_0x0015
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0013 }
                r1.<init>()     // Catch:{ all -> 0x0013 }
                r4.queue = r1     // Catch:{ all -> 0x0013 }
                goto L_0x0015
            L_0x0013:
                r5 = move-exception
                goto L_0x0068
            L_0x0015:
                java.util.List<java.lang.Object> r1 = r4.queue     // Catch:{ all -> 0x0013 }
                r1.add(r5)     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                return
            L_0x001c:
                r1 = 1
                r4.emitting = r1     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                r0 = 0
                boolean r5 = r4.emitValue(r5)     // Catch:{ all -> 0x0055 }
                if (r5 != 0) goto L_0x0031
                java.lang.Object r5 = r4.guard
                monitor-enter(r5)
                r4.emitting = r0     // Catch:{ all -> 0x002e }
                monitor-exit(r5)     // Catch:{ all -> 0x002e }
                return
            L_0x002e:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x002e }
                throw r0
            L_0x0031:
                java.lang.Object r5 = r4.guard     // Catch:{ all -> 0x0055 }
                monitor-enter(r5)     // Catch:{ all -> 0x0055 }
                java.util.List<java.lang.Object> r2 = r4.queue     // Catch:{ all -> 0x003e }
                if (r2 != 0) goto L_0x0041
                r4.emitting = r0     // Catch:{ all -> 0x003e }
                monitor-exit(r5)     // Catch:{ all -> 0x003c }
                return
            L_0x003c:
                r2 = move-exception
                goto L_0x0058
            L_0x003e:
                r2 = move-exception
                r1 = 0
                goto L_0x0058
            L_0x0041:
                r3 = 0
                r4.queue = r3     // Catch:{ all -> 0x003e }
                monitor-exit(r5)     // Catch:{ all -> 0x003e }
                boolean r5 = r4.drain(r2)     // Catch:{ all -> 0x0055 }
                if (r5 != 0) goto L_0x0031
                java.lang.Object r5 = r4.guard
                monitor-enter(r5)
                r4.emitting = r0     // Catch:{ all -> 0x0052 }
                monitor-exit(r5)     // Catch:{ all -> 0x0052 }
                return
            L_0x0052:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0052 }
                throw r0
            L_0x0055:
                r5 = move-exception
                r1 = 0
                goto L_0x005b
            L_0x0058:
                monitor-exit(r5)     // Catch:{ all -> 0x003c }
                throw r2     // Catch:{ all -> 0x005a }
            L_0x005a:
                r5 = move-exception
            L_0x005b:
                if (r1 != 0) goto L_0x0067
                java.lang.Object r1 = r4.guard
                monitor-enter(r1)
                r4.emitting = r0     // Catch:{ all -> 0x0064 }
                monitor-exit(r1)     // Catch:{ all -> 0x0064 }
                goto L_0x0067
            L_0x0064:
                r5 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0064 }
                throw r5
            L_0x0067:
                throw r5
            L_0x0068:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.onNext(java.lang.Object):void");
        }

        public void onStart() {
            request(LocationRequestCompat.PASSIVE_INTERVAL);
        }

        public boolean replaceSubject() {
            Observer<T> observer = this.state.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.state = this.state.clear();
                unsubscribe();
                return false;
            }
            UnicastSubject create = UnicastSubject.create();
            this.state = this.state.create(create, create);
            this.child.onNext(create);
            return true;
        }

        public void scheduleExact() {
            Scheduler.Worker worker2 = this.worker;
            AnonymousClass2 r1 = new Action0() {
                public void call() {
                    ExactSubscriber.this.nextWindow();
                }
            };
            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
            worker2.schedulePeriodically(r1, 0, operatorWindowWithTime.timespan, operatorWindowWithTime.unit);
        }
    }

    public final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<CountedSerializedSubject<T>> chunks = new LinkedList();
        boolean done;
        final Object guard = new Object();
        final Scheduler.Worker worker;

        public InexactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker2) {
            super(subscriber);
            this.child = subscriber;
            this.worker = worker2;
        }

        public CountedSerializedSubject<T> createCountedSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new CountedSerializedSubject<>(create, create);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            if (r0.hasNext() == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            ((rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r0.next()).consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            r3.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCompleted() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0009 }
                if (r1 == 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r1 = move-exception
                goto L_0x0037
            L_0x000b:
                r1 = 1
                r3.done = r1     // Catch:{ all -> 0x0009 }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0009 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x0009 }
                r1.<init>(r2)     // Catch:{ all -> 0x0009 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x0009 }
                r2.clear()     // Catch:{ all -> 0x0009 }
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                java.util.Iterator r0 = r1.iterator()
            L_0x001f:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0031
                java.lang.Object r1 = r0.next()
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r1 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r1
                rx.Observer<T> r1 = r1.consumer
                r1.onCompleted()
                goto L_0x001f
            L_0x0031:
                rx.Subscriber<? super rx.Observable<T>> r0 = r3.child
                r0.onCompleted()
                return
            L_0x0037:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.onCompleted():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            if (r0.hasNext() == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            ((rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r0.next()).consumer.onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            r3.child.onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0009 }
                if (r1 == 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r4 = move-exception
                goto L_0x0037
            L_0x000b:
                r1 = 1
                r3.done = r1     // Catch:{ all -> 0x0009 }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0009 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x0009 }
                r1.<init>(r2)     // Catch:{ all -> 0x0009 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x0009 }
                r2.clear()     // Catch:{ all -> 0x0009 }
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                java.util.Iterator r0 = r1.iterator()
            L_0x001f:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0031
                java.lang.Object r1 = r0.next()
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r1 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r1
                rx.Observer<T> r1 = r1.consumer
                r1.onError(r4)
                goto L_0x001f
            L_0x0031:
                rx.Subscriber<? super rx.Observable<T>> r0 = r3.child
                r0.onError(r4)
                return
            L_0x0037:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.onError(java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
            if (r0.hasNext() == false) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
            r1 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r0.next();
            r1.consumer.onNext(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
            if (r1.count != r5.this$0.size) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            r1.consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.guard
                monitor-enter(r0)
                boolean r1 = r5.done     // Catch:{ all -> 0x0009 }
                if (r1 == 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r6 = move-exception
                goto L_0x0059
            L_0x000b:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0009 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r5.chunks     // Catch:{ all -> 0x0009 }
                r1.<init>(r2)     // Catch:{ all -> 0x0009 }
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r2 = r5.chunks     // Catch:{ all -> 0x0009 }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0009 }
            L_0x0018:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0009 }
                if (r3 == 0) goto L_0x0034
                java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0009 }
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r3 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r3     // Catch:{ all -> 0x0009 }
                int r4 = r3.count     // Catch:{ all -> 0x0009 }
                int r4 = r4 + 1
                r3.count = r4     // Catch:{ all -> 0x0009 }
                rx.internal.operators.OperatorWindowWithTime r3 = rx.internal.operators.OperatorWindowWithTime.this     // Catch:{ all -> 0x0009 }
                int r3 = r3.size     // Catch:{ all -> 0x0009 }
                if (r4 != r3) goto L_0x0018
                r2.remove()     // Catch:{ all -> 0x0009 }
                goto L_0x0018
            L_0x0034:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                java.util.Iterator r0 = r1.iterator()
            L_0x0039:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0058
                java.lang.Object r1 = r0.next()
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r1 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r1
                rx.Observer<T> r2 = r1.consumer
                r2.onNext(r6)
                int r2 = r1.count
                rx.internal.operators.OperatorWindowWithTime r3 = rx.internal.operators.OperatorWindowWithTime.this
                int r3 = r3.size
                if (r2 != r3) goto L_0x0039
                rx.Observer<T> r1 = r1.consumer
                r1.onCompleted()
                goto L_0x0039
            L_0x0058:
                return
            L_0x0059:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.onNext(java.lang.Object):void");
        }

        public void onStart() {
            request(LocationRequestCompat.PASSIVE_INTERVAL);
        }

        public void scheduleChunk() {
            Scheduler.Worker worker2 = this.worker;
            AnonymousClass1 r1 = new Action0() {
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            };
            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
            long j = operatorWindowWithTime.timeshift;
            worker2.schedulePeriodically(r1, j, j, operatorWindowWithTime.unit);
        }

        public void startNewChunk() {
            final CountedSerializedSubject createCountedSerializedSubject = createCountedSerializedSubject();
            synchronized (this.guard) {
                try {
                    if (!this.done) {
                        this.chunks.add(createCountedSerializedSubject);
                        try {
                            this.child.onNext(createCountedSerializedSubject.producer);
                            Scheduler.Worker worker2 = this.worker;
                            AnonymousClass2 r2 = new Action0() {
                                public void call() {
                                    InexactSubscriber.this.terminateChunk(createCountedSerializedSubject);
                                }
                            };
                            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
                            worker2.schedule(r2, operatorWindowWithTime.timespan, operatorWindowWithTime.unit);
                        } catch (Throwable th) {
                            onError(th);
                        }
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
            if (r1 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            r4.consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void terminateChunk(rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject<T> r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0009 }
                if (r1 == 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r4 = move-exception
                goto L_0x002e
            L_0x000b:
                java.util.List<rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject<T>> r1 = r3.chunks     // Catch:{ all -> 0x0009 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0009 }
            L_0x0011:
                boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0009 }
                if (r2 == 0) goto L_0x0024
                java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0009 }
                rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject r2 = (rx.internal.operators.OperatorWindowWithTime.CountedSerializedSubject) r2     // Catch:{ all -> 0x0009 }
                if (r2 != r4) goto L_0x0011
                r1.remove()     // Catch:{ all -> 0x0009 }
                r1 = 1
                goto L_0x0025
            L_0x0024:
                r1 = 0
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                if (r1 == 0) goto L_0x002d
                rx.Observer<T> r4 = r4.consumer
                r4.onCompleted()
            L_0x002d:
                return
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.terminateChunk(rx.internal.operators.OperatorWindowWithTime$CountedSerializedSubject):void");
        }
    }

    public static final class State<T> {
        static final State<Object> EMPTY = new State<>((Observer) null, (Observable) null, 0);
        final Observer<T> consumer;
        final int count;
        final Observable<T> producer;

        public State(Observer<T> observer, Observable<T> observable, int i) {
            this.consumer = observer;
            this.producer = observable;
            this.count = i;
        }

        public static <T> State<T> empty() {
            return EMPTY;
        }

        public State<T> clear() {
            return empty();
        }

        public State<T> create(Observer<T> observer, Observable<T> observable) {
            return new State<>(observer, observable, 0);
        }

        public State<T> next() {
            return new State<>(this.consumer, this.producer, this.count + 1);
        }
    }

    public OperatorWindowWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler2) {
        this.timespan = j;
        this.timeshift = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(subscriber, createWorker);
            exactSubscriber.add(createWorker);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(subscriber, createWorker);
        inexactSubscriber.add(createWorker);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }
}
