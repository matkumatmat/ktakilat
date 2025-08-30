package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;

public final class OperatorWindowWithObservable<T, U> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    final Observable<U> other;

    public static final class BoundarySubscriber<T, U> extends Subscriber<U> {
        final SourceSubscriber<T> sub;

        public BoundarySubscriber(SourceSubscriber<T> sourceSubscriber) {
            this.sub = sourceSubscriber;
        }

        public void onCompleted() {
            this.sub.onCompleted();
        }

        public void onError(Throwable th) {
            this.sub.onError(th);
        }

        public void onNext(U u) {
            this.sub.replaceWindow();
        }

        public void onStart() {
            request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public static final class SourceSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        Observer<T> consumer;
        boolean emitting;
        final Object guard = new Object();
        Observable<T> producer;
        List<Object> queue;

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber) {
            this.child = new SerializedSubscriber(subscriber);
        }

        public void complete() {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        public void createNewWindow() {
            UnicastSubject create = UnicastSubject.create();
            this.consumer = create;
            this.producer = create;
        }

        public void drain(List<Object> list) {
            if (list != null) {
                for (Object next : list) {
                    if (next == OperatorWindowWithObservable.NEXT_SUBJECT) {
                        replaceSubject();
                    } else if (NotificationLite.isError(next)) {
                        error(NotificationLite.getError(next));
                        return;
                    } else if (NotificationLite.isCompleted(next)) {
                        complete();
                        return;
                    } else {
                        emitValue(next);
                    }
                }
            }
        }

        public void emitValue(T t) {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onNext(t);
            }
        }

        public void error(Throwable th) {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
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

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            drain(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            if (r0 == false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
            emitValue(r7);
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
            r1 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r5 = r6.queue;
            r6.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
            if (r5 != null) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x003d, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0040, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0041, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0043, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0044, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x004d, code lost:
            if (r6.child.isUnsubscribed() == false) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x004f, code lost:
            r1 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0051, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0054, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0055, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0059, code lost:
            r1 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            throw r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x005d, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x005e, code lost:
            if (r3 == false) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0062, code lost:
            monitor-enter(r6.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x006a, code lost:
            throw r7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.guard
                monitor-enter(r0)
                boolean r1 = r6.emitting     // Catch:{ all -> 0x0013 }
                if (r1 == 0) goto L_0x001c
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0013 }
                if (r1 != 0) goto L_0x0015
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0013 }
                r1.<init>()     // Catch:{ all -> 0x0013 }
                r6.queue = r1     // Catch:{ all -> 0x0013 }
                goto L_0x0015
            L_0x0013:
                r7 = move-exception
                goto L_0x006b
            L_0x0015:
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0013 }
                r1.add(r7)     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                return
            L_0x001c:
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0013 }
                r2 = 0
                r6.queue = r2     // Catch:{ all -> 0x0013 }
                r3 = 1
                r6.emitting = r3     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                r0 = 1
            L_0x0026:
                r4 = 0
                r6.drain(r1)     // Catch:{ all -> 0x0031 }
                if (r0 == 0) goto L_0x0034
                r6.emitValue(r7)     // Catch:{ all -> 0x0031 }
                r0 = 0
                goto L_0x0034
            L_0x0031:
                r7 = move-exception
                r3 = 0
                goto L_0x005e
            L_0x0034:
                java.lang.Object r1 = r6.guard     // Catch:{ all -> 0x0031 }
                monitor-enter(r1)     // Catch:{ all -> 0x0031 }
                java.util.List<java.lang.Object> r5 = r6.queue     // Catch:{ all -> 0x0043 }
                r6.queue = r2     // Catch:{ all -> 0x0043 }
                if (r5 != 0) goto L_0x0046
                r6.emitting = r4     // Catch:{ all -> 0x0043 }
                monitor-exit(r1)     // Catch:{ all -> 0x0041 }
                return
            L_0x0041:
                r7 = move-exception
                goto L_0x005b
            L_0x0043:
                r7 = move-exception
                r3 = 0
                goto L_0x005b
            L_0x0046:
                monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                rx.Subscriber<? super rx.Observable<T>> r1 = r6.child     // Catch:{ all -> 0x0031 }
                boolean r1 = r1.isUnsubscribed()     // Catch:{ all -> 0x0031 }
                if (r1 == 0) goto L_0x0059
                java.lang.Object r1 = r6.guard
                monitor-enter(r1)
                r6.emitting = r4     // Catch:{ all -> 0x0056 }
                monitor-exit(r1)     // Catch:{ all -> 0x0056 }
                return
            L_0x0056:
                r7 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0056 }
                throw r7
            L_0x0059:
                r1 = r5
                goto L_0x0026
            L_0x005b:
                monitor-exit(r1)     // Catch:{ all -> 0x0041 }
                throw r7     // Catch:{ all -> 0x005d }
            L_0x005d:
                r7 = move-exception
            L_0x005e:
                if (r3 != 0) goto L_0x006a
                java.lang.Object r0 = r6.guard
                monitor-enter(r0)
                r6.emitting = r4     // Catch:{ all -> 0x0067 }
                monitor-exit(r0)     // Catch:{ all -> 0x0067 }
                goto L_0x006a
            L_0x0067:
                r7 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0067 }
                throw r7
            L_0x006a:
                throw r7
            L_0x006b:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithObservable.SourceSubscriber.onNext(java.lang.Object):void");
        }

        public void onStart() {
            request(LocationRequestCompat.PASSIVE_INTERVAL);
        }

        public void replaceSubject() {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            createNewWindow();
            this.child.onNext(this.producer);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            drain(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
            if (r0 == false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
            replaceSubject();
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            r1 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r5 = r6.queue;
            r6.queue = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003d, code lost:
            if (r5 != null) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x003f, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0042, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0043, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0045, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0046, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x004f, code lost:
            if (r6.child.isUnsubscribed() == false) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0051, code lost:
            r1 = r6.guard;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0053, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0056, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0057, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x005b, code lost:
            r1 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x005f, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0060, code lost:
            if (r3 == false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0064, code lost:
            monitor-enter(r6.guard);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            r6.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x006c, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replaceWindow() {
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
                java.lang.Object r2 = rx.internal.operators.OperatorWindowWithObservable.NEXT_SUBJECT     // Catch:{ all -> 0x0013 }
                r1.add(r2)     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                return
            L_0x001e:
                java.util.List<java.lang.Object> r1 = r6.queue     // Catch:{ all -> 0x0013 }
                r2 = 0
                r6.queue = r2     // Catch:{ all -> 0x0013 }
                r3 = 1
                r6.emitting = r3     // Catch:{ all -> 0x0013 }
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                r0 = 1
            L_0x0028:
                r4 = 0
                r6.drain(r1)     // Catch:{ all -> 0x0033 }
                if (r0 == 0) goto L_0x0036
                r6.replaceSubject()     // Catch:{ all -> 0x0033 }
                r0 = 0
                goto L_0x0036
            L_0x0033:
                r0 = move-exception
                r3 = 0
                goto L_0x0060
            L_0x0036:
                java.lang.Object r1 = r6.guard     // Catch:{ all -> 0x0033 }
                monitor-enter(r1)     // Catch:{ all -> 0x0033 }
                java.util.List<java.lang.Object> r5 = r6.queue     // Catch:{ all -> 0x0045 }
                r6.queue = r2     // Catch:{ all -> 0x0045 }
                if (r5 != 0) goto L_0x0048
                r6.emitting = r4     // Catch:{ all -> 0x0045 }
                monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                return
            L_0x0043:
                r0 = move-exception
                goto L_0x005d
            L_0x0045:
                r0 = move-exception
                r3 = 0
                goto L_0x005d
            L_0x0048:
                monitor-exit(r1)     // Catch:{ all -> 0x0045 }
                rx.Subscriber<? super rx.Observable<T>> r1 = r6.child     // Catch:{ all -> 0x0033 }
                boolean r1 = r1.isUnsubscribed()     // Catch:{ all -> 0x0033 }
                if (r1 == 0) goto L_0x005b
                java.lang.Object r1 = r6.guard
                monitor-enter(r1)
                r6.emitting = r4     // Catch:{ all -> 0x0058 }
                monitor-exit(r1)     // Catch:{ all -> 0x0058 }
                return
            L_0x0058:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0058 }
                throw r0
            L_0x005b:
                r1 = r5
                goto L_0x0028
            L_0x005d:
                monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                throw r0     // Catch:{ all -> 0x005f }
            L_0x005f:
                r0 = move-exception
            L_0x0060:
                if (r3 != 0) goto L_0x006c
                java.lang.Object r1 = r6.guard
                monitor-enter(r1)
                r6.emitting = r4     // Catch:{ all -> 0x0069 }
                monitor-exit(r1)     // Catch:{ all -> 0x0069 }
                goto L_0x006c
            L_0x0069:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0069 }
                throw r0
            L_0x006c:
                throw r0
            L_0x006d:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithObservable.SourceSubscriber.replaceWindow():void");
        }
    }

    public OperatorWindowWithObservable(Observable<U> observable) {
        this.other = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber);
        BoundarySubscriber boundarySubscriber = new BoundarySubscriber(sourceSubscriber);
        subscriber.add(sourceSubscriber);
        subscriber.add(boundarySubscriber);
        sourceSubscriber.replaceWindow();
        this.other.unsafeSubscribe(boundarySubscriber);
        return sourceSubscriber;
    }
}
