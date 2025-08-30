package io.reactivex.internal.operators.parallel;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ParallelReduceFull<T> extends Flowable<T> {

    public static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        public Object c;
        public boolean d;

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
            } else {
                this.d = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            if (this.d) {
                return;
            }
            if (this.c == null) {
                this.c = obj;
                return;
            }
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                ((Subscription) get()).cancel();
                onError(th);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;

        public final void cancel() {
            throw null;
        }
    }

    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
