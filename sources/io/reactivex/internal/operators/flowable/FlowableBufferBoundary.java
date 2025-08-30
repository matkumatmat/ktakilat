package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {

    public static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;
        public final FlowableSubscriber c;
        public final CompositeDisposable d = new Object();
        public final AtomicLong e = new AtomicLong();
        public final AtomicReference f = new AtomicReference();
        public final AtomicThrowable g = new AtomicThrowable();
        public volatile boolean i;
        public final SpscLinkedArrayQueue j = new SpscLinkedArrayQueue(Flowable.c);
        public volatile boolean k;
        public LinkedHashMap l = new LinkedHashMap();
        public long m;

        public static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            public final BufferBoundarySubscriber c;

            public BufferOpenSubscriber(BufferBoundarySubscriber bufferBoundarySubscriber) {
                this.c = bufferBoundarySubscriber;
            }

            public final void dispose() {
                SubscriptionHelper.cancel(this);
            }

            public final boolean isDisposed() {
                if (get() == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            }

            public final void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                BufferBoundarySubscriber bufferBoundarySubscriber = this.c;
                bufferBoundarySubscriber.d.c(this);
                if (bufferBoundarySubscriber.d.d() == 0) {
                    SubscriptionHelper.cancel(bufferBoundarySubscriber.f);
                    bufferBoundarySubscriber.i = true;
                    bufferBoundarySubscriber.b();
                }
            }

            public final void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                BufferBoundarySubscriber bufferBoundarySubscriber = this.c;
                SubscriptionHelper.cancel(bufferBoundarySubscriber.f);
                bufferBoundarySubscriber.d.c(this);
                bufferBoundarySubscriber.onError(th);
            }

            public final void onNext(Object obj) {
                BufferBoundarySubscriber bufferBoundarySubscriber = this.c;
                bufferBoundarySubscriber.getClass();
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    SubscriptionHelper.cancel(bufferBoundarySubscriber.f);
                    bufferBoundarySubscriber.onError(th);
                }
            }

            public final void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        /* JADX WARNING: type inference failed for: r2v2, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public BufferBoundarySubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            if (r4 == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
            r3.i = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferCloseSubscriber r4, long r5) {
            /*
                r3 = this;
                io.reactivex.disposables.CompositeDisposable r0 = r3.d
                r0.c(r4)
                io.reactivex.disposables.CompositeDisposable r4 = r3.d
                int r4 = r4.d()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference r4 = r3.f
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r4)
                r4 = 1
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.LinkedHashMap r1 = r3.l     // Catch:{ all -> 0x001d }
                if (r1 != 0) goto L_0x001f
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                return
            L_0x001d:
                r4 = move-exception
                goto L_0x0035
            L_0x001f:
                io.reactivex.internal.queue.SpscLinkedArrayQueue r2 = r3.j     // Catch:{ all -> 0x001d }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x001d }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x001d }
                r2.offer(r5)     // Catch:{ all -> 0x001d }
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                if (r4 == 0) goto L_0x0031
                r3.i = r0
            L_0x0031:
                r3.b()
                return
            L_0x0035:
                monitor-exit(r3)     // Catch:{ all -> 0x001d }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber.a(io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber, long):void");
        }

        public final void b() {
            int i2;
            boolean z;
            if (getAndIncrement() == 0) {
                long j2 = this.m;
                FlowableSubscriber flowableSubscriber = this.c;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.j;
                int i3 = 1;
                do {
                    long j3 = this.e.get();
                    while (true) {
                        i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.k) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z2 = this.i;
                            if (!z2 || this.g.get() == null) {
                                Collection collection = (Collection) spscLinkedArrayQueue.poll();
                                if (collection == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z2 && z) {
                                    flowableSubscriber.onComplete();
                                    return;
                                } else if (z) {
                                    break;
                                } else {
                                    flowableSubscriber.onNext(collection);
                                    j2++;
                                }
                            } else {
                                spscLinkedArrayQueue.clear();
                                flowableSubscriber.onError(this.g.terminate());
                                return;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (this.k) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else if (this.i) {
                            if (this.g.get() != null) {
                                spscLinkedArrayQueue.clear();
                                flowableSubscriber.onError(this.g.terminate());
                                return;
                            } else if (spscLinkedArrayQueue.isEmpty()) {
                                flowableSubscriber.onComplete();
                                return;
                            }
                        }
                    }
                    this.m = j2;
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public final void cancel() {
            if (SubscriptionHelper.cancel(this.f)) {
                this.k = true;
                this.d.dispose();
                synchronized (this) {
                    this.l = null;
                }
                if (getAndIncrement() != 0) {
                    this.j.clear();
                }
            }
        }

        public final void onComplete() {
            this.d.dispose();
            synchronized (this) {
                try {
                    LinkedHashMap linkedHashMap = this.l;
                    if (linkedHashMap != null) {
                        for (Collection offer : linkedHashMap.values()) {
                            this.j.offer(offer);
                        }
                        this.l = null;
                        this.i = true;
                        b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.g.addThrowable(th)) {
                this.d.dispose();
                synchronized (this) {
                    this.l = null;
                }
                this.i = true;
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            synchronized (this) {
                try {
                    LinkedHashMap linkedHashMap = this.l;
                    if (linkedHashMap != null) {
                        for (Collection add : linkedHashMap.values()) {
                            add.add(obj);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f, subscription)) {
                this.d.b(new BufferOpenSubscriber(this));
                throw null;
            }
        }

        public final void request(long j2) {
            BackpressureHelper.a(this.e, j2);
            b();
        }
    }

    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;

        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public final boolean isDisposed() {
            if (get() == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                throw null;
            }
        }

        public final void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj == subscriptionHelper) {
                RxJavaPlugins.b(th);
            } else {
                lazySet(subscriptionHelper);
                throw null;
            }
        }

        public final void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(flowableSubscriber);
        flowableSubscriber.onSubscribe(bufferBoundarySubscriber);
        this.d.a(bufferBoundarySubscriber);
    }
}
