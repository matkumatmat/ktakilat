package io.reactivex.processors;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    public static final Object[] d = new Object[0];

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
    }

    public interface ReplayBuffer<T> {
    }

    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        public final FlowableSubscriber c;
        public final ReplayProcessor d;
        public final AtomicLong e = new AtomicLong();
        public volatile boolean f;

        public ReplaySubscription(FlowableSubscriber flowableSubscriber, ReplayProcessor replayProcessor) {
            this.c = flowableSubscriber;
            this.d = replayProcessor;
        }

        public final void cancel() {
            if (!this.f) {
                this.f = true;
                this.d.getClass();
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this.e, j);
                this.d.getClass();
                throw null;
            }
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
    }

    public static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
    }

    public static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new ReplaySubscription(flowableSubscriber, this));
        throw null;
    }

    public final void onComplete() {
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        RxJavaPlugins.b(th);
    }

    public final void onNext(Object obj) {
        ObjectHelper.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    public final void onSubscribe(Subscription subscription) {
        subscription.cancel();
    }
}
