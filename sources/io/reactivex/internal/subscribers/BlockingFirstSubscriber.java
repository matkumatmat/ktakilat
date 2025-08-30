package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public final void onError(Throwable th) {
        if (this.c != null) {
            RxJavaPlugins.b(th);
        }
        countDown();
    }

    public final void onNext(Object obj) {
        if (this.c == null) {
            this.c = obj;
            this.d.cancel();
            countDown();
        }
    }
}
