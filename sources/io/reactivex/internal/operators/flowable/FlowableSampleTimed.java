package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public final void a() {
            b();
            throw null;
        }

        public final void run() {
            throw null;
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public final void a() {
            this.c.onComplete();
        }
    }

    public static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final SerializedSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public final SequentialDisposable e = new SequentialDisposable();
        public Subscription f;

        public SampleTimedSubscriber(SerializedSubscriber serializedSubscriber) {
            this.c = serializedSubscriber;
        }

        public abstract void a();

        public final void b() {
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

        public final void cancel() {
            DisposableHelper.dispose(this.e);
            this.f.cancel();
        }

        public final void onComplete() {
            DisposableHelper.dispose(this.e);
            a();
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.e);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            lazySet(obj);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.c.onSubscribe(this);
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this.d, j);
            }
        }

        public void run() {
            b();
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new SampleTimedSubscriber(new SerializedSubscriber(flowableSubscriber)));
    }
}
