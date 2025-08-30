package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzlx implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzma zzb;

    public zzlx(zzma zzma, long j) {
        this.zza = j;
        Objects.requireNonNull(zzma);
        this.zzb = zzma;
    }

    public final void run() {
        zzma zzma = this.zzb;
        zzma.zzu.zzw().zzc(this.zza);
        zzma.zza = null;
    }
}
