package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzou implements Runnable {
    final /* synthetic */ zzpg zza;
    final /* synthetic */ zzpf zzb;

    public zzou(zzpf zzpf, zzpg zzpg) {
        this.zza = zzpg;
        Objects.requireNonNull(zzpf);
        this.zzb = zzpf;
    }

    public final void run() {
        zzpf zzpf = this.zzb;
        zzpf.zzat(this.zza);
        zzpf.zzc();
    }
}
