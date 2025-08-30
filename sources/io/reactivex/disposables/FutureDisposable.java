package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;

    public final void dispose() {
        Future future = (Future) getAndSet((Object) null);
        if (future != null) {
            future.cancel(false);
        }
    }

    public final boolean isDisposed() {
        Future future = (Future) get();
        if (future == null || future.isDone()) {
            return true;
        }
        return false;
    }
}
