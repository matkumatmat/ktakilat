package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {

    public static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        public Subscription c;

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
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                throw null;
            }
        }
    }

    public final void c(CompletableObserver completableObserver) {
        throw null;
    }
}
