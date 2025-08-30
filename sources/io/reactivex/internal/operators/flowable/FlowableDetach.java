package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public Subscriber c;
        public Subscription d;

        public final void cancel() {
            Subscription subscription = this.d;
            this.d = EmptyComponent.INSTANCE;
            this.c = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        public final void onComplete() {
            Subscriber subscriber = this.c;
            this.d = EmptyComponent.INSTANCE;
            this.c = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }

        public final void onError(Throwable th) {
            Subscriber subscriber = this.c;
            this.d = EmptyComponent.INSTANCE;
            this.c = EmptyComponent.asSubscriber();
            subscriber.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.c.onSubscribe(this);
            }
        }

        public final void request(long j) {
            this.d.request(j);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.FlowableSubscriber, io.reactivex.internal.operators.flowable.FlowableDetach$DetachSubscriber, java.lang.Object] */
    public final void b(FlowableSubscriber flowableSubscriber) {
        ? obj = new Object();
        obj.c = flowableSubscriber;
        this.d.a(obj);
    }
}
