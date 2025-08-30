package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class b implements SuccessContinuation {
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public /* synthetic */ b(String str, int i) {
        this.c = i;
        this.d = str;
    }

    public final Task then(Object obj) {
        switch (this.c) {
            case 0:
                return ((TopicsSubscriber) obj).subscribeToTopic(this.d);
            default:
                return ((TopicsSubscriber) obj).unsubscribeFromTopic(this.d);
        }
    }
}
