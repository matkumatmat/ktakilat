package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {
        public final void clear() {
            throw null;
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
            } else {
                this.f = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                if (this.g != 0) {
                    this.c.onNext((Object) null);
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final Object poll() {
            Object poll = this.e.poll();
            if (poll == null) {
                return poll;
            }
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptySubscription.error(th, flowableSubscriber);
        }
    }
}
