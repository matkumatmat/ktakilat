package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        public final SwitchMapSubscriber c;
        public final long d;
        public final int e;
        public volatile SimpleQueue f;
        public volatile boolean g;
        public int i;

        public SwitchMapInnerSubscriber(SwitchMapSubscriber switchMapSubscriber, long j, int i2) {
            this.c = switchMapSubscriber;
            this.d = j;
            this.e = i2;
        }

        public final void onComplete() {
            SwitchMapSubscriber switchMapSubscriber = this.c;
            if (this.d == switchMapSubscriber.k) {
                this.g = true;
                switchMapSubscriber.b();
            }
        }

        public final void onError(Throwable th) {
            SwitchMapSubscriber switchMapSubscriber = this.c;
            if (this.d != switchMapSubscriber.k || !switchMapSubscriber.e.addThrowable(th)) {
                RxJavaPlugins.b(th);
                return;
            }
            switchMapSubscriber.g.cancel();
            this.g = true;
            switchMapSubscriber.b();
        }

        public final void onNext(Object obj) {
            SwitchMapSubscriber switchMapSubscriber = this.c;
            if (this.d != switchMapSubscriber.k) {
                return;
            }
            if (this.i != 0 || this.f.offer(obj)) {
                switchMapSubscriber.b();
            } else {
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.i = requestFusion;
                        this.f = queueSubscription;
                        this.g = true;
                        this.c.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.i = requestFusion;
                        this.f = queueSubscription;
                        subscription.request((long) this.e);
                        return;
                    }
                }
                this.f = new SpscArrayQueue(this.e);
                subscription.request((long) this.e);
            }
        }
    }

    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final SwitchMapInnerSubscriber l;
        private static final long serialVersionUID = -3491074160481096299L;
        public final FlowableSubscriber c;
        public volatile boolean d;
        public final AtomicThrowable e;
        public volatile boolean f;
        public Subscription g;
        public final AtomicReference i = new AtomicReference();
        public final AtomicLong j = new AtomicLong();
        public volatile long k;

        static {
            SwitchMapInnerSubscriber switchMapInnerSubscriber = new SwitchMapInnerSubscriber((SwitchMapSubscriber) null, -1, 1);
            l = switchMapInnerSubscriber;
            SubscriptionHelper.cancel(switchMapInnerSubscriber);
        }

        public SwitchMapSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
            this.e = new AtomicThrowable();
        }

        public final void a() {
            SwitchMapInnerSubscriber switchMapInnerSubscriber;
            AtomicReference atomicReference = this.i;
            SwitchMapInnerSubscriber switchMapInnerSubscriber2 = (SwitchMapInnerSubscriber) atomicReference.get();
            SwitchMapInnerSubscriber switchMapInnerSubscriber3 = l;
            if (switchMapInnerSubscriber2 != switchMapInnerSubscriber3 && (switchMapInnerSubscriber = (SwitchMapInnerSubscriber) atomicReference.getAndSet(switchMapInnerSubscriber3)) != switchMapInnerSubscriber3 && switchMapInnerSubscriber != null) {
                SubscriptionHelper.cancel(switchMapInnerSubscriber);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0073 A[LOOP:1: B:32:0x0073->B:35:0x007e, LOOP_START] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00d5 A[LOOP:3: B:60:0x00d5->B:63:0x00e0, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                io.reactivex.FlowableSubscriber r2 = r1.c
                r4 = 1
            L_0x000c:
                boolean r0 = r1.f
                r5 = 0
                if (r0 == 0) goto L_0x0017
                java.util.concurrent.atomic.AtomicReference r0 = r1.i
                r0.lazySet(r5)
                return
            L_0x0017:
                boolean r0 = r1.d
                if (r0 == 0) goto L_0x003e
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0032
                r17.a()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x0032:
                java.util.concurrent.atomic.AtomicReference r0 = r1.i
                java.lang.Object r0 = r0.get()
                if (r0 != 0) goto L_0x003e
                r2.onComplete()
                return
            L_0x003e:
                java.util.concurrent.atomic.AtomicReference r0 = r1.i
                java.lang.Object r0 = r0.get()
                r6 = r0
                io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber r6 = (io.reactivex.internal.operators.flowable.FlowableSwitchMap.SwitchMapInnerSubscriber) r6
                if (r6 == 0) goto L_0x004d
                io.reactivex.internal.fuseable.SimpleQueue r0 = r6.f
                r7 = r0
                goto L_0x004e
            L_0x004d:
                r7 = r5
            L_0x004e:
                if (r7 == 0) goto L_0x0111
                boolean r0 = r6.g
                if (r0 == 0) goto L_0x0081
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x006b
                r17.a()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x006b:
                boolean r0 = r7.isEmpty()
                if (r0 == 0) goto L_0x0081
                java.util.concurrent.atomic.AtomicReference r0 = r1.i
            L_0x0073:
                boolean r7 = r0.compareAndSet(r6, r5)
                if (r7 == 0) goto L_0x007a
                goto L_0x000c
            L_0x007a:
                java.lang.Object r7 = r0.get()
                if (r7 == r6) goto L_0x0073
                goto L_0x000c
            L_0x0081:
                java.util.concurrent.atomic.AtomicLong r0 = r1.j
                long r8 = r0.get()
                r10 = 0
                r12 = r10
            L_0x008a:
                r14 = 0
                int r0 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                if (r0 == 0) goto L_0x00ed
                boolean r0 = r1.f
                if (r0 == 0) goto L_0x0094
                return
            L_0x0094:
                boolean r0 = r6.g
                java.lang.Object r15 = r7.poll()     // Catch:{ all -> 0x009b }
                goto L_0x00aa
            L_0x009b:
                r0 = move-exception
                r15 = r0
                io.reactivex.exceptions.Exceptions.a(r15)
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r6)
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                r0.addThrowable(r15)
                r15 = r5
                r0 = 1
            L_0x00aa:
                if (r15 != 0) goto L_0x00af
                r16 = 1
                goto L_0x00b1
            L_0x00af:
                r16 = 0
            L_0x00b1:
                java.util.concurrent.atomic.AtomicReference r3 = r1.i
                java.lang.Object r3 = r3.get()
                if (r6 == r3) goto L_0x00bb
            L_0x00b9:
                r14 = 1
                goto L_0x00ed
            L_0x00bb:
                if (r0 == 0) goto L_0x00e3
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x00d1
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x00d1:
                if (r16 == 0) goto L_0x00e3
                java.util.concurrent.atomic.AtomicReference r0 = r1.i
            L_0x00d5:
                boolean r3 = r0.compareAndSet(r6, r5)
                if (r3 == 0) goto L_0x00dc
                goto L_0x00e2
            L_0x00dc:
                java.lang.Object r3 = r0.get()
                if (r3 == r6) goto L_0x00d5
            L_0x00e2:
                goto L_0x00b9
            L_0x00e3:
                if (r16 == 0) goto L_0x00e6
                goto L_0x00ed
            L_0x00e6:
                r2.onNext(r15)
                r14 = 1
                long r12 = r12 + r14
                goto L_0x008a
            L_0x00ed:
                int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x010d
                boolean r0 = r1.f
                if (r0 != 0) goto L_0x010d
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 == 0) goto L_0x0104
                java.util.concurrent.atomic.AtomicLong r0 = r1.j
                long r7 = -r12
                r0.addAndGet(r7)
            L_0x0104:
                java.lang.Object r0 = r6.get()
                org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
                r0.request(r12)
            L_0x010d:
                if (r14 == 0) goto L_0x0111
                goto L_0x000c
            L_0x0111:
                int r0 = -r4
                int r4 = r1.addAndGet(r0)
                if (r4 != 0) goto L_0x000c
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableSwitchMap.SwitchMapSubscriber.b():void");
        }

        public final void cancel() {
            if (!this.f) {
                this.f = true;
                this.g.cancel();
                a();
            }
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                b();
            }
        }

        public final void onError(Throwable th) {
            if (this.d || !this.e.addThrowable(th)) {
                RxJavaPlugins.b(th);
                return;
            }
            a();
            this.d = true;
            b();
        }

        public final void onNext(Object obj) {
            if (!this.d) {
                this.k++;
                SwitchMapInnerSubscriber switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.i.get();
                if (switchMapInnerSubscriber != null) {
                    SubscriptionHelper.cancel(switchMapInnerSubscriber);
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.g.cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.c.onSubscribe(this);
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.j, j2);
                if (this.k == 0) {
                    this.g.request(LocationRequestCompat.PASSIVE_INTERVAL);
                } else {
                    b();
                }
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        Flowable flowable = this.d;
        if (!FlowableScalarXMap.a(flowable, flowableSubscriber)) {
            flowable.a(new SwitchMapSubscriber(flowableSubscriber));
        }
    }
}
