package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableReduceSeedSingle<T, R> extends Single<R> {

    public static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {
        public Object c;
        public Subscription d;

        public final void dispose() {
            this.d.cancel();
            this.d = SubscriptionHelper.CANCELLED;
        }

        public final boolean isDisposed() {
            if (this.d == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            if (this.c != null) {
                this.c = null;
                this.d = SubscriptionHelper.CANCELLED;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.c == null) {
                RxJavaPlugins.b(th);
                return;
            }
            this.c = null;
            this.d = SubscriptionHelper.CANCELLED;
            throw null;
        }

        public final void onNext(Object obj) {
            if (this.c != null) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.d.cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                throw null;
            }
        }
    }

    public final void c(SingleObserver singleObserver) {
        throw null;
    }
}
