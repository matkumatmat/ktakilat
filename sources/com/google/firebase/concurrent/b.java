package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f309a;
    public final /* synthetic */ DelegatingScheduledExecutorService b;
    public final /* synthetic */ long c;
    public final /* synthetic */ TimeUnit d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Object obj, long j, TimeUnit timeUnit, int i) {
        this.f309a = i;
        this.b = delegatingScheduledExecutorService;
        this.e = obj;
        this.c = j;
        this.d = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        switch (this.f309a) {
            case 0:
                return this.b.lambda$schedule$2((Runnable) this.e, this.c, this.d, completer);
            default:
                return this.b.lambda$schedule$5((Callable) this.e, this.c, this.d, completer);
        }
    }
}
