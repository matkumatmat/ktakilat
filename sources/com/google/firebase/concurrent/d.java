package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ DelegatingScheduledExecutorService d;
    public final /* synthetic */ Runnable e;
    public final /* synthetic */ DelegatingScheduledFuture.Completer f;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.c = i;
        this.d = delegatingScheduledExecutorService;
        this.e = runnable;
        this.f = completer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$scheduleWithFixedDelay$10(this.e, this.f);
                return;
            case 1:
                this.d.lambda$scheduleAtFixedRate$7(this.e, this.f);
                return;
            default:
                this.d.lambda$schedule$1(this.e, this.f);
                return;
        }
    }
}
