package defpackage;

import com.google.firebase.messaging.FirebaseMessaging;

/* renamed from: e9  reason: default package */
public final /* synthetic */ class e9 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FirebaseMessaging d;

    public /* synthetic */ e9(FirebaseMessaging firebaseMessaging, int i) {
        this.c = i;
        this.d = firebaseMessaging;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$new$2();
                return;
            default:
                this.d.lambda$new$4();
                return;
        }
    }
}
