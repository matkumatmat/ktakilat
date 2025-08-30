package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class d implements SuccessContinuation, RequestDeduplicator.GetTokenRequest {
    public final /* synthetic */ FirebaseMessaging c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Store.Token e;

    public /* synthetic */ d(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.c = firebaseMessaging;
        this.d = str;
        this.e = token;
    }

    public Task start() {
        return this.c.lambda$blockingGetToken$14(this.d, this.e);
    }

    public Task then(Object obj) {
        return this.c.lambda$blockingGetToken$13(this.d, this.e, (String) obj);
    }
}
