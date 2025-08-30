package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    public final Queue c;

    public BlockingObserver(Queue<Object> queue) {
        this.c = queue;
    }

    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.c.offer(TERMINATED);
        }
    }

    public boolean isDisposed() {
        if (get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    public void onComplete() {
        this.c.offer(NotificationLite.complete());
    }

    public void onError(Throwable th) {
        this.c.offer(NotificationLite.error(th));
    }

    public void onNext(T t) {
        this.c.offer(NotificationLite.next(t));
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
