package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzkk implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzli zze;

    public zzkk(zzli zzli, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
        Objects.requireNonNull(zzli);
        this.zze = zzli;
    }

    public final void run() {
        this.zze.zzu.zzt().zzt(this.zza, (String) null, this.zzb, this.zzc, this.zzd);
    }
}
