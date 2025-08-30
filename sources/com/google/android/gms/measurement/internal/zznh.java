package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final /* synthetic */ class zznh implements Runnable {
    private final /* synthetic */ zznk zza;
    private final /* synthetic */ AtomicReference zzb;
    private final /* synthetic */ zzr zzc;
    private final /* synthetic */ zzon zzd;

    public /* synthetic */ zznh(zznk zznk, AtomicReference atomicReference, zzr zzr, zzon zzon) {
        this.zza = zznk;
        this.zzb = atomicReference;
        this.zzc = zzr;
        this.zzd = zzon;
    }

    public final /* synthetic */ void run() {
        this.zza.zzT(this.zzb, this.zzc, this.zzd);
    }
}
