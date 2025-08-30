package io.reactivex.internal.observers;

public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public final void onError(Throwable th) {
        if (this.c == null) {
            this.d = th;
        }
        countDown();
    }

    public final void onNext(Object obj) {
        if (this.c == null) {
            this.c = obj;
            this.e.dispose();
            countDown();
        }
    }
}
