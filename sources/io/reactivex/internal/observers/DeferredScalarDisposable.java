package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.plugins.RxJavaPlugins;

public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = -5502432239815349361L;
    public final Observer c;
    public Object d;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.c = observer;
    }

    public final void clear() {
        lazySet(32);
        this.d = null;
    }

    public final void complete(T t) {
        int i = get();
        if ((i & 54) == 0) {
            Observer observer = this.c;
            if (i == 8) {
                this.d = t;
                lazySet(16);
                observer.onNext((Object) null);
            } else {
                lazySet(2);
                observer.onNext(t);
            }
            if (get() != 4) {
                observer.onComplete();
            }
        }
    }

    public void dispose() {
        set(4);
        this.d = null;
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            RxJavaPlugins.b(th);
            return;
        }
        lazySet(2);
        this.c.onError(th);
    }

    public final boolean isDisposed() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    public void onComplete() {
        complete();
    }

    public void onError(Throwable th) {
        error(th);
    }

    public void onSuccess(Object obj) {
        complete(obj);
    }

    @Nullable
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t = this.d;
        this.d = null;
        lazySet(32);
        return t;
    }

    public final int requestFusion(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryDispose() {
        if (getAndSet(4) != 4) {
            return true;
        }
        return false;
    }

    public final void complete() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.c.onComplete();
        }
    }
}
