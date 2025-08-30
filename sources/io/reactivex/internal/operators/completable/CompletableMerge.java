package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class CompletableMerge extends Completable {

    public static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;
        public final CompletableObserver c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final CompositeDisposable e = new Object();
        public Subscription f;

        public final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 251330541679988317L;

            public MergeInnerObserver() {
            }

            public final void dispose() {
                DisposableHelper.dispose(this);
            }

            public final boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public final void onComplete() {
                CompletableMergeSubscriber completableMergeSubscriber = CompletableMergeSubscriber.this;
                completableMergeSubscriber.e.c(this);
                if (completableMergeSubscriber.decrementAndGet() == 0) {
                    Throwable th = (Throwable) completableMergeSubscriber.d.get();
                    CompletableObserver completableObserver = completableMergeSubscriber.c;
                    if (th != null) {
                        completableObserver.onError(th);
                    } else {
                        completableObserver.onComplete();
                    }
                } else {
                    completableMergeSubscriber.f.request(1);
                }
            }

            public final void onError(Throwable th) {
                CompletableMergeSubscriber completableMergeSubscriber = CompletableMergeSubscriber.this;
                CompositeDisposable compositeDisposable = completableMergeSubscriber.e;
                compositeDisposable.c(this);
                completableMergeSubscriber.f.cancel();
                compositeDisposable.dispose();
                AtomicThrowable atomicThrowable = completableMergeSubscriber.d;
                if (!atomicThrowable.addThrowable(th)) {
                    RxJavaPlugins.b(th);
                } else if (completableMergeSubscriber.getAndSet(0) > 0) {
                    completableMergeSubscriber.c.onError(atomicThrowable.terminate());
                }
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        /* JADX WARNING: type inference failed for: r1v1, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public CompletableMergeSubscriber(CompletableObserver completableObserver) {
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
                AtomicThrowable atomicThrowable = this.d;
                Throwable th = (Throwable) atomicThrowable.get();
                CompletableObserver completableObserver = this.c;
                if (th != null) {
                    completableObserver.onError(atomicThrowable.terminate());
                } else {
                    completableObserver.onComplete();
                }
            }
        }

        public final void onError(Throwable th) {
            this.e.dispose();
            AtomicThrowable atomicThrowable = this.d;
            if (!atomicThrowable.addThrowable(th)) {
                RxJavaPlugins.b(th);
            } else if (getAndSet(0) > 0) {
                this.c.onError(atomicThrowable.terminate());
            }
        }

        public final void onNext(Object obj) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.e.b(mergeInnerObserver);
            ((CompletableSource) obj).b(mergeInnerObserver);
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
        new CompletableMergeSubscriber(completableObserver);
        throw null;
    }
}
