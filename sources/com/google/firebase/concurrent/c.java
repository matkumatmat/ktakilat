package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Runnable d;
    public final /* synthetic */ DelegatingScheduledFuture.Completer e;

    public /* synthetic */ c(Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.c = i;
        this.d = runnable;
        this.e = completer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.d, this.e);
                return;
            case 1:
                DelegatingScheduledExecutorService.lambda$schedule$0(this.d, this.e);
                return;
            default:
                DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.d, this.e);
                return;
        }
    }
}
