package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;

final class zzmm implements Runnable {
    final /* synthetic */ zzlt zza;
    final /* synthetic */ zznk zzb;

    public zzmm(zznk zznk, zzlt zzlt) {
        this.zza = zzlt;
        Objects.requireNonNull(zznk);
        this.zzb = zznk;
    }

    public final void run() {
        zznk zznk = this.zzb;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.w(zznk.zzu, "Failed to send current screen to service");
            return;
        }
        try {
            zzlt zzlt = this.zza;
            if (zzlt == null) {
                zzZ.zzl(0, (String) null, (String) null, zznk.zzu.zzaY().getPackageName());
            } else {
                zzZ.zzl(zzlt.zzc, zzlt.zza, zzlt.zzb, zznk.zzu.zzaY().getPackageName());
            }
            zznk.zzV();
        } catch (RemoteException e) {
            this.zzb.zzu.zzaV().zzb().zzb("Failed to send current screen to the service", e);
        }
    }
}
