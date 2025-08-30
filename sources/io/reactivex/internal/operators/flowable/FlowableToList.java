package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import org.reactivestreams.Subscription;

public final class FlowableToList<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {

    public static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8134157938864266736L;
        public Subscription e;

        public final void cancel() {
            super.cancel();
            this.e.cancel();
        }

        public final void onComplete() {
            complete(this.d);
        }

        public final void onError(Throwable th) {
            this.d = null;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            Collection collection = (Collection) this.d;
            if (collection != null) {
                collection.add(obj);
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

    public final void b(FlowableSubscriber flowableSubscriber) {
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptySubscription.error(th, flowableSubscriber);
        }
    }
}
