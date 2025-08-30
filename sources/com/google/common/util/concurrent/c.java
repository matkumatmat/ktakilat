package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionSequencer;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ TrustedListenableFutureTask c;
    public final /* synthetic */ SettableFuture d;
    public final /* synthetic */ ListenableFuture e;
    public final /* synthetic */ ListenableFuture f;
    public final /* synthetic */ ExecutionSequencer.TaskNonReentrantExecutor g;

    public /* synthetic */ c(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor) {
        this.c = trustedListenableFutureTask;
        this.d = settableFuture;
        this.e = listenableFuture;
        this.f = listenableFuture2;
        this.g = taskNonReentrantExecutor;
    }

    public final void run() {
        ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor = this.g;
        ExecutionSequencer.lambda$submitAsync$0(this.c, this.d, this.e, this.f, taskNonReentrantExecutor);
    }
}
