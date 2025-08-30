package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {

    public static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        public Subscription c;
        public SimpleQueue d;
        public int e;

        public final class RailSubscription implements Subscription {
            public final void cancel() {
                throw null;
            }

            public final void request(long j) {
                if (SubscriptionHelper.validate(j)) {
                    throw null;
                }
            }
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                if (this.e == 1) {
                    throw null;
                }
                throw null;
            }
        }

        public final void onComplete() {
            a();
        }

        public final void onError(Throwable th) {
            a();
        }

        public final void onNext(Object obj) {
            if (this.e != 0 || this.d.offer(obj)) {
                a();
                return;
            }
            this.c.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.e = requestFusion;
                        this.d = queueSubscription;
                        throw null;
                    } else if (requestFusion == 2) {
                        this.e = requestFusion;
                        this.d = queueSubscription;
                        throw null;
                    }
                }
                this.d = new SpscArrayQueue(0);
                throw null;
            }
        }
    }
}
