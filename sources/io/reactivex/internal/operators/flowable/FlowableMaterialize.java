package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {

    public static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        public final void b(Object obj) {
            Notification notification = (Notification) obj;
            if (NotificationLite.isError(notification.f656a)) {
                RxJavaPlugins.b(notification.b());
            }
        }

        public final void onComplete() {
            a(Notification.b);
        }

        public final void onError(Throwable th) {
            a(Notification.a(th));
        }

        public final void onNext(Object obj) {
            this.f++;
            ObjectHelper.b(obj, "value is null");
            this.c.onNext(new Notification(obj));
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SinglePostCompleteSubscriber(flowableSubscriber));
    }
}
