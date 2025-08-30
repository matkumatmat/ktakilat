package com.google.firebase.messaging;

import android.content.Intent;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ FcmLifecycleCallbacks c;
    public final /* synthetic */ Intent d;

    public /* synthetic */ a(FcmLifecycleCallbacks fcmLifecycleCallbacks, Intent intent) {
        this.c = fcmLifecycleCallbacks;
        this.d = intent;
    }

    public final void run() {
        this.c.lambda$onActivityCreated$0(this.d);
    }
}
