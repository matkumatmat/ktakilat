package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        public volatile boolean c;
        public volatile SimpleQueue d;
        public long e;
        public int f;

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
            this.c = true;
            throw null;
        }

        public final void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            throw null;
        }

        public final void onNext(Object obj) {
            if (this.f != 2) {
                throw null;
            }
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f = requestFusion;
                        this.d = queueSubscription;
                        this.c = true;
                        throw null;
                    } else if (requestFusion == 2) {
                        this.f = requestFusion;
                        this.d = queueSubscription;
                    }
                }
                subscription.request((long) 0);
            }
        }
    }

    public static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final InnerSubscriber[] m = new InnerSubscriber[0];
        public static final InnerSubscriber[] n = new InnerSubscriber[0];
        private static final long serialVersionUID = -2117620485640801370L;
        public final Subscriber c;
        public volatile boolean d;
        public final AtomicThrowable e = new AtomicThrowable();
        public volatile boolean f;
        public final AtomicReference g;
        public final AtomicLong i;
        public Subscription j;
        public long k;
        public int l;

        public MergeSubscriber(Subscriber subscriber) {
            AtomicReference atomicReference = new AtomicReference();
            this.g = atomicReference;
            this.i = new AtomicLong();
            this.c = subscriber;
            Math.max(1, 0);
            atomicReference.lazySet(m);
        }

        public final boolean a() {
            if (this.f) {
                return true;
            }
            if (this.e.get() == null) {
                return false;
            }
            Throwable terminate = this.e.terminate();
            if (terminate != ExceptionHelper.f682a) {
                this.c.onError(terminate);
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
            if (0 != r3) goto L_0x0061;
         */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x0164 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0167  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b() {
            /*
                r25 = this;
                r1 = r25
                int r0 = r25.getAndIncrement()
                if (r0 != 0) goto L_0x01ac
                org.reactivestreams.Subscriber r2 = r1.c
                r4 = 1
            L_0x000b:
                boolean r0 = r25.a()
                if (r0 == 0) goto L_0x0013
                goto L_0x01ac
            L_0x0013:
                java.util.concurrent.atomic.AtomicLong r0 = r1.i
                long r5 = r0.get()
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 != 0) goto L_0x0024
                r10 = 1
                goto L_0x0025
            L_0x0024:
                r10 = 0
            L_0x0025:
                r14 = 0
                boolean r0 = r1.d
                java.util.concurrent.atomic.AtomicReference r7 = r1.g
                java.lang.Object r7 = r7.get()
                io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber[] r7 = (io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber[]) r7
                int r8 = r7.length
                if (r0 == 0) goto L_0x004c
                if (r8 != 0) goto L_0x004c
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                java.lang.Throwable r0 = r0.terminate()
                java.lang.Throwable r3 = io.reactivex.internal.util.ExceptionHelper.f682a
                if (r0 == r3) goto L_0x01ac
                if (r0 != 0) goto L_0x0047
                r2.onComplete()
                goto L_0x01ac
            L_0x0047:
                r2.onError(r0)
                goto L_0x01ac
            L_0x004c:
                r16 = r4
                if (r8 == 0) goto L_0x018a
                long r3 = r1.k
                int r0 = r1.l
                if (r8 <= r0) goto L_0x0061
                r17 = r7[r0]
                r18 = 0
                r17.getClass()
                int r17 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
                if (r17 == 0) goto L_0x0086
            L_0x0061:
                if (r8 > r0) goto L_0x0064
                r0 = 0
            L_0x0064:
                r9 = 0
            L_0x0065:
                if (r9 >= r8) goto L_0x007b
                r18 = r7[r0]
                r19 = 0
                r18.getClass()
                int r18 = (r19 > r3 ? 1 : (r19 == r3 ? 0 : -1))
                if (r18 != 0) goto L_0x0073
                goto L_0x007b
            L_0x0073:
                int r0 = r0 + 1
                if (r0 != r8) goto L_0x0078
                r0 = 0
            L_0x0078:
                int r9 = r9 + 1
                goto L_0x0065
            L_0x007b:
                r1.l = r0
                r3 = r7[r0]
                r11 = 0
                r3.getClass()
                r1.k = r11
            L_0x0086:
                r3 = r0
                r11 = r14
                r0 = 0
                r9 = 0
            L_0x008a:
                if (r9 >= r8) goto L_0x0177
                boolean r13 = r25.a()
                if (r13 == 0) goto L_0x0094
                goto L_0x01ac
            L_0x0094:
                r13 = r7[r3]
                r20 = 0
            L_0x0098:
                boolean r21 = r25.a()
                if (r21 == 0) goto L_0x00a0
                goto L_0x01ac
            L_0x00a0:
                io.reactivex.internal.fuseable.SimpleQueue r4 = r13.d
                if (r4 != 0) goto L_0x00aa
                r22 = r7
                r23 = r8
                goto L_0x013e
            L_0x00aa:
                r22 = r7
                r23 = r8
                r7 = r14
            L_0x00af:
                int r24 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
                if (r24 == 0) goto L_0x00fb
                java.lang.Object r14 = r4.poll()     // Catch:{ all -> 0x00d4 }
                if (r14 != 0) goto L_0x00be
                r20 = r14
                r14 = 0
                goto L_0x00fb
            L_0x00be:
                r2.onNext(r14)
                boolean r15 = r25.a()
                if (r15 == 0) goto L_0x00c9
                goto L_0x01ac
            L_0x00c9:
                r18 = 1
                long r5 = r5 - r18
                long r7 = r7 + r18
                r20 = r14
                r14 = 0
                goto L_0x00af
            L_0x00d4:
                r0 = move-exception
                r4 = r0
                io.reactivex.exceptions.Exceptions.a(r4)
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r13)
                io.reactivex.internal.util.AtomicThrowable r0 = r1.e
                r0.addThrowable(r4)
                org.reactivestreams.Subscription r0 = r1.j
                r0.cancel()
                boolean r0 = r25.a()
                if (r0 == 0) goto L_0x00ee
                goto L_0x01ac
            L_0x00ee:
                r1.d(r13)
                int r9 = r9 + 1
                r4 = r23
                r0 = 1
                r7 = 1
            L_0x00f8:
                r13 = 1
                goto L_0x016f
            L_0x00fb:
                int r4 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
                if (r4 == 0) goto L_0x012d
                if (r10 != 0) goto L_0x0109
                java.util.concurrent.atomic.AtomicLong r4 = r1.i
                long r5 = -r7
                long r4 = r4.addAndGet(r5)
                goto L_0x010e
            L_0x0109:
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x010e:
                int r6 = r13.f
                r14 = 1
                if (r6 == r14) goto L_0x012c
                long r14 = r13.e
                long r14 = r14 + r7
                r6 = 0
                long r6 = (long) r6
                int r8 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
                if (r8 < 0) goto L_0x012a
                r6 = 0
                r13.e = r6
                java.lang.Object r6 = r13.get()
                org.reactivestreams.Subscription r6 = (org.reactivestreams.Subscription) r6
                r6.request(r14)
                goto L_0x012c
            L_0x012a:
                r13.e = r14
            L_0x012c:
                r5 = r4
            L_0x012d:
                r7 = 0
                int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r4 == 0) goto L_0x013e
                if (r20 != 0) goto L_0x0136
                goto L_0x013e
            L_0x0136:
                r7 = r22
                r8 = r23
                r14 = 0
                goto L_0x0098
            L_0x013e:
                boolean r4 = r13.c
                io.reactivex.internal.fuseable.SimpleQueue r7 = r13.d
                if (r4 == 0) goto L_0x014d
                if (r7 == 0) goto L_0x0150
                boolean r4 = r7.isEmpty()
                if (r4 == 0) goto L_0x014d
                goto L_0x0150
            L_0x014d:
                r7 = 1
                goto L_0x015e
            L_0x0150:
                r1.d(r13)
                boolean r0 = r25.a()
                if (r0 == 0) goto L_0x015a
                goto L_0x01ac
            L_0x015a:
                r7 = 1
                long r11 = r11 + r7
                r0 = 1
            L_0x015e:
                r13 = 0
                int r4 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
                if (r4 != 0) goto L_0x0167
                r9 = r0
                r13 = 1
                goto L_0x017b
            L_0x0167:
                int r3 = r3 + 1
                r4 = r23
                if (r3 != r4) goto L_0x00f8
                r3 = 0
                goto L_0x00f8
            L_0x016f:
                int r9 = r9 + r13
                r8 = r4
                r7 = r22
                r14 = 0
                goto L_0x008a
            L_0x0177:
                r22 = r7
                r13 = 1
                r9 = r0
            L_0x017b:
                r1.l = r3
                r0 = r22[r3]
                r3 = 0
                r0.getClass()
                r1.k = r3
                r14 = r11
                r3 = 0
                goto L_0x0190
            L_0x018a:
                r13 = 1
                r3 = 0
                r9 = 0
                r14 = 0
            L_0x0190:
                int r0 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
                if (r0 == 0) goto L_0x019d
                boolean r0 = r1.f
                if (r0 != 0) goto L_0x019d
                org.reactivestreams.Subscription r0 = r1.j
                r0.request(r14)
            L_0x019d:
                if (r9 == 0) goto L_0x01a3
                r4 = r16
                goto L_0x000b
            L_0x01a3:
                r3 = r16
                int r0 = -r3
                int r4 = r1.addAndGet(r0)
                if (r4 != 0) goto L_0x000b
            L_0x01ac:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber.b():void");
        }

        public final void cancel() {
            InnerSubscriber[] innerSubscriberArr;
            if (!this.f) {
                this.f = true;
                this.j.cancel();
                AtomicReference atomicReference = this.g;
                InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) atomicReference.get();
                InnerSubscriber[] innerSubscriberArr3 = n;
                if (!(innerSubscriberArr2 == innerSubscriberArr3 || (innerSubscriberArr = (InnerSubscriber[]) atomicReference.getAndSet(innerSubscriberArr3)) == innerSubscriberArr3)) {
                    for (InnerSubscriber innerSubscriber : innerSubscriberArr) {
                        innerSubscriber.getClass();
                        SubscriptionHelper.cancel(innerSubscriber);
                    }
                    Throwable terminate = this.e.terminate();
                    if (!(terminate == null || terminate == ExceptionHelper.f682a)) {
                        RxJavaPlugins.b(terminate);
                    }
                }
                getAndIncrement();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber r8) {
            /*
                r7 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r7.g
                java.lang.Object r1 = r0.get()
                io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber[] r1 = (io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber[]) r1
                int r2 = r1.length
                if (r2 != 0) goto L_0x000c
                return
            L_0x000c:
                r3 = 0
                r4 = 0
            L_0x000e:
                if (r4 >= r2) goto L_0x0018
                r5 = r1[r4]
                if (r5 != r8) goto L_0x0015
                goto L_0x0019
            L_0x0015:
                int r4 = r4 + 1
                goto L_0x000e
            L_0x0018:
                r4 = -1
            L_0x0019:
                if (r4 >= 0) goto L_0x001c
                return
            L_0x001c:
                r5 = 1
                if (r2 != r5) goto L_0x0022
                io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber[] r2 = m
                goto L_0x0031
            L_0x0022:
                int r6 = r2 + -1
                io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber[] r6 = new io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber[r6]
                java.lang.System.arraycopy(r1, r3, r6, r3, r4)
                int r3 = r4 + 1
                int r2 = r2 - r4
                int r2 = r2 - r5
                java.lang.System.arraycopy(r1, r3, r6, r4, r2)
                r2 = r6
            L_0x0031:
                boolean r3 = r0.compareAndSet(r1, r2)
                if (r3 == 0) goto L_0x0038
                return
            L_0x0038:
                java.lang.Object r3 = r0.get()
                if (r3 == r1) goto L_0x0031
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber.d(io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber):void");
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                b();
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
            } else if (this.e.addThrowable(th)) {
                this.d = true;
                b();
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onNext(Object obj) {
            if (!this.d) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.j.cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                this.c.onSubscribe(this);
                if (!this.f) {
                    subscription.request((long) 0);
                }
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.i, j2);
                b();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        Flowable flowable = this.d;
        if (!FlowableScalarXMap.a(flowable, flowableSubscriber)) {
            flowable.a(new MergeSubscriber(flowableSubscriber));
        }
    }
}
