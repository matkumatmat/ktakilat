package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    public final Observer g;
    public final AtomicReference i = new AtomicReference();

    public enum EmptyObserver implements Observer<Object> {
        ;

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
        }

        public final void onNext(Object obj) {
        }

        public final void onSubscribe(Disposable disposable) {
        }
    }

    public TestObserver() {
        EmptyObserver emptyObserver = EmptyObserver.c;
        this.g = emptyObserver;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.i);
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.i.get());
    }

    public final void onComplete() {
        CountDownLatch countDownLatch = this.c;
        if (!this.f) {
            this.f = true;
            if (this.i.get() == null) {
                this.e.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.g.getClass();
        } finally {
            countDownLatch.countDown();
        }
    }

    public final void onError(Throwable th) {
        CountDownLatch countDownLatch = this.c;
        boolean z = this.f;
        VolatileSizeArrayList volatileSizeArrayList = this.e;
        if (!z) {
            this.f = true;
            if (this.i.get() == null) {
                volatileSizeArrayList.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th == null) {
                volatileSizeArrayList.add(new NullPointerException("onError received a null Throwable"));
            } else {
                volatileSizeArrayList.add(th);
            }
            this.g.getClass();
            countDownLatch.countDown();
        } catch (Throwable th2) {
            countDownLatch.countDown();
            throw th2;
        }
    }

    public final void onNext(Object obj) {
        boolean z = this.f;
        VolatileSizeArrayList volatileSizeArrayList = this.e;
        if (!z) {
            this.f = true;
            if (this.i.get() == null) {
                volatileSizeArrayList.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        this.d.add(obj);
        if (obj == null) {
            volatileSizeArrayList.add(new NullPointerException("onNext received a null value"));
        }
        this.g.getClass();
    }

    public final void onSubscribe(Disposable disposable) {
        Thread.currentThread();
        VolatileSizeArrayList volatileSizeArrayList = this.e;
        if (disposable == null) {
            volatileSizeArrayList.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        AtomicReference atomicReference = this.i;
        while (!atomicReference.compareAndSet((Object) null, disposable)) {
            if (atomicReference.get() != null) {
                disposable.dispose();
                if (atomicReference.get() != DisposableHelper.DISPOSED) {
                    volatileSizeArrayList.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
                    return;
                }
                return;
            }
        }
        this.g.getClass();
    }

    public final void onSuccess(Object obj) {
        onNext(obj);
        onComplete();
    }
}
