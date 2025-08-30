package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableIntervalRange extends Flowable<Long> {

    public static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public final FlowableSubscriber c;
        public long d;
        public final AtomicReference e = new AtomicReference();

        public IntervalRangeSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
            this.d = 0;
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
            Object obj = atomicReference.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                long j = get();
                FlowableSubscriber flowableSubscriber = this.c;
                if (j != 0) {
                    long j2 = this.d;
                    flowableSubscriber.onNext(Long.valueOf(j2));
                    if (j2 == 0) {
                        if (atomicReference.get() != disposableHelper) {
                            flowableSubscriber.onComplete();
                        }
                        DisposableHelper.dispose(atomicReference);
                        return;
                    }
                    this.d = j2 + 1;
                    if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                flowableSubscriber.onError(new MissingBackpressureException(ba.p(new StringBuilder("Can't deliver value "), this.d, " due to lack of requests")));
                DisposableHelper.dispose(atomicReference);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new IntervalRangeSubscriber(flowableSubscriber));
        throw null;
    }
}
