package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {

    public static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;

        public final void onComplete() {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.c.onError(th);
            }
        }

        public final void onError(Throwable th) {
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                this.c.onError(new CompositeException(th, th2));
            }
        }

        public final void onNext(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.c.onError(th);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SinglePostCompleteSubscriber(flowableSubscriber));
    }
}
