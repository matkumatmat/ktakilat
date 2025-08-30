package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class c implements OnSuccessListener, Continuation, OnCompleteListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public void onComplete(Task task) {
        switch (this.c) {
            case 2:
                WakeLockHolder.completeWakefulIntent((Intent) this.d);
                return;
            case 3:
                ((WithinAppServiceConnection.BindRequest) this.d).finish();
                return;
            default:
                ((ScheduledFuture) this.d).cancel(false);
                return;
        }
    }

    public void onSuccess(Object obj) {
        ((FirebaseMessaging) this.d).lambda$new$3((TopicsSubscriber) obj);
    }

    public Object then(Task task) {
        return ((GmsRpc) this.d).lambda$extractResponseWhenComplete$0(task);
    }
}
