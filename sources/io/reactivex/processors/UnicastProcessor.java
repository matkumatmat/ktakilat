package io.reactivex.processors;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    public final SpscLinkedArrayQueue d;
    public final AtomicReference e;
    public final boolean f = true;
    public volatile boolean g;
    public Throwable i;
    public final AtomicReference j = new AtomicReference();
    public volatile boolean k;
    public final AtomicBoolean l = new AtomicBoolean();
    public final BasicIntQueueSubscription m = new UnicastQueueSubscription();
    public final AtomicLong n = new AtomicLong();
    public boolean o;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        public final void cancel() {
            if (!UnicastProcessor.this.k) {
                UnicastProcessor.this.k = true;
                Runnable runnable = (Runnable) UnicastProcessor.this.e.getAndSet((Object) null);
                if (runnable != null) {
                    runnable.run();
                }
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (!unicastProcessor.o && unicastProcessor.m.getAndIncrement() == 0) {
                    UnicastProcessor.this.d.clear();
                    UnicastProcessor.this.j.lazySet((Object) null);
                }
            }
        }

        public final void clear() {
            UnicastProcessor.this.d.clear();
        }

        public final boolean isEmpty() {
            return UnicastProcessor.this.d.isEmpty();
        }

        public final Object poll() {
            return UnicastProcessor.this.d.poll();
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                BackpressureHelper.a(unicastProcessor.n, j);
                unicastProcessor.g();
            }
        }

        public final int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.o = true;
            return 2;
        }
    }

    public UnicastProcessor(Runnable runnable, int i2) {
        ObjectHelper.c(i2, "capacityHint");
        this.d = new SpscLinkedArrayQueue(i2);
        this.e = new AtomicReference(runnable);
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        if (this.l.get() || !this.l.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), flowableSubscriber);
            return;
        }
        flowableSubscriber.onSubscribe(this.m);
        this.j.set(flowableSubscriber);
        if (this.k) {
            this.j.lazySet((Object) null);
        } else {
            g();
        }
    }

    public final boolean f(boolean z, boolean z2, boolean z3, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
        if (this.k) {
            spscLinkedArrayQueue.clear();
            this.j.lazySet((Object) null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.i != null) {
                spscLinkedArrayQueue.clear();
                this.j.lazySet((Object) null);
                subscriber.onError(this.i);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th = this.i;
                this.j.lazySet((Object) null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: org.reactivestreams.Subscriber} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r18 = this;
            r6 = r18
            io.reactivex.internal.subscriptions.BasicIntQueueSubscription r0 = r6.m
            int r0 = r0.getAndIncrement()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReference r0 = r6.j
            java.lang.Object r0 = r0.get()
            org.reactivestreams.Subscriber r0 = (org.reactivestreams.Subscriber) r0
            r7 = 1
            r8 = r0
            r0 = 1
        L_0x0016:
            if (r8 == 0) goto L_0x00de
            boolean r0 = r6.o
            if (r0 == 0) goto L_0x006b
            io.reactivex.internal.queue.SpscLinkedArrayQueue r0 = r6.d
            boolean r1 = r6.f
        L_0x0020:
            boolean r2 = r6.k
            r3 = 0
            if (r2 == 0) goto L_0x002f
            r0.clear()
            java.util.concurrent.atomic.AtomicReference r0 = r6.j
            r0.lazySet(r3)
            goto L_0x00db
        L_0x002f:
            boolean r2 = r6.g
            if (r1 != 0) goto L_0x0048
            if (r2 == 0) goto L_0x0048
            java.lang.Throwable r4 = r6.i
            if (r4 == 0) goto L_0x0048
            r0.clear()
            java.util.concurrent.atomic.AtomicReference r0 = r6.j
            r0.lazySet(r3)
            java.lang.Throwable r0 = r6.i
            r8.onError(r0)
            goto L_0x00db
        L_0x0048:
            r8.onNext(r3)
            if (r2 == 0) goto L_0x0060
            java.util.concurrent.atomic.AtomicReference r0 = r6.j
            r0.lazySet(r3)
            java.lang.Throwable r0 = r6.i
            if (r0 == 0) goto L_0x005b
            r8.onError(r0)
            goto L_0x00db
        L_0x005b:
            r8.onComplete()
            goto L_0x00db
        L_0x0060:
            io.reactivex.internal.subscriptions.BasicIntQueueSubscription r2 = r6.m
            int r3 = -r7
            int r7 = r2.addAndGet(r3)
            if (r7 != 0) goto L_0x0020
            goto L_0x00db
        L_0x006b:
            io.reactivex.internal.queue.SpscLinkedArrayQueue r9 = r6.d
            boolean r0 = r6.f
            r10 = r0 ^ 1
            r11 = 1
        L_0x0072:
            java.util.concurrent.atomic.AtomicLong r0 = r6.n
            long r12 = r0.get()
            r4 = 0
        L_0x007a:
            int r16 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00a8
            boolean r2 = r6.g
            java.lang.Object r3 = r9.poll()
            if (r3 != 0) goto L_0x0089
            r17 = 1
            goto L_0x008c
        L_0x0089:
            r0 = 0
            r17 = 0
        L_0x008c:
            r0 = r18
            r1 = r10
            r7 = r3
            r3 = r17
            r14 = r4
            r4 = r8
            r5 = r9
            boolean r0 = r0.f(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x009c
            goto L_0x00db
        L_0x009c:
            if (r17 == 0) goto L_0x009f
            goto L_0x00a9
        L_0x009f:
            r8.onNext(r7)
            r0 = 1
            long r4 = r14 + r0
            r7 = 1
            goto L_0x007a
        L_0x00a8:
            r14 = r4
        L_0x00a9:
            if (r16 != 0) goto L_0x00bd
            boolean r2 = r6.g
            boolean r3 = r9.isEmpty()
            r0 = r18
            r1 = r10
            r4 = r8
            r5 = r9
            boolean r0 = r0.f(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00bd
            goto L_0x00db
        L_0x00bd:
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x00d2
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x00d2
            java.util.concurrent.atomic.AtomicLong r0 = r6.n
            long r1 = -r14
            r0.addAndGet(r1)
        L_0x00d2:
            io.reactivex.internal.subscriptions.BasicIntQueueSubscription r0 = r6.m
            int r1 = -r11
            int r11 = r0.addAndGet(r1)
            if (r11 != 0) goto L_0x00dc
        L_0x00db:
            return
        L_0x00dc:
            r7 = 1
            goto L_0x0072
        L_0x00de:
            io.reactivex.internal.subscriptions.BasicIntQueueSubscription r1 = r6.m
            int r0 = -r0
            int r0 = r1.addAndGet(r0)
            if (r0 != 0) goto L_0x00e8
            return
        L_0x00e8:
            java.util.concurrent.atomic.AtomicReference r1 = r6.j
            java.lang.Object r1 = r1.get()
            r8 = r1
            org.reactivestreams.Subscriber r8 = (org.reactivestreams.Subscriber) r8
            r7 = 1
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.UnicastProcessor.g():void");
    }

    public final void onComplete() {
        if (!this.g && !this.k) {
            this.g = true;
            Runnable runnable = (Runnable) this.e.getAndSet((Object) null);
            if (runnable != null) {
                runnable.run();
            }
            g();
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.g || this.k) {
            RxJavaPlugins.b(th);
            return;
        }
        this.i = th;
        this.g = true;
        Runnable runnable = (Runnable) this.e.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
        g();
    }

    public final void onNext(Object obj) {
        ObjectHelper.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.g && !this.k) {
            this.d.offer(obj);
            g();
        }
    }

    public final void onSubscribe(Subscription subscription) {
        if (this.g || this.k) {
            subscription.cancel();
        } else {
            subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
