package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableTimer extends Flowable<Long> {

    public static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public final FlowableSubscriber c;
        public volatile boolean d;

        public TimerSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            DisposableHelper.dispose(this);
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.d = true;
            }
        }

        public final void run() {
            if (get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (this.d) {
                this.c.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.c.onComplete();
                return;
            }
            lazySet(EmptyDisposable.INSTANCE);
            this.c.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new TimerSubscriber(flowableSubscriber));
        throw null;
    }
}
