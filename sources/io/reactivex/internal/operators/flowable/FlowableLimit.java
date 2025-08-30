package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableLimit<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2288246011222124525L;
        public final FlowableSubscriber c;
        public long d = 0;
        public Subscription e;

        public LimitSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
            lazySet(0);
        }

        public final void cancel() {
            this.e.cancel();
        }

        public final void onComplete() {
            if (this.d > 0) {
                this.d = 0;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.d > 0) {
                this.d = 0;
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            long j = this.d;
            if (j > 0) {
                long j2 = j - 1;
                this.d = j2;
                FlowableSubscriber flowableSubscriber = this.c;
                flowableSubscriber.onNext(obj);
                if (j2 == 0) {
                    this.e.cancel();
                    flowableSubscriber.onComplete();
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                long j = this.d;
                FlowableSubscriber flowableSubscriber = this.c;
                if (j == 0) {
                    subscription.cancel();
                    EmptySubscription.complete(flowableSubscriber);
                    return;
                }
                this.e = subscription;
                flowableSubscriber.onSubscribe(this);
            }
        }

        public final void request(long j) {
            long j2;
            long j3;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != 0) {
                        if (j2 <= j) {
                            j3 = j2;
                        } else {
                            j3 = j;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j2 - j3));
                this.e.request(j3);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new LimitSubscriber(flowableSubscriber));
    }
}
