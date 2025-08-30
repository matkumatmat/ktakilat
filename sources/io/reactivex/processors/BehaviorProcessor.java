package io.reactivex.processors;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

public final class BehaviorProcessor<T> extends FlowableProcessor<T> {
    public static final Object[] d = new Object[0];

    public static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        public final FlowableSubscriber c;
        public final BehaviorProcessor d;
        public volatile boolean e;

        public BehaviorSubscription(FlowableSubscriber flowableSubscriber, BehaviorProcessor behaviorProcessor) {
            this.c = flowableSubscriber;
            this.d = behaviorProcessor;
        }

        public final void cancel() {
            if (!this.e) {
                this.e = true;
                this.d.getClass();
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this, j);
            }
        }

        public final boolean test(Object obj) {
            if (this.e) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.c.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.c.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j = get();
                if (j != 0) {
                    this.c.onNext(NotificationLite.getValue(obj));
                    if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                        return false;
                    }
                    decrementAndGet();
                    return false;
                }
                cancel();
                this.c.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        flowableSubscriber.onSubscribe(new BehaviorSubscription(flowableSubscriber, this));
        throw null;
    }

    public final void onComplete() {
        Throwable th = ExceptionHelper.f682a;
        throw null;
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        throw null;
    }

    public final void onNext(Object obj) {
        ObjectHelper.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        throw null;
    }

    public final void onSubscribe(Subscription subscription) {
        throw null;
    }
}
