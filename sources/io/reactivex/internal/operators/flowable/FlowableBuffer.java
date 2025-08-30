package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {

    public static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        public final FlowableSubscriber c;
        public Collection d;
        public Subscription e;
        public boolean f;
        public int g;

        public PublisherBufferExactSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.e.cancel();
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                Collection collection = this.d;
                FlowableSubscriber flowableSubscriber = this.c;
                if (collection != null && !collection.isEmpty()) {
                    flowableSubscriber.onNext(collection);
                }
                flowableSubscriber.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                Collection collection = this.d;
                if (collection != null) {
                    collection.add(obj);
                    int i = this.g + 1;
                    if (i == 0) {
                        this.g = 0;
                        this.d = null;
                        this.c.onNext(collection);
                        return;
                    }
                    this.g = i;
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.c.onSubscribe(this);
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.e.request(BackpressureHelper.d(j, (long) 0));
            }
        }
    }

    public static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        public Subscription c;
        public boolean d;
        public volatile boolean e;

        public final void cancel() {
            this.e = true;
            this.c.cancel();
        }

        public final boolean getAsBoolean() {
            return this.e;
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                if (0 != 0) {
                    BackpressureHelper.e(this, 0);
                }
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
            } else {
                this.d = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            if (!this.d) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                throw null;
            }
        }

        /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Throwable, java.util.ArrayDeque] */
        public final void request(long j) {
            long j2;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                } while (!compareAndSet(j2, BackpressureHelper.c(LocationRequestCompat.PASSIVE_INTERVAL & j2, j) | (j2 & Long.MIN_VALUE)));
                ? r2 = 0;
                if (j2 == Long.MIN_VALUE) {
                    long j3 = j | Long.MIN_VALUE;
                    long j4 = j3 & Long.MIN_VALUE;
                    while (true) {
                        boolean z = true;
                        if (j4 != j3) {
                            try {
                                z = getAsBoolean();
                            } catch (Throwable th) {
                                Exceptions.a(th);
                            }
                            if (!z) {
                                r2.poll().getClass();
                                throw null;
                            }
                            return;
                        }
                        try {
                            z = getAsBoolean();
                        } catch (Throwable th2) {
                            Exceptions.a(th2);
                        }
                        if (!z) {
                            if (!r2.isEmpty()) {
                                j3 = get();
                                if (j3 == j4) {
                                    long addAndGet = addAndGet(-(j4 & LocationRequestCompat.PASSIVE_INTERVAL));
                                    if ((LocationRequestCompat.PASSIVE_INTERVAL & addAndGet) != 0) {
                                        j3 = addAndGet;
                                        j4 = addAndGet & Long.MIN_VALUE;
                                    } else {
                                        return;
                                    }
                                }
                            } else {
                                throw null;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    throw r2;
                }
            }
        }
    }

    public static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        public Collection c;
        public Subscription d;
        public boolean e;
        public int f;

        public final void cancel() {
            this.d.cancel();
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                Collection collection = this.c;
                this.c = null;
                collection.getClass();
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            this.c = null;
            throw null;
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                Collection collection = this.c;
                int i = this.f;
                int i2 = i + 1;
                if (i != 0) {
                    if (collection != null) {
                        collection.add(obj);
                        if (collection.size() == 0) {
                            this.c = null;
                            throw null;
                        }
                    }
                    if (i2 == 0) {
                        i2 = 0;
                    }
                    this.f = i2;
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                throw null;
            }
        }

        public final void request(long j) {
            if (!SubscriptionHelper.validate(j)) {
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.d.request(BackpressureHelper.d((long) 0, j));
                return;
            }
            this.d.request(BackpressureHelper.c(BackpressureHelper.d(j, (long) 0), BackpressureHelper.d((long) 0, j - 1)));
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new PublisherBufferExactSubscriber(flowableSubscriber));
    }
}
