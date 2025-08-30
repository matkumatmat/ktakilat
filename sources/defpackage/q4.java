package defpackage;

import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;

/* renamed from: q4  reason: default package */
public final /* synthetic */ class q4 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CrashlyticsCore d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ q4(CrashlyticsCore crashlyticsCore, String str, String str2, int i) {
        this.c = i;
        this.d = crashlyticsCore;
        this.e = str;
        this.f = str2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$setCustomKey$5(this.e, this.f);
                return;
            default:
                this.d.lambda$setInternalKey$7(this.e, this.f);
                return;
        }
    }
}
