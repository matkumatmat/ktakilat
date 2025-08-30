package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {

    public static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        public final EqualSubscriber e = new EqualSubscriber(this);
        public final EqualSubscriber f = new EqualSubscriber(this);
        public final AtomicThrowable g = new AtomicThrowable();
        public final AtomicInteger i = new AtomicInteger();
        public Object j;
        public Object k;

        public EqualCoordinator(FlowableSubscriber flowableSubscriber) {
            super(flowableSubscriber);
        }

        public final void a(Throwable th) {
            if (this.g.addThrowable(th)) {
                b();
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void b() {
            boolean z;
            if (this.i.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    SimpleQueue simpleQueue = this.e.d;
                    SimpleQueue simpleQueue2 = this.f.d;
                    if (simpleQueue == null || simpleQueue2 == null) {
                        if (isCancelled()) {
                            this.e.a();
                            this.f.a();
                            return;
                        } else if (((Throwable) this.g.get()) != null) {
                            e();
                            this.c.onError(this.g.terminate());
                            return;
                        }
                    } else if (isCancelled()) {
                        this.e.a();
                        this.f.a();
                        return;
                    } else if (((Throwable) this.g.get()) != null) {
                        e();
                        this.c.onError(this.g.terminate());
                        return;
                    } else {
                        boolean z2 = this.e.e;
                        Object obj = this.j;
                        if (obj == null) {
                            try {
                                obj = simpleQueue.poll();
                                this.j = obj;
                            } catch (Throwable th) {
                                Exceptions.a(th);
                                e();
                                this.g.addThrowable(th);
                                this.c.onError(this.g.terminate());
                                return;
                            }
                        }
                        boolean z3 = false;
                        if (obj == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z4 = this.f.e;
                        Object obj2 = this.k;
                        if (obj2 == null) {
                            try {
                                obj2 = simpleQueue2.poll();
                                this.k = obj2;
                            } catch (Throwable th2) {
                                Exceptions.a(th2);
                                e();
                                this.g.addThrowable(th2);
                                this.c.onError(this.g.terminate());
                                return;
                            }
                        }
                        if (obj2 == null) {
                            z3 = true;
                        }
                        if (z2 && z4 && z && z3) {
                            complete(Boolean.TRUE);
                            return;
                        } else if (z2 && z4 && z != z3) {
                            e();
                            complete(Boolean.FALSE);
                            return;
                        } else if (!z && !z3) {
                            try {
                                throw null;
                            } catch (Throwable th3) {
                                Exceptions.a(th3);
                                e();
                                this.g.addThrowable(th3);
                                this.c.onError(this.g.terminate());
                                return;
                            }
                        }
                    }
                    i2 = this.i.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public final void cancel() {
            super.cancel();
            EqualSubscriber equalSubscriber = this.e;
            equalSubscriber.getClass();
            SubscriptionHelper.cancel(equalSubscriber);
            EqualSubscriber equalSubscriber2 = this.f;
            equalSubscriber2.getClass();
            SubscriptionHelper.cancel(equalSubscriber2);
            if (this.i.getAndIncrement() == 0) {
                equalSubscriber.a();
                equalSubscriber2.a();
            }
        }

        public final void e() {
            EqualSubscriber equalSubscriber = this.e;
            equalSubscriber.getClass();
            SubscriptionHelper.cancel(equalSubscriber);
            equalSubscriber.a();
            EqualSubscriber equalSubscriber2 = this.f;
            equalSubscriber2.getClass();
            SubscriptionHelper.cancel(equalSubscriber2);
            equalSubscriber2.a();
        }
    }

    public interface EqualCoordinatorHelper {
        void a(Throwable th);

        void b();
    }

    public static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        public final AtomicInteger c;
        public volatile SimpleQueue d;
        public volatile boolean e;
        public int f;

        public EqualSubscriber(EqualCoordinatorHelper equalCoordinatorHelper) {
            this.c = (AtomicInteger) equalCoordinatorHelper;
        }

        public final void a() {
            SimpleQueue simpleQueue = this.d;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [java.util.concurrent.atomic.AtomicInteger, io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinatorHelper] */
        public final void onComplete() {
            this.e = true;
            this.c.b();
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicInteger, io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinatorHelper] */
        public final void onError(Throwable th) {
            this.c.a(th);
        }

        /* JADX WARNING: type inference failed for: r2v1, types: [java.util.concurrent.atomic.AtomicInteger, io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinatorHelper] */
        public final void onNext(Object obj) {
            if (this.f != 0 || this.d.offer(obj)) {
                this.c.b();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        /* JADX WARNING: type inference failed for: r5v1, types: [java.util.concurrent.atomic.AtomicInteger, io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinatorHelper] */
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f = requestFusion;
                        this.d = queueSubscription;
                        this.e = true;
                        this.c.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f = requestFusion;
                        this.d = queueSubscription;
                        subscription.request((long) 0);
                        return;
                    }
                }
                this.d = new SpscArrayQueue(0);
                subscription.request((long) 0);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new EqualCoordinator(flowableSubscriber));
        throw null;
    }
}
