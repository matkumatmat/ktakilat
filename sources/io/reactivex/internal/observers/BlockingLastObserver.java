package io.reactivex.internal.observers;

public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public final void onError(Throwable th) {
        this.c = null;
        this.d = th;
        countDown();
    }

    public final void onNext(Object obj) {
        this.c = obj;
    }
}
