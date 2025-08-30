package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

final class zzic implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzjc zzb;

    public zzic(zzjc zzjc, String str) {
        this.zza = str;
        Objects.requireNonNull(zzjc);
        this.zzb = zzjc;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzjc zzjc = this.zzb;
        zzjc.zzL().zzY();
        return zzjc.zzL().zzj().zzn(this.zza);
    }
}
