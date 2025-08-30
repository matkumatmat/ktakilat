package io.reactivex.internal.operators.maybe;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    public static final class DelayMaybeObserver<T, U> implements MaybeObserver<T>, Disposable {
        public final OtherSubscriber c;
        public Disposable d;

        public DelayMaybeObserver(MaybeObserver maybeObserver) {
            this.c = new OtherSubscriber(maybeObserver);
        }

        public final void dispose() {
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
            SubscriptionHelper.cancel(this.c);
        }

        public final boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) this.c.get());
        }

        public final void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            throw null;
        }

        public final void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            this.c.e = th;
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.d = DisposableHelper.DISPOSED;
            this.c.d = obj;
            throw null;
        }
    }

    public static final class OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        public final MaybeObserver c;
        public Object d;
        public Throwable e;

        public OtherSubscriber(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void onComplete() {
            Throwable th = this.e;
            MaybeObserver maybeObserver = this.c;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            Object obj = this.d;
            if (obj != null) {
                maybeObserver.onSuccess(obj);
            } else {
                maybeObserver.onComplete();
            }
        }

        public final void onError(Throwable th) {
            Throwable th2 = this.e;
            MaybeObserver maybeObserver = this.c;
            if (th2 == null) {
                maybeObserver.onError(th);
                return;
            }
            maybeObserver.onError(new CompositeException(th2, th));
        }

        public final void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                onComplete();
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        new DelayMaybeObserver(maybeObserver);
        throw null;
    }
}
