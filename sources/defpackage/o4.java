package defpackage;

import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;

/* renamed from: o4  reason: default package */
public final /* synthetic */ class o4 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CrashlyticsCore d;
    public final /* synthetic */ SettingsProvider e;

    public /* synthetic */ o4(CrashlyticsCore crashlyticsCore, SettingsProvider settingsProvider, int i) {
        this.c = i;
        this.d = crashlyticsCore;
        this.e = settingsProvider;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$doBackgroundInitializationAsync$0(this.e);
                return;
            default:
                this.d.lambda$finishInitSynchronously$9(this.e);
                return;
        }
    }
}
