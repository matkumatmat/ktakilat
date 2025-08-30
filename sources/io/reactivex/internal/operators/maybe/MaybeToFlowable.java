package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

public final class MaybeToFlowable<T> extends Flowable<T> implements HasUpstreamMaybeSource<T> {
    public final MaybeSource d;

    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        public Disposable e;

        public final void cancel() {
            super.cancel();
            this.e.dispose();
        }

        public final void onComplete() {
            this.c.onComplete();
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

    public MaybeToFlowable(MaybeSource maybeSource) {
        this.d = maybeSource;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.MaybeObserver, io.reactivex.internal.subscriptions.DeferredScalarSubscription] */
    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.b(new DeferredScalarSubscription(flowableSubscriber));
    }
}
