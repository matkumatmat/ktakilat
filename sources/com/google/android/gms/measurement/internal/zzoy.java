package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;

final class zzoy implements Callable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzpf zzb;

    public zzoy(zzpf zzpf, zzr zzr) {
        this.zza = zzr;
        Objects.requireNonNull(zzpf);
        this.zzb = zzpf;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzr zzr = this.zza;
        zzpf zzpf = this.zzb;
        zzjk zzB = zzpf.zzB((String) Preconditions.checkNotNull(zzr.zza));
        zzjj zzjj = zzjj.ANALYTICS_STORAGE;
        if (zzB.zzo(zzjj) && zzjk.zzf(zzr.zzs, 100).zzo(zzjj)) {
            return zzpf.zzan(zzr).zzd();
        }
        zzpf.zzaV().zzk().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
