package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzir implements Runnable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjc zzc;

    public zzir(zzjc zzjc, zzbg zzbg, String str) {
        this.zza = zzbg;
        this.zzb = str;
        Objects.requireNonNull(zzjc);
        this.zzc = zzjc;
    }

    public final void run() {
        zzjc zzjc = this.zzc;
        zzjc.zzL().zzY();
        zzjc.zzL().zzD(this.zza, this.zzb);
    }
}
