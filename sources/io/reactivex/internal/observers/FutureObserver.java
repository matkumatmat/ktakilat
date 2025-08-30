package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {
    public Object c;
    public Throwable d;
    public final AtomicReference e = new AtomicReference();

    public FutureObserver() {
        super(1);
    }

    public final boolean cancel(boolean z) {
        DisposableHelper disposableHelper;
        while (true) {
            AtomicReference atomicReference = this.e;
            Disposable disposable = (Disposable) atomicReference.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
            while (true) {
                if (atomicReference.compareAndSet(disposable, disposableHelper)) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    countDown();
                    return true;
                } else if (atomicReference.get() != disposable) {
                }
            }
        }
    }

    public final void dispose() {
    }

    public final Object get() {
        if (getCount() != 0) {
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.d;
            if (th == null) {
                return this.c;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public final boolean isCancelled() {
        return DisposableHelper.isDisposed((Disposable) this.e.get());
    }

    public final boolean isDisposed() {
        return isDone();
    }

    public final boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    public final void onComplete() {
        if (this.c == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        while (true) {
            AtomicReference atomicReference = this.e;
            Disposable disposable = (Disposable) atomicReference.get();
            if (disposable != this && disposable != DisposableHelper.DISPOSED) {
                while (true) {
                    if (atomicReference.compareAndSet(disposable, this)) {
                        countDown();
                        return;
                    } else if (atomicReference.get() != disposable) {
                    }
                }
            } else {
                return;
            }
        }
    }

    public final void onError(Throwable th) {
        if (this.d == null) {
            this.d = th;
            while (true) {
                AtomicReference atomicReference = this.e;
                Disposable disposable = (Disposable) atomicReference.get();
                if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                    RxJavaPlugins.b(th);
                } else {
                    while (true) {
                        if (atomicReference.compareAndSet(disposable, this)) {
                            countDown();
                            return;
                        } else if (atomicReference.get() != disposable) {
                        }
                    }
                }
            }
            RxJavaPlugins.b(th);
            return;
        }
        RxJavaPlugins.b(th);
    }

    public final void onNext(Object obj) {
        if (this.c != null) {
            ((Disposable) this.e.get()).dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.c = obj;
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.e, disposable);
    }

    public final Object get(long j, TimeUnit timeUnit) {
        if (getCount() != 0 && !await(j, timeUnit)) {
            throw new TimeoutException();
        } else if (!isCancelled()) {
            Throwable th = this.d;
            if (th == null) {
                return this.c;
            }
            throw new ExecutionException(th);
        } else {
            throw new CancellationException();
        }
    }
}
