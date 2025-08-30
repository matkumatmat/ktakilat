package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class DisposeOnCancel implements Future<Object> {
    public final Disposable c;

    public DisposeOnCancel(Disposable disposable) {
        this.c = disposable;
    }

    public final boolean cancel(boolean z) {
        this.c.dispose();
        return false;
    }

    public final Object get() {
        return null;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return false;
    }

    public final Object get(long j, TimeUnit timeUnit) {
        return null;
    }
}
