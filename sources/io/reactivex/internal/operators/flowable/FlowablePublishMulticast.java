package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {

    public static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        public static final MulticastSubscription[] n = new MulticastSubscription[0];
        public static final MulticastSubscription[] o = new MulticastSubscription[0];
        public final AtomicInteger d = new AtomicInteger();
        public final AtomicReference e = new AtomicReference(n);
        public final int f = 0;
        public final AtomicReference g = new AtomicReference();
        public volatile SimpleQueue i;
        public int j;
        public volatile boolean k;
        public Throwable l;
        public int m;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(io.reactivex.FlowableSubscriber r7) {
            /*
                r6 = this;
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription r0 = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription
                r0.<init>(r7, r6)
                r7.onSubscribe(r0)
            L_0x0008:
                java.util.concurrent.atomic.AtomicReference r1 = r6.e
                java.lang.Object r2 = r1.get()
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r2 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r2
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r3 = o
                if (r2 != r3) goto L_0x0020
                java.lang.Throwable r0 = r6.l
                if (r0 == 0) goto L_0x001c
                r7.onError(r0)
                goto L_0x0042
            L_0x001c:
                r7.onComplete()
                goto L_0x0042
            L_0x0020:
                int r3 = r2.length
                int r4 = r3 + 1
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r4 = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[r4]
                r5 = 0
                java.lang.System.arraycopy(r2, r5, r4, r5, r3)
                r4[r3] = r0
            L_0x002b:
                boolean r3 = r1.compareAndSet(r2, r4)
                if (r3 == 0) goto L_0x0043
                long r1 = r0.get()
                r3 = -9223372036854775808
                int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r7 != 0) goto L_0x003f
                r6.h(r0)
                return
            L_0x003f:
                r6.f()
            L_0x0042:
                return
            L_0x0043:
                java.lang.Object r3 = r1.get()
                if (r3 == r2) goto L_0x002b
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.b(io.reactivex.FlowableSubscriber):void");
        }

        public final void dispose() {
            SimpleQueue simpleQueue;
            SubscriptionHelper.cancel(this.g);
            if (this.d.getAndIncrement() == 0 && (simpleQueue = this.i) != null) {
                simpleQueue.clear();
            }
        }

        public final void e() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.e.getAndSet(o)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.c.onComplete();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x0132 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0133  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void f() {
            /*
                r24 = this;
                r1 = r24
                java.util.concurrent.atomic.AtomicInteger r0 = r1.d
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                io.reactivex.internal.fuseable.SimpleQueue r0 = r1.i
                int r2 = r1.m
                int r3 = r1.f
                int r4 = r1.j
                r5 = 1
                if (r4 == r5) goto L_0x0018
                r4 = 1
                goto L_0x0019
            L_0x0018:
                r4 = 0
            L_0x0019:
                java.util.concurrent.atomic.AtomicReference r7 = r1.e
                java.lang.Object r8 = r7.get()
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
                r9 = 1
            L_0x0022:
                int r10 = r8.length
                if (r0 == 0) goto L_0x0125
                if (r10 == 0) goto L_0x0125
                int r11 = r8.length
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r15 = r12
                r14 = 0
            L_0x002f:
                r17 = -9223372036854775808
                if (r14 >= r11) goto L_0x0052
                r5 = r8[r14]
                long r19 = r5.get()
                r21 = r7
                long r6 = r5.e
                long r19 = r19 - r6
                int r5 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
                if (r5 == 0) goto L_0x004a
                int r5 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
                if (r5 <= 0) goto L_0x004c
                r15 = r19
                goto L_0x004c
            L_0x004a:
                int r10 = r10 + -1
            L_0x004c:
                int r14 = r14 + 1
                r7 = r21
                r5 = 1
                goto L_0x002f
            L_0x0052:
                r21 = r7
                r5 = 0
                if (r10 != 0) goto L_0x0059
                r15 = r5
            L_0x0059:
                int r7 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
                if (r7 == 0) goto L_0x00f9
                boolean r10 = r24.isDisposed()
                if (r10 == 0) goto L_0x0067
                r0.clear()
                return
            L_0x0067:
                boolean r10 = r1.k
                if (r10 == 0) goto L_0x0073
                java.lang.Throwable r11 = r1.l
                if (r11 == 0) goto L_0x0073
                r1.g(r11)
                return
            L_0x0073:
                java.lang.Object r11 = r0.poll()     // Catch:{ all -> 0x00eb }
                if (r11 != 0) goto L_0x007b
                r14 = 1
                goto L_0x007c
            L_0x007b:
                r14 = 0
            L_0x007c:
                if (r10 == 0) goto L_0x008c
                if (r14 == 0) goto L_0x008c
                java.lang.Throwable r0 = r1.l
                if (r0 == 0) goto L_0x0088
                r1.g(r0)
                goto L_0x008b
            L_0x0088:
                r24.e()
            L_0x008b:
                return
            L_0x008c:
                if (r14 == 0) goto L_0x0090
                goto L_0x00f9
            L_0x0090:
                int r7 = r8.length
                r10 = 0
                r14 = 0
            L_0x0093:
                r19 = 1
                if (r10 >= r7) goto L_0x00bc
                r5 = r8[r10]
                long r22 = r5.get()
                int r6 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
                if (r6 == 0) goto L_0x00b1
                int r6 = (r22 > r12 ? 1 : (r22 == r12 ? 0 : -1))
                if (r6 == 0) goto L_0x00ab
                long r12 = r5.e
                long r12 = r12 + r19
                r5.e = r12
            L_0x00ab:
                io.reactivex.FlowableSubscriber r5 = r5.c
                r5.onNext(r11)
                goto L_0x00b2
            L_0x00b1:
                r14 = 1
            L_0x00b2:
                int r10 = r10 + 1
                r5 = 0
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0093
            L_0x00bc:
                long r15 = r15 - r19
                if (r4 == 0) goto L_0x00d1
                int r2 = r2 + 1
                if (r2 != r3) goto L_0x00d1
                java.util.concurrent.atomic.AtomicReference r2 = r1.g
                java.lang.Object r2 = r2.get()
                org.reactivestreams.Subscription r2 = (org.reactivestreams.Subscription) r2
                long r5 = (long) r3
                r2.request(r5)
                r2 = 0
            L_0x00d1:
                java.lang.Object r5 = r21.get()
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r5 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r5
                if (r14 != 0) goto L_0x00e5
                if (r5 == r8) goto L_0x00dc
                goto L_0x00e5
            L_0x00dc:
                r5 = 0
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0059
            L_0x00e5:
                r8 = r5
            L_0x00e6:
                r7 = r21
                r5 = 1
                goto L_0x0022
            L_0x00eb:
                r0 = move-exception
                r2 = r0
                io.reactivex.exceptions.Exceptions.a(r2)
                java.util.concurrent.atomic.AtomicReference r0 = r1.g
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r0)
                r1.g(r2)
                return
            L_0x00f9:
                if (r7 != 0) goto L_0x0127
                boolean r5 = r24.isDisposed()
                if (r5 == 0) goto L_0x0105
                r0.clear()
                return
            L_0x0105:
                boolean r5 = r1.k
                if (r5 == 0) goto L_0x0111
                java.lang.Throwable r6 = r1.l
                if (r6 == 0) goto L_0x0111
                r1.g(r6)
                return
            L_0x0111:
                if (r5 == 0) goto L_0x0127
                boolean r5 = r0.isEmpty()
                if (r5 == 0) goto L_0x0127
                java.lang.Throwable r0 = r1.l
                if (r0 == 0) goto L_0x0121
                r1.g(r0)
                goto L_0x0124
            L_0x0121:
                r24.e()
            L_0x0124:
                return
            L_0x0125:
                r21 = r7
            L_0x0127:
                r1.m = r2
                java.util.concurrent.atomic.AtomicInteger r5 = r1.d
                int r6 = -r9
                int r9 = r5.addAndGet(r6)
                if (r9 != 0) goto L_0x0133
                return
            L_0x0133:
                if (r0 != 0) goto L_0x0137
                io.reactivex.internal.fuseable.SimpleQueue r0 = r1.i
            L_0x0137:
                java.lang.Object r5 = r21.get()
                r8 = r5
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
                goto L_0x00e6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.f():void");
        }

        public final void g(Throwable th) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.e.getAndSet(o)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.c.onError(th);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void h(io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription r8) {
            /*
                r7 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r7.e
                java.lang.Object r1 = r0.get()
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r1 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r1
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
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r2 = n
                goto L_0x0031
            L_0x0022:
                int r6 = r2 + -1
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r6 = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[r6]
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.h(io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription):void");
        }

        public final boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) this.g.get());
        }

        public final void onComplete() {
            if (!this.k) {
                this.k = true;
                f();
            }
        }

        public final void onError(Throwable th) {
            if (this.k) {
                RxJavaPlugins.b(th);
                return;
            }
            this.l = th;
            this.k = true;
            f();
        }

        public final void onNext(Object obj) {
            if (!this.k) {
                if (this.j != 0 || this.i.offer(obj)) {
                    f();
                    return;
                }
                ((Subscription) this.g.get()).cancel();
                onError(new MissingBackpressureException());
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.g, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.i = queueSubscription;
                        this.k = true;
                        f();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.i = queueSubscription;
                        subscription.request((long) 0);
                        return;
                    }
                }
                this.i = new SpscArrayQueue(0);
                subscription.request((long) 0);
            }
        }
    }

    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        public final FlowableSubscriber c;
        public final MulticastProcessor d;
        public long e;

        public MulticastSubscription(FlowableSubscriber flowableSubscriber, MulticastProcessor multicastProcessor) {
            this.c = flowableSubscriber;
            this.d = multicastProcessor;
        }

        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                MulticastProcessor multicastProcessor = this.d;
                multicastProcessor.h(this);
                multicastProcessor.f();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.b(this, j);
                this.d.f();
            }
        }
    }

    public static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        public Subscription c;

        public final void cancel() {
            this.c.cancel();
            throw null;
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                throw null;
            }
        }

        public final void request(long j) {
            this.c.request(j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        new MulticastProcessor();
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptySubscription.error(th, flowableSubscriber);
        }
    }
}
