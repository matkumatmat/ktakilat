package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzkt implements Runnable {
    final /* synthetic */ zzjk zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzli zzd;

    public zzkt(zzli zzli, zzjk zzjk, long j, boolean z) {
        this.zza = zzjk;
        this.zzb = j;
        this.zzc = z;
        Objects.requireNonNull(zzli);
        this.zzd = zzli;
    }

    public final void run() {
        zzli zzli = this.zzd;
        zzjk zzjk = this.zza;
        zzli.zzA(zzjk);
        zzli.zzaj(zzjk, this.zzb, true, this.zzc);
    }
}
