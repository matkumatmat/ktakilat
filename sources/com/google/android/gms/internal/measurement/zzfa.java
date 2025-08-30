package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Objects;

final class zzfa implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzfb zza;

    public zzfa(zzfb zzfb) {
        Objects.requireNonNull(zzfb);
        this.zza = zzfb;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.zza.zzM(new zzet(this, bundle, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzM(new zzez(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzM(new zzew(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        this.zza.zzM(new zzev(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzco zzco = new zzco();
        this.zza.zzM(new zzey(this, activity, zzco));
        Bundle zze = zzco.zze(50);
        if (zze != null) {
            bundle.putAll(zze);
        }
    }

    public final void onActivityStarted(Activity activity) {
        this.zza.zzM(new zzeu(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        this.zza.zzM(new zzex(this, activity));
    }
}
