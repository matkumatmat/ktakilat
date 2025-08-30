package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmr implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zznk zzb;

    public zzmr(zznk zznk, zzr zzr) {
        this.zza = zzr;
        Objects.requireNonNull(zznk);
        this.zzb = zznk;
    }

    public final void run() {
        zznk zznk = this.zzb;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.w(zznk.zzu, "Failed to send consent settings to service");
            return;
        }
        try {
            zzr zzr = this.zza;
            Preconditions.checkNotNull(zzr);
            zzZ.zzv(zzr);
            zznk.zzV();
        } catch (RemoteException e) {
            this.zzb.zzu.zzaV().zzb().zzb("Failed to send consent settings to the service", e);
        }
    }
}
