package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzly implements Runnable {
    final /* synthetic */ zzlt zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzma zzc;

    public zzly(zzma zzma, zzlt zzlt, long j) {
        this.zza = zzlt;
        this.zzb = j;
        Objects.requireNonNull(zzma);
        this.zzc = zzma;
    }

    public final void run() {
        zzma zzma = this.zzc;
        zzma.zzv(this.zza, false, this.zzb);
        zzma.zza = null;
        zzma.zzu.zzt().zzG((zzlt) null);
    }
}
