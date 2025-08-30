package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f667a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.internal.util.ErrorMode[] r0 = io.reactivex.internal.util.ErrorMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f667a = r0
                io.reactivex.internal.util.ErrorMode r1 = io.reactivex.internal.util.ErrorMode.BOUNDARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f667a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.internal.util.ErrorMode r1 = io.reactivex.internal.util.ErrorMode.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableConcatMap.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;
        public Subscription c;
        public SimpleQueue d;
        public volatile boolean e;
        public volatile boolean f;
        public volatile boolean g;
        public int i;

        public abstract void d();

        public abstract void e();

        public final void onComplete() {
            this.e = true;
            d();
        }

        public final void onNext(Object obj) {
            if (this.i == 2 || this.d.offer(obj)) {
                d();
                return;
            }
            this.c.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.i = requestFusion;
                        this.d = queueSubscription;
                        this.e = true;
                        e();
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.i = requestFusion;
                        this.d = queueSubscription;
                        e();
                        subscription.request((long) 0);
                        return;
                    }
                }
                this.d = new SpscArrayQueue(0);
                e();
                subscription.request((long) 0);
            }
        }
    }

    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;

        public final void a(Throwable th) {
            throw null;
        }

        public final void b(Object obj) {
            throw null;
        }

        public final void cancel() {
            if (!this.f) {
                this.f = true;
                throw null;
            }
        }

        public final void d() {
            boolean z;
            if (getAndIncrement() == 0) {
                while (!this.f) {
                    if (!this.g) {
                        boolean z2 = this.e;
                        if (!z2) {
                            try {
                                if (this.d.poll() == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z2 && z) {
                                    throw null;
                                } else if (!z) {
                                    try {
                                        throw null;
                                    } catch (Throwable th) {
                                        throw null;
                                    }
                                }
                            } finally {
                                Exceptions.a(th);
                                this.c.cancel();
                            }
                        } else {
                            throw null;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public final void e() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void request(long j) {
            throw null;
        }
    }

    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;

        public final void a(Throwable th) {
            throw null;
        }

        public final void b(Object obj) {
            if (get() == 0 && compareAndSet(0, 1)) {
                throw null;
            }
        }

        public final void cancel() {
            if (!this.f) {
                this.f = true;
                throw null;
            }
        }

        public final void d() {
            throw null;
        }

        public final void e() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void request(long j) {
            throw null;
        }
    }

    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 897683679971470653L;
        public long k;

        public final void onComplete() {
            long j = this.k;
            if (j != 0) {
                this.k = 0;
                produced(j);
            }
            throw null;
        }

        public final void onError(Throwable th) {
            long j = this.k;
            if (j != 0) {
                this.k = 0;
                produced(j);
            }
            throw null;
        }

        public final void onNext(Object obj) {
            this.k++;
            throw null;
        }
    }

    public interface ConcatMapSupport<T> {
        void a(Throwable th);

        void b(Object obj);
    }

    public static final class WeakScalarSubscription<T> implements Subscription {
        public boolean c;

        public final void cancel() {
        }

        public final void request(long j) {
            if (j > 0 && !this.c) {
                this.c = true;
                throw null;
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        if (!FlowableScalarXMap.a(this.d, flowableSubscriber)) {
            int[] iArr = AnonymousClass1.f667a;
            throw null;
        }
    }
}
