package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.Callable;

/* renamed from: g9  reason: default package */
public final /* synthetic */ class g9 implements Callable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FirebaseRemoteConfig d;

    public /* synthetic */ g9(FirebaseRemoteConfig firebaseRemoteConfig, int i) {
        this.c = i;
        this.d = firebaseRemoteConfig;
    }

    public final Object call() {
        switch (this.c) {
            case 0:
                return this.d.lambda$reset$6();
            default:
                return this.d.getInfo();
        }
    }
}
