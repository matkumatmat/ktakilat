package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {

    public static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {
        public Subscription c;
        public long d;

        public final void dispose() {
            this.c.cancel();
            this.c = SubscriptionHelper.CANCELLED;
        }

        public final boolean isDisposed() {
            if (this.c == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            this.c = SubscriptionHelper.CANCELLED;
            throw null;
        }

        public final void onError(Throwable th) {
            this.c = SubscriptionHelper.CANCELLED;
            throw null;
        }

        public final void onNext(Object obj) {
            this.d++;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                throw null;
            }
        }
    }

    public final void c(SingleObserver singleObserver) {
        throw null;
    }
}
