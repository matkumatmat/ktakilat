package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;
        public final FlowableSubscriber c;
        public Subscription d;
        public volatile boolean e;
        public volatile boolean f;
        public final AtomicLong g = new AtomicLong();
        public final AtomicInteger i = new AtomicInteger();

        public TakeLastSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a() {
            if (this.i.getAndIncrement() == 0) {
                FlowableSubscriber flowableSubscriber = this.c;
                long j = this.g.get();
                while (!this.f) {
                    if (this.e) {
                        long j2 = 0;
                        while (j2 != j) {
                            if (!this.f) {
                                Object poll = poll();
                                if (poll == null) {
                                    flowableSubscriber.onComplete();
                                    return;
                                } else {
                                    flowableSubscriber.onNext(poll);
                                    j2++;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!(j2 == 0 || j == LocationRequestCompat.PASSIVE_INTERVAL)) {
                            j = this.g.addAndGet(-j2);
                        }
                    }
                    if (this.i.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public final void cancel() {
            this.f = true;
            this.d.cancel();
        }

        public final void onComplete() {
            this.e = true;
            a();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (size() == 0) {
                poll();
            }
            offer(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this.g, j);
                a();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new TakeLastSubscriber(flowableSubscriber));
    }
}
