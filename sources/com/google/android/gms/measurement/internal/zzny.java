package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.util.Objects;

final class zzny extends zzay {
    final /* synthetic */ zznz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzny(zznz zznz, zzjf zzjf) {
        super(zzjf);
        Objects.requireNonNull(zznz);
        this.zza = zznz;
    }

    @WorkerThread
    public final void zza() {
        zznz zznz = this.zza;
        zzob zzob = zznz.zzc;
        zzob.zzg();
        zzib zzib = zzob.zzu;
        zznz.zzd(false, false, zzib.zzaZ().elapsedRealtime());
        zzob.zzu.zzw().zzc(zzib.zzaZ().elapsedRealtime());
    }
}
