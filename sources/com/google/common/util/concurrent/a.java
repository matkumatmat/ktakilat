package com.google.common.util.concurrent;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AggregateFuture c;
    public final /* synthetic */ ListenableFuture d;
    public final /* synthetic */ int e;

    public /* synthetic */ a(AggregateFuture aggregateFuture, ListenableFuture listenableFuture, int i) {
        this.c = aggregateFuture;
        this.d = listenableFuture;
        this.e = i;
    }

    public final void run() {
        this.c.lambda$init$0(this.d, this.e);
    }
}
