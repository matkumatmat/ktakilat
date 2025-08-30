package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableCompletableObserver implements CompletableObserver, Disposable {
    public final void dispose() {
        DisposableHelper.dispose((AtomicReference<Disposable>) null);
    }

    public final boolean isDisposed() {
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
        EndConsumerHelper.b((AtomicReference) null, disposable, getClass());
    }
}
