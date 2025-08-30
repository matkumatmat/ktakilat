package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscription;

public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {
        public final FlowableSubscriber c;
        public final FlowableJust d;
        public final SubscriptionArbiter e = new SubscriptionArbiter();
        public boolean f = true;

        public SwitchIfEmptySubscriber(FlowableSubscriber flowableSubscriber, FlowableJust flowableJust) {
            this.c = flowableSubscriber;
            this.d = flowableJust;
        }

        public final void onComplete() {
            if (this.f) {
                this.f = false;
                this.d.d(this);
                return;
            }
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (this.f) {
                this.f = false;
            }
            this.c.onNext(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            this.e.setSubscription(subscription);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(flowableSubscriber, (FlowableJust) null);
        flowableSubscriber.onSubscribe(switchIfEmptySubscriber.e);
        this.d.a(switchIfEmptySubscriber);
    }
}
