package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;

public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        public final boolean c(Object obj) {
            if (this.f) {
                return false;
            }
            if (this.g != 0) {
                return this.c.c((Object) null);
            }
            try {
                throw null;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        public final void onNext(Object obj) {
            if (!c(obj)) {
                this.d.request(1);
            }
        }

        public final Object poll() {
            if (this.e.poll() == null) {
                return null;
            }
            throw null;
        }
    }

    public static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        public final boolean c(Object obj) {
            if (this.f) {
                return false;
            }
            if (this.g != 0) {
                this.c.onNext((Object) null);
                return true;
            }
            try {
                throw null;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        public final void onNext(Object obj) {
            if (!c(obj)) {
                this.d.request(1);
            }
        }

        public final Object poll() {
            if (this.e.poll() == null) {
                return null;
            }
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        boolean z = flowableSubscriber instanceof ConditionalSubscriber;
        Flowable flowable = this.d;
        if (z) {
            flowable.a(new BasicFuseableConditionalSubscriber((ConditionalSubscriber) flowableSubscriber));
        } else {
            flowable.a(new BasicFuseableSubscriber(flowableSubscriber));
        }
    }
}
