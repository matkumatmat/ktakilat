package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzoi extends zzay {
    final /* synthetic */ zzoj zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzoi(zzoj zzoj, zzjf zzjf) {
        super(zzjf);
        Objects.requireNonNull(zzoj);
        this.zza = zzoj;
    }

    public final void zza() {
        zzoj zzoj = this.zza;
        zzoj.zzd();
        zzoj.zzu.zzaV().zzk().zza("Starting upload from DelayedRunnable");
        zzoj.zzg.zzM();
    }
}
