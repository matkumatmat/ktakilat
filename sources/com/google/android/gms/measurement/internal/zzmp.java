package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzmp extends zzay {
    final /* synthetic */ zznk zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzmp(zznk zznk, zzjf zzjf) {
        super(zzjf);
        Objects.requireNonNull(zznk);
        this.zza = zznk;
    }

    public final void zza() {
        e.C(this.zza.zzu, "Tasks have been queued for a long time");
    }
}
