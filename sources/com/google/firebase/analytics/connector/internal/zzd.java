package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjl;
import java.util.Objects;

final class zzd implements AppMeasurementSdk.OnEventListener {
    final /* synthetic */ zze zza;

    public zzd(zze zze) {
        Objects.requireNonNull(zze);
        this.zza = zze;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        zze zze = this.zza;
        if (zze.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            int i = zzc.zza;
            String zza2 = zzjl.zza(str2);
            if (zza2 != null) {
                str2 = zza2;
            }
            bundle2.putString("events", str2);
            zze.zzd().onMessageTriggered(2, bundle2);
        }
    }
}
