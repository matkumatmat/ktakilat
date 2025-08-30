package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        public final FlowableSubscriber c;
        public final AtomicReference d = new AtomicReference();
        public final OtherObserver e = new OtherObserver(this);
        public final AtomicThrowable f = new AtomicThrowable();
        public final AtomicLong g = new AtomicLong();
        public volatile boolean i;
        public volatile boolean j;

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithSubscriber c;

            public OtherObserver(MergeWithSubscriber mergeWithSubscriber) {
                this.c = mergeWithSubscriber;
            }

            public final void onComplete() {
                MergeWithSubscriber mergeWithSubscriber = this.c;
                mergeWithSubscriber.j = true;
                if (mergeWithSubscriber.i) {
                    HalfSerializer.b(mergeWithSubscriber.c, mergeWithSubscriber, mergeWithSubscriber.f);
                }
            }

            public final void onError(Throwable th) {
                MergeWithSubscriber mergeWithSubscriber = this.c;
                SubscriptionHelper.cancel(mergeWithSubscriber.d);
                HalfSerializer.d(mergeWithSubscriber.c, th, mergeWithSubscriber, mergeWithSubscriber.f);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this.d);
            DisposableHelper.dispose(this.e);
        }

        public final void onComplete() {
            this.i = true;
            if (this.j) {
                HalfSerializer.b(this.c, this, this.f);
            }
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.cancel(this.d);
            HalfSerializer.d(this.c, th, this, this.f);
        }

        public final void onNext(Object obj) {
            HalfSerializer.f(this.c, obj, this, this.f);
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.d, this.g, subscription);
        }

        public final void request(long j2) {
            SubscriptionHelper.deferredRequest(this.d, this.g, j2);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(flowableSubscriber);
        flowableSubscriber.onSubscribe(mergeWithSubscriber);
        this.d.a(mergeWithSubscriber);
        throw null;
    }
}
