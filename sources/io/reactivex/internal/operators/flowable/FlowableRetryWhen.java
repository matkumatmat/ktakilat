package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;

public final class FlowableRetryWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            long j = this.k;
            if (j != 0) {
                this.k = 0;
                produced(j);
            }
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        new UnicastProcessor((Runnable) null, 8).e();
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptySubscription.error(th, flowableSubscriber);
        }
    }
}
