package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzhz implements Runnable {
    final /* synthetic */ zzjr zza;
    final /* synthetic */ zzib zzb;

    public zzhz(zzib zzib, zzjr zzjr) {
        this.zza = zzjr;
        Objects.requireNonNull(zzib);
        this.zzb = zzib;
    }

    public final void run() {
        zzib zzib = this.zzb;
        zzjr zzjr = this.zza;
        zzib.zzK(zzjr);
        zzib.zza(zzjr.zzd);
    }
}
