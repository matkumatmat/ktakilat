package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
        public final void onComplete() {
        }

        public final void onError(Throwable th) {
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce((AtomicReference<Subscription>) null, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        public final FlowableSubscriber c;
        public final AtomicLong d = new AtomicLong();

        public ReplaySubscription(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            if (this.d.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                AtomicLong atomicLong = this.d;
                BackpressureHelper.b(atomicLong, j);
                if (getAndIncrement() == 0 && atomicLong.get() != Long.MIN_VALUE) {
                    throw null;
                }
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new ReplaySubscription(flowableSubscriber));
        throw null;
    }
}
