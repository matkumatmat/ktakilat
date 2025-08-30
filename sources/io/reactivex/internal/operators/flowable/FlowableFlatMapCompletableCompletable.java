package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {

    public static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 8443155186132538303L;
        public final CompletableObserver c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final CompositeDisposable e = new Object();
        public Subscription f;

        public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
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
        public FlatMapCompletableMainSubscriber(CompletableObserver completableObserver) {
            this.c = completableObserver;
            lazySet(1);
        }

        public final void dispose() {
            this.f.cancel();
            this.e.dispose();
        }

        public final boolean isDisposed() {
            return this.e.d;
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.d.terminate();
                CompletableObserver completableObserver = this.c;
                if (terminate != null) {
                    completableObserver.onError(terminate);
                } else {
                    completableObserver.onComplete();
                }
            } else {
                this.f.request(1);
            }
        }

        public final void onError(Throwable th) {
            AtomicThrowable atomicThrowable = this.d;
            if (atomicThrowable.addThrowable(th)) {
                dispose();
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
    }

    public final void c(CompletableObserver completableObserver) {
        new FlatMapCompletableMainSubscriber(completableObserver);
        throw null;
    }
}
