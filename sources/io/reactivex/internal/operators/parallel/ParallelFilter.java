package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class ParallelFilter<T> extends ParallelFlowable<T> {

    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        public Subscription c;
        public boolean d;

        public final void cancel() {
            this.c.cancel();
        }

        public final void onNext(Object obj) {
            if (!c(obj) && !this.d) {
                this.c.request(1);
            }
        }

        public final void request(long j) {
            this.c.request(j);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        public final boolean c(Object obj) {
            if (this.d) {
                return false;
            }
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                cancel();
                onError(th);
                return false;
            }
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
            } else {
                this.d = true;
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

    public static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        public final boolean c(Object obj) {
            if (this.d) {
                return false;
            }
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                cancel();
                onError(th);
                return false;
            }
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
            } else {
                this.d = true;
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
}
