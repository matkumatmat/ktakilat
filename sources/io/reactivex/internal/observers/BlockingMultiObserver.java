package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    public Object c;
    public Throwable d;
    public Disposable e;
    public volatile boolean f;

    public final Object a() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e2) {
                this.f = true;
                Disposable disposable = this.e;
                if (disposable != null) {
                    disposable.dispose();
                }
                throw ExceptionHelper.c(e2);
            }
        }
        Throwable th = this.d;
        if (th == null) {
            return this.c;
        }
        throw ExceptionHelper.c(th);
    }

    public final void onComplete() {
        countDown();
    }

    public final void onError(Throwable th) {
        this.d = th;
        countDown();
    }

    public final void onSubscribe(Disposable disposable) {
        this.e = disposable;
        if (this.f) {
            disposable.dispose();
        }
    }

    public final void onSuccess(Object obj) {
        this.c = obj;
        countDown();
    }
}
