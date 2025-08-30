package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzio implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzjc zzb;

    public zzio(zzjc zzjc, zzr zzr) {
        this.zza = zzr;
        Objects.requireNonNull(zzjc);
        this.zzb = zzjc;
    }

    public final void run() {
        zzjc zzjc = this.zzb;
        zzjc.zzL().zzY();
        zzpf zzL = zzjc.zzL();
        zzL.zzaW().zzg();
        zzL.zzu();
        zzr zzr = this.zza;
        Preconditions.checkNotEmpty(zzr.zza);
        zzL.zzv(zzr);
        zzL.zzw(zzr);
    }
}
