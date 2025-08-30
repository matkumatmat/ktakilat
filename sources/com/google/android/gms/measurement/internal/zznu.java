package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznu implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzob zzb;

    public zznu(zzob zzob, long j) {
        this.zza = j;
        Objects.requireNonNull(zzob);
        this.zzb = zzob;
    }

    public final void run() {
        this.zzb.zzl(this.zza);
    }
}
