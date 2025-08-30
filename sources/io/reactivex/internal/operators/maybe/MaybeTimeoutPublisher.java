package io.reactivex.internal.operators.maybe;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class MaybeTimeoutPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 8663801314800248617L;

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    public static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;
        public final MaybeObserver c;
        public final TimeoutOtherMaybeObserver d = new TimeoutOtherMaybeObserver(this);
        public final TimeoutFallbackMaybeObserver e = null;

        public TimeoutMainMaybeObserver(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.d);
            TimeoutFallbackMaybeObserver timeoutFallbackMaybeObserver = this.e;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.dispose(timeoutFallbackMaybeObserver);
            }
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

    public static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        public final TimeoutMainMaybeObserver c;

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver timeoutMainMaybeObserver) {
            this.c = timeoutMainMaybeObserver;
        }

        public final void onComplete() {
            TimeoutMainMaybeObserver timeoutMainMaybeObserver = this.c;
            timeoutMainMaybeObserver.getClass();
            if (DisposableHelper.dispose(timeoutMainMaybeObserver)) {
                timeoutMainMaybeObserver.c.onError(new TimeoutException());
            }
        }

        public final void onError(Throwable th) {
            TimeoutMainMaybeObserver timeoutMainMaybeObserver = this.c;
            timeoutMainMaybeObserver.getClass();
            if (DisposableHelper.dispose(timeoutMainMaybeObserver)) {
                timeoutMainMaybeObserver.c.onError(th);
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onNext(Object obj) {
            ((Subscription) get()).cancel();
            TimeoutMainMaybeObserver timeoutMainMaybeObserver = this.c;
            timeoutMainMaybeObserver.getClass();
            if (DisposableHelper.dispose(timeoutMainMaybeObserver)) {
                timeoutMainMaybeObserver.c.onError(new TimeoutException());
            }
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        maybeObserver.onSubscribe(new TimeoutMainMaybeObserver(maybeObserver));
        throw null;
    }
}
