package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {

    public static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        public Subscription c;
        public boolean d;
        public Object e;

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
            if (!this.d) {
                this.d = true;
                this.c = SubscriptionHelper.CANCELLED;
                Object obj = this.e;
                this.e = null;
                obj.getClass();
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
                return;
            }
            this.d = true;
            this.c = SubscriptionHelper.CANCELLED;
            throw null;
        }

        public final void onNext(Object obj) {
            if (!this.d) {
                if (this.e == null) {
                    this.e = obj;
                    return;
                }
                this.d = true;
                this.c.cancel();
                this.c = SubscriptionHelper.CANCELLED;
                new IllegalArgumentException("Sequence contains more than one element!");
                throw null;
            }
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
