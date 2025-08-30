package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmt implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzah zzc;
    final /* synthetic */ zznk zzd;

    public zzmt(zznk zznk, boolean z, zzr zzr, boolean z2, zzah zzah, zzah zzah2) {
        this.zza = zzr;
        this.zzb = z2;
        this.zzc = zzah;
        Objects.requireNonNull(zznk);
        this.zzd = zznk;
    }

    public final void run() {
        zzah zzah;
        zznk zznk = this.zzd;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.w(zznk.zzu, "Discarding data. Failed to send conditional user property to service");
            return;
        }
        zzr zzr = this.zza;
        Preconditions.checkNotNull(zzr);
        if (this.zzb) {
            zzah = null;
        } else {
            zzah = this.zzc;
        }
        zznk.zzm(zzZ, zzah, zzr);
        zznk.zzV();
    }
}
