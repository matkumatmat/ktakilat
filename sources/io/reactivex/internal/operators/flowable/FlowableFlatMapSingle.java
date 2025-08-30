package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapSingle<T, R> extends AbstractFlowableWithUpstream<T, R> {

    public static final class FlatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        public final FlowableSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public final CompositeDisposable e = new Object();
        public final AtomicInteger f = new AtomicInteger(1);
        public final AtomicThrowable g = new AtomicThrowable();
        public final AtomicReference i = new AtomicReference();
        public Subscription j;
        public volatile boolean k;

        public final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public final void dispose() {
                DisposableHelper.dispose(this);
            }

            public final boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public final void onError(Throwable th) {
                throw null;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onSuccess(Object obj) {
                throw null;
            }
        }

        /* JADX WARNING: type inference failed for: r2v2, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public FlatMapSingleSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.i.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        public final void b() {
            boolean z;
            int i2;
            boolean z2;
            boolean z3;
            Object obj;
            boolean z4;
            FlowableSubscriber flowableSubscriber = this.c;
            AtomicInteger atomicInteger = this.f;
            AtomicReference atomicReference = this.i;
            int i3 = 1;
            do {
                long j2 = this.d.get();
                long j3 = 0;
                while (true) {
                    z = false;
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.k) {
                        a();
                        return;
                    } else if (((Throwable) this.g.get()) != null) {
                        Throwable terminate = this.g.terminate();
                        a();
                        flowableSubscriber.onError(terminate);
                        return;
                    } else {
                        if (atomicInteger.get() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                        if (spscLinkedArrayQueue != null) {
                            obj = spscLinkedArrayQueue.poll();
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z3 && z4) {
                            Throwable terminate2 = this.g.terminate();
                            if (terminate2 != null) {
                                flowableSubscriber.onError(terminate2);
                                return;
                            } else {
                                flowableSubscriber.onComplete();
                                return;
                            }
                        } else if (z4) {
                            break;
                        } else {
                            flowableSubscriber.onNext(obj);
                            j3++;
                        }
                    }
                }
                if (i2 == 0) {
                    if (this.k) {
                        a();
                        return;
                    } else if (((Throwable) this.g.get()) != null) {
                        Throwable terminate3 = this.g.terminate();
                        a();
                        flowableSubscriber.onError(terminate3);
                        return;
                    } else {
                        if (atomicInteger.get() == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) atomicReference.get();
                        if (spscLinkedArrayQueue2 == null || spscLinkedArrayQueue2.isEmpty()) {
                            z = true;
                        }
                        if (z2 && z) {
                            Throwable terminate4 = this.g.terminate();
                            if (terminate4 != null) {
                                flowableSubscriber.onError(terminate4);
                                return;
                            } else {
                                flowableSubscriber.onComplete();
                                return;
                            }
                        }
                    }
                }
                if (j3 != 0) {
                    BackpressureHelper.e(this.d, j3);
                    this.j.request(j3);
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }

        public final void cancel() {
            this.k = true;
            this.j.cancel();
            this.e.dispose();
        }

        public final SpscLinkedArrayQueue d() {
            while (true) {
                AtomicReference atomicReference = this.i;
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                if (spscLinkedArrayQueue != null) {
                    return spscLinkedArrayQueue;
                }
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = new SpscLinkedArrayQueue(Flowable.c);
                while (true) {
                    if (atomicReference.compareAndSet((Object) null, spscLinkedArrayQueue2)) {
                        return spscLinkedArrayQueue2;
                    }
                    if (atomicReference.get() != null) {
                    }
                }
            }
        }

        public final void onComplete() {
            this.f.decrementAndGet();
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public final void onError(Throwable th) {
            this.f.decrementAndGet();
            if (this.g.addThrowable(th)) {
                this.e.dispose();
                if (getAndIncrement() == 0) {
                    b();
                    return;
                }
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.j.cancel();
                onError(th);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                this.c.onSubscribe(this);
                subscription.request((long) 0);
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.d, j2);
                if (getAndIncrement() == 0) {
                    b();
                }
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new FlatMapSingleSubscriber(flowableSubscriber));
    }
}
