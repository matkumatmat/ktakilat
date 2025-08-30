package io.reactivex.internal.operators.single;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class SingleTakeUntil<T, U> extends Single<T> {

    public static final class TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -622603812305745221L;
        public final SingleObserver c;
        public final TakeUntilOtherSubscriber d = new TakeUntilOtherSubscriber(this);

        public TakeUntilMainObserver(SingleObserver singleObserver) {
            this.c = singleObserver;
        }

        public final void a(Throwable th) {
            Disposable disposable;
            Disposable disposable2 = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable2 == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                RxJavaPlugins.b(th);
                return;
            }
            if (disposable != null) {
                disposable.dispose();
            }
            this.c.onError(th);
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
            TakeUntilOtherSubscriber takeUntilOtherSubscriber = this.d;
            takeUntilOtherSubscriber.getClass();
            SubscriptionHelper.cancel(takeUntilOtherSubscriber);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onError(Throwable th) {
            TakeUntilOtherSubscriber takeUntilOtherSubscriber = this.d;
            takeUntilOtherSubscriber.getClass();
            SubscriptionHelper.cancel(takeUntilOtherSubscriber);
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || ((Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                RxJavaPlugins.b(th);
            } else {
                this.c.onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(Object obj) {
            TakeUntilOtherSubscriber takeUntilOtherSubscriber = this.d;
            takeUntilOtherSubscriber.getClass();
            SubscriptionHelper.cancel(takeUntilOtherSubscriber);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (((Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                this.c.onSuccess(obj);
            }
        }
    }

    public static final class TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        public final TakeUntilMainObserver c;

        public TakeUntilOtherSubscriber(TakeUntilMainObserver takeUntilMainObserver) {
            this.c = takeUntilMainObserver;
        }

        public final void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.c.a(new CancellationException());
            }
        }

        public final void onError(Throwable th) {
            this.c.a(th);
        }

        public final void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.c.a(new CancellationException());
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public final void c(SingleObserver singleObserver) {
        singleObserver.onSubscribe(new TakeUntilMainObserver(singleObserver));
        throw null;
    }
}
