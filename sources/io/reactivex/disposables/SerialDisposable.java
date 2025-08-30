package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialDisposable implements Disposable {
    public final void dispose() {
        DisposableHelper.dispose((AtomicReference<Disposable>) null);
    }

    public final boolean isDisposed() {
        throw null;
    }
}
