package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {
    public final /* synthetic */ DelegatingScheduledExecutorService c;
    public final /* synthetic */ Callable d;
    public final /* synthetic */ DelegatingScheduledFuture.Completer e;

    public /* synthetic */ f(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.c = delegatingScheduledExecutorService;
        this.d = callable;
        this.e = completer;
    }

    public final Object call() {
        return this.c.lambda$schedule$4(this.d, this.e);
    }
}
