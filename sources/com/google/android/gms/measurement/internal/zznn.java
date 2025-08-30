package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznn implements Runnable {
    final /* synthetic */ zzpf zza;
    final /* synthetic */ Runnable zzb;

    public zznn(zzns zzns, zzpf zzpf, Runnable runnable) {
        this.zza = zzpf;
        this.zzb = runnable;
        Objects.requireNonNull(zzns);
    }

    public final void run() {
        zzpf zzpf = this.zza;
        zzpf.zzY();
        zzpf.zzX(this.zzb);
        zzpf.zzM();
    }
}
