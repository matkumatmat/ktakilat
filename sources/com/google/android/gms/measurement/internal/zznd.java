package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class zznd implements Runnable {
    final /* synthetic */ ConnectionResult zza;
    final /* synthetic */ zzne zzb;

    public zznd(zzne zzne, ConnectionResult connectionResult) {
        this.zza = connectionResult;
        Objects.requireNonNull(zzne);
        this.zzb = zzne;
    }

    public final void run() {
        zznk zznk = this.zzb.zza;
        zznk.zzaa((zzga) null);
        if (this.zza.getErrorCode() == 7777) {
            if (zznk.zzab() == null) {
                zznk.zzac(Executors.newScheduledThreadPool(1));
            }
            zznk.zzab().schedule(new zznb(this), ((Long) zzfx.zzZ.zzb((Object) null)).longValue(), TimeUnit.MILLISECONDS);
            return;
        }
        zznk.zzX();
    }
}
