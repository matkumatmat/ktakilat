package rx.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Beta;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

@Beta
public abstract class AsyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {

    public static final class AsyncOuterManager<S, T> implements Producer, Subscription, Observer<Observable<? extends T>> {
        Producer concatProducer;
        boolean emitting;
        long expectedDelivery;
        private boolean hasTerminated;
        final AtomicBoolean isUnsubscribed;
        private final UnicastSubject<Observable<T>> merger;
        private boolean onNextCalled;
        private final AsyncOnSubscribe<S, T> parent;
        List<Long> requests;
        private final SerializedObserver<Observable<? extends T>> serializedSubscriber;
        private S state;
        final CompositeSubscription subscriptions = new CompositeSubscription();

        public AsyncOuterManager(AsyncOnSubscribe<S, T> asyncOnSubscribe, S s, UnicastSubject<Observable<T>> unicastSubject) {
            this.parent = asyncOnSubscribe;
            this.serializedSubscriber = new SerializedObserver<>(this);
            this.state = s;
            this.merger = unicastSubject;
            this.isUnsubscribed = new AtomicBoolean();
        }

        private void handleThrownError(Throwable th) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(th);
                return;
            }
            this.hasTerminated = true;
            this.merger.onError(th);
            cleanup();
        }

        private void subscribeBufferToObservable(Observable<? extends T> observable) {
            BufferUntilSubscriber create = BufferUntilSubscriber.create();
            final AnonymousClass1 r3 = new Subscriber<T>(this.expectedDelivery, create) {
                long remaining;
                final /* synthetic */ BufferUntilSubscriber val$buffer;
                final /* synthetic */ long val$expected;

                {
                    this.val$expected = r2;
                    this.val$buffer = r4;
                    this.remaining = r2;
                }

                public void onCompleted() {
                    this.val$buffer.onCompleted();
                    long j = this.remaining;
                    if (j > 0) {
                        AsyncOuterManager.this.requestRemaining(j);
                    }
                }

                public void onError(Throwable th) {
                    this.val$buffer.onError(th);
                }

                public void onNext(T t) {
                    this.remaining--;
                    this.val$buffer.onNext(t);
                }
            };
            this.subscriptions.add(r3);
            observable.doOnTerminate(new Action0() {
                public void call() {
                    AsyncOuterManager.this.subscriptions.remove(r3);
                }
            }).subscribe(r3);
            this.merger.onNext(create);
        }

        public void cleanup() {
            this.subscriptions.unsubscribe();
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable th) {
                handleThrownError(th);
            }
        }

        public boolean isUnsubscribed() {
            return this.isUnsubscribed.get();
        }

        public void nextIteration(long j) {
            this.state = this.parent.next(this.state, j, this.serializedSubscriber);
        }

        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public void onError(Throwable th) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onError(th);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0048, code lost:
            r5 = r5.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0050, code lost:
            if (r5.hasNext() == false) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0060, code lost:
            if (tryEmit(r5.next().longValue()) == false) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0062, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void request(long r5) {
            /*
                r4 = this;
                r0 = 0
                int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0007
                return
            L_0x0007:
                if (r2 < 0) goto L_0x0067
                monitor-enter(r4)
                boolean r0 = r4.emitting     // Catch:{ all -> 0x001c }
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0026
                java.util.List<java.lang.Long> r0 = r4.requests     // Catch:{ all -> 0x001c }
                if (r0 != 0) goto L_0x001e
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x001c }
                r0.<init>()     // Catch:{ all -> 0x001c }
                r4.requests = r0     // Catch:{ all -> 0x001c }
                goto L_0x001e
            L_0x001c:
                r5 = move-exception
                goto L_0x0065
            L_0x001e:
                java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x001c }
                r0.add(r3)     // Catch:{ all -> 0x001c }
                goto L_0x0029
            L_0x0026:
                r4.emitting = r1     // Catch:{ all -> 0x001c }
                r1 = 0
            L_0x0029:
                monitor-exit(r4)     // Catch:{ all -> 0x001c }
                rx.Producer r0 = r4.concatProducer
                r0.request(r5)
                if (r1 == 0) goto L_0x0032
                return
            L_0x0032:
                boolean r5 = r4.tryEmit(r5)
                if (r5 == 0) goto L_0x0039
                return
            L_0x0039:
                monitor-enter(r4)
                java.util.List<java.lang.Long> r5 = r4.requests     // Catch:{ all -> 0x0042 }
                if (r5 != 0) goto L_0x0044
                r4.emitting = r2     // Catch:{ all -> 0x0042 }
                monitor-exit(r4)     // Catch:{ all -> 0x0042 }
                return
            L_0x0042:
                r5 = move-exception
                goto L_0x0063
            L_0x0044:
                r6 = 0
                r4.requests = r6     // Catch:{ all -> 0x0042 }
                monitor-exit(r4)     // Catch:{ all -> 0x0042 }
                java.util.Iterator r5 = r5.iterator()
            L_0x004c:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L_0x0039
                java.lang.Object r6 = r5.next()
                java.lang.Long r6 = (java.lang.Long) r6
                long r0 = r6.longValue()
                boolean r6 = r4.tryEmit(r0)
                if (r6 == 0) goto L_0x004c
                return
            L_0x0063:
                monitor-exit(r4)     // Catch:{ all -> 0x0042 }
                throw r5
            L_0x0065:
                monitor-exit(r4)     // Catch:{ all -> 0x001c }
                throw r5
            L_0x0067:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Request can't be negative! "
                java.lang.String r5 = defpackage.e.j(r5, r1)
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.observables.AsyncOnSubscribe.AsyncOuterManager.request(long):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
            if (tryEmit(r4) == false) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r4 = r3.requests;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0033, code lost:
            if (r4 != null) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0035, code lost:
            r3.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0038, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x003a, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x003c, code lost:
            r3.requests = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x003f, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0040, code lost:
            r4 = r4.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0048, code lost:
            if (r4.hasNext() == false) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
            if (tryEmit(r4.next().longValue()) == false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x005c, code lost:
            throw r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestRemaining(long r4) {
            /*
                r3 = this;
                r0 = 0
                int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0007
                return
            L_0x0007:
                if (r2 < 0) goto L_0x005f
                monitor-enter(r3)
                boolean r0 = r3.emitting     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x0025
                java.util.List<java.lang.Long> r0 = r3.requests     // Catch:{ all -> 0x001a }
                if (r0 != 0) goto L_0x001c
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x001a }
                r0.<init>()     // Catch:{ all -> 0x001a }
                r3.requests = r0     // Catch:{ all -> 0x001a }
                goto L_0x001c
            L_0x001a:
                r4 = move-exception
                goto L_0x005d
            L_0x001c:
                java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x001a }
                r0.add(r4)     // Catch:{ all -> 0x001a }
                monitor-exit(r3)     // Catch:{ all -> 0x001a }
                return
            L_0x0025:
                r0 = 1
                r3.emitting = r0     // Catch:{ all -> 0x001a }
                monitor-exit(r3)     // Catch:{ all -> 0x001a }
                boolean r4 = r3.tryEmit(r4)
                if (r4 == 0) goto L_0x0030
                return
            L_0x0030:
                monitor-enter(r3)
                java.util.List<java.lang.Long> r4 = r3.requests     // Catch:{ all -> 0x003a }
                if (r4 != 0) goto L_0x003c
                r4 = 0
                r3.emitting = r4     // Catch:{ all -> 0x003a }
                monitor-exit(r3)     // Catch:{ all -> 0x003a }
                return
            L_0x003a:
                r4 = move-exception
                goto L_0x005b
            L_0x003c:
                r5 = 0
                r3.requests = r5     // Catch:{ all -> 0x003a }
                monitor-exit(r3)     // Catch:{ all -> 0x003a }
                java.util.Iterator r4 = r4.iterator()
            L_0x0044:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L_0x0030
                java.lang.Object r5 = r4.next()
                java.lang.Long r5 = (java.lang.Long) r5
                long r0 = r5.longValue()
                boolean r5 = r3.tryEmit(r0)
                if (r5 == 0) goto L_0x0044
                return
            L_0x005b:
                monitor-exit(r3)     // Catch:{ all -> 0x003a }
                throw r4
            L_0x005d:
                monitor-exit(r3)     // Catch:{ all -> 0x001a }
                throw r4
            L_0x005f:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Request can't be negative! "
                java.lang.String r4 = defpackage.e.j(r4, r1)
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.observables.AsyncOnSubscribe.AsyncOuterManager.requestRemaining(long):void");
        }

        public void setConcatProducer(Producer producer) {
            if (this.concatProducer == null) {
                this.concatProducer = producer;
                return;
            }
            throw new IllegalStateException("setConcatProducer may be called at most once!");
        }

        public boolean tryEmit(long j) {
            if (isUnsubscribed()) {
                cleanup();
                return true;
            }
            try {
                this.onNextCalled = false;
                this.expectedDelivery = j;
                nextIteration(j);
                if (this.hasTerminated) {
                    if (this.subscriptions.hasSubscriptions()) {
                    }
                    cleanup();
                    return true;
                }
                if (!isUnsubscribed()) {
                    if (this.onNextCalled) {
                        return false;
                    }
                    handleThrownError(new IllegalStateException("No events emitted!"));
                    return true;
                }
                cleanup();
                return true;
            } catch (Throwable th) {
                handleThrownError(th);
                return true;
            }
        }

        public void unsubscribe() {
            if (this.isUnsubscribed.compareAndSet(false, true)) {
                synchronized (this) {
                    try {
                        if (this.emitting) {
                            ArrayList arrayList = new ArrayList();
                            this.requests = arrayList;
                            arrayList.add(0L);
                            return;
                        }
                        this.emitting = true;
                        cleanup();
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }

        public void onNext(Observable<? extends T> observable) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                if (!this.hasTerminated) {
                    subscribeBufferToObservable(observable);
                    return;
                }
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }
    }

    public static final class UnicastSubject<T> extends Observable<T> implements Observer<T> {
        private final State<T> state;

        public static final class State<T> implements Observable.OnSubscribe<T> {
            Subscriber<? super T> subscriber;

            public void call(Subscriber<? super T> subscriber2) {
                synchronized (this) {
                    try {
                        if (this.subscriber == null) {
                            this.subscriber = subscriber2;
                        } else {
                            subscriber2.onError(new IllegalStateException("There can be only one subscriber"));
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }

        public UnicastSubject(State<T> state2) {
            super(state2);
            this.state = state2;
        }

        public static <T> UnicastSubject<T> create() {
            return new UnicastSubject<>(new State());
        }

        public void onCompleted() {
            this.state.subscriber.onCompleted();
        }

        public void onError(Throwable th) {
            this.state.subscriber.onError(th);
        }

        public void onNext(T t) {
            this.state.subscriber.onNext(t);
        }
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            public S call(S s, Long l, Observer<Observable<? extends T>> observer) {
                action3.call(s, l, observer);
                return s;
            }
        });
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, func3, action1);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            public Void call(Void voidR, Long l, Observer<Observable<? extends T>> observer) {
                action2.call(l, observer);
                return voidR;
            }
        });
    }

    public abstract S generateState();

    public abstract S next(S s, long j, Observer<Observable<? extends T>> observer);

    public void onUnsubscribe(S s) {
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
        return new AsyncOnSubscribeImpl(func0, func3);
    }

    public final void call(final Subscriber<? super T> subscriber) {
        try {
            Object generateState = generateState();
            UnicastSubject create = UnicastSubject.create();
            final AsyncOuterManager asyncOuterManager = new AsyncOuterManager(this, generateState, create);
            AnonymousClass6 r0 = new Subscriber<T>() {
                public void onCompleted() {
                    subscriber.onCompleted();
                }

                public void onError(Throwable th) {
                    subscriber.onError(th);
                }

                public void onNext(T t) {
                    subscriber.onNext(t);
                }

                public void setProducer(Producer producer) {
                    asyncOuterManager.setConcatProducer(producer);
                }
            };
            create.onBackpressureBuffer().concatMap(new Func1<Observable<T>, Observable<T>>() {
                public Observable<T> call(Observable<T> observable) {
                    return observable.onBackpressureBuffer();
                }
            }).unsafeSubscribe(r0);
            subscriber.add(r0);
            subscriber.add(asyncOuterManager);
            subscriber.setProducer(asyncOuterManager);
        } catch (Throwable th) {
            subscriber.onError(th);
        }
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            public S call(S s, Long l, Observer<Observable<? extends T>> observer) {
                action3.call(s, l, observer);
                return s;
            }
        }, action1);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2, final Action0 action0) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            public Void call(Void voidR, Long l, Observer<Observable<? extends T>> observer) {
                action2.call(l, observer);
                return null;
            }
        }, new Action1<Void>() {
            public void call(Void voidR) {
                action0.call();
            }
        });
    }

    public static final class AsyncOnSubscribeImpl<S, T> extends AsyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
            this.generator = func0;
            this.next = func3;
            this.onUnsubscribe = action1;
        }

        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) obj);
        }

        public S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        public S next(S s, long j, Observer<Observable<? extends T>> observer) {
            return this.next.call(s, Long.valueOf(j), observer);
        }

        public void onUnsubscribe(S s) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(s);
            }
        }

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
            this(func0, func3, (Action1) null);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3, Action1<? super S> action1) {
            this((Func0) null, func3, action1);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3) {
            this((Func0) null, func3, (Action1) null);
        }
    }
}
