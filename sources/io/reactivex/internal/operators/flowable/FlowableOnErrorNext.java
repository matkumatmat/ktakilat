package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class OnErrorNextSubscriber<T> implements FlowableSubscriber<T> {
        public final FlowableSubscriber c;
        public final SubscriptionArbiter d = new SubscriptionArbiter();
        public boolean e;
        public boolean f;

        public OnErrorNextSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                this.e = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            boolean z = this.e;
            FlowableSubscriber flowableSubscriber = this.c;
            if (!z) {
                this.e = true;
                try {
                    throw null;
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    flowableSubscriber.onError(new CompositeException(th, th2));
                }
            } else if (this.f) {
                RxJavaPlugins.b(th);
            } else {
                flowableSubscriber.onError(th);
            }
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                this.c.onNext(obj);
                if (!this.e) {
                    this.d.produced(1);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            this.d.setSubscription(subscription);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(flowableSubscriber);
        flowableSubscriber.onSubscribe(onErrorNextSubscriber.d);
        this.d.a(onErrorNextSubscriber);
    }
}
