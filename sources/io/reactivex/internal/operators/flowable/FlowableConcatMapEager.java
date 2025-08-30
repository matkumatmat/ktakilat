package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {

    public static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        public final FlowableSubscriber c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicLong e = new AtomicLong();
        public final SpscLinkedArrayQueue f = new SpscLinkedArrayQueue(Math.min(0, 0));
        public Subscription g;
        public volatile boolean i;
        public volatile boolean j;
        public volatile InnerQueuedSubscriber k;

        public ConcatMapEagerDelayErrorSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a(InnerQueuedSubscriber innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            b();
        }

        public final void b() {
            InnerQueuedSubscriber innerQueuedSubscriber;
            long j2;
            boolean z;
            SimpleQueue queue;
            int i2;
            boolean z2;
            if (getAndIncrement() == 0) {
                InnerQueuedSubscriber innerQueuedSubscriber2 = this.k;
                FlowableSubscriber flowableSubscriber = this.c;
                int i3 = 1;
                while (true) {
                    long j3 = this.e.get();
                    if (innerQueuedSubscriber2 != null) {
                        innerQueuedSubscriber = innerQueuedSubscriber2;
                    } else if (ErrorMode.END == null || ((Throwable) this.d.get()) == null) {
                        boolean z3 = this.j;
                        innerQueuedSubscriber = (InnerQueuedSubscriber) this.f.poll();
                        if (z3 && innerQueuedSubscriber == null) {
                            Throwable terminate = this.d.terminate();
                            if (terminate != null) {
                                flowableSubscriber.onError(terminate);
                                return;
                            } else {
                                flowableSubscriber.onComplete();
                                return;
                            }
                        } else if (innerQueuedSubscriber != null) {
                            this.k = innerQueuedSubscriber;
                        }
                    } else {
                        f();
                        flowableSubscriber.onError(this.d.terminate());
                        return;
                    }
                    if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                        j2 = 0;
                        z = false;
                    } else {
                        j2 = 0;
                        while (true) {
                            i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                            if (i2 == 0) {
                                break;
                            } else if (this.i) {
                                f();
                                return;
                            } else if (ErrorMode.IMMEDIATE != null || ((Throwable) this.d.get()) == null) {
                                boolean isDone = innerQueuedSubscriber.isDone();
                                try {
                                    Object poll = queue.poll();
                                    if (poll == null) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (isDone && z2) {
                                        this.k = null;
                                        this.g.request(1);
                                        innerQueuedSubscriber = null;
                                        z = true;
                                        break;
                                    } else if (z2) {
                                        break;
                                    } else {
                                        flowableSubscriber.onNext(poll);
                                        j2++;
                                        innerQueuedSubscriber.requestOne();
                                    }
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Exceptions.a(th2);
                                    this.k = null;
                                    innerQueuedSubscriber.cancel();
                                    f();
                                    flowableSubscriber.onError(th2);
                                    return;
                                }
                            } else {
                                this.k = null;
                                innerQueuedSubscriber.cancel();
                                f();
                                flowableSubscriber.onError(this.d.terminate());
                                return;
                            }
                        }
                        z = false;
                        if (i2 == 0) {
                            if (this.i) {
                                f();
                                return;
                            } else if (ErrorMode.IMMEDIATE != null || ((Throwable) this.d.get()) == null) {
                                boolean isDone2 = innerQueuedSubscriber.isDone();
                                boolean isEmpty = queue.isEmpty();
                                if (isDone2 && isEmpty) {
                                    this.k = null;
                                    this.g.request(1);
                                    innerQueuedSubscriber = null;
                                    z = true;
                                }
                            } else {
                                this.k = null;
                                innerQueuedSubscriber.cancel();
                                f();
                                flowableSubscriber.onError(this.d.terminate());
                                return;
                            }
                        }
                    }
                    if (!(j2 == 0 || j3 == LocationRequestCompat.PASSIVE_INTERVAL)) {
                        this.e.addAndGet(-j2);
                    }
                    if (z || (i3 = addAndGet(-i3)) != 0) {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                    } else {
                        return;
                    }
                }
            }
        }

        public final void cancel() {
            if (!this.i) {
                this.i = true;
                this.g.cancel();
                if (getAndIncrement() == 0) {
                    do {
                        f();
                    } while (decrementAndGet() != 0);
                }
            }
        }

        public final void d(InnerQueuedSubscriber innerQueuedSubscriber, Object obj) {
            if (innerQueuedSubscriber.queue().offer(obj)) {
                b();
                return;
            }
            innerQueuedSubscriber.cancel();
            e(innerQueuedSubscriber, new MissingBackpressureException());
        }

        public final void e(InnerQueuedSubscriber innerQueuedSubscriber, Throwable th) {
            if (this.d.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (ErrorMode.END != null) {
                    this.g.cancel();
                }
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void f() {
            while (true) {
                InnerQueuedSubscriber innerQueuedSubscriber = (InnerQueuedSubscriber) this.f.poll();
                if (innerQueuedSubscriber != null) {
                    innerQueuedSubscriber.cancel();
                } else {
                    return;
                }
            }
        }

        public final void onComplete() {
            this.j = true;
            b();
        }

        public final void onError(Throwable th) {
            if (this.d.addThrowable(th)) {
                this.j = true;
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.g.cancel();
                onError(th);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.c.onSubscribe(this);
                subscription.request((long) 0);
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.e, j2);
                b();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new ConcatMapEagerDelayErrorSubscriber(flowableSubscriber));
    }
}
