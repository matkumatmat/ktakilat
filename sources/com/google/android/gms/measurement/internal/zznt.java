package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznt implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzob zzb;

    public zznt(zzob zzob, long j) {
        this.zza = j;
        Objects.requireNonNull(zzob);
        this.zzb = zzob;
    }

    public final void run() {
        this.zzb.zzk(this.zza);
    }
}
