package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {
        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            throw null;
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        public final void a(long j) {
            throw null;
        }

        public final void cancel() {
            super.cancel();
            throw null;
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce((AtomicReference<Subscription>) null, subscription)) {
                setSubscription(subscription);
            }
        }
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        public final void a(long j) {
            if (compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                SubscriptionHelper.cancel((AtomicReference<Subscription>) null);
                new TimeoutException();
                throw null;
            }
        }

        public final void cancel() {
            SubscriptionHelper.cancel((AtomicReference<Subscription>) null);
            throw null;
        }

        public final void onComplete() {
            if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
                RxJavaPlugins.b(th);
                return;
            }
            throw null;
        }

        public final void onNext(Object obj) {
            long j = get();
            if (j != LocationRequestCompat.PASSIVE_INTERVAL && compareAndSet(j, 1 + j)) {
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce((AtomicReference<Subscription>) null, (AtomicLong) null, subscription);
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest((AtomicReference<Subscription>) null, (AtomicLong) null, j);
        }
    }

    public interface TimeoutSupport {
        void a(long j);
    }

    public static final class TimeoutTask implements Runnable {
        public final void run() {
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
