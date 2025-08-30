package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntilPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class InnerSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public final FlowableSubscriber c;
        public Subscription d;
        public boolean e;

        public InnerSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.d.cancel();
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (!this.e) {
                this.e = true;
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                this.c.onNext(obj);
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.d.cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.c.onSubscribe(this);
            }
        }

        public final void request(long j) {
            this.d.request(j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new InnerSubscriber(flowableSubscriber));
    }
}
