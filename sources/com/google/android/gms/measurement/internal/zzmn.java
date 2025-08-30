package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmn implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbe zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zznk zze;

    public zzmn(zznk zznk, boolean z, zzr zzr, boolean z2, zzbe zzbe, Bundle bundle) {
        this.zza = zzr;
        this.zzb = z2;
        this.zzc = zzbe;
        this.zzd = bundle;
        Objects.requireNonNull(zznk);
        this.zze = zznk;
    }

    public final void run() {
        zznk zznk = this.zze;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.w(zznk.zzu, "Failed to send default event parameters to service");
            return;
        }
        zzbe zzbe = null;
        if (zznk.zzu.zzc().zzp((String) null, zzfx.zzbc)) {
            zzr zzr = this.zza;
            Preconditions.checkNotNull(zzr);
            zznk zznk2 = this.zze;
            if (!this.zzb) {
                zzbe = this.zzc;
            }
            zznk2.zzm(zzZ, zzbe, zzr);
            return;
        }
        try {
            zzr zzr2 = this.zza;
            Preconditions.checkNotNull(zzr2);
            zzZ.zzu(this.zzd, zzr2);
            zznk.zzV();
        } catch (RemoteException e) {
            this.zze.zzu.zzaV().zzb().zzb("Failed to send default event parameters to service", e);
        }
    }
}
