package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Runnable d;

    public /* synthetic */ g(Runnable runnable, int i) {
        this.c = i;
        this.d = runnable;
    }

    public final Object call() {
        switch (this.c) {
            case 0:
                return this.d.run();
            default:
                return this.d.run();
        }
    }
}
