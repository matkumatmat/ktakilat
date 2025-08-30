package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzjz implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzli zzb;

    public zzjz(zzli zzli, long j) {
        this.zza = j;
        Objects.requireNonNull(zzli);
        this.zzb = zzli;
    }

    public final void run() {
        zzib zzib = this.zzb.zzu;
        zzhd zzhd = zzib.zzd().zzf;
        long j = this.zza;
        zzhd.zzb(j);
        zzib.zzaV().zzj().zzb("Session timeout duration set", Long.valueOf(j));
    }
}
