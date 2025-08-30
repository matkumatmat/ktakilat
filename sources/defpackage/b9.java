package defpackage;

import com.google.firebase.installations.FirebaseInstallations;

/* renamed from: b9  reason: default package */
public final /* synthetic */ class b9 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FirebaseInstallations d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ b9(FirebaseInstallations firebaseInstallations, boolean z, int i) {
        this.c = i;
        this.d = firebaseInstallations;
        this.e = z;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$doRegistrationOrRefresh$3(this.e);
                return;
            default:
                this.d.lambda$getToken$2(this.e);
                return;
        }
    }
}
