package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f669a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.BackpressureOverflowStrategy[] r0 = io.reactivex.BackpressureOverflowStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f669a = r0
                io.reactivex.BackpressureOverflowStrategy r1 = io.reactivex.BackpressureOverflowStrategy.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f669a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureOverflowStrategy r1 = io.reactivex.BackpressureOverflowStrategy.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        public final FlowableSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public final ArrayDeque e = new ArrayDeque();
        public Subscription f;
        public volatile boolean g;
        public volatile boolean i;
        public Throwable j;

        public OnBackpressureBufferStrategySubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public static void a(ArrayDeque arrayDeque) {
            synchronized (arrayDeque) {
                arrayDeque.clear();
            }
        }

        public final void b() {
            int i2;
            boolean isEmpty;
            Object poll;
            boolean z;
            if (getAndIncrement() == 0) {
                ArrayDeque arrayDeque = this.e;
                FlowableSubscriber flowableSubscriber = this.c;
                int i3 = 1;
                do {
                    long j2 = this.d.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.g) {
                            a(arrayDeque);
                            return;
                        } else {
                            boolean z2 = this.i;
                            synchronized (arrayDeque) {
                                poll = arrayDeque.poll();
                            }
                            if (poll == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z2) {
                                Throwable th = this.j;
                                if (th != null) {
                                    a(arrayDeque);
                                    flowableSubscriber.onError(th);
                                    return;
                                } else if (z) {
                                    flowableSubscriber.onComplete();
                                    return;
                                }
                            }
                            if (z) {
                                break;
                            }
                            flowableSubscriber.onNext(poll);
                            j3++;
                        }
                    }
                    if (i2 == 0) {
                        if (this.g) {
                            a(arrayDeque);
                            return;
                        }
                        boolean z3 = this.i;
                        synchronized (arrayDeque) {
                            isEmpty = arrayDeque.isEmpty();
                        }
                        if (z3) {
                            Throwable th2 = this.j;
                            if (th2 != null) {
                                a(arrayDeque);
                                flowableSubscriber.onError(th2);
                                return;
                            } else if (isEmpty) {
                                flowableSubscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.e(this.d, j3);
                    }
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public final void cancel() {
            this.g = true;
            this.f.cancel();
            if (getAndIncrement() == 0) {
                a(this.e);
            }
        }

        public final void onComplete() {
            this.i = true;
            b();
        }

        public final void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.b(th);
                return;
            }
            this.j = th;
            this.i = true;
            b();
        }

        public final void onNext(Object obj) {
            if (!this.i) {
                ArrayDeque arrayDeque = this.e;
                synchronized (arrayDeque) {
                    if (((long) arrayDeque.size()) != 0) {
                        arrayDeque.offer(obj);
                    } else {
                        int[] iArr = AnonymousClass1.f669a;
                        throw null;
                    }
                }
                b();
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.d, j2);
                b();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new OnBackpressureBufferStrategySubscriber(flowableSubscriber));
    }
}
