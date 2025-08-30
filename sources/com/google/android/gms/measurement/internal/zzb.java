package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzd zzc;

    public zzb(zzd zzd, String str, long j) {
        this.zza = str;
        this.zzb = j;
        Objects.requireNonNull(zzd);
        this.zzc = zzd;
    }

    public final void run() {
        this.zzc.zze(this.zza, this.zzb);
    }
}
