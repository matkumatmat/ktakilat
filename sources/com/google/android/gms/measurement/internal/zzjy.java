package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzjy implements Runnable {
    final /* synthetic */ zzli zza;

    public zzjy(zzli zzli) {
        Objects.requireNonNull(zzli);
        this.zza = zzli;
    }

    public final void run() {
        this.zza.zzb.zza();
    }
}
