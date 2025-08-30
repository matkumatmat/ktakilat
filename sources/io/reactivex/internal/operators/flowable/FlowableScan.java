package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public final FlowableSubscriber c;
        public Subscription d;
        public Object e;
        public boolean f;

        public ScanSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.d.cancel();
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                if (this.e == null) {
                    this.e = obj;
                    this.c.onNext(obj);
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.d.cancel();
                    onError(th);
                }
            }
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

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new ScanSubscriber(flowableSubscriber));
    }
}
