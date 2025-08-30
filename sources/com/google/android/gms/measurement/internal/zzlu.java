package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

final class zzlu implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzlt zzb;
    final /* synthetic */ zzlt zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzma zze;

    public zzlu(zzma zzma, Bundle bundle, zzlt zzlt, zzlt zzlt2, long j) {
        this.zza = bundle;
        this.zzb = zzlt;
        this.zzc = zzlt2;
        this.zzd = j;
        Objects.requireNonNull(zzma);
        this.zze = zzma;
    }

    public final void run() {
        this.zze.zzt(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
