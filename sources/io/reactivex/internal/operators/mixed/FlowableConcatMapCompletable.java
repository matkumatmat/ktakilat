package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableConcatMapCompletable<T> extends Completable {

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        public final CompletableObserver c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final ConcatMapInnerObserver e = new ConcatMapInnerObserver(this);
        public final SpscArrayQueue f = new SpscArrayQueue(0);
        public Subscription g;
        public volatile boolean i;
        public volatile boolean j;
        public volatile boolean k;
        public int l;

        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            public final ConcatMapCompletableObserver c;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver concatMapCompletableObserver) {
                this.c = concatMapCompletableObserver;
            }

            public final void onComplete() {
                ConcatMapCompletableObserver concatMapCompletableObserver = this.c;
                concatMapCompletableObserver.i = false;
                concatMapCompletableObserver.a();
            }

            public final void onError(Throwable th) {
                ConcatMapCompletableObserver concatMapCompletableObserver = this.c;
                if (!concatMapCompletableObserver.d.addThrowable(th)) {
                    RxJavaPlugins.b(th);
                } else if (ErrorMode.IMMEDIATE == null) {
                    concatMapCompletableObserver.g.cancel();
                    Throwable terminate = concatMapCompletableObserver.d.terminate();
                    if (terminate != ExceptionHelper.f682a) {
                        concatMapCompletableObserver.c.onError(terminate);
                    }
                    if (concatMapCompletableObserver.getAndIncrement() == 0) {
                        concatMapCompletableObserver.f.clear();
                    }
                } else {
                    concatMapCompletableObserver.i = false;
                    concatMapCompletableObserver.a();
                }
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(CompletableObserver completableObserver) {
            this.c = completableObserver;
        }

        public final void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                while (!this.k) {
                    if (!this.i) {
                        if (ErrorMode.BOUNDARY != null || this.d.get() == null) {
                            boolean z2 = this.j;
                            if (this.f.poll() == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z2 && z) {
                                Throwable terminate = this.d.terminate();
                                if (terminate != null) {
                                    this.c.onError(terminate);
                                    return;
                                } else {
                                    this.c.onComplete();
                                    return;
                                }
                            } else if (!z) {
                                int i2 = this.l + 1;
                                if (i2 == 0) {
                                    this.l = 0;
                                    this.g.request((long) 0);
                                } else {
                                    this.l = i2;
                                }
                                try {
                                    throw null;
                                } catch (Throwable th) {
                                    Exceptions.a(th);
                                    this.f.clear();
                                    this.g.cancel();
                                    this.d.addThrowable(th);
                                    this.c.onError(this.d.terminate());
                                    return;
                                }
                            }
                        } else {
                            this.f.clear();
                            this.c.onError(this.d.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f.clear();
            }
        }

        public final void dispose() {
            this.k = true;
            this.g.cancel();
            ConcatMapInnerObserver concatMapInnerObserver = this.e;
            concatMapInnerObserver.getClass();
            DisposableHelper.dispose(concatMapInnerObserver);
            if (getAndIncrement() == 0) {
                this.f.clear();
            }
        }

        public final boolean isDisposed() {
            return this.k;
        }

        public final void onComplete() {
            this.j = true;
            a();
        }

        public final void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.b(th);
            } else if (ErrorMode.IMMEDIATE == null) {
                ConcatMapInnerObserver concatMapInnerObserver = this.e;
                concatMapInnerObserver.getClass();
                DisposableHelper.dispose(concatMapInnerObserver);
                Throwable terminate = this.d.terminate();
                if (terminate != ExceptionHelper.f682a) {
                    this.c.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.f.clear();
                }
            } else {
                this.j = true;
                a();
            }
        }

        public final void onNext(Object obj) {
            if (this.f.offer(obj)) {
                a();
                return;
            }
            this.g.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.c.onSubscribe(this);
                subscription.request((long) 0);
            }
        }
    }

    public final void c(CompletableObserver completableObserver) {
        new ConcatMapCompletableObserver(completableObserver);
        throw null;
    }
}
