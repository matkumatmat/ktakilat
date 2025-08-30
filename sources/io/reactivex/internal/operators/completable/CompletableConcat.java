package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class CompletableConcat extends Completable {

    public static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = 9032184911934499404L;
        public final CompletableObserver c;
        public final int d = 0;
        public final ConcatInnerObserver e = new ConcatInnerObserver(this);
        public final AtomicBoolean f = new AtomicBoolean();
        public int g;
        public int i;
        public SimpleQueue j;
        public Subscription k;
        public volatile boolean l;
        public volatile boolean m;

        public static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -5454794857847146511L;
            public final CompletableConcatSubscriber c;

            public ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.c = completableConcatSubscriber;
            }

            public final void onComplete() {
                CompletableConcatSubscriber completableConcatSubscriber = this.c;
                completableConcatSubscriber.m = false;
                completableConcatSubscriber.a();
            }

            public final void onError(Throwable th) {
                CompletableConcatSubscriber completableConcatSubscriber = this.c;
                if (completableConcatSubscriber.f.compareAndSet(false, true)) {
                    completableConcatSubscriber.k.cancel();
                    completableConcatSubscriber.c.onError(th);
                    return;
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public CompletableConcatSubscriber(CompletableObserver completableObserver) {
            this.c = completableObserver;
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.m) {
                        boolean z2 = this.l;
                        try {
                            CompletableSource completableSource = (CompletableSource) this.j.poll();
                            if (completableSource == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z2 || !z) {
                                if (!z) {
                                    this.m = true;
                                    completableSource.b(this.e);
                                    if (this.g != 1) {
                                        int i2 = this.i + 1;
                                        if (i2 == this.d) {
                                            this.i = 0;
                                            this.k.request((long) i2);
                                        } else {
                                            this.i = i2;
                                        }
                                    }
                                }
                            } else if (this.f.compareAndSet(false, true)) {
                                this.c.onComplete();
                                return;
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.a(th);
                            if (this.f.compareAndSet(false, true)) {
                                this.k.cancel();
                                this.c.onError(th);
                                return;
                            }
                            RxJavaPlugins.b(th);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public final void dispose() {
            this.k.cancel();
            DisposableHelper.dispose(this.e);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.e.get());
        }

        public final void onComplete() {
            this.l = true;
            a();
        }

        public final void onError(Throwable th) {
            if (this.f.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.e);
                this.c.onError(th);
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            CompletableSource completableSource = (CompletableSource) obj;
            if (this.g != 0 || this.j.offer(completableSource)) {
                a();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.k, subscription)) {
                this.k = subscription;
                long j2 = (long) 0;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.g = requestFusion;
                        this.j = queueSubscription;
                        this.l = true;
                        this.c.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.g = requestFusion;
                        this.j = queueSubscription;
                        this.c.onSubscribe(this);
                        subscription.request(j2);
                        return;
                    }
                }
                this.j = new SpscArrayQueue(0);
                this.c.onSubscribe(this);
                subscription.request(j2);
            }
        }
    }

    public final void c(CompletableObserver completableObserver) {
        new CompletableConcatSubscriber(completableObserver);
        throw null;
    }
}
