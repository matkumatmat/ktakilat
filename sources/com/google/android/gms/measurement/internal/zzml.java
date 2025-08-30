package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzml extends zzay {
    final /* synthetic */ zznk zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzml(zznk zznk, zzjf zzjf) {
        super(zzjf);
        Objects.requireNonNull(zznk);
        this.zza = zznk;
    }

    public final void zza() {
        zznk zznk = this.zza;
        zznk.zzg();
        if (zznk.zzh()) {
            zznk.zzu.zzaV().zzk().zza("Inactivity, disconnecting from the service");
            zznk.zzM();
        }
    }
}
