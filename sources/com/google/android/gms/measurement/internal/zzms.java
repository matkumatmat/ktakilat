package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzms implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbg zzc;
    final /* synthetic */ zznk zzd;

    public zzms(zznk zznk, boolean z, zzr zzr, boolean z2, zzbg zzbg, String str) {
        this.zza = zzr;
        this.zzb = z2;
        this.zzc = zzbg;
        Objects.requireNonNull(zznk);
        this.zzd = zznk;
    }

    public final void run() {
        zzbg zzbg;
        zznk zznk = this.zzd;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.w(zznk.zzu, "Discarding data. Failed to send event to service");
            return;
        }
        zzr zzr = this.zza;
        Preconditions.checkNotNull(zzr);
        if (this.zzb) {
            zzbg = null;
        } else {
            zzbg = this.zzc;
        }
        zznk.zzm(zzZ, zzbg, zzr);
        zznk.zzV();
    }
}
