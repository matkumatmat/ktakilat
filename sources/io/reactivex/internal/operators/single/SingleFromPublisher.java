package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class SingleFromPublisher<T> extends Single<T> {

    public static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {
        public Subscription c;
        public Object d;
        public boolean e;
        public volatile boolean f;

        public final void dispose() {
            this.f = true;
            this.c.cancel();
        }

        public final boolean isDisposed() {
            return this.f;
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                this.d = null;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
                return;
            }
            this.e = true;
            this.d = null;
            throw null;
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                if (this.d == null) {
                    this.d = obj;
                    return;
                }
                this.c.cancel();
                this.e = true;
                this.d = null;
                new IndexOutOfBoundsException("Too many elements in the Publisher");
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
