package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        public final FlowableSubscriber c;
        public final SpscLinkedArrayQueue d;
        public Subscription e;
        public final AtomicLong f = new AtomicLong();
        public volatile boolean g;

        public SkipLastTimedSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
            this.d = new SpscLinkedArrayQueue(0);
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    AtomicLong atomicLong = this.f;
                    if (0 == atomicLong.get()) {
                        if (0 != 0) {
                            BackpressureHelper.e(atomicLong, 0);
                        }
                        i = addAndGet(-i);
                    } else {
                        Long l = (Long) this.d.b();
                        throw null;
                    }
                } while (i != 0);
            }
        }

        public final void cancel() {
            if (!this.g) {
                this.g = true;
                this.e.cancel();
                if (getAndIncrement() == 0) {
                    this.d.clear();
                }
            }
        }

        public final void onComplete() {
            a();
        }

        public final void onError(Throwable th) {
            a();
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this.f, j);
                a();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SkipLastTimedSubscriber(flowableSubscriber));
    }
}
