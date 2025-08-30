package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Objects;

final class zzkh implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzli zzb;

    public zzkh(zzli zzli, Bundle bundle) {
        this.zza = bundle;
        Objects.requireNonNull(zzli);
        this.zzb = zzli;
    }

    public final void run() {
        zzli zzli = this.zzb;
        zzli.zzg();
        zzli.zzb();
        Bundle bundle = this.zza;
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzli.zzu.zzB()) {
            zzli.zzu.zzaV().zzk().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzpk zzpk = new zzpk(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), string2);
        try {
            zzib zzib = zzli.zzu;
            zzbg zzac = zzib.zzk().zzac(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0, true, true);
            zzbg zzac2 = zzib.zzk().zzac(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0, true, true);
            zzbg zzac3 = zzib.zzk().zzac(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0, true, true);
            zzli.zzu.zzt().zzp(new zzah(bundle.getString("app_id"), string2, zzpk, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzac2, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzac, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzac3));
        } catch (IllegalArgumentException unused) {
        }
    }
}
