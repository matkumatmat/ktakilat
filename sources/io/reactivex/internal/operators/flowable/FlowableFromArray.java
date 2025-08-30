package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;

public final class FlowableFromArray<T> extends Flowable<T> {

    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        public final ConditionalSubscriber c;

        public ArrayConditionalSubscription(ConditionalSubscriber conditionalSubscriber) {
            this.c = conditionalSubscriber;
        }

        public final void a() {
            throw null;
        }

        public final void b(long j) {
            throw null;
        }
    }

    public static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        public final FlowableSubscriber c;

        public ArraySubscription(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a() {
            throw null;
        }

        public final void b(long j) {
            throw null;
        }
    }

    public static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;

        public abstract void a();

        public abstract void b(long j);

        public final void cancel() {
        }

        public final void clear() {
            throw null;
        }

        public final boolean isEmpty() {
            throw null;
        }

        public final Object poll() {
            throw null;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.a(this, j) == 0) {
                if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                    a();
                } else {
                    b(j);
                }
            }
        }

        public final int requestFusion(int i) {
            return i & 1;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        if (flowableSubscriber instanceof ConditionalSubscriber) {
            flowableSubscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) flowableSubscriber));
        } else {
            flowableSubscriber.onSubscribe(new ArraySubscription(flowableSubscriber));
        }
    }
}
