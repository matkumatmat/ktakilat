package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {
    public final FlowableOnBackpressureDrop e = this;

    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6246093802440953054L;
        public final FlowableSubscriber c;
        public final FlowableOnBackpressureDrop d;
        public Subscription e;
        public boolean f;

        public BackpressureDropSubscriber(FlowableSubscriber flowableSubscriber, FlowableOnBackpressureDrop flowableOnBackpressureDrop) {
            this.c = flowableSubscriber;
            this.d = flowableOnBackpressureDrop;
        }

        public final void cancel() {
            this.e.cancel();
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
                if (get() != 0) {
                    this.c.onNext(obj);
                    BackpressureHelper.e(this, 1);
                    return;
                }
                try {
                    this.d.getClass();
                } catch (Throwable th) {
                    Exceptions.a(th);
                    cancel();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this, j);
            }
        }
    }

    public FlowableOnBackpressureDrop(FlowableFromObservable flowableFromObservable) {
        super(flowableFromObservable);
    }

    public final void accept(Object obj) {
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new BackpressureDropSubscriber(flowableSubscriber, this.e));
    }
}
