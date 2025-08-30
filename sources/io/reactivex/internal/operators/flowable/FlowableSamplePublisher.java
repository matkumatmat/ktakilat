package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSamplePublisher<T> extends Flowable<T> {

    public static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public final void a() {
            throw null;
        }

        public final void b() {
            throw null;
        }

        public final void d() {
            throw null;
        }
    }

    public static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public final void a() {
            this.c.onComplete();
        }

        public final void b() {
            this.c.onComplete();
        }

        public final void d() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                AtomicLong atomicLong = this.d;
                long j = atomicLong.get();
                SerializedSubscriber serializedSubscriber = this.c;
                if (j != 0) {
                    serializedSubscriber.onNext(andSet);
                    BackpressureHelper.e(atomicLong, 1);
                    return;
                }
                cancel();
                serializedSubscriber.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    public static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3517602651313910099L;
        public final SerializedSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public final AtomicReference e = new AtomicReference();
        public Subscription f;

        public SamplePublisherSubscriber(SerializedSubscriber serializedSubscriber) {
            this.c = serializedSubscriber;
        }

        public abstract void a();

        public abstract void b();

        public final void cancel() {
            SubscriptionHelper.cancel(this.e);
            this.f.cancel();
        }

        public abstract void d();

        public final void onComplete() {
            SubscriptionHelper.cancel(this.e);
            a();
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.cancel(this.e);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            lazySet(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.c.onSubscribe(this);
                if (this.e.get() == null) {
                    throw null;
                }
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this.d, j);
            }
        }
    }

    public static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {
        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            throw null;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        new SamplePublisherSubscriber(new SerializedSubscriber(flowableSubscriber));
        throw null;
    }
}
