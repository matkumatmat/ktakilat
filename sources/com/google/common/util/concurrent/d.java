package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ d(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((JdkFutureAdapters.ListenableFutureAdapter) this.d).lambda$addListener$0();
                return;
            default:
                WrappingExecutorService.lambda$wrapTask$0((Callable) this.d);
                return;
        }
    }
}
