package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class j implements Callable {
    public final /* synthetic */ Context c;
    public final /* synthetic */ ScheduledExecutorService d;
    public final /* synthetic */ FirebaseMessaging e;
    public final /* synthetic */ Metadata f;
    public final /* synthetic */ GmsRpc g;

    public /* synthetic */ j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        this.c = context;
        this.d = scheduledExecutorService;
        this.e = firebaseMessaging;
        this.f = metadata;
        this.g = gmsRpc;
    }

    public final Object call() {
        return TopicsSubscriber.lambda$createInstance$0(this.c, this.d, this.e, this.f, this.g);
    }
}
