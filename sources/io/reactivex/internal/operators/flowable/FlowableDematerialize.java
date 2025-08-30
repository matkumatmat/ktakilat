package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableDematerialize<T> extends AbstractFlowableWithUpstream<Notification<T>, T> {

    public static final class DematerializeSubscriber<T> implements FlowableSubscriber<Notification<T>>, Subscription {
        public final FlowableSubscriber c;
        public boolean d;
        public Subscription e;

        public DematerializeSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.e.cancel();
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
                return;
            }
            this.d = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            Notification notification = (Notification) obj;
            if (this.d) {
                if (NotificationLite.isError(notification.f656a)) {
                    RxJavaPlugins.b(notification.b());
                }
            } else if (NotificationLite.isError(notification.f656a)) {
                this.e.cancel();
                onError(notification.b());
            } else if (notification.f656a == null) {
                this.e.cancel();
                onComplete();
            } else {
                this.c.onNext(notification.c());
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.c.onSubscribe(this);
            }
        }

        public final void request(long j) {
            this.e.request(j);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new DematerializeSubscriber(flowableSubscriber));
    }
}
