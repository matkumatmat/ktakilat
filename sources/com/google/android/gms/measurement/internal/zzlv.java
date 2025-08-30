package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

final class zzlv implements Runnable {
    final /* synthetic */ zzlt zza;
    final /* synthetic */ zzlt zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzma zze;

    public zzlv(zzma zzma, zzlt zzlt, zzlt zzlt2, long j, boolean z) {
        this.zza = zzlt;
        this.zzb = zzlt2;
        this.zzc = j;
        this.zzd = z;
        Objects.requireNonNull(zzma);
        this.zze = zzma;
    }

    public final void run() {
        this.zze.zzu(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
