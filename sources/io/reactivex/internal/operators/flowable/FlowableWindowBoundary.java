package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    public static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        public final WindowBoundaryMainSubscriber d;
        public boolean e;

        public WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber windowBoundaryMainSubscriber) {
            this.d = windowBoundaryMainSubscriber;
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = this.d;
                SubscriptionHelper.cancel(windowBoundaryMainSubscriber.e);
                windowBoundaryMainSubscriber.l = true;
                windowBoundaryMainSubscriber.a();
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = this.d;
            SubscriptionHelper.cancel(windowBoundaryMainSubscriber.e);
            if (windowBoundaryMainSubscriber.i.addThrowable(th)) {
                windowBoundaryMainSubscriber.l = true;
                windowBoundaryMainSubscriber.a();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                Object obj2 = WindowBoundaryMainSubscriber.o;
                WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = this.d;
                windowBoundaryMainSubscriber.g.offer(obj2);
                windowBoundaryMainSubscriber.a();
            }
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final Object o = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final FlowableSubscriber c;
        public final WindowBoundaryInnerSubscriber d = new WindowBoundaryInnerSubscriber(this);
        public final AtomicReference e = new AtomicReference();
        public final AtomicInteger f = new AtomicInteger(1);
        public final MpscLinkedQueue g = new MpscLinkedQueue();
        public final AtomicThrowable i = new AtomicThrowable();
        public final AtomicBoolean j = new AtomicBoolean();
        public final AtomicLong k = new AtomicLong();
        public volatile boolean l;
        public UnicastProcessor m;
        public long n;

        public WindowBoundaryMainSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                FlowableSubscriber flowableSubscriber = this.c;
                MpscLinkedQueue mpscLinkedQueue = this.g;
                AtomicThrowable atomicThrowable = this.i;
                long j2 = this.n;
                int i2 = 1;
                while (this.f.get() != 0) {
                    UnicastProcessor unicastProcessor = this.m;
                    boolean z2 = this.l;
                    if (!z2 || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastProcessor != null) {
                                    this.m = null;
                                    unicastProcessor.onComplete();
                                }
                                flowableSubscriber.onComplete();
                                return;
                            }
                            if (unicastProcessor != null) {
                                this.m = null;
                                unicastProcessor.onError(terminate);
                            }
                            flowableSubscriber.onError(terminate);
                            return;
                        } else if (z) {
                            this.n = j2;
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != o) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != null) {
                                this.m = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.j.get()) {
                                UnicastProcessor unicastProcessor2 = new UnicastProcessor(this, 0);
                                this.m = unicastProcessor2;
                                this.f.getAndIncrement();
                                if (j2 != this.k.get()) {
                                    j2++;
                                    flowableSubscriber.onNext(unicastProcessor2);
                                } else {
                                    SubscriptionHelper.cancel(this.e);
                                    this.d.dispose();
                                    atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.l = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastProcessor != null) {
                            this.m = null;
                            unicastProcessor.onError(terminate2);
                        }
                        flowableSubscriber.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.m = null;
            }
        }

        public final void cancel() {
            if (this.j.compareAndSet(false, true)) {
                this.d.dispose();
                if (this.f.decrementAndGet() == 0) {
                    SubscriptionHelper.cancel(this.e);
                }
            }
        }

        public final void onComplete() {
            this.d.dispose();
            this.l = true;
            a();
        }

        public final void onError(Throwable th) {
            this.d.dispose();
            if (this.i.addThrowable(th)) {
                this.l = true;
                a();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            this.g.offer(obj);
            a();
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.e, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }

        public final void request(long j2) {
            BackpressureHelper.a(this.k, j2);
        }

        public final void run() {
            if (this.f.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.e);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(flowableSubscriber);
        flowableSubscriber.onSubscribe(windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.g.offer(WindowBoundaryMainSubscriber.o);
        windowBoundaryMainSubscriber.a();
        throw null;
    }
}
