package io.reactivex.internal.operators.single;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

public final class SingleFlatMapIterableFlowable<T, R> extends Flowable<R> {

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        public final FlowableSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public Disposable e;
        public volatile Iterator f;
        public volatile boolean g;
        public boolean i;

        public FlatMapIterableObserver(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.g = true;
            this.e.dispose();
            this.e = DisposableHelper.DISPOSED;
        }

        public final void clear() {
            this.f = null;
        }

        public final boolean isEmpty() {
            if (this.f == null) {
                return true;
            }
            return false;
        }

        public final void onError(Throwable th) {
            this.e = DisposableHelper.DISPOSED;
            this.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.c.onError(th);
            }
        }

        public final Object poll() {
            Iterator it = this.f;
            if (it == null) {
                return null;
            }
            Object next = it.next();
            ObjectHelper.b(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f = null;
            }
            return next;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this.d, j);
                if (getAndIncrement() == 0) {
                    FlowableSubscriber flowableSubscriber = this.c;
                    Iterator it = this.f;
                    if (!this.i || it == null) {
                        int i2 = 1;
                        while (true) {
                            if (it != null) {
                                long j2 = this.d.get();
                                if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                                    while (!this.g) {
                                        try {
                                            flowableSubscriber.onNext(it.next());
                                            if (!this.g) {
                                                try {
                                                    if (!it.hasNext()) {
                                                        flowableSubscriber.onComplete();
                                                        return;
                                                    }
                                                } catch (Throwable th) {
                                                    Exceptions.a(th);
                                                    flowableSubscriber.onError(th);
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            Exceptions.a(th2);
                                            flowableSubscriber.onError(th2);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                long j3 = 0;
                                while (j3 != j2) {
                                    if (!this.g) {
                                        try {
                                            Object next = it.next();
                                            ObjectHelper.b(next, "The iterator returned a null value");
                                            flowableSubscriber.onNext(next);
                                            if (!this.g) {
                                                j3++;
                                                try {
                                                    if (!it.hasNext()) {
                                                        flowableSubscriber.onComplete();
                                                        return;
                                                    }
                                                } catch (Throwable th3) {
                                                    Exceptions.a(th3);
                                                    flowableSubscriber.onError(th3);
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } catch (Throwable th4) {
                                            Exceptions.a(th4);
                                            flowableSubscriber.onError(th4);
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                if (j3 != 0) {
                                    BackpressureHelper.e(this.d, j3);
                                }
                            }
                            i2 = addAndGet(-i2);
                            if (i2 != 0) {
                                if (it == null) {
                                    it = this.f;
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        flowableSubscriber.onNext((Object) null);
                        flowableSubscriber.onComplete();
                    }
                }
            }
        }

        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.i = true;
            return 2;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        new FlatMapIterableObserver(flowableSubscriber);
        throw null;
    }
}
