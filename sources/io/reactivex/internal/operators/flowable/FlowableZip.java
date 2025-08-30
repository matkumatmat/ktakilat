package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R> extends Flowable<R> {

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        public volatile boolean c;

        public final void cancel() {
            if (!this.c) {
                this.c = true;
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a((AtomicLong) null, j);
                throw null;
            }
        }
    }

    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        public SimpleQueue c;
        public long d;
        public int e;

        public final void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            if (this.e != 2) {
                this.c.offer(obj);
            }
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.e = requestFusion;
                        this.c = queueSubscription;
                        throw null;
                    } else if (requestFusion == 2) {
                        this.e = requestFusion;
                        this.c = queueSubscription;
                        subscription.request((long) 0);
                        return;
                    }
                }
                this.c = new SpscArrayQueue(0);
                subscription.request((long) 0);
            }
        }

        public final void request(long j) {
            if (this.e != 1) {
                long j2 = this.d + j;
                if (j2 >= ((long) 0)) {
                    this.d = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.d = j2;
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        Throwable th = null;
        th.getClass();
        throw th;
    }
}
