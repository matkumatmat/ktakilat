package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzlw implements Runnable {
    final /* synthetic */ zzma zza;

    public zzlw(zzma zzma) {
        Objects.requireNonNull(zzma);
        this.zza = zzma;
    }

    public final void run() {
        zzma zzma = this.zza;
        zzma.zza = zzma.zzw();
    }
}
