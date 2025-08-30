package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzke implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzli zzc;

    public zzke(zzli zzli, AtomicReference atomicReference, boolean z) {
        this.zza = atomicReference;
        this.zzb = z;
        Objects.requireNonNull(zzli);
        this.zzc = zzli;
    }

    public final void run() {
        this.zzc.zzu.zzt().zzv(this.zza, this.zzb);
    }
}
