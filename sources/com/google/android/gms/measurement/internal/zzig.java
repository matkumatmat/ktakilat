package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzig implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjc zzc;

    public zzig(zzjc zzjc, zzah zzah, zzr zzr) {
        this.zza = zzah;
        this.zzb = zzr;
        Objects.requireNonNull(zzjc);
        this.zzc = zzjc;
    }

    public final void run() {
        zzjc zzjc = this.zzc;
        zzjc.zzL().zzY();
        zzah zzah = this.zza;
        if (zzah.zzc.zza() == null) {
            zzjc.zzL().zzal(zzah, this.zzb);
            return;
        }
        zzjc.zzL().zzaj(zzah, this.zzb);
    }
}
