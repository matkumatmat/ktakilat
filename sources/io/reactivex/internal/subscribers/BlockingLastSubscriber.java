package io.reactivex.internal.subscribers;

public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public final void onError(Throwable th) {
        this.c = null;
        countDown();
    }

    public final void onNext(Object obj) {
        this.c = obj;
    }
}
