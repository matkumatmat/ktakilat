package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ AggregateFuture c;
    public final /* synthetic */ ImmutableCollection d;

    public /* synthetic */ b(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        this.c = aggregateFuture;
        this.d = immutableCollection;
    }

    public final void run() {
        this.c.lambda$init$1(this.d);
    }
}
