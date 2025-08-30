package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {

    public static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        public Object c;
        public Subscription d;
        public boolean e;

        public final void dispose() {
            this.d.cancel();
            this.e = true;
        }

        public final boolean isDisposed() {
            return this.e;
        }

        public final void onComplete() {
            if (!this.e) {
                this.e = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
            } else {
                this.e = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            if (!this.e) {
                if (this.c == null) {
                    this.c = obj;
                    return;
                }
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

    public final void c(MaybeObserver maybeObserver) {
        throw null;
    }
}
