package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        public final FlowableSubscriber c;
        public final AtomicReference d = new AtomicReference();
        public final OtherObserver e = new OtherObserver(this);
        public final AtomicThrowable f = new AtomicThrowable();
        public final AtomicLong g = new AtomicLong();
        public final int i;
        public final int j;
        public volatile SpscArrayQueue k;
        public Object l;
        public volatile boolean m;
        public volatile boolean n;
        public volatile int o;
        public long p;
        public int q;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver c;

            public OtherObserver(MergeWithObserver mergeWithObserver) {
                this.c = mergeWithObserver;
            }

            public final void onComplete() {
                MergeWithObserver mergeWithObserver = this.c;
                mergeWithObserver.o = 2;
                if (mergeWithObserver.getAndIncrement() == 0) {
                    mergeWithObserver.a();
                }
            }

            public final void onError(Throwable th) {
                MergeWithObserver mergeWithObserver = this.c;
                if (mergeWithObserver.f.addThrowable(th)) {
                    SubscriptionHelper.cancel(mergeWithObserver.d);
                    if (mergeWithObserver.getAndIncrement() == 0) {
                        mergeWithObserver.a();
                        return;
                    }
                    return;
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onSuccess(Object obj) {
                MergeWithObserver mergeWithObserver = this.c;
                if (mergeWithObserver.compareAndSet(0, 1)) {
                    long j = mergeWithObserver.p;
                    if (mergeWithObserver.g.get() != j) {
                        mergeWithObserver.p = j + 1;
                        mergeWithObserver.c.onNext(obj);
                        mergeWithObserver.o = 2;
                    } else {
                        mergeWithObserver.l = obj;
                        mergeWithObserver.o = 1;
                        if (mergeWithObserver.decrementAndGet() == 0) {
                            return;
                        }
                    }
                } else {
                    mergeWithObserver.l = obj;
                    mergeWithObserver.o = 1;
                    if (mergeWithObserver.getAndIncrement() != 0) {
                        return;
                    }
                }
                mergeWithObserver.a();
            }
        }

        public MergeWithObserver(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
            int i2 = Flowable.c;
            this.i = i2;
            this.j = i2 - (i2 >> 2);
        }

        public final void a() {
            int i2;
            boolean z;
            Object obj;
            boolean z2;
            FlowableSubscriber flowableSubscriber = this.c;
            long j2 = this.p;
            int i3 = this.q;
            int i4 = this.j;
            int i5 = 1;
            int i6 = 1;
            while (true) {
                long j3 = this.g.get();
                while (true) {
                    i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.m) {
                        this.l = null;
                        this.k = null;
                        return;
                    } else if (this.f.get() != null) {
                        this.l = null;
                        this.k = null;
                        flowableSubscriber.onError(this.f.terminate());
                        return;
                    } else {
                        int i7 = this.o;
                        if (i7 == i5) {
                            Object obj2 = this.l;
                            this.l = null;
                            this.o = 2;
                            flowableSubscriber.onNext(obj2);
                            j2++;
                        } else {
                            boolean z3 = this.n;
                            SpscArrayQueue spscArrayQueue = this.k;
                            if (spscArrayQueue != null) {
                                obj = spscArrayQueue.poll();
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z3 && z2 && i7 == 2) {
                                this.k = null;
                                flowableSubscriber.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                flowableSubscriber.onNext(obj);
                                j2++;
                                i3++;
                                if (i3 == i4) {
                                    ((Subscription) this.d.get()).request((long) i4);
                                    i3 = 0;
                                }
                                i5 = 1;
                            }
                        }
                    }
                }
                if (i2 == 0) {
                    if (this.m) {
                        this.l = null;
                        this.k = null;
                        return;
                    } else if (this.f.get() != null) {
                        this.l = null;
                        this.k = null;
                        flowableSubscriber.onError(this.f.terminate());
                        return;
                    } else {
                        boolean z4 = this.n;
                        SpscArrayQueue spscArrayQueue2 = this.k;
                        if (spscArrayQueue2 == null || spscArrayQueue2.isEmpty()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z4 && z && this.o == 2) {
                            this.k = null;
                            flowableSubscriber.onComplete();
                            return;
                        }
                    }
                }
                this.p = j2;
                this.q = i3;
                i6 = addAndGet(-i6);
                if (i6 != 0) {
                    i5 = 1;
                } else {
                    return;
                }
            }
        }

        public final void cancel() {
            this.m = true;
            SubscriptionHelper.cancel(this.d);
            DisposableHelper.dispose(this.e);
            if (getAndIncrement() == 0) {
                this.k = null;
                this.l = null;
            }
        }

        public final void onComplete() {
            this.n = true;
            if (getAndIncrement() == 0) {
                a();
            }
        }

        public final void onError(Throwable th) {
            if (this.f.addThrowable(th)) {
                SubscriptionHelper.cancel(this.d);
                if (getAndIncrement() == 0) {
                    a();
                    return;
                }
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (compareAndSet(0, 1)) {
                long j2 = this.p;
                if (this.g.get() != j2) {
                    SpscArrayQueue spscArrayQueue = this.k;
                    if (spscArrayQueue == null || spscArrayQueue.isEmpty()) {
                        this.p = j2 + 1;
                        this.c.onNext(obj);
                        int i2 = this.q + 1;
                        if (i2 == this.j) {
                            this.q = 0;
                            ((Subscription) this.d.get()).request((long) i2);
                        } else {
                            this.q = i2;
                        }
                    } else {
                        spscArrayQueue.offer(obj);
                    }
                } else {
                    SpscArrayQueue spscArrayQueue2 = this.k;
                    if (spscArrayQueue2 == null) {
                        spscArrayQueue2 = new SpscArrayQueue(Flowable.c);
                        this.k = spscArrayQueue2;
                    }
                    spscArrayQueue2.offer(obj);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SpscArrayQueue spscArrayQueue3 = this.k;
                if (spscArrayQueue3 == null) {
                    spscArrayQueue3 = new SpscArrayQueue(Flowable.c);
                    this.k = spscArrayQueue3;
                }
                spscArrayQueue3.offer(obj);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            a();
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.d, subscription, (long) this.i);
        }

        public final void request(long j2) {
            BackpressureHelper.a(this.g, j2);
            if (getAndIncrement() == 0) {
                a();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(flowableSubscriber);
        flowableSubscriber.onSubscribe(mergeWithObserver);
        this.d.a(mergeWithObserver);
        throw null;
    }
}
