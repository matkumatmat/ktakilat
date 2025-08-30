package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {

    public static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;
        public final FlowableSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public final AtomicThrowable e = new AtomicThrowable();
        public final ConcatMapMaybeObserver f = new ConcatMapMaybeObserver(this);
        public final SpscArrayQueue g = new SpscArrayQueue(0);
        public Subscription i;
        public volatile boolean j;
        public volatile boolean k;
        public long l;
        public int m;
        public Object n;
        public volatile int o;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapMaybeSubscriber c;

            public ConcatMapMaybeObserver(ConcatMapMaybeSubscriber concatMapMaybeSubscriber) {
                this.c = concatMapMaybeSubscriber;
            }

            public final void onComplete() {
                ConcatMapMaybeSubscriber concatMapMaybeSubscriber = this.c;
                concatMapMaybeSubscriber.o = 0;
                concatMapMaybeSubscriber.a();
            }

            public final void onError(Throwable th) {
                ConcatMapMaybeSubscriber concatMapMaybeSubscriber = this.c;
                if (concatMapMaybeSubscriber.e.addThrowable(th)) {
                    if (ErrorMode.END != null) {
                        concatMapMaybeSubscriber.i.cancel();
                    }
                    concatMapMaybeSubscriber.o = 0;
                    concatMapMaybeSubscriber.a();
                    return;
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public final void onSuccess(Object obj) {
                ConcatMapMaybeSubscriber concatMapMaybeSubscriber = this.c;
                concatMapMaybeSubscriber.n = obj;
                concatMapMaybeSubscriber.o = 2;
                concatMapMaybeSubscriber.a();
            }
        }

        public ConcatMapMaybeSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                FlowableSubscriber flowableSubscriber = this.c;
                SpscArrayQueue spscArrayQueue = this.g;
                AtomicThrowable atomicThrowable = this.e;
                AtomicLong atomicLong = this.d;
                int i2 = 1;
                while (true) {
                    if (this.k) {
                        spscArrayQueue.clear();
                        this.n = null;
                    } else {
                        int i3 = this.o;
                        if (atomicThrowable.get() == null || !(ErrorMode.IMMEDIATE == null || (ErrorMode.BOUNDARY == null && i3 == 0))) {
                            if (i3 == 0) {
                                boolean z2 = this.j;
                                if (spscArrayQueue.poll() == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z2 && z) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        flowableSubscriber.onComplete();
                                        return;
                                    } else {
                                        flowableSubscriber.onError(terminate);
                                        return;
                                    }
                                } else if (!z) {
                                    int i4 = this.m + 1;
                                    if (i4 == 0) {
                                        this.m = 0;
                                        this.i.request((long) 0);
                                    } else {
                                        this.m = i4;
                                    }
                                    try {
                                        throw null;
                                    } catch (Throwable th) {
                                        Exceptions.a(th);
                                        this.i.cancel();
                                        spscArrayQueue.clear();
                                        atomicThrowable.addThrowable(th);
                                        flowableSubscriber.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                long j2 = this.l;
                                if (j2 != atomicLong.get()) {
                                    Object obj = this.n;
                                    this.n = null;
                                    flowableSubscriber.onNext(obj);
                                    this.l = j2 + 1;
                                    this.o = 0;
                                }
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                spscArrayQueue.clear();
                this.n = null;
                flowableSubscriber.onError(atomicThrowable.terminate());
            }
        }

        public final void cancel() {
            this.k = true;
            this.i.cancel();
            ConcatMapMaybeObserver concatMapMaybeObserver = this.f;
            concatMapMaybeObserver.getClass();
            DisposableHelper.dispose(concatMapMaybeObserver);
            if (getAndIncrement() == 0) {
                this.g.clear();
                this.n = null;
            }
        }

        public final void onComplete() {
            this.j = true;
            a();
        }

        public final void onError(Throwable th) {
            if (this.e.addThrowable(th)) {
                if (ErrorMode.IMMEDIATE == null) {
                    ConcatMapMaybeObserver concatMapMaybeObserver = this.f;
                    concatMapMaybeObserver.getClass();
                    DisposableHelper.dispose(concatMapMaybeObserver);
                }
                this.j = true;
                a();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (!this.g.offer(obj)) {
                this.i.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            a();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.c.onSubscribe(this);
                subscription.request((long) 0);
            }
        }

        public final void request(long j2) {
            BackpressureHelper.a(this.d, j2);
            a();
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        new ConcatMapMaybeSubscriber(flowableSubscriber);
        throw null;
    }
}
