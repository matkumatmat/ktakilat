package io.reactivex.internal.operators.parallel;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class ParallelCollect<T, C> extends ParallelFlowable<C> {

    public static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        public boolean f;

        public final void cancel() {
            super.cancel();
            this.e.cancel();
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                complete(null);
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }
}
