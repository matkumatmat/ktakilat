package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzit implements Runnable {
    final /* synthetic */ zzpk zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjc zzc;

    public zzit(zzjc zzjc, zzpk zzpk, zzr zzr) {
        this.zza = zzpk;
        this.zzb = zzr;
        Objects.requireNonNull(zzjc);
        this.zzc = zzjc;
    }

    public final void run() {
        zzjc zzjc = this.zzc;
        zzjc.zzL().zzY();
        zzpk zzpk = this.zza;
        if (zzpk.zza() == null) {
            zzr zzr = this.zzb;
            zzjc.zzL().zzac(zzpk.zzb, zzr);
            return;
        }
        zzjc.zzL().zzab(zzpk, this.zzb);
    }
}
