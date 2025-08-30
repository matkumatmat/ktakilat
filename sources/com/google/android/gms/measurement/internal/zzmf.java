package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmf implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzpk zzc;
    final /* synthetic */ zznk zzd;

    public zzmf(zznk zznk, zzr zzr, boolean z, zzpk zzpk) {
        this.zza = zzr;
        this.zzb = z;
        this.zzc = zzpk;
        Objects.requireNonNull(zznk);
        this.zzd = zznk;
    }

    public final void run() {
        zzpk zzpk;
        zznk zznk = this.zzd;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.w(zznk.zzu, "Discarding data. Failed to set user property");
            return;
        }
        zzr zzr = this.zza;
        Preconditions.checkNotNull(zzr);
        if (this.zzb) {
            zzpk = null;
        } else {
            zzpk = this.zzc;
        }
        zznk.zzm(zzZ, zzpk, zzr);
        zznk.zzV();
    }
}
