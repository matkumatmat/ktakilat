package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzid implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzjc zzb;

    public zzid(zzjc zzjc, zzr zzr) {
        this.zza = zzr;
        Objects.requireNonNull(zzjc);
        this.zzb = zzjc;
    }

    public final void run() {
        zzjc zzjc = this.zzb;
        zzjc.zzL().zzY();
        zzjc.zzL().zzag(this.zza);
    }
}
