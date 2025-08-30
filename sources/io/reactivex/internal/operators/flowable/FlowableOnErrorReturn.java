package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

public final class FlowableOnErrorReturn<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;

        public final void onComplete() {
            this.c.onComplete();
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
            this.f++;
            this.c.onNext(obj);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SinglePostCompleteSubscriber(flowableSubscriber));
    }
}
