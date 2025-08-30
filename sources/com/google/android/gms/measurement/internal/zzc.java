package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzc implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzd zzb;

    public zzc(zzd zzd, long j) {
        this.zza = j;
        Objects.requireNonNull(zzd);
        this.zzb = zzd;
    }

    public final void run() {
        this.zzb.zzf(this.zza);
    }
}
