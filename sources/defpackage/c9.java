package defpackage;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.FirebaseMessaging;

/* renamed from: c9  reason: default package */
public final /* synthetic */ class c9 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FirebaseMessaging d;
    public final /* synthetic */ TaskCompletionSource e;

    public /* synthetic */ c9(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource, int i) {
        this.c = i;
        this.d = firebaseMessaging;
        this.e = taskCompletionSource;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$deleteToken$9(this.e);
                return;
            case 1:
                this.d.lambda$getToken$7(this.e);
                return;
            default:
                this.d.lambda$deleteToken$8(this.e);
                return;
        }
    }
}
