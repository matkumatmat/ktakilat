package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {

    public static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        public final FlowableSubscriber c;
        public final int d = 0;
        public final AtomicLong e = new AtomicLong();
        public Subscription f;
        public SimpleQueue g;
        public volatile boolean i;
        public volatile boolean j;
        public final AtomicReference k = new AtomicReference();
        public Iterator l;
        public int m;
        public int n;

        public FlattenIterableSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void b() {
            boolean z;
            boolean z2;
            boolean z3;
            if (getAndIncrement() == 0) {
                FlowableSubscriber flowableSubscriber = this.c;
                SimpleQueue simpleQueue = this.g;
                int i2 = 1;
                boolean z4 = false;
                if (this.n != 1) {
                    z = true;
                } else {
                    z = false;
                }
                Iterator it = this.l;
                int i3 = 1;
                while (true) {
                    if (it == null) {
                        boolean z5 = this.i;
                        try {
                            Object poll = simpleQueue.poll();
                            if (poll == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!e(z5, z3, flowableSubscriber, simpleQueue)) {
                                if (poll != null) {
                                    try {
                                        throw null;
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                        Exceptions.a(th2);
                                        this.f.cancel();
                                        ExceptionHelper.a(this.k, th2);
                                        flowableSubscriber.onError(ExceptionHelper.b(this.k));
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            Exceptions.a(th4);
                            this.f.cancel();
                            ExceptionHelper.a(this.k, th4);
                            Throwable b = ExceptionHelper.b(this.k);
                            this.l = null;
                            simpleQueue.clear();
                            flowableSubscriber.onError(b);
                            return;
                        }
                    }
                    if (it != null) {
                        long j2 = this.e.get();
                        long j3 = 0;
                        while (true) {
                            if (j3 == j2) {
                                break;
                            } else if (!e(this.i, z4, flowableSubscriber, simpleQueue)) {
                                try {
                                    Object next = it.next();
                                    ObjectHelper.b(next, "The iterator returned a null value");
                                    flowableSubscriber.onNext(next);
                                    if (!e(this.i, z4, flowableSubscriber, simpleQueue)) {
                                        j3++;
                                        try {
                                            if (!it.hasNext()) {
                                                if (z) {
                                                    int i4 = this.m + i2;
                                                    if (i4 == this.d) {
                                                        this.m = z4 ? 1 : 0;
                                                        this.f.request((long) i4);
                                                    } else {
                                                        this.m = i4;
                                                    }
                                                }
                                                this.l = null;
                                                it = null;
                                            }
                                        } catch (Throwable th5) {
                                            Throwable th6 = th5;
                                            Exceptions.a(th6);
                                            this.l = null;
                                            this.f.cancel();
                                            ExceptionHelper.a(this.k, th6);
                                            flowableSubscriber.onError(ExceptionHelper.b(this.k));
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th7) {
                                    Exceptions.a(th7);
                                    this.l = null;
                                    this.f.cancel();
                                    ExceptionHelper.a(this.k, th7);
                                    flowableSubscriber.onError(ExceptionHelper.b(this.k));
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (j3 == j2) {
                            boolean z6 = this.i;
                            if (!simpleQueue.isEmpty() || it != null) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (e(z6, z2, flowableSubscriber, simpleQueue)) {
                                return;
                            }
                        }
                        if (!(j3 == 0 || j2 == LocationRequestCompat.PASSIVE_INTERVAL)) {
                            this.e.addAndGet(-j3);
                        }
                        if (it == null) {
                            continue;
                            i2 = 1;
                            z4 = false;
                        }
                    }
                    i3 = addAndGet(-i3);
                    if (i3 != 0) {
                        i2 = 1;
                        z4 = false;
                    } else {
                        return;
                    }
                }
            }
        }

        public final void cancel() {
            if (!this.j) {
                this.j = true;
                this.f.cancel();
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }

        public final void clear() {
            this.l = null;
            this.g.clear();
        }

        public final boolean e(boolean z, boolean z2, FlowableSubscriber flowableSubscriber, SimpleQueue simpleQueue) {
            if (this.j) {
                this.l = null;
                simpleQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (((Throwable) this.k.get()) != null) {
                    Throwable b = ExceptionHelper.b(this.k);
                    this.l = null;
                    simpleQueue.clear();
                    flowableSubscriber.onError(b);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    flowableSubscriber.onComplete();
                    return true;
                }
            }
        }

        public final boolean isEmpty() {
            if (this.l != null || !this.g.isEmpty()) {
                return false;
            }
            return true;
        }

        public final void onComplete() {
            if (!this.i) {
                this.i = true;
                b();
            }
        }

        public final void onError(Throwable th) {
            if (this.i || !ExceptionHelper.a(this.k, th)) {
                RxJavaPlugins.b(th);
                return;
            }
            this.i = true;
            b();
        }

        public final void onNext(Object obj) {
            if (!this.i) {
                if (this.n != 0 || this.g.offer(obj)) {
                    b();
                } else {
                    onError(new MissingBackpressureException("Queue is full?!"));
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.n = requestFusion;
                        this.g = queueSubscription;
                        this.i = true;
                        this.c.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.n = requestFusion;
                        this.g = queueSubscription;
                        this.c.onSubscribe(this);
                        subscription.request((long) 0);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(0);
                this.c.onSubscribe(this);
                subscription.request((long) 0);
            }
        }

        public final Object poll() {
            Iterator it = this.l;
            if (it != null) {
                Object next = it.next();
                ObjectHelper.b(next, "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.l = null;
                }
                return next;
            } else if (this.g.poll() == null) {
                return null;
            } else {
                throw null;
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.a(this.e, j2);
                b();
            }
        }

        public final int requestFusion(int i2) {
            if ((i2 & 1) == 0 || this.n != 1) {
                return 0;
            }
            return 1;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        Flowable flowable = this.d;
        if (flowable instanceof Callable) {
            try {
                if (((Callable) flowable).call() == null) {
                    EmptySubscription.complete(flowableSubscriber);
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    EmptySubscription.error(th, flowableSubscriber);
                }
            } catch (Throwable th2) {
                Exceptions.a(th2);
                EmptySubscription.error(th2, flowableSubscriber);
            }
        } else {
            flowable.a(new FlattenIterableSubscriber(flowableSubscriber));
        }
    }
}
