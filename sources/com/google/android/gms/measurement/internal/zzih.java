package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzih implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ zzjc zzb;

    public zzih(zzjc zzjc, zzah zzah) {
        this.zza = zzah;
        Objects.requireNonNull(zzjc);
        this.zzb = zzjc;
    }

    public final void run() {
        zzjc zzjc = this.zzb;
        zzjc.zzL().zzY();
        zzah zzah = this.zza;
        if (zzah.zzc.zza() == null) {
            zzjc.zzL().zzak(zzah);
        } else {
            zzjc.zzL().zzai(zzah);
        }
    }
}
