package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((CustomThreadFactory) this.d).lambda$newThread$0((Runnable) this.e);
                return;
            case 1:
                DelegatingScheduledExecutorService.lambda$schedule$3((Callable) this.d, (DelegatingScheduledFuture.Completer) this.e);
                return;
            default:
                ((LimitedConcurrencyExecutor) this.d).lambda$decorate$0((Runnable) this.e);
                return;
        }
    }
}
