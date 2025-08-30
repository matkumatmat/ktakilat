package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: f9  reason: default package */
public final /* synthetic */ class f9 implements Continuation, SuccessContinuation {
    public final /* synthetic */ FirebaseRemoteConfig c;

    public /* synthetic */ f9(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.c = firebaseRemoteConfig;
    }

    public Task then(Object obj) {
        return this.c.lambda$fetchAndActivate$1((Void) obj);
    }

    public Object then(Task task) {
        return Boolean.valueOf(this.c.processActivatePutTask(task));
    }
}
