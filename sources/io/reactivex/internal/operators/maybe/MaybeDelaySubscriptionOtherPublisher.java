package io.reactivex.internal.operators.maybe;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 706635022205076709L;
        public final MaybeObserver c;

        public DelayMaybeObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(Object obj) {
            this.c.onSuccess(obj);
        }
    }

    public static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {
        public final DelayMaybeObserver c;
        public Subscription d;

        public OtherSubscriber(MaybeObserver maybeObserver) {
            this.c = new DelayMaybeObserver(maybeObserver);
        }

        public final void dispose() {
            this.d.cancel();
            this.d = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.c);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.c.get());
        }

        public final void onComplete() {
            Subscription subscription = this.d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.d = subscriptionHelper;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            Subscription subscription = this.d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.d = subscriptionHelper;
                this.c.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            Subscription subscription = this.d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                this.d = subscriptionHelper;
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.c.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        new OtherSubscriber(maybeObserver);
        throw null;
    }
}
