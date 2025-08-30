package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        public final FlowableSubscriber c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final CompositeDisposable e = new Object();
        public Subscription f;

        public final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            public final void dispose() {
                DisposableHelper.dispose(this);
            }

            public final boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public final void onComplete() {
                throw null;
            }

            public final void onError(Throwable th) {
                throw null;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        /* JADX WARNING: type inference failed for: r1v2, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public FlatMapCompletableMainSubscriber(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
            lazySet(1);
        }

        public final void cancel() {
            this.f.cancel();
            this.e.dispose();
        }

        public final void clear() {
        }

        public final boolean isEmpty() {
            return true;
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.d.terminate();
                FlowableSubscriber flowableSubscriber = this.c;
                if (terminate != null) {
                    flowableSubscriber.onError(terminate);
                } else {
                    flowableSubscriber.onComplete();
                }
            } else {
                this.f.request(1);
            }
        }

        public final void onError(Throwable th) {
            AtomicThrowable atomicThrowable = this.d;
            if (atomicThrowable.addThrowable(th)) {
                cancel();
                if (getAndSet(0) > 0) {
                    this.c.onError(atomicThrowable.terminate());
                    return;
                }
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.f.cancel();
                onError(th);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.c.onSubscribe(this);
                subscription.request((long) 0);
            }
        }

        public final Object poll() {
            return null;
        }

        public final void request(long j) {
        }

        public final int requestFusion(int i) {
            return i & 2;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new FlatMapCompletableMainSubscriber(flowableSubscriber));
    }
}
