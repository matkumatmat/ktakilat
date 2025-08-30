package io.reactivex.processors;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

@Experimental
@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    public volatile SimpleQueue d;

    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        public final FlowableSubscriber c;
        public final MulticastProcessor d;

        public MulticastSubscription(FlowableSubscriber flowableSubscriber, MulticastProcessor multicastProcessor) {
            this.c = flowableSubscriber;
            this.d = multicastProcessor;
        }

        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.d.getClass();
                throw null;
            }
        }

        public final void request(long j) {
            long j2;
            long j3;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                        if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                            long j4 = j2 + j;
                            if (j4 >= 0) {
                                j3 = j4;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.d.getClass();
                throw null;
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new MulticastSubscription(flowableSubscriber, this));
        throw null;
    }

    public final void onComplete() {
        throw null;
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        throw null;
    }

    public final void onNext(Object obj) {
        throw null;
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce((AtomicReference<Subscription>) null, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.d = queueSubscription;
                    throw null;
                } else if (requestFusion == 2) {
                    this.d = queueSubscription;
                    subscription.request((long) 0);
                    return;
                }
            }
            new SpscArrayQueue(0);
            subscription.request((long) 0);
        }
    }
}
