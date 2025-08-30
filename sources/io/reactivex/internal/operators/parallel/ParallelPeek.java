package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class ParallelPeek<T> extends ParallelFlowable<T> {

    public static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public Subscription c;
        public boolean d;

        public final void cancel() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(th);
                this.c.cancel();
            }
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            if (!this.d) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    subscription.cancel();
                    throw null;
                }
            }
        }

        public final void request(long j) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(th);
                this.c.request(j);
            }
        }
    }
}
