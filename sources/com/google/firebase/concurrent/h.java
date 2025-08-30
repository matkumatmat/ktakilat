package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Callable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Runnable d;
    public final /* synthetic */ Object e;

    public /* synthetic */ h(Runnable runnable, Object obj, int i) {
        this.c = i;
        this.d = runnable;
        this.e = obj;
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
