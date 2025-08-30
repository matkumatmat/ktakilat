package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

public final class FlowableLastSingle<T> extends Single<T> {

    public static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        public Subscription c;
        public Object d;

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
            this.d = null;
            throw null;
        }

        public final void onNext(Object obj) {
            this.d = obj;
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
