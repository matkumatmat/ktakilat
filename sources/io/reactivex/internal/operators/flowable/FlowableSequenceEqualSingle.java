package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        public final SingleObserver c;
        public final FlowableSequenceEqual.EqualSubscriber d = new FlowableSequenceEqual.EqualSubscriber(this);
        public final FlowableSequenceEqual.EqualSubscriber e = new FlowableSequenceEqual.EqualSubscriber(this);
        public final AtomicThrowable f = new AtomicThrowable();
        public Object g;
        public Object i;

        public EqualCoordinator(SingleObserver singleObserver) {
            this.c = singleObserver;
        }

        public final void a(Throwable th) {
            if (this.f.addThrowable(th)) {
                b();
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void b() {
            boolean z;
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    SimpleQueue simpleQueue = this.d.d;
                    SimpleQueue simpleQueue2 = this.e.d;
                    if (simpleQueue == null || simpleQueue2 == null) {
                        if (isDisposed()) {
                            this.d.a();
                            this.e.a();
                            return;
                        } else if (((Throwable) this.f.get()) != null) {
                            c();
                            this.c.onError(this.f.terminate());
                            return;
                        }
                    } else if (isDisposed()) {
                        this.d.a();
                        this.e.a();
                        return;
                    } else if (((Throwable) this.f.get()) != null) {
                        c();
                        this.c.onError(this.f.terminate());
                        return;
                    } else {
                        boolean z2 = this.d.e;
                        Object obj = this.g;
                        if (obj == null) {
                            try {
                                obj = simpleQueue.poll();
                                this.g = obj;
                            } catch (Throwable th) {
                                Exceptions.a(th);
                                c();
                                this.f.addThrowable(th);
                                this.c.onError(this.f.terminate());
                                return;
                            }
                        }
                        boolean z3 = false;
                        if (obj == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z4 = this.e.e;
                        Object obj2 = this.i;
                        if (obj2 == null) {
                            try {
                                obj2 = simpleQueue2.poll();
                                this.i = obj2;
                            } catch (Throwable th2) {
                                Exceptions.a(th2);
                                c();
                                this.f.addThrowable(th2);
                                this.c.onError(this.f.terminate());
                                return;
                            }
                        }
                        if (obj2 == null) {
                            z3 = true;
                        }
                        if (z2 && z4 && z && z3) {
                            this.c.onSuccess(Boolean.TRUE);
                            return;
                        } else if (z2 && z4 && z != z3) {
                            c();
                            this.c.onSuccess(Boolean.FALSE);
                            return;
                        } else if (!z && !z3) {
                            try {
                                throw null;
                            } catch (Throwable th3) {
                                Exceptions.a(th3);
                                c();
                                this.f.addThrowable(th3);
                                this.c.onError(this.f.terminate());
                                return;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public final void c() {
            FlowableSequenceEqual.EqualSubscriber equalSubscriber = this.d;
            equalSubscriber.getClass();
            SubscriptionHelper.cancel(equalSubscriber);
            equalSubscriber.a();
            FlowableSequenceEqual.EqualSubscriber equalSubscriber2 = this.e;
            equalSubscriber2.getClass();
            SubscriptionHelper.cancel(equalSubscriber2);
            equalSubscriber2.a();
        }

        public final void dispose() {
            FlowableSequenceEqual.EqualSubscriber equalSubscriber = this.d;
            equalSubscriber.getClass();
            SubscriptionHelper.cancel(equalSubscriber);
            FlowableSequenceEqual.EqualSubscriber equalSubscriber2 = this.e;
            equalSubscriber2.getClass();
            SubscriptionHelper.cancel(equalSubscriber2);
            if (getAndIncrement() == 0) {
                equalSubscriber.a();
                equalSubscriber2.a();
            }
        }

        public final boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) this.d.get());
        }
    }

    public final void c(SingleObserver singleObserver) {
        singleObserver.onSubscribe(new EqualCoordinator(singleObserver));
        throw null;
    }
}
