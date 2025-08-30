package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableObserver<T> implements Observer<T>, Disposable {
    public final AtomicReference c = new AtomicReference();

    public final void dispose() {
        DisposableHelper.dispose(this.c);
    }

    public final boolean isDisposed() {
        if (this.c.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    public final void onSubscribe(Disposable disposable) {
        EndConsumerHelper.b(this.c, disposable, getClass());
    }
}
