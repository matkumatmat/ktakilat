package defpackage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.perf.config.RemoteConfigManager;

/* renamed from: xd  reason: default package */
public final /* synthetic */ class xd implements OnSuccessListener, OnFailureListener {
    public final /* synthetic */ RemoteConfigManager c;

    public /* synthetic */ xd(RemoteConfigManager remoteConfigManager) {
        this.c = remoteConfigManager;
    }

    public void onFailure(Exception exc) {
        this.c.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(exc);
    }

    public void onSuccess(Object obj) {
        this.c.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0((Boolean) obj);
    }
}
