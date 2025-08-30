package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final /* synthetic */ class zzkz implements Runnable {
    private final /* synthetic */ zzli zza;
    private final /* synthetic */ AtomicReference zzb;

    public /* synthetic */ zzkz(zzli zzli, AtomicReference atomicReference) {
        this.zza = zzli;
        this.zzb = atomicReference;
    }

    public final /* synthetic */ void run() {
        zzli zzli = this.zza;
        zzli.zzu.zzt().zzw(this.zzb, zzli.zzu.zzd().zzi.zza());
    }
}
