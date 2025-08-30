package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

final class zzip implements Callable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzjc zzb;

    public zzip(zzjc zzjc, zzr zzr) {
        this.zza = zzr;
        Objects.requireNonNull(zzjc);
        this.zzb = zzjc;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzjc zzjc = this.zzb;
        zzjc.zzL().zzY();
        return new zzao(zzjc.zzL().zzy(this.zza.zza));
    }
}
