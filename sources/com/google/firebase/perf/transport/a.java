package com.google.firebase.perf.transport;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ TransportManager c;
    public final /* synthetic */ PendingPerfEvent d;

    public /* synthetic */ a(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        this.c = transportManager;
        this.d = pendingPerfEvent;
    }

    public final void run() {
        this.c.lambda$finishInitialization$0(this.d);
    }
}
