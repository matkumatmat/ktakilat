package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;

public final class Disposables {
    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.disposables.Disposable, java.util.concurrent.atomic.AtomicReference] */
    public static Disposable a(Runnable runnable) {
        return new AtomicReference(runnable);
    }
}
