package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {

    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4945480365982832967L;
        public final FlowableSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public final AtomicReference e = new AtomicReference();
        public final AtomicThrowable f = new AtomicThrowable();
        public final OtherSubscriber g = new OtherSubscriber();

        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            public OtherSubscriber() {
            }

            public final void onComplete() {
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                SubscriptionHelper.cancel(takeUntilMainSubscriber.e);
                HalfSerializer.b(takeUntilMainSubscriber.c, takeUntilMainSubscriber, takeUntilMainSubscriber.f);
            }

            public final void onError(Throwable th) {
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                SubscriptionHelper.cancel(takeUntilMainSubscriber.e);
                HalfSerializer.d(takeUntilMainSubscriber.c, th, takeUntilMainSubscriber, takeUntilMainSubscriber.f);
            }

            public final void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            public final void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public TakeUntilMainSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this.e);
            SubscriptionHelper.cancel(this.g);
        }

        public final void onComplete() {
            SubscriptionHelper.cancel(this.g);
            HalfSerializer.b(this.c, this, this.f);
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.cancel(this.g);
            HalfSerializer.d(this.c, th, this, this.f);
        }

        public final void onNext(Object obj) {
            HalfSerializer.f(this.c, obj, this, this.f);
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.e, this.d, subscription);
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this.e, this.d, j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new TakeUntilMainSubscriber(flowableSubscriber));
        throw null;
    }
}
