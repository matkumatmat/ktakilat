package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmg implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zznk zzb;

    public zzmg(zznk zznk, zzr zzr) {
        this.zza = zzr;
        Objects.requireNonNull(zznk);
        this.zzb = zznk;
    }

    public final void run() {
        zznk zznk = this.zzb;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.w(zznk.zzu, "Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzr zzr = this.zza;
            Preconditions.checkNotNull(zzr);
            zzZ.zzt(zzr);
        } catch (RemoteException e) {
            this.zzb.zzu.zzaV().zzb().zzb("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzV();
    }
}
