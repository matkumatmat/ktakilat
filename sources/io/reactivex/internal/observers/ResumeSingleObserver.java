package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ResumeSingleObserver<T> implements SingleObserver<T> {
    public final void onError(Throwable th) {
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace((AtomicReference<Disposable>) null, disposable);
    }

    public final void onSuccess(Object obj) {
        throw null;
    }
}
