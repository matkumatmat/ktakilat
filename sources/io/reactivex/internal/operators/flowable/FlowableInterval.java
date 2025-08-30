package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableInterval extends Flowable<Long> {

    public static final class IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public final FlowableSubscriber c;
        public long d;
        public final AtomicReference e = new AtomicReference();

        public IntervalSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            DisposableHelper.dispose(this.e);
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this, j);
            }
        }

        public final void run() {
            AtomicReference atomicReference = this.e;
            if (atomicReference.get() != DisposableHelper.DISPOSED) {
                long j = get();
                FlowableSubscriber flowableSubscriber = this.c;
                if (j != 0) {
                    long j2 = this.d;
                    this.d = j2 + 1;
                    flowableSubscriber.onNext(Long.valueOf(j2));
                    BackpressureHelper.e(this, 1);
                    return;
                }
                flowableSubscriber.onError(new MissingBackpressureException(ba.p(new StringBuilder("Can't deliver value "), this.d, " due to lack of requests")));
                DisposableHelper.dispose(atomicReference);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new IntervalSubscriber(flowableSubscriber));
        throw null;
    }
}
