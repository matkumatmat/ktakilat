package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableConcatArray<T> extends Flowable<T> {

    public static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        public final FlowableSubscriber k;
        public final AtomicInteger l = new AtomicInteger();
        public long m;

        public ConcatArraySubscriber(FlowableSubscriber flowableSubscriber) {
            this.k = flowableSubscriber;
        }

        public final void onComplete() {
            if (this.l.getAndIncrement() == 0) {
                throw null;
            }
        }

        public final void onError(Throwable th) {
            this.k.onError(th);
        }

        public final void onNext(Object obj) {
            this.m++;
            this.k.onNext(obj);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(flowableSubscriber);
        flowableSubscriber.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
