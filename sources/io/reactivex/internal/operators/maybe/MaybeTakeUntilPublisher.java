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

public final class MaybeTakeUntilPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;
        public final MaybeObserver c;
        public final TakeUntilOtherMaybeObserver d = new TakeUntilOtherMaybeObserver(this);

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Subscription> implements FlowableSubscriber<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            public final TakeUntilMainMaybeObserver c;

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver takeUntilMainMaybeObserver) {
                this.c = takeUntilMainMaybeObserver;
            }

            public final void onComplete() {
                TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = this.c;
                takeUntilMainMaybeObserver.getClass();
                if (DisposableHelper.dispose(takeUntilMainMaybeObserver)) {
                    takeUntilMainMaybeObserver.c.onComplete();
                }
            }

            public final void onError(Throwable th) {
                TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = this.c;
                takeUntilMainMaybeObserver.getClass();
                if (DisposableHelper.dispose(takeUntilMainMaybeObserver)) {
                    takeUntilMainMaybeObserver.c.onError(th);
                } else {
                    RxJavaPlugins.b(th);
                }
            }

            public final void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = this.c;
                takeUntilMainMaybeObserver.getClass();
                if (DisposableHelper.dispose(takeUntilMainMaybeObserver)) {
                    takeUntilMainMaybeObserver.c.onComplete();
                }
            }

            public final void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public TakeUntilMainMaybeObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.d);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            SubscriptionHelper.cancel(this.d);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.cancel(this.d);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.c.onError(th);
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(Object obj) {
            SubscriptionHelper.cancel(this.d);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.c.onSuccess(obj);
            }
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        maybeObserver.onSubscribe(new TakeUntilMainMaybeObserver(maybeObserver));
        throw null;
    }
}
