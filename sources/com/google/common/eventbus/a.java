package com.google.common.eventbus;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Subscriber c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Object obj, Subscriber subscriber) {
        this.c = subscriber;
        this.d = obj;
    }

    public final void run() {
        this.c.lambda$dispatchEvent$0(this.d);
    }
}
