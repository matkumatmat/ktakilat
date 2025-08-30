package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {

    public final class SingletonArrayFunc implements Function<T, R> {
        public final Object apply(Object obj) {
            throw null;
        }
    }

    public static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;
        public volatile boolean c;

        public final boolean c(Object obj) {
            if (this.c) {
                return false;
            }
            throw null;
        }

        public final void cancel() {
            SubscriptionHelper.cancel((AtomicReference<Subscription>) null);
            throw null;
        }

        public final void onComplete() {
            if (!this.c) {
                this.c = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.b(th);
            } else {
                this.c = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            c(obj);
            if (!this.c) {
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

    public static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        public boolean c;

        public final void onComplete() {
            if (!this.c) {
                throw null;
            }
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            if (!this.c) {
                this.c = true;
            }
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptySubscription.error(th, flowableSubscriber);
        }
    }
}
