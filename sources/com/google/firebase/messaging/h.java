package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class h implements Continuation {
    public final /* synthetic */ RequestDeduplicator c;
    public final /* synthetic */ String d;

    public /* synthetic */ h(RequestDeduplicator requestDeduplicator, String str) {
        this.c = requestDeduplicator;
        this.d = str;
    }

    public final Object then(Task task) {
        return this.c.lambda$getOrStartGetTokenRequest$0(this.d, task);
    }
}
