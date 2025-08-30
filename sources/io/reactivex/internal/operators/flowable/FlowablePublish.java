package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {

    public static final class FlowablePublisher<T> implements Publisher<T> {
        public final void d(Subscriber subscriber) {
            subscriber.onSubscribe(new InnerSubscriber(subscriber));
            throw null;
        }
    }

    public static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        public final Subscriber c;

        public InnerSubscriber(Subscriber subscriber) {
            this.c = subscriber;
        }

        public final void cancel() {
            if (get() != Long.MIN_VALUE) {
                getAndSet(Long.MIN_VALUE);
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.b(this, j);
            }
        }
    }

    public static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = -202316842419149694L;
        public volatile Object c;
        public int d;
        public volatile SimpleQueue e;

        public final void a() {
            if (getAndIncrement() == 0) {
                throw null;
            }
        }

        public final void dispose() {
            throw null;
        }

        public final boolean isDisposed() {
            throw null;
        }

        public final void onComplete() {
            if (this.c == null) {
                this.c = NotificationLite.complete();
                a();
            }
        }

        public final void onError(Throwable th) {
            if (this.c == null) {
                this.c = NotificationLite.error(th);
                a();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (this.d != 0 || this.e.offer(obj)) {
                a();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce((AtomicReference<Subscription>) null, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.d = requestFusion;
                        this.e = queueSubscription;
                        this.c = NotificationLite.complete();
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.d = requestFusion;
                        this.e = queueSubscription;
                        subscription.request((long) 0);
                        return;
                    }
                }
                this.e = new SpscArrayQueue(0);
                subscription.request((long) 0);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
