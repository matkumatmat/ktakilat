package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzax implements Runnable {
    final /* synthetic */ zzjf zza;
    final /* synthetic */ zzay zzb;

    public zzax(zzay zzay, zzjf zzjf) {
        this.zza = zzjf;
        Objects.requireNonNull(zzay);
        this.zzb = zzay;
    }

    public final void run() {
        zzjf zzjf = this.zza;
        zzjf.zzaU();
        if (zzae.zza()) {
            zzjf.zzaW().zzj(this);
            return;
        }
        zzay zzay = this.zzb;
        boolean zzc = zzay.zzc();
        zzay.zze(0);
        if (zzc) {
            zzay.zza();
        }
    }
}
