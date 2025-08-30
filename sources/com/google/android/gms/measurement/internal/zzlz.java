package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzlz implements Runnable {
    final /* synthetic */ zzma zza;

    public zzlz(zzma zzma) {
        Objects.requireNonNull(zzma);
        this.zza = zzma;
    }

    public final void run() {
        this.zza.zzx((zzlt) null);
    }
}
