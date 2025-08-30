package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {

    public final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {
        public final void onComplete() {
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            throw null;
        }
    }

    public static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;
        public final SerializedSubscriber c;
        public final AtomicReference d = new AtomicReference();
        public final AtomicLong e = new AtomicLong();
        public final AtomicReference f = new AtomicReference();

        public WithLatestFromSubscriber(SerializedSubscriber serializedSubscriber) {
            this.c = serializedSubscriber;
        }

        public final boolean c(Object obj) {
            if (get() == null) {
                return false;
            }
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                cancel();
                this.c.onError(th);
                return false;
            }
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this.d);
            SubscriptionHelper.cancel(this.f);
        }

        public final void onComplete() {
            SubscriptionHelper.cancel(this.f);
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.cancel(this.f);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            c(obj);
            ((Subscription) this.d.get()).request(1);
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.d, this.e, subscription);
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this.d, this.e, j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(flowableSubscriber);
        serializedSubscriber.onSubscribe(new WithLatestFromSubscriber(serializedSubscriber));
        throw null;
    }
}
