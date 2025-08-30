package defpackage;

import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;

/* renamed from: r4  reason: default package */
public final /* synthetic */ class r4 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CrashlyticsCore d;
    public final /* synthetic */ long e;
    public final /* synthetic */ String f;

    public /* synthetic */ r4(CrashlyticsCore crashlyticsCore, long j, String str, int i) {
        this.c = i;
        this.d = crashlyticsCore;
        this.e = j;
        this.f = str;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$log$2(this.e, this.f);
                return;
            default:
                this.d.lambda$log$3(this.e, this.f);
                return;
        }
    }
}
