package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {

    public static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;

        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public final boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) get());
        }

        public final void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                throw null;
            }
        }

        public final void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj == subscriptionHelper) {
                RxJavaPlugins.b(th);
            } else {
                lazySet(subscriptionHelper);
                throw null;
            }
        }

        public final void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                lazySet(subscriptionHelper);
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        public final void a(long j) {
            throw null;
        }

        public final void b(long j, Throwable th) {
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

    public interface TimeoutSelectorSupport extends FlowableTimeoutTimed.TimeoutSupport {
        void b(long j, Throwable th);
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        public final FlowableSubscriber c;
        public final SequentialDisposable d = new SequentialDisposable();
        public final AtomicReference e = new AtomicReference();
        public final AtomicLong f = new AtomicLong();

        public TimeoutSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a(long j) {
            if (compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                SubscriptionHelper.cancel(this.e);
                this.c.onError(new TimeoutException());
            }
        }

        public final void b(long j, Throwable th) {
            if (compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                SubscriptionHelper.cancel(this.e);
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this.e);
            this.d.dispose();
        }

        public final void onComplete() {
            if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.d.dispose();
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.d.dispose();
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            long j = get();
            if (j != LocationRequestCompat.PASSIVE_INTERVAL && compareAndSet(j, 1 + j)) {
                Disposable disposable = (Disposable) this.d.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                FlowableSubscriber flowableSubscriber = this.c;
                flowableSubscriber.onNext(obj);
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    ((Subscription) this.e.get()).cancel();
                    getAndSet(LocationRequestCompat.PASSIVE_INTERVAL);
                    flowableSubscriber.onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.e, this.f, subscription);
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this.e, this.f, j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(flowableSubscriber);
        flowableSubscriber.onSubscribe(timeoutSubscriber);
        this.d.a(timeoutSubscriber);
    }
}
