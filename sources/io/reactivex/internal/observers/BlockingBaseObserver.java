package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    public Object c;
    public Throwable d;
    public Disposable e;
    public volatile boolean f;

    public final Object a() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw ExceptionHelper.c(e2);
            }
        }
        Throwable th = this.d;
        if (th == null) {
            return this.c;
        }
        throw ExceptionHelper.c(th);
    }

    public final void dispose() {
        this.f = true;
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f;
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(Disposable disposable) {
        this.e = disposable;
        if (this.f) {
            disposable.dispose();
        }
    }
}
