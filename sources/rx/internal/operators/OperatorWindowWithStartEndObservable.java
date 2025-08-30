package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.CompositeSubscription;

public final class OperatorWindowWithStartEndObservable<T, U, V> implements Observable.Operator<Observable<T>, T> {
    final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
    final Observable<? extends U> windowOpenings;

    public static final class SerializedSubject<T> {
        final Observer<T> consumer;
        final Observable<T> producer;

        public SerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    public final class SourceSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<SerializedSubject<T>> chunks = new LinkedList();
        final CompositeSubscription composite;
        boolean done;
        final Object guard = new Object();

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber, CompositeSubscription compositeSubscription) {
            this.child = new SerializedSubscriber(subscriber);
            this.composite = compositeSubscription;
        }

        public void beginWindow(U u) {
            final SerializedSubject createSerializedSubject = createSerializedSubject();
            synchronized (this.guard) {
                try {
                    if (!this.done) {
                        this.chunks.add(createSerializedSubject);
                        this.child.onNext(createSerializedSubject.producer);
                        try {
                            Observable observable = (Observable) OperatorWindowWithStartEndObservable.this.windowClosingSelector.call(u);
                            AnonymousClass1 r1 = new Subscriber<V>() {
                                boolean once = true;

                                public void onCompleted() {
                                    if (this.once) {
                                        this.once = false;
                                        SourceSubscriber.this.endWindow(createSerializedSubject);
                                        SourceSubscriber.this.composite.remove(this);
                                    }
                                }

                                public void onError(Throwable th) {
                                    SourceSubscriber.this.onError(th);
                                }

                                public void onNext(V v) {
                                    onCompleted();
                                }
                            };
                            this.composite.add(r1);
                            observable.unsafeSubscribe(r1);
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

        public SerializedSubject<T> createSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new SerializedSubject<>(create, create);
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
        public void endWindow(rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject<T> r4) {
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
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r1 = r3.chunks     // Catch:{ all -> 0x0009 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0009 }
            L_0x0011:
                boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0009 }
                if (r2 == 0) goto L_0x0024
                java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0009 }
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r2 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r2     // Catch:{ all -> 0x0009 }
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
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.endWindow(rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            if (r0.hasNext() == false) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
            ((rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r0.next()).consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
            r3.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
            r3.composite.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCompleted() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard     // Catch:{ all -> 0x0036 }
                monitor-enter(r0)     // Catch:{ all -> 0x0036 }
                boolean r1 = r3.done     // Catch:{ all -> 0x000e }
                if (r1 == 0) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                rx.subscriptions.CompositeSubscription r0 = r3.composite
                r0.unsubscribe()
                return
            L_0x000e:
                r1 = move-exception
                goto L_0x0043
            L_0x0010:
                r1 = 1
                r3.done = r1     // Catch:{ all -> 0x000e }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x000e }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x000e }
                r1.<init>(r2)     // Catch:{ all -> 0x000e }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x000e }
                r2.clear()     // Catch:{ all -> 0x000e }
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x0036 }
            L_0x0024:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0036 }
                if (r1 == 0) goto L_0x0038
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0036 }
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r1 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r1     // Catch:{ all -> 0x0036 }
                rx.Observer<T> r1 = r1.consumer     // Catch:{ all -> 0x0036 }
                r1.onCompleted()     // Catch:{ all -> 0x0036 }
                goto L_0x0024
            L_0x0036:
                r0 = move-exception
                goto L_0x0045
            L_0x0038:
                rx.Subscriber<? super rx.Observable<T>> r0 = r3.child     // Catch:{ all -> 0x0036 }
                r0.onCompleted()     // Catch:{ all -> 0x0036 }
                rx.subscriptions.CompositeSubscription r0 = r3.composite
                r0.unsubscribe()
                return
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                throw r1     // Catch:{ all -> 0x0036 }
            L_0x0045:
                rx.subscriptions.CompositeSubscription r1 = r3.composite
                r1.unsubscribe()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onCompleted():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            if (r0.hasNext() == false) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
            ((rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r0.next()).consumer.onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
            r3.child.onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
            r3.composite.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard     // Catch:{ all -> 0x0036 }
                monitor-enter(r0)     // Catch:{ all -> 0x0036 }
                boolean r1 = r3.done     // Catch:{ all -> 0x000e }
                if (r1 == 0) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                rx.subscriptions.CompositeSubscription r4 = r3.composite
                r4.unsubscribe()
                return
            L_0x000e:
                r4 = move-exception
                goto L_0x0043
            L_0x0010:
                r1 = 1
                r3.done = r1     // Catch:{ all -> 0x000e }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x000e }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x000e }
                r1.<init>(r2)     // Catch:{ all -> 0x000e }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x000e }
                r2.clear()     // Catch:{ all -> 0x000e }
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x0036 }
            L_0x0024:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0036 }
                if (r1 == 0) goto L_0x0038
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0036 }
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r1 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r1     // Catch:{ all -> 0x0036 }
                rx.Observer<T> r1 = r1.consumer     // Catch:{ all -> 0x0036 }
                r1.onError(r4)     // Catch:{ all -> 0x0036 }
                goto L_0x0024
            L_0x0036:
                r4 = move-exception
                goto L_0x0045
            L_0x0038:
                rx.Subscriber<? super rx.Observable<T>> r0 = r3.child     // Catch:{ all -> 0x0036 }
                r0.onError(r4)     // Catch:{ all -> 0x0036 }
                rx.subscriptions.CompositeSubscription r4 = r3.composite
                r4.unsubscribe()
                return
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                throw r4     // Catch:{ all -> 0x0036 }
            L_0x0045:
                rx.subscriptions.CompositeSubscription r0 = r3.composite
                r0.unsubscribe()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onError(java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            if (r0.hasNext() == false) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
            ((rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r0.next()).consumer.onNext(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r4) {
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
                goto L_0x002a
            L_0x000b:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0009 }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x0009 }
                r1.<init>(r2)     // Catch:{ all -> 0x0009 }
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                java.util.Iterator r0 = r1.iterator()
            L_0x0017:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0029
                java.lang.Object r1 = r0.next()
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r1 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r1
                rx.Observer<T> r1 = r1.consumer
                r1.onNext(r4)
                goto L_0x0017
            L_0x0029:
                return
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onNext(java.lang.Object):void");
        }

        public void onStart() {
            request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public OperatorWindowWithStartEndObservable(Observable<? extends U> observable, Func1<? super U, ? extends Observable<? extends V>> func1) {
        this.windowOpenings = observable;
        this.windowClosingSelector = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        subscriber.add(compositeSubscription);
        final SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber, compositeSubscription);
        AnonymousClass1 r3 = new Subscriber<U>() {
            public void onCompleted() {
                sourceSubscriber.onCompleted();
            }

            public void onError(Throwable th) {
                sourceSubscriber.onError(th);
            }

            public void onNext(U u) {
                sourceSubscriber.beginWindow(u);
            }

            public void onStart() {
                request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        };
        compositeSubscription.add(sourceSubscriber);
        compositeSubscription.add(r3);
        this.windowOpenings.unsafeSubscribe(r3);
        return sourceSubscriber;
    }
}
