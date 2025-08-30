package defpackage;

import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.messaging.FirebaseMessaging;

/* renamed from: d9  reason: default package */
public final /* synthetic */ class d9 implements FirebaseInstanceIdInternal.NewTokenListener, OnSuccessListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ FirebaseMessaging d;

    public /* synthetic */ d9(FirebaseMessaging firebaseMessaging, int i) {
        this.c = i;
        this.d = firebaseMessaging;
    }

    public void onNewToken(String str) {
        this.d.lambda$new$1(str);
    }

    public void onSuccess(Object obj) {
        switch (this.c) {
            case 1:
                this.d.lambda$setNotificationDelegationEnabled$6((Void) obj);
                return;
            default:
                this.d.lambda$handleProxiedNotificationData$5((CloudMessage) obj);
                return;
        }
    }
}
