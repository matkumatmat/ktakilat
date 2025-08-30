package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzda;
import java.util.Objects;

final class zzq implements zzjp {
    public final zzda zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzq(AppMeasurementDynamiteService appMeasurementDynamiteService, zzda zzda) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzda;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zza.zze(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzib zzib = this.zzb.zza;
            if (zzib != null) {
                zzib.zzaV().zze().zzb("Event listener threw exception", e);
            }
        }
    }
}
