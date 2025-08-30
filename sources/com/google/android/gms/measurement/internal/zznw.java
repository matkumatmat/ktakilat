package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznw implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zznx zzc;

    public zznw(zznx zznx, long j, long j2) {
        Objects.requireNonNull(zznx);
        this.zzc = zznx;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzu.zzaW().zzj(new zznv(this));
    }
}
