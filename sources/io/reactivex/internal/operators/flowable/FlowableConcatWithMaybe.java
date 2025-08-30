package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableConcatWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        public final AtomicReference g = new AtomicReference();
        public boolean i;

        public ConcatWithSubscriber(FlowableSubscriber flowableSubscriber) {
            super(flowableSubscriber);
        }

        public final void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.g);
        }

        public final void onComplete() {
            if (this.i) {
                this.c.onComplete();
                return;
            }
            this.i = true;
            this.d = SubscriptionHelper.CANCELLED;
            throw null;
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.f++;
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.g, disposable);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new ConcatWithSubscriber(flowableSubscriber));
    }
}
