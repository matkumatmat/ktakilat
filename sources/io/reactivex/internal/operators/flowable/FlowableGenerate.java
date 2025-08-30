package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class FlowableGenerate<T, S> extends Flowable<T> {

    public static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        public Object c;
        public volatile boolean d;
        public boolean e;

        public final void b(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(th);
            }
        }

        public final void cancel() {
            if (!this.d) {
                this.d = true;
                if (BackpressureHelper.a(this, 1) == 0) {
                    Object obj = this.c;
                    this.c = null;
                    b(obj);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.b(th);
            } else {
                this.e = true;
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.a(this, j) == 0) {
                Object obj = this.c;
                while (0 == j) {
                    j = get();
                    if (0 == j) {
                        this.c = obj;
                        j = addAndGet(-0);
                        if (j == 0) {
                            return;
                        }
                    }
                }
                if (this.d) {
                    this.c = null;
                    b(obj);
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.d = true;
                    this.c = null;
                    onError(th);
                    b(obj);
                }
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptySubscription.error(th, flowableSubscriber);
        }
    }
}
