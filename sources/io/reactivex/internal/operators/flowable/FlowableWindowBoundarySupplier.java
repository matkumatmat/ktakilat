package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
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

public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

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
                windowBoundaryMainSubscriber.k.cancel();
                windowBoundaryMainSubscriber.l = true;
                windowBoundaryMainSubscriber.b();
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = this.d;
            windowBoundaryMainSubscriber.k.cancel();
            if (windowBoundaryMainSubscriber.g.addThrowable(th)) {
                windowBoundaryMainSubscriber.l = true;
                windowBoundaryMainSubscriber.b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        /* JADX WARNING: Removed duplicated region for block: B:4:0x000f A[LOOP:0: B:4:0x000f->B:7:0x001b, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(java.lang.Object r3) {
            /*
                r2 = this;
                boolean r3 = r2.e
                if (r3 == 0) goto L_0x0005
                return
            L_0x0005:
                r3 = 1
                r2.e = r3
                r2.dispose()
                io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber r3 = r2.d
                java.util.concurrent.atomic.AtomicReference r0 = r3.d
            L_0x000f:
                r1 = 0
                boolean r1 = r0.compareAndSet(r2, r1)
                if (r1 == 0) goto L_0x0017
                goto L_0x001d
            L_0x0017:
                java.lang.Object r1 = r0.get()
                if (r1 == r2) goto L_0x000f
            L_0x001d:
                java.lang.Object r0 = io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier.WindowBoundaryMainSubscriber.p
                io.reactivex.internal.queue.MpscLinkedQueue r1 = r3.f
                r1.offer(r0)
                r3.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber.onNext(java.lang.Object):void");
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final WindowBoundaryInnerSubscriber o = new WindowBoundaryInnerSubscriber((WindowBoundaryMainSubscriber) null);
        public static final Object p = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final FlowableSubscriber c;
        public final AtomicReference d = new AtomicReference();
        public final AtomicInteger e = new AtomicInteger(1);
        public final MpscLinkedQueue f = new MpscLinkedQueue();
        public final AtomicThrowable g = new AtomicThrowable();
        public final AtomicBoolean i = new AtomicBoolean();
        public final AtomicLong j = new AtomicLong();
        public Subscription k;
        public volatile boolean l;
        public UnicastProcessor m;
        public long n;

        public WindowBoundaryMainSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a() {
            AtomicReference atomicReference = this.d;
            WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber = o;
            Disposable disposable = (Disposable) atomicReference.getAndSet(windowBoundaryInnerSubscriber);
            if (disposable != null && disposable != windowBoundaryInnerSubscriber) {
                disposable.dispose();
            }
        }

        public final void b() {
            boolean z;
            if (getAndIncrement() == 0) {
                FlowableSubscriber flowableSubscriber = this.c;
                MpscLinkedQueue mpscLinkedQueue = this.f;
                AtomicThrowable atomicThrowable = this.g;
                long j2 = this.n;
                int i2 = 1;
                while (this.e.get() != 0) {
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
                        } else if (poll != p) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != null) {
                                this.m = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.i.get()) {
                                if (j2 == this.j.get()) {
                                    this.k.cancel();
                                    a();
                                    atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.l = true;
                                } else {
                                    this.m = new UnicastProcessor(this, 0);
                                    this.e.getAndIncrement();
                                    try {
                                        throw null;
                                    } catch (Throwable th) {
                                        Exceptions.a(th);
                                        atomicThrowable.addThrowable(th);
                                        this.l = true;
                                    }
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
            if (this.i.compareAndSet(false, true)) {
                a();
                if (this.e.decrementAndGet() == 0) {
                    this.k.cancel();
                }
            }
        }

        public final void onComplete() {
            a();
            this.l = true;
            b();
        }

        public final void onError(Throwable th) {
            a();
            if (this.g.addThrowable(th)) {
                this.l = true;
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            this.f.offer(obj);
            b();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.k, subscription)) {
                this.k = subscription;
                this.c.onSubscribe(this);
                this.f.offer(p);
                b();
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j2) {
            BackpressureHelper.a(this.j, j2);
        }

        public final void run() {
            if (this.e.decrementAndGet() == 0) {
                this.k.cancel();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new WindowBoundaryMainSubscriber(flowableSubscriber));
    }
}
