package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;

public final class OperatorBufferWithStartEndObservable<T, TOpening, TClosing> implements Observable.Operator<List<T>, T> {
    final Func1<? super TOpening, ? extends Observable<? extends TClosing>> bufferClosing;
    final Observable<? extends TOpening> bufferOpening;

    public final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        final List<List<T>> chunks = new LinkedList();
        final CompositeSubscription closingSubscriptions;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.closingSubscriptions = compositeSubscription;
            add(compositeSubscription);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
            r2.child.onNext(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void endBuffer(java.util.List<T> r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.done     // Catch:{ all -> 0x0007 }
                if (r0 == 0) goto L_0x0009
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r3 = move-exception
                goto L_0x002c
            L_0x0009:
                java.util.List<java.util.List<T>> r0 = r2.chunks     // Catch:{ all -> 0x0007 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0007 }
            L_0x000f:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0007 }
                if (r1 == 0) goto L_0x0022
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0007 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0007 }
                if (r1 != r3) goto L_0x000f
                r0.remove()     // Catch:{ all -> 0x0007 }
                r0 = 1
                goto L_0x0023
            L_0x0022:
                r0 = 0
            L_0x0023:
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                if (r0 == 0) goto L_0x002b
                rx.Subscriber<? super java.util.List<T>> r0 = r2.child
                r0.onNext(r3)
            L_0x002b:
                return
            L_0x002c:
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber.endBuffer(java.util.List):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r0 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            if (r0.hasNext() == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            r3.child.onNext((java.util.List) r0.next());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
            r3.child.onCompleted();
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCompleted() {
            /*
                r3 = this;
                monitor-enter(r3)     // Catch:{ all -> 0x002f }
                boolean r0 = r3.done     // Catch:{ all -> 0x0007 }
                if (r0 == 0) goto L_0x0009
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r0 = move-exception
                goto L_0x003a
            L_0x0009:
                r0 = 1
                r3.done = r0     // Catch:{ all -> 0x0007 }
                java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x0007 }
                java.util.List<java.util.List<T>> r1 = r3.chunks     // Catch:{ all -> 0x0007 }
                r0.<init>(r1)     // Catch:{ all -> 0x0007 }
                java.util.List<java.util.List<T>> r1 = r3.chunks     // Catch:{ all -> 0x0007 }
                r1.clear()     // Catch:{ all -> 0x0007 }
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002f }
            L_0x001d:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x002f }
                if (r1 == 0) goto L_0x0031
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x002f }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x002f }
                rx.Subscriber<? super java.util.List<T>> r2 = r3.child     // Catch:{ all -> 0x002f }
                r2.onNext(r1)     // Catch:{ all -> 0x002f }
                goto L_0x001d
            L_0x002f:
                r0 = move-exception
                goto L_0x003c
            L_0x0031:
                rx.Subscriber<? super java.util.List<T>> r0 = r3.child
                r0.onCompleted()
                r3.unsubscribe()
                return
            L_0x003a:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                throw r0     // Catch:{ all -> 0x002f }
            L_0x003c:
                rx.Subscriber<? super java.util.List<T>> r1 = r3.child
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r0, (rx.Observer<?>) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber.onCompleted():void");
        }

        public void onError(Throwable th) {
            synchronized (this) {
                try {
                    if (!this.done) {
                        this.done = true;
                        this.chunks.clear();
                        this.child.onError(th);
                        unsubscribe();
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    for (List<T> add : this.chunks) {
                        add.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void startBuffer(TOpening topening) {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                try {
                    if (!this.done) {
                        this.chunks.add(arrayList);
                        try {
                            Observable observable = (Observable) OperatorBufferWithStartEndObservable.this.bufferClosing.call(topening);
                            AnonymousClass1 r1 = new Subscriber<TClosing>() {
                                public void onCompleted() {
                                    BufferingSubscriber.this.closingSubscriptions.remove(this);
                                    BufferingSubscriber.this.endBuffer(arrayList);
                                }

                                public void onError(Throwable th) {
                                    BufferingSubscriber.this.onError(th);
                                }

                                public void onNext(TClosing tclosing) {
                                    BufferingSubscriber.this.closingSubscriptions.remove(this);
                                    BufferingSubscriber.this.endBuffer(arrayList);
                                }
                            };
                            this.closingSubscriptions.add(r1);
                            observable.unsafeSubscribe(r1);
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, (Observer<?>) this);
                        }
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
        }
    }

    public OperatorBufferWithStartEndObservable(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        this.bufferOpening = observable;
        this.bufferClosing = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
        AnonymousClass1 r1 = new Subscriber<TOpening>() {
            public void onCompleted() {
                bufferingSubscriber.onCompleted();
            }

            public void onError(Throwable th) {
                bufferingSubscriber.onError(th);
            }

            public void onNext(TOpening topening) {
                bufferingSubscriber.startBuffer(topening);
            }
        };
        subscriber.add(r1);
        subscriber.add(bufferingSubscriber);
        this.bufferOpening.unsafeSubscribe(r1);
        return bufferingSubscriber;
    }
}
