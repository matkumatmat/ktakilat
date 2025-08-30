package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    public static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        public final FlowableSubscriber c;
        public final AtomicBoolean d = new AtomicBoolean();
        public long e;
        public Subscription f;
        public UnicastProcessor g;

        public WindowExactSubscriber(FlowableSubscriber flowableSubscriber) {
            super(1);
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            if (this.d.compareAndSet(false, true)) {
                run();
            }
        }

        public final void onComplete() {
            UnicastProcessor unicastProcessor = this.g;
            if (unicastProcessor != null) {
                this.g = null;
                unicastProcessor.onComplete();
            }
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            UnicastProcessor unicastProcessor = this.g;
            if (unicastProcessor != null) {
                this.g = null;
                unicastProcessor.onError(th);
            }
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            long j = this.e;
            UnicastProcessor unicastProcessor = this.g;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = new UnicastProcessor(this, 0);
                this.g = unicastProcessor;
                this.c.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            unicastProcessor.onNext(obj);
            if (j2 == 0) {
                this.e = 0;
                this.g = null;
                unicastProcessor.onComplete();
                return;
            }
            this.e = j2;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.c.onSubscribe(this);
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.f.request(BackpressureHelper.d(0, j));
            }
        }

        public final void run() {
            if (decrementAndGet() == 0) {
                this.f.cancel();
            }
        }
    }

    public static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        public Subscription c;
        public volatile boolean d;

        public final void cancel() {
            this.d = true;
            throw null;
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            if (0 != 0 || this.d) {
                throw null;
            }
            getAndIncrement();
            new UnicastProcessor(this, 0);
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a((AtomicLong) null, j);
                throw null;
            }
        }

        public final void run() {
            if (decrementAndGet() == 0) {
                this.c.cancel();
            }
        }
    }

    public static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        public long c;
        public Subscription d;
        public UnicastProcessor e;

        public final void cancel() {
            throw null;
        }

        public final void onComplete() {
            UnicastProcessor unicastProcessor = this.e;
            if (unicastProcessor != null) {
                this.e = null;
                unicastProcessor.onComplete();
            }
            throw null;
        }

        public final void onError(Throwable th) {
            UnicastProcessor unicastProcessor = this.e;
            if (unicastProcessor != null) {
                this.e = null;
                unicastProcessor.onError(th);
            }
            throw null;
        }

        public final void onNext(Object obj) {
            long j = this.c;
            UnicastProcessor unicastProcessor = this.e;
            if (j != 0) {
                long j2 = j + 1;
                if (unicastProcessor != null) {
                    unicastProcessor.onNext(obj);
                }
                int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i == 0) {
                    this.e = null;
                    unicastProcessor.onComplete();
                }
                if (i == 0) {
                    this.c = 0;
                } else {
                    this.c = j2;
                }
            } else {
                getAndIncrement();
                this.e = new UnicastProcessor(this, 0);
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                throw null;
            }
        }

        public final void run() {
            if (decrementAndGet() == 0) {
                this.d.cancel();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new WindowExactSubscriber(flowableSubscriber));
    }
}
