package defpackage;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.profileinstaller.ProfileInstaller;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* renamed from: a0  reason: default package */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Context d;

    public /* synthetic */ a0(Context context, int i) {
        this.c = i;
        this.d = context;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(this.d);
                return;
            case 1:
                AppCompatDelegate.syncRequestedAndStoredLocales(this.d);
                return;
            case 2:
                ProfileInstallerInitializer.writeInBackground(this.d);
                return;
            default:
                ProfileInstaller.writeProfile(this.d);
                return;
        }
    }
}
