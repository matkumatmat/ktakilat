package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzoz implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzpa zzd;

    public zzoz(zzpa zzpa, String str, String str2, Bundle bundle) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
        Objects.requireNonNull(zzpa);
        this.zzd = zzpa;
    }

    public final void run() {
        zzpf zzpf = this.zzd.zza;
        zzpo zzt = zzpf.zzt();
        long currentTimeMillis = zzpf.zzaZ().currentTimeMillis();
        String str = this.zza;
        zzpf.zzD((zzbg) Preconditions.checkNotNull(zzt.zzac(str, this.zzb, this.zzc, "auto", currentTimeMillis, false, true)), str);
    }
}
