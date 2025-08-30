package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class MaybeConcatArray<T> extends Flowable<T> {

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        public final FlowableSubscriber c;
        public final AtomicLong d = new AtomicLong();
        public final AtomicReference e = new AtomicReference(NotificationLite.COMPLETE);
        public final SequentialDisposable f = new SequentialDisposable();
        public long g;

        public ConcatMaybeObserver(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                AtomicReference atomicReference = this.e;
                do {
                    SequentialDisposable sequentialDisposable = this.f;
                    if (sequentialDisposable.isDisposed()) {
                        atomicReference.lazySet((Object) null);
                        return;
                    }
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        if (obj != NotificationLite.COMPLETE) {
                            long j = this.g;
                            if (j != this.d.get()) {
                                this.g = j + 1;
                                atomicReference.lazySet((Object) null);
                                this.c.onNext(obj);
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (!sequentialDisposable.isDisposed()) {
                            throw null;
                        }
                    }
                } while (decrementAndGet() != 0);
            }
        }

        public final void cancel() {
            this.f.dispose();
        }

        public final void onComplete() {
            this.e.lazySet(NotificationLite.COMPLETE);
            a();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.f.replace(disposable);
        }

        public final void onSuccess(Object obj) {
            this.e.lazySet(obj);
            a();
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this.d, j);
                a();
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(flowableSubscriber);
        flowableSubscriber.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.a();
    }
}
