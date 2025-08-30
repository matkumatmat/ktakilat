package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzkj implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzli zzd;

    public zzkj(zzli zzli, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        Objects.requireNonNull(zzli);
        this.zzd = zzli;
    }

    public final void run() {
        this.zzd.zzu.zzt().zzq(this.zza, (String) null, this.zzb, this.zzc);
    }
}
