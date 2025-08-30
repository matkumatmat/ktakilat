package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;

public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    public static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        public final boolean c(Object obj) {
            if (this.f) {
                return false;
            }
            try {
                throw null;
            } catch (Throwable th) {
                a(th);
                return true;
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
            if (this.e.poll() == null) {
                return null;
            }
            throw null;
        }
    }

    public static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
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
