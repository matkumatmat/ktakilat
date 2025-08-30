package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzgz implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzha zzb;

    public zzgz(zzha zzha, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzha);
        this.zzb = zzha;
    }

    public final void run() {
        this.zzb.zzc().zzar(this.zza);
    }
}
