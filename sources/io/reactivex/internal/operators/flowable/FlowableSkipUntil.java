package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSkipUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6270983465606289181L;
        public final FlowableSubscriber c;
        public final AtomicReference d = new AtomicReference();
        public final AtomicLong e = new AtomicLong();
        public final OtherSubscriber f = new OtherSubscriber();
        public final AtomicThrowable g = new AtomicThrowable();
        public volatile boolean i;

        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            public OtherSubscriber() {
            }

            public final void onComplete() {
                SkipUntilMainSubscriber.this.i = true;
            }

            public final void onError(Throwable th) {
                SkipUntilMainSubscriber skipUntilMainSubscriber = SkipUntilMainSubscriber.this;
                SubscriptionHelper.cancel(skipUntilMainSubscriber.d);
                HalfSerializer.d(skipUntilMainSubscriber.c, th, skipUntilMainSubscriber, skipUntilMainSubscriber.g);
            }

            public final void onNext(Object obj) {
                SkipUntilMainSubscriber.this.i = true;
                ((Subscription) get()).cancel();
            }

            public final void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public SkipUntilMainSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final boolean c(Object obj) {
            if (!this.i) {
                return false;
            }
            HalfSerializer.f(this.c, obj, this, this.g);
            return true;
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this.d);
            SubscriptionHelper.cancel(this.f);
        }

        public final void onComplete() {
            SubscriptionHelper.cancel(this.f);
            HalfSerializer.b(this.c, this, this.g);
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.cancel(this.f);
            HalfSerializer.d(this.c, th, this, this.g);
        }

        public final void onNext(Object obj) {
            if (!c(obj)) {
                ((Subscription) this.d.get()).request(1);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.d, this.e, subscription);
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this.d, this.e, j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new SkipUntilMainSubscriber(flowableSubscriber));
        throw null;
    }
}
