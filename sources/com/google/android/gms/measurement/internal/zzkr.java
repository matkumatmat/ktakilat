package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzkr implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzli zzb;

    public zzkr(zzli zzli, Boolean bool) {
        this.zza = bool;
        Objects.requireNonNull(zzli);
        this.zzb = zzli;
    }

    public final void run() {
        this.zzb.zzai(this.zza, true);
    }
}
