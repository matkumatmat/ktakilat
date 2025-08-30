package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;
import java.util.concurrent.Callable;

final class zziv implements Callable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzjc zzc;

    public zziv(zzjc zzjc, zzr zzr, Bundle bundle) {
        this.zza = zzr;
        this.zzb = bundle;
        Objects.requireNonNull(zzjc);
        this.zzc = zzjc;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzjc zzjc = this.zzc;
        zzjc.zzL().zzY();
        return zzjc.zzL().zzap(this.zza, this.zzb);
    }
}
