package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zziq implements Runnable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjc zzc;

    public zziq(zzjc zzjc, zzbg zzbg, zzr zzr) {
        this.zza = zzbg;
        this.zzb = zzr;
        Objects.requireNonNull(zzjc);
        this.zzc = zzjc;
    }

    public final void run() {
        zzbg zzbg = this.zza;
        zzr zzr = this.zzb;
        zzjc zzjc = this.zzc;
        zzjc.zzb(zzjc.zzc(zzbg, zzr), zzr);
    }
}
