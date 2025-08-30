package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final ConditionalSubscriber c;
        public Subscription d;
        public QueueSubscription e;
        public boolean f;

        public DoFinallyConditionalSubscriber(ConditionalSubscriber conditionalSubscriber) {
            this.c = conditionalSubscriber;
        }

        public final boolean c(Object obj) {
            return this.c.c(obj);
        }

        public final void cancel() {
            this.d.cancel();
            e();
        }

        public final void clear() {
            this.e.clear();
        }

        public final void e() {
            if (compareAndSet(0, 1)) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    RxJavaPlugins.b(th);
                }
            }
        }

        public final boolean isEmpty() {
            return this.e.isEmpty();
        }

        public final void onComplete() {
            this.c.onComplete();
            e();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
            e();
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.e = (QueueSubscription) subscription;
                }
                this.c.onSubscribe(this);
            }
        }

        public final Object poll() {
            Object poll = this.e.poll();
            if (poll == null && this.f) {
                e();
            }
            return poll;
        }

        public final void request(long j) {
            this.d.request(j);
        }

        public final int requestFusion(int i) {
            QueueSubscription queueSubscription = this.e;
            boolean z = false;
            if (queueSubscription == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z = true;
                }
                this.f = z;
            }
            return requestFusion;
        }
    }

    public static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final FlowableSubscriber c;
        public Subscription d;
        public QueueSubscription e;
        public boolean f;

        public DoFinallySubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.d.cancel();
            e();
        }

        public final void clear() {
            this.e.clear();
        }

        public final void e() {
            if (compareAndSet(0, 1)) {
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    RxJavaPlugins.b(th);
                }
            }
        }

        public final boolean isEmpty() {
            return this.e.isEmpty();
        }

        public final void onComplete() {
            this.c.onComplete();
            e();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
            e();
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.e = (QueueSubscription) subscription;
                }
                this.c.onSubscribe(this);
            }
        }

        public final Object poll() {
            Object poll = this.e.poll();
            if (poll == null && this.f) {
                e();
            }
            return poll;
        }

        public final void request(long j) {
            this.d.request(j);
        }

        public final int requestFusion(int i) {
            QueueSubscription queueSubscription = this.e;
            boolean z = false;
            if (queueSubscription == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z = true;
                }
                this.f = z;
            }
            return requestFusion;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        boolean z = flowableSubscriber instanceof ConditionalSubscriber;
        Flowable flowable = this.d;
        if (z) {
            flowable.a(new DoFinallyConditionalSubscriber((ConditionalSubscriber) flowableSubscriber));
        } else {
            flowable.a(new DoFinallySubscriber(flowableSubscriber));
        }
    }
}
