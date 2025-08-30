package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription, Disposable {

    public enum EmptySubscriber implements FlowableSubscriber<Object> {
        ;

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
        }

        public final void onNext(Object obj) {
        }

        public final void onSubscribe(Subscription subscription) {
        }
    }

    public final void cancel() {
    }

    public final void dispose() {
    }

    public final boolean isDisposed() {
        return true;
    }

    public final void onComplete() {
        if (!this.f) {
            this.f = true;
            throw null;
        }
        try {
            Thread.currentThread();
            throw null;
        } catch (Throwable th) {
            this.c.countDown();
            throw th;
        }
    }

    public final void onError(Throwable th) {
        if (this.f) {
            try {
                Thread.currentThread();
                VolatileSizeArrayList volatileSizeArrayList = this.e;
                volatileSizeArrayList.add(th);
                if (th == null) {
                    volatileSizeArrayList.add(new IllegalStateException("onError received a null Throwable"));
                }
                throw null;
            } catch (Throwable th2) {
                this.c.countDown();
                throw th2;
            }
        } else {
            this.f = true;
            throw null;
        }
    }

    public final void onNext(Object obj) {
        if (this.f) {
            Thread.currentThread();
            this.d.add(obj);
            if (obj == null) {
                this.e.add(new NullPointerException("onNext received a null value"));
            }
            throw null;
        }
        this.f = true;
        throw null;
    }

    public final void onSubscribe(Subscription subscription) {
        Thread.currentThread();
        if (subscription == null) {
            this.e.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        throw null;
    }

    public final void request(long j) {
        SubscriptionHelper.deferredRequest((AtomicReference<Subscription>) null, (AtomicLong) null, j);
    }
}
