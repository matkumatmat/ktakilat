package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

public final class SingleToFlowable<T> extends Flowable<T> {
    public final SingleSource d;

    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 187782011903685568L;
        public Disposable e;

        public final void cancel() {
            super.cancel();
            this.e.dispose();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public SingleToFlowable(SingleSource singleSource) {
        this.d = singleSource;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.SingleObserver] */
    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.b(new DeferredScalarSubscription(flowableSubscriber));
    }
}
