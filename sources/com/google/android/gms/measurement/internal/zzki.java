package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Objects;

final class zzki implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzli zzb;

    public zzki(zzli zzli, Bundle bundle) {
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
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzli.zzu.zzB()) {
            zzli.zzu.zzaV().zzk().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzpk zzpk = new zzpk(checkNotEmpty, 0, (Object) null, "");
        try {
            zzah zzah = r4;
            zzah zzah2 = new zzah(bundle.getString("app_id"), "", zzpk, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzbg) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzbg) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzli.zzu.zzk().zzac(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true));
            zzli.zzu.zzt().zzp(zzah);
        } catch (IllegalArgumentException unused) {
        }
    }
}
