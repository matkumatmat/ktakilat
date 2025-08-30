package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public final FlowableSubscriber c;
        public Subscription d;

        public SubscriptionLambdaSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(th);
                this.d.cancel();
            }
        }

        public final void onComplete() {
            if (this.d != SubscriptionHelper.CANCELLED) {
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.d != SubscriptionHelper.CANCELLED) {
                this.c.onError(th);
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                subscription.cancel();
                this.d = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.c);
            }
        }

        public final void request(long j) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(th);
                this.d.request(j);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SubscriptionLambdaSubscriber(flowableSubscriber));
    }
}
