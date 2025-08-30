package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;

@Experimental
public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        public final boolean c(Object obj) {
            boolean c = this.c.c(obj);
            try {
                throw null;
            } catch (Throwable th) {
                a(th);
                return c;
            }
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
            if (this.g == 0) {
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

    public static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        public final void onNext(Object obj) {
            if (!this.f) {
                this.c.onNext(obj);
                if (this.g == 0) {
                    try {
                        throw null;
                    } catch (Throwable th) {
                        a(th);
                    }
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
        boolean z = flowableSubscriber instanceof ConditionalSubscriber;
        Flowable flowable = this.d;
        if (z) {
            flowable.a(new BasicFuseableConditionalSubscriber((ConditionalSubscriber) flowableSubscriber));
        } else {
            flowable.a(new BasicFuseableSubscriber(flowableSubscriber));
        }
    }
}
