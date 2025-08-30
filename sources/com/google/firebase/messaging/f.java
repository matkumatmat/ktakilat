package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ Context c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ TaskCompletionSource e;

    public /* synthetic */ f(Context context, boolean z, TaskCompletionSource taskCompletionSource) {
        this.c = context;
        this.d = z;
        this.e = taskCompletionSource;
    }

    public final void run() {
        ProxyNotificationInitializer.lambda$setEnableProxyNotification$0(this.c, this.d, this.e);
    }
}
